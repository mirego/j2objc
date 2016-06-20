// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//
//  J2ObjC_common.m
//  J2ObjC
//
//  Implements definitions from J2ObjC_common.h.

#import "J2ObjC_common.h"

#import <libkern/OSAtomic.h>

#import "FastPointerLookup.h"
#import "IOSClass.h"
#import "java/lang/AbstractStringBuilder.h"
#import "java/lang/AssertionError.h"
#import "java/lang/ClassCastException.h"
#import "java/lang/NullPointerException.h"
#import "java_lang_IntegralToString.h"
#import "java_lang_RealToString.h"

void JreThrowNullPointerException() {
  @throw AUTORELEASE([[JavaLangNullPointerException alloc] init]);
}

void JreThrowClassCastException() {
  @throw AUTORELEASE([[JavaLangClassCastException alloc] init]);
}

void JreThrowAssertionError(id __unsafe_unretained msg) {
  @throw AUTORELEASE([[JavaLangAssertionError alloc] initWithId:[msg description]]);
}

#if defined(J2OBJC_COUNT_NIL_CHK) && !defined(J2OBJC_DISABLE_NIL_CHECKS)
static int j2objc_nil_chk_count = 0;

void JrePrintNilChkCount() {
  printf("nil_chk count: %d\n", j2objc_nil_chk_count);
}

void JrePrintNilChkCountAtExit() {
  atexit(JrePrintNilChkCount);
}

id nil_chk(id __unsafe_unretained p) {
  j2objc_nil_chk_count++;
  if (__builtin_expect(!p, 0)) {
    JreThrowNullPointerException();
  }
  return p;
}
#endif

id JreStrongAssign(__strong id *pIvar, id value) {
  return JreAutoreleasedAssign(pIvar, [value retain]);
}

id JreStrongAssignAndConsume(__strong id *pIvar, NS_RELEASES_ARGUMENT id value) {
  return JreAutoreleasedAssign(pIvar, value);
}

// Declare a pool of spin locks for volatile variable access. The use of spin
// locks for atomic access is consistent with how Apple implements atomic
// property accessors, and the hashing used here is inspired by Apple's
// implementation:
// http://www.opensource.apple.com/source/objc4/objc4-532.2/runtime/Accessors.subproj/objc-accessors.mm
// Note that normally a spin lock only requires acquire/release semantics, but
// we use sequencially consistent ordering when acquiring and releasing the spin
// locks to provide sequencial consistency of all volatile accesses.
#define VOLATILE_POWER 7
#define VOLATILE_MASK ((1 << VOLATILE_POWER) - 1)
#define VOLATILE_HASH(x) (((long)x >> 5) & VOLATILE_MASK)
#define VOLATILE_GETLOCK(ptr) &volatile_locks[VOLATILE_HASH(ptr)]
#define VOLATILE_LOCK(l) OSSpinLockLock(l)
#define VOLATILE_UNLOCK(l) OSSpinLockUnlock(l)
typedef OSSpinLock volatile_lock_t;
static volatile_lock_t volatile_locks[1 << VOLATILE_POWER] = { 0 };

id JreLoadVolatileId(volatile_id *pVar) {
  volatile_lock_t *lock = VOLATILE_GETLOCK(pVar);
  VOLATILE_LOCK(lock);
  id value = [*(id *)pVar retain];
  VOLATILE_UNLOCK(lock);
  return [value autorelease];
}

id JreAssignVolatileId(volatile_id *pVar, id value) {
  volatile_lock_t *lock = VOLATILE_GETLOCK(pVar);
  VOLATILE_LOCK(lock);
  *(id *)pVar = value;
  VOLATILE_UNLOCK(lock);
  return value;
}

static inline id JreVolatileStrongAssignInner(
    volatile_id *pIvar, NS_RELEASES_ARGUMENT id value) {
  volatile_lock_t *lock = VOLATILE_GETLOCK(pIvar);
  VOLATILE_LOCK(lock);
  id oldValue = *(id *)pIvar;
  *(id *)pIvar = value;
  VOLATILE_UNLOCK(lock);
  [oldValue autorelease];
  return value;
}

