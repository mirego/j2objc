// kotlin interop >>

#import "NSMutableArray+JavaUtilList.h"

#include "java/lang/ArrayIndexOutOfBoundsException.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/IllegalStateException.h"
#include "java/lang/NullPointerException.h"
#include "java/util/Arrays.h"
#include "java/util/ConcurrentModificationException.h"
#include "java/util/Iterator.h"
#include "java/util/ListIterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/function/Predicate.h"
#include "java/util/function/UnaryOperator.h"

@interface NSMutableArray_Iterator<ObjectType>: NSObject < JavaUtilIterator > {
@protected
  NSMutableArray<ObjectType> *mutableArray_;
  jint lastRet_;
  jint cursor_;
  jint size_;
}

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray;
@end

@interface NSMutableArray_ListIterator<ObjectType>: NSMutableArray_Iterator<ObjectType> < JavaUtilListIterator >

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray index:(jint)index;
@end

@implementation NSMutableArray (JavaUtilList)

- (instancetype)initWithInt:(jint)initialCapacity {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal Capacity: %d", initialCapacity]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (id)java_clone {
  return AUTORELEASE([self mutableCopy]);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableArray_Iterator alloc] initWithMutableArray:self]);
}

- (jboolean)addWithId:(id)e {
  [self addObject:javaWrapNull(e)];
  return true;
}

- (jboolean)removeWithId:(id)o {
  NSUInteger index = [self indexOfObject:javaWrapNull(o)];
  if (index != NSNotFound) {
    [self removeObjectAtIndex:index];
    return true;
  } else {
    return false;
  }
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    [self addObject:javaWrapNull([iter next])];
  }
  return !c.isEmpty;
}

- (jboolean)addAllWithInt:(jint)index
   withJavaUtilCollection:(id<JavaUtilCollection>)c {
  if (index > self.size || index < 0) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    [self insertObject:javaWrapNull([iter next]) atIndex:index++];
  }
  return !c.isEmpty;
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    id o = javaWrapNull([iter next]);
    if ([self containsObject:o]) {
      [self removeObject:o];
      modified = true;
    }
  }
  return modified;
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  (void)nil_chk(filter);
  NSMutableArray *objectsToRemove = [NSMutableArray array];
  for (id o in self) {
    if ([filter testWithId:javaUnwrapNull(o)]) {
      [objectsToRemove addObject:o];
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
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  NSMutableArray *objectsToRemove = [NSMutableArray array];
  for (id o in self) {
    if (![c containsWithId:javaUnwrapNull(o)]) {
      [objectsToRemove addObject:o];
    }
  }
  if (objectsToRemove.count != 0) {
    [self removeObjectsInArray:objectsToRemove];
    return true;
  } else {
    return false;
  }
}

- (void)clear {
  [self removeAllObjects];
}

- (void)replaceAllWithJavaUtilFunctionUnaryOperator:(id<JavaUtilFunctionUnaryOperator>)operator_ {
  (void)nil_chk(operator_);
  [self enumerateObjectsUsingBlock:^(id object, NSUInteger index, BOOL *stop) {
    [self replaceObjectAtIndex:index withObject:javaWrapNull([operator_ applyWithId:javaUnwrapNull(object)])];
  }];
}

- (void)sortWithJavaUtilComparator:(id<JavaUtilComparator>)c {
  (void)nil_chk(c);
  // NOTE This is really not optimal, or even correct (not using comparator at all!!)
  IOSObjectArray *array = [self toArray];
  JavaUtilArrays_sortWithNSObjectArray_(array);

  [self removeAllObjects];
  [array enumerateObjectsUsingBlock:^(id object, NSUInteger index, BOOL *stop) {
    [self addObject:javaWrapNull(object)];
  }];
}

- (id)setWithInt:(jint)index
          withId:(id)element {
  if (index < 0 || index >= self.size) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  id currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull([self objectAtIndex:index]));
  [self replaceObjectAtIndex:index withObject:javaWrapNull(element)];
  return currentValue;
}

- (void)addWithInt:(jint)index
            withId:(id)element {
  if (index > self.size || index < 0) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  [self insertObject:javaWrapNull(element) atIndex:index];
}

- (id)removeWithInt:(jint)index {
  if (index < 0 || index >= self.size) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  id currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull([self objectAtIndex:index]));
  [self removeObjectAtIndex:index];
  return currentValue;
}

- (id<JavaUtilListIterator>)listIterator {
  return AUTORELEASE([[NSMutableArray_ListIterator alloc] initWithMutableArray:self index:0]);
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)index {
  if (index < 0 || index > self.size) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  return AUTORELEASE([[NSMutableArray_ListIterator alloc] initWithMutableArray:self index:index]);
}

- (id<JavaUtilList>)subListWithInt:(jint)fromIndex
                           withInt:(jint)toIndex {
  if (fromIndex < 0) {
      @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"fromIndex = %d", fromIndex]);
  }
  if (toIndex > self.size) {
      @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"toIndex = %d", toIndex]);
  }
  if (fromIndex > toIndex) {
      @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"fromIndex(%d) > toIndex(%d)", fromIndex, toIndex]);
  }

  // NOTE This is supposed to be a view of this ArrayList so any modifications also affect this ArrayList
  return AUTORELEASE([[self subarrayWithRange:NSMakeRange(fromIndex, (toIndex - fromIndex))] mutableCopy]);
}

@end

@implementation NSMutableArray_Iterator

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray {
  if (self = [self init]) {
    mutableArray_ = RETAIN_(mutableArray);
    lastRet_ = -1;
    cursor_ = 0;
    size_ = (jint) mutableArray.count;
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
  return cursor_ < size_;
}

- (id)next {
  jint i = cursor_;
  if (i >= size_) {
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
  size_--;
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

@implementation NSMutableArray_ListIterator

- (instancetype)initWithMutableArray:(NSMutableArray *)mutableArray index:(jint)index {
  if (self = [super initWithMutableArray:mutableArray]) {
    cursor_ = index;
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
  if (lastRet_ < 0 || lastRet_ >= size_) {
    @throw create_JavaUtilConcurrentModificationException_init();
  }
  [mutableArray_ replaceObjectAtIndex:lastRet_ withObject:javaWrapNull(e)];
}

- (void)addWithId:(id)e {
  jint i = cursor_;
  if (i < 0 || i > size_) {
    @throw create_JavaUtilConcurrentModificationException_init();
  }
  [mutableArray_ insertObject:javaWrapNull(e) atIndex:i];
  cursor_ = i + 1;
  lastRet_ = -1;
  size_++;
}

@end

// Empty class to force category to be loaded.
@implementation JreNSMutableArrayListCategoryDummy
@end

// kotlin interop <<
