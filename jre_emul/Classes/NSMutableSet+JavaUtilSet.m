// kotlin interop >>

#import "NSMutableSet+JavaUtilSet.h"

#include "java/lang/Float.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/IllegalStateException.h"
#include "java/util/Iterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/function/Predicate.h"

@interface NSMutableSet_Iterator<ObjectType>: NSObject < JavaUtilIterator > {
@private
  NSMutableSet<ObjectType> *mutableSet_;
  NSEnumerator<ObjectType> *objectEnumerator_;
  id currentObject_;
  id nextObject_;
}

- (instancetype)initWithMutableSet:(NSMutableSet *)mutableSet;
@end

@implementation NSMutableSet (JavaUtilSet)

- (instancetype)initWithInt:(jint)initialCapacity {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal initial capacity: %d", initialCapacity]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal initial capacity: %d", initialCapacity]);
  }
  if (loadFactor <= 0 || CommonFloat_isNaNWithFloat_(loadFactor)) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal load factor: %f", loadFactor]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (id)java_clone {
  return AUTORELEASE([[NSMutableSet alloc] initWithSet:self]);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableSet_Iterator alloc] initWithMutableSet:self]);
}

- (jboolean)addWithId:(id)e {
  e = javaWrapNull(e);
  if (![self containsObject:e]) {
    [self addObject:e];
    return true;
  } else {
    return false;
  }
}

- (jboolean)removeWithId:(id)o {
  o = javaWrapNull(o);
  if ([self containsObject:o]) {
    [self removeObject:o];
    return true;
  } else {
    return false;
  }
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    id o = javaWrapNull([iter next]);
    if (![self containsObject:o]) {
      [self addObject:o];
      modified = true;
    }
  }
  return modified;
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    modified |= [self removeWithId:[iter next]];
  }
  return modified;
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  (void)nil_chk(filter);
  NSMutableSet *objectsToRemove = [NSMutableSet set];
  for (id o in self) {
    if ([filter testWithId:javaUnwrapNull(o)]) {
      [objectsToRemove addObject:o];
    }
  }
  if (objectsToRemove.count != 0) {
    [self minusSet:objectsToRemove];
    return true;
  } else {
    return false;
  }
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    modified |= ![self removeWithId:[iter next]];
  }
  return modified;
}

- (void)clear {
  [self removeAllObjects];
}

@end

@implementation NSMutableSet_Iterator

- (instancetype)initWithMutableSet:(NSMutableSet *)mutableSet {
  if (self = [self init]) {
    mutableSet_ = RETAIN_(mutableSet);
    objectEnumerator_ = RETAIN_(mutableSet.objectEnumerator);
    nextObject_ = RETAIN_([objectEnumerator_ nextObject]);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableSet_ release];
  [objectEnumerator_ release];
  [currentObject_ release];
  [nextObject_ release];
  [super dealloc];
}
#endif

- (jboolean)hasNext {
  return nextObject_ != nil;
}

- (id)next {
  if (nextObject_ == nil) {
    @throw create_JavaUtilNoSuchElementException_init();
  }
  RELEASE_(currentObject_);
  currentObject_ = RETAIN_AND_AUTORELEASE(nextObject_);
  nextObject_ = RETAIN_([objectEnumerator_ nextObject]);
  return javaUnwrapNull(currentObject_);
}

- (void)remove {
  if (currentObject_ == nil) {
    @throw create_JavaLangIllegalStateException_init();
  }
  [mutableSet_ removeObject:currentObject_];
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

// Empty class to force category to be loaded.
@implementation JreNSMutableSetSetCategoryDummy
@end

// kotlin interop <<
