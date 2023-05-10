// kotlin interop >>

#import "NSMutableArray+JavaUtilList.h"

#include "java/lang/IllegalStateException.h"
#include "java/lang/IndexOutOfBoundsException.h"
#include "java/lang/NullPointerException.h"
#include "java/util/ConcurrentModificationException.h"
#include "java/util/Iterator.h"
#include "java/util/ListIterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/function/Predicate.h"

@interface NSMutableArrayIterator<ObjectType>: NSObject < JavaUtilIterator > {
@protected
  NSMutableArray *mutableArray_;
  jint lastRet_;
  jint cursor_;
}

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray;
@end

@interface NSMutableArrayListIterator<ObjectType>: NSMutableArrayIterator<ObjectType> < JavaUtilListIterator >

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray index:(NSUInteger)index;
@end

@implementation NSMutableArray (JavaUtilList)

- (instancetype)initWithInitialCapacity:(jint)initialCapacity {
  return [self initWithCapacity:initialCapacity];
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableArrayIterator alloc] initWithMutableArray:self]);
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
  for (id o in c) {
    o = javaWrapNull(o);
    if (![self containsObject:o]) {
      [self addObject:o];
      modified = true;
    }
  }
  return modified;
}

- (jboolean)addAllWithInt:(jint)index
   withJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableArray+JavaUtilList");
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  for (id o in c) {
    o = javaWrapNull(o);
    if ([self containsObject:o]) {
      [self removeObject:o];
      modified = true;
    }
  }
  return modified;
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  if (filter == nil) {
    @throw create_JavaLangNullPointerException_init();
  }
  NSMutableArray *objectsToRemove = [NSMutableArray array];
  for (id o in self) {
    if ([filter testWithId:javaUnwrapNull(o)]) {
      [objectsToRemove addObject:javaWrapNull(o)];
    }
  }
  if (objectsToRemove.count != 0) {
    [self removeObjectsInArray:objectsToRemove];
    return true;
  } else {
    return false;
  }
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  for (id o in c) {
    o = javaWrapNull(o);
    if (![self containsObject:o]) {
      [self removeObject:o];
      modified = true;
    }
  }
  return modified;
}

- (void)clear {
  [self removeAllObjects];
}

- (void)replaceAllWithJavaUtilFunctionUnaryOperator:(id<JavaUtilFunctionUnaryOperator>)operator_ {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableArray+JavaUtilList");
}

- (void)sortWithJavaUtilComparator:(id<JavaUtilComparator>)c {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableArray+JavaUtilList");
}

- (id)setWithInt:(jint)index
          withId:(id)element {
  if (index < 0 || index >= self.count) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  id previousObject = [self objectAtIndex:index];
  [self replaceObjectAtIndex:index withObject:javaWrapNull(element)];
  return javaUnwrapNull(previousObject);
}

- (void)addWithInt:(jint)index
            withId:(id)element {
  if (index < 0 || index > self.count) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  [self insertObject:javaWrapNull(element) atIndex:index];
}

- (id)removeWithInt:(jint)index {
  if (index < 0 || index >= self.count) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  id previousObject = [self objectAtIndex:index];
  [self removeObjectAtIndex:index];
  return javaUnwrapNull(previousObject);
}

- (id<JavaUtilListIterator>)listIterator {
  return AUTORELEASE([[NSMutableArrayListIterator alloc] initWithMutableArray:self index:0]);
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)index {
  if (index < 0 || index > self.count) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  return AUTORELEASE([[NSMutableArrayListIterator alloc] initWithMutableArray:self index:index]);
}

@end

@implementation NSMutableArrayIterator

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray {
  if ((self = [self init])) {
    mutableArray_ = RETAIN_(mutableArray);
    lastRet_ = -1;
    cursor_ = 0;
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableArray_ release];
  [super dealloc];
}
#endif

- (jboolean)hasNext {
  return cursor_ < mutableArray_.count;
}

- (id)next {
  jint i = cursor_;
  if (i >= mutableArray_.count) {
    @throw create_JavaUtilNoSuchElementException_init();
  }
  cursor_ = i + 1;
  return javaUnwrapNull(mutableArray_[(lastRet_ = i)]);
}

- (void)remove {
  if (lastRet_ < 0) {
    @throw create_JavaLangIllegalStateException_init();
  }
  [mutableArray_ removeObjectAtIndex:lastRet_];
  cursor_ = lastRet_;
  lastRet_ = -1;
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

@implementation NSMutableArrayListIterator

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray index:(NSUInteger)index {
  if (self = [super initWithMutableArray:mutableArray]) {
    cursor_ = (jint) index;
  }
  return self;
}

- (jboolean)hasPrevious {
  return cursor_ != 0;
}

- (id)previous {
  jint i = cursor_ - 1;
  if (i < 0) {
    @throw create_JavaUtilNoSuchElementException_init();
  }
  cursor_ = i;
  return javaUnwrapNull(mutableArray_[(lastRet_ = i)]);
}

- (jint)nextIndex {
  return cursor_;
}

- (jint)previousIndex {
  return cursor_ - 1;
}

- (void)setWithId:(id)e {
  if (lastRet_ < 0) {
    @throw create_JavaLangIllegalStateException_init();
  }
  if (lastRet_ < 0 || lastRet_ >= mutableArray_.count) {
    @throw create_JavaUtilConcurrentModificationException_init();
  }
  [mutableArray_ replaceObjectAtIndex:lastRet_ withObject:javaWrapNull(e)];
}

- (void)addWithId:(id)e {
  jint i = cursor_;
  if (i < 0 || i > mutableArray_.count) {
    @throw create_JavaUtilConcurrentModificationException_init();
  }
  [mutableArray_ insertObject:javaWrapNull(e) atIndex:i];
  cursor_ = i + 1;
  lastRet_ = -1;
}

@end

// Empty class to force category to be loaded.
@implementation JreNSMutableArrayListCategoryDummy
@end

// kotlin interop <<
