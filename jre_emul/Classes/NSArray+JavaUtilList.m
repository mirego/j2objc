// kotlin interop >>

#import "NSArray+JavaUtilList.h"

#include "java/lang/ArrayIndexOutOfBoundsException.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/UnsupportedOperationException.h"
#include "java/util/Iterator.h"
#include "java/util/ListIterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/Spliterators.h"

@interface NSArray_Iterator<ObjectType>: NSObject < JavaUtilIterator > {
@protected
  NSArray<ObjectType> *array_;
  jint cursor_;
  jint size_;
}

- (instancetype)initWithArray:(NSArray *)array;
@end

@interface NSArray_ListIterator<ObjectType>: NSArray_Iterator<ObjectType> < JavaUtilListIterator >

- (instancetype)initWithArray:(NSArray *)array index:(jint)index;
@end

@implementation NSArray (JavaUtilList)

- (instancetype)initWithJavaUtilCollection:(id<JavaUtilCollection>)elements {
  return [self initWithArray:javaWrapCollection(nil_chk(elements))];
}

- (id)java_clone {
  return AUTORELEASE([self copy]);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSArray_Iterator alloc] initWithArray:self]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilSpliterators_spliteratorWithJavaUtilCollection_withInt_(self, (JavaUtilSpliterator_ORDERED | JavaUtilSpliterator_SIZED | JavaUtilSpliterator_SUBSIZED));
}

- (jint)size {
  return (jint) self.count;
}

- (jboolean)isEmpty {
  return self.size == 0;
}

- (jboolean)containsWithId:(id)o {
  return [self containsObject:javaWrapNull(o)];
}

- (IOSObjectArray *)toArray {
  return [self toArrayWithNSObjectArray:[IOSObjectArray arrayWithLength:self.size type:NSObject_class_()]];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  (void)nil_chk(a);
  jint size = self.size;
  if (a->size_ < size) {
    a = [IOSObjectArray arrayWithLength:size type:a->elementType_];
  }

  [self enumerateObjectsUsingBlock:^(id object, NSUInteger index, BOOL *stop) {
    [a replaceObjectAtIndex:index withObject:javaUnwrapNull(object)];
  }];

  // Insert NULL at the end if there is room for it
  if (a->size_ > size) {
    [a replaceObjectAtIndex:size withObject:nil];
  }

  return a;
}

- (jboolean)addWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeWithId:(id)o {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    if (![self containsObject:javaWrapNull([iter next])]) {
      return false;
    }
  }
  return true;
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)addAllWithInt:(jint)index
   withJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)clear {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

//- (jboolean)isEqual:(id)o {
//}

- (NSUInteger)hash {
  jint hashCode = 1;
  for (id e in self) {
    hashCode = 31 * hashCode + (jint) [javaUnwrapNull(e) hash];
  }
  return hashCode;
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (id<JavaUtilStreamStream>)parallelStream {
  return JavaUtilCollection_parallelStream(self);
}

- (void)replaceAllWithJavaUtilFunctionUnaryOperator:(id<JavaUtilFunctionUnaryOperator>)operator_ {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)sortWithJavaUtilComparator:(id<JavaUtilComparator>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id)getWithInt:(jint)index {
  if (index < 0 || index >= self.size) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  return javaUnwrapNull([self objectAtIndex:index]);
}

- (id)setWithInt:(jint)index
          withId:(id)element {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)addWithInt:(jint)index
            withId:(id)element {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id)removeWithInt:(jint)index {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jint)indexOfWithId:(id)o {
  return (jint) [self indexOfObject:javaWrapNull(o)];
}

- (jint)lastIndexOfWithId:(id)o {
  o = javaWrapNull(o);
  return (jint) [self indexOfObjectWithOptions:NSEnumerationReverse passingTest:^BOOL(id obj, NSUInteger idx, BOOL *stop) {
    return [obj isEqual:o];
  }];
}

- (id<JavaUtilListIterator>)listIterator {
  return AUTORELEASE([[NSArray_ListIterator alloc] initWithArray:self index:0]);
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)index {
  if (index < 0 || index > self.size) {
    @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_([NSString stringWithFormat:@"Index: %d, Size: %d", index, self.size]);
  }
  return AUTORELEASE([[NSArray_ListIterator alloc] initWithArray:self index:index]);
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

  return [self subarrayWithRange:NSMakeRange(fromIndex, (toIndex - fromIndex))];
}

@end

@implementation NSArray_Iterator

- (instancetype)initWithArray:(NSArray *)array {
  if (self = [self init]) {
    array_ = RETAIN_(array);
    cursor_ = 0;
    size_ = (jint) array.count;
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [array_ release];
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
  return javaUnwrapNull(array_[i]);
}

- (void)remove {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

@implementation NSArray_ListIterator

- (instancetype)initWithArray:(NSArray *)array index:(jint)index {
  if (self = [super initWithArray:array]) {
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
  return javaUnwrapNull(array_[i]);
}

- (jint)nextIndex {
  return cursor_;
}

- (jint)previousIndex {
  return cursor_ - 1;
}

- (void)setWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)addWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

@end

// Empty class to force category to be loaded.
@implementation JreNSArrayListCategoryDummy
@end

// kotlin interop <<