id JreVolatileStrongAssign(volatile_id *pIvar, id value) {
  return JreVolatileStrongAssignInner(pIvar, [value retain]);
}

id JreVolatileStrongAssignAndConsume(volatile_id *pIvar, NS_RELEASES_ARGUMENT id value) {
  return JreVolatileStrongAssignInner(pIvar, value);
}

jboolean JreCompareAndSwapVolatileStrongId(volatile_id *pVar, id expected, id newValue) {
  volatile_lock_t *lock = VOLATILE_GETLOCK(pVar);
  VOLATILE_LOCK(lock);
  jboolean result = *(id *)pVar == expected;
  if (result) {
    *(id *)pVar = [newValue retain];
  }
  VOLATILE_UNLOCK(lock);
  if (result) {
    [expected autorelease];
  }
  return result;
}

id JreExchangeVolatileStrongId(volatile_id *pVar, id newValue) {
  [newValue retain];
  volatile_lock_t *lock = VOLATILE_GETLOCK(pVar);
  VOLATILE_LOCK(lock);
  id oldValue = *(id *)pVar;
  *(id *)pVar = newValue;
  VOLATILE_UNLOCK(lock);
  [oldValue autorelease];
  return oldValue;
}

void JreReleaseVolatile(volatile_id *pVar) {
  // This is only called from a dealloc method, so we can assume there are no
  // concurrent threads with access to this address. Therefore, synchronization
  // is unnecessary.
  [*(id *)pVar release];
}

void JreCloneVolatile(volatile_id *pVar, volatile_id *pOther) {
  volatile_lock_t *lock = VOLATILE_GETLOCK(pOther);
  VOLATILE_LOCK(lock);
  *(id *)pVar = *(id *)pOther;
  VOLATILE_UNLOCK(lock);
}

void JreCloneVolatileStrong(volatile_id *pVar, volatile_id *pOther) {
  // We lock on pOther because it may be visible to other threads. Since we are
  // still within Object.clone() we know that pVar isn't visible to other
  // threads yet, so we don't need to use it's lock. However, we do the
  // assignment within pOther's lock to provide sequencial consistency.
  volatile_lock_t *lock = VOLATILE_GETLOCK(pOther);
  VOLATILE_LOCK(lock);
  *(id *)pVar = [*(id *)pOther retain];
  VOLATILE_UNLOCK(lock);
}

// Block flag position for copy dispose, (1 << 25).
#define COPY_DISPOSE_FLAG 0x02000000

// Modified from clang block implementation http://clang.llvm.org/docs/Block-ABI-Apple.html
typedef struct Block_literal_1 {
  void *isa;
  int flags;
  int reserved;
  void (*invoke)(void *, ...);
  struct Block_descriptor_1 {
    unsigned long int reserved;
    unsigned long int size;
    // There will be 2 function pointers at the beginning of the signature if the copy_dispose flag
    // is set.
    void *signature[1];
  } *descriptor;
} Block_literal;

// Returns a type string from a block.
const char *blockTypeSignature(id block) {
  Block_literal *blockLiteral = (__bridge void *) block;
  // Offset for optional function pointers.
  int i = (blockLiteral->flags & COPY_DISPOSE_FLAG) ? 2 : 0;
  return (const char *) blockLiteral->descriptor->signature[i];
}

typedef struct {
  void *id;
} LambdaHolder;

static void *LambdaLookup(void *ptr) {
  LambdaHolder *lh = malloc(sizeof(LambdaHolder));
  lh->id = nil;
  return lh;
}

static FastPointerLookup_t lambdaLookup = FAST_POINTER_LOOKUP_INIT(&LambdaLookup);

// Method to handle dynamic creation of class wrappers surrounding blocks which come from lambdas
// not requiring a capture.
id GetNonCapturingLambda(Protocol *protocol, NSString *blockClassName,
    SEL methodSelector, id block) {
  // Relies on lambda names being constant strings with matching pointers for matching names.
  // This should happen as a clang optimization, as all string constants are kept on the stack for
  // the program duration.
  LambdaHolder *lambdaHolder = FastPointerLookup(&lambdaLookup, (__bridge void*) blockClassName);
  @synchronized(blockClassName) {
    if (lambdaHolder->id == nil) {
      Class blockClass = objc_allocateClassPair([NSObject class], [blockClassName UTF8String], 0);
      // Fail quickly if we can't create the runtime class.
      if (!class_addProtocol(blockClass, protocol)) {
        @throw AUTORELEASE([[JavaLangAssertionError alloc]
            initWithId:@"Unable to add protocol to non-capturing lambda class."]);
      }
      IMP block_implementation = imp_implementationWithBlock(block);
      if (!class_addMethod(blockClass, methodSelector, block_implementation,
          blockTypeSignature(block))) {
        @throw AUTORELEASE([[JavaLangAssertionError alloc]
            initWithId:@"Unable to add method to non-capturing lambda class."]);
      }
      objc_registerClassPair(blockClass);
      lambdaHolder->id = (void*)[[blockClass alloc] init];
    }
  }
  return (__bridge id) lambdaHolder->id;
}

// Method to handle dynamic creation of class wrappers surrounding blocks from lambdas requiring
// a capture.
id GetCapturingLambda(Protocol *protocol, NSString *blockClassName,
    SEL methodSelector, id blockWrapper, id block) {
  LambdaHolder *lambdaHolder = FastPointerLookup(&lambdaLookup, (__bridge void*) blockClassName);
  @synchronized(blockClassName) {
    if (lambdaHolder->id == nil) {
      Class lambdaClass = objc_allocateClassPair([NSObject class], [blockClassName UTF8String], 0);
      // Fail quickly if we can't create the runtime class.
      if (!class_addProtocol(lambdaClass, protocol)) {
        @throw AUTORELEASE([[JavaLangAssertionError alloc]
            initWithId:@"Unable to add protocol to capturing lambda class."]);
      }
      IMP block_implementation = imp_implementationWithBlock(blockWrapper);
      if (!class_addMethod([lambdaClass class], methodSelector, block_implementation,
          blockTypeSignature(blockWrapper))) {
        @throw AUTORELEASE([[JavaLangAssertionError alloc]
          initWithId:@"Unable to add method to capturing lambda class."]);
      }
      objc_registerClassPair(lambdaClass);
      lambdaHolder->id = (void*)[lambdaClass class];
    }
  }
  id instance = [[(id) lambdaHolder->id alloc] init];
  objc_setAssociatedObject(instance, (void*) 0, block, OBJC_ASSOCIATION_COPY_NONATOMIC);
  return instance;
}

// Counts the number of object types in a string concatenation.
static NSUInteger CountObjectArgs(const char *types) {
  NSUInteger numObjs = 0;
  while (*types) {
    if (*(types++) == '@') numObjs++;
  }
  return numObjs;
}

// Computes the capacity for the buffer.
static jint ComputeCapacity(const char *types, va_list va, NSString **objDescriptions) {
  jint capacity = 0;
  while (*types) {
    switch(*types) {
      case 'C':
        capacity++;
        va_arg(va, jint);
        break;
      case 'D':
        capacity += 24;  // Determined experimentally.
        va_arg(va, jdouble);
        break;
      case 'F':
        capacity += 15;  // Determined experimentally.
        va_arg(va, jdouble);
        break;
      case 'B':
        capacity += 4;
        va_arg(va, jint);
        break;
      case 'S':
        capacity += 6;
        va_arg(va, jint);
        break;
      case 'I':
        capacity += 11;
        va_arg(va, jint);
        break;
      case 'J':
        capacity += 20;
        va_arg(va, jlong);
        break;
      case 'Z':
        capacity += (jboolean)va_arg(va, jint) ? 4 : 5;
        break;
      case '$':
        {
          NSString *str = va_arg(va, NSString *);
          capacity += str ? CFStringGetLength((CFStringRef)str) : 4;
        }
        break;
      case '@':
        {
          id obj = va_arg(va, id);
          if (obj) {
            NSString *description = [obj description];
            *(objDescriptions++) = description;
            capacity += CFStringGetLength((CFStringRef)description);
          } else {
            *(objDescriptions++) = nil;
            capacity += 4;
          }
        }
        break;
    }
    types++;
  }
  return capacity;
}

static void AppendArgs(
    const char *types, va_list va, NSString **objDescriptions, JreStringBuilder *sb) {
  while (*types) {
    switch (*types) {
      case 'C':
        JreStringBuilder_appendChar(sb, (jchar)va_arg(va, jint));
        break;
      case 'D':
        RealToString_appendDouble(sb, va_arg(va, jdouble));
        break;
      case 'F':
        RealToString_appendFloat(sb, (jfloat)va_arg(va, jdouble));
        break;
      case 'B':
      case 'I':
      case 'S':
        IntegralToString_convertInt(sb, va_arg(va, jint));
        break;
      case 'J':
        IntegralToString_convertLong(sb, va_arg(va, jlong));
        break;
      case 'Z':
        JreStringBuilder_appendString(sb, (jboolean)va_arg(va, jint) ? @"true" : @"false");
        break;
      case '$':
        JreStringBuilder_appendString(sb, va_arg(va, NSString *));
        break;
      case '@':
        va_arg(va, id);
        JreStringBuilder_appendString(sb, *(objDescriptions++));
        break;
    }
    types++;
  }
}

NSString *JreStrcat(const char *types, ...) {
  NSString *objDescriptions[CountObjectArgs(types)];
  va_list va;
  va_start(va, types);
  jint capacity = ComputeCapacity(types, va, objDescriptions);
  va_end(va);

  // Create a string builder and fill it.
  JreStringBuilder sb;
  JreStringBuilder_initWithCapacity(&sb, capacity);
  va_start(va, types);
  AppendArgs(types, va, objDescriptions, &sb);
  va_end(va);
  return JreStringBuilder_toStringAndDealloc(&sb);
}

id JreStrAppendInner(id lhs, const char *types, va_list va) {
  va_list va_capacity;
  va_copy(va_capacity, va);
  NSString *objDescriptions[CountObjectArgs(types)];

  jint capacity = ComputeCapacity(types, va_capacity, objDescriptions);
  va_end(va_capacity);

  NSString *lhsDescription = nil;
  if (lhs) {
    lhsDescription = [lhs description];
    capacity += CFStringGetLength((CFStringRef)lhsDescription);
  } else {
    capacity += 4;
  }

  JreStringBuilder sb;
  JreStringBuilder_initWithCapacity(&sb, capacity);
  JreStringBuilder_appendString(&sb, lhsDescription);
  AppendArgs(types, va, objDescriptions, &sb);

  return JreStringBuilder_toStringAndDealloc(&sb);
}

id JreStrAppend(__weak id *lhs, const char *types, ...) {
  va_list va;
  va_start(va, types);
  NSString *result = JreStrAppendInner(*lhs, types, va);
  va_end(va);
  return *lhs = result;
}

id JreStrAppendStrong(__strong id *lhs, const char *types, ...) {
  va_list va;
  va_start(va, types);
  NSString *result = JreStrAppendInner(*lhs, types, va);
  va_end(va);
  return JreStrongAssign(lhs, result);
}

id JreStrAppendVolatile(volatile_id *lhs, const char *types, ...) {
  va_list va;
  va_start(va, types);
  NSString *result = JreStrAppendInner(JreLoadVolatileId(lhs), types, va);
  va_end(va);
  return JreAssignVolatileId(lhs, result);
}

id JreStrAppendVolatileStrong(volatile_id *lhs, const char *types, ...) {
  va_list va;
  va_start(va, types);
  NSString *result = JreStrAppendInner(JreLoadVolatileId(lhs), types, va);
  va_end(va);
  return JreVolatileStrongAssign(lhs, result);
}

id JreStrAppendArray(JreArrayRef lhs, const char *types, ...) {
  va_list va;
  va_start(va, types);
  NSString *result = JreStrAppendInner(*lhs.pValue, types, va);
  va_end(va);
  return IOSObjectArray_SetRef(lhs, result);
}

FOUNDATION_EXPORT void JreRelease(id obj) {
  [obj release];
}
