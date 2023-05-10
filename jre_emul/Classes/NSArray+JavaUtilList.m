// kotlin interop >>

#import "NSArray+JavaUtilList.h"

#include "java/lang/UnsupportedOperationException.h"
#include "java/util/Iterator.h"
#include "java/util/NoSuchElementException.h"

@interface NSArrayIterator<ObjectType>: NSObject < JavaUtilIterator > {
@private
  NSEnumerator<ObjectType> *objectEnumerator_;
  id nextObject_;
}

- (instancetype)initWithArray:(NSArray<ObjectType> *)array;
@end

@implementation NSArray (JavaUtilList)

- (instancetype)initWithElements:(id<JavaUtilCollection>)elements {
  return [self initWithArray:javaWrapCollection(elements)];
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSArrayIterator alloc] initWithArray:self]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilCollection_spliterator(self);
}

- (jint)size {
  return (jint) self.count;
}

- (jboolean)isEmpty {
  return self.count == 0;
}

- (jboolean)containsWithId:(id)o {
  return [self containsObject:javaWrapNull(o)];
}

- (IOSObjectArray *)toArray {
  return [IOSObjectArray arrayWithNSArray:self type:NSObject_class_()];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  NSUInteger size = (jint) self.count;
  if (a->size_ < size) {
    a = [IOSObjectArray newArrayWithLength:size type:NSObject_class_()];
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
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)removeWithId:(id)o {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSArray+JavaUtilList");
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)addAllWithInt:(jint)index
   withJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)clear {
  @throw create_JavaLangUnsupportedOperationException_init();
}

//- (jboolean)isEqual:(id)o {
//}

//- (NSUInteger)hash {
//}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (id<JavaUtilStreamStream>)parallelStream {
  return JavaUtilCollection_parallelStream(self);
}

- (void)replaceAllWithJavaUtilFunctionUnaryOperator:(id<JavaUtilFunctionUnaryOperator>)operator_ {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)sortWithJavaUtilComparator:(id<JavaUtilComparator>)c {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id)getWithInt:(jint)index {
  return javaUnwrapNull([self objectAtIndex:index]);
}

- (id)setWithInt:(jint)index
          withId:(id)element {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)addWithInt:(jint)index
            withId:(id)element {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id)removeWithInt:(jint)index {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jint)indexOfWithId:(id)o {
  return (jint) [self indexOfObject:javaWrapNull(o)];
}

- (jint)lastIndexOfWithId:(id)o {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSArray+JavaUtilList");
}

- (id<JavaUtilListIterator>)listIterator {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSArray+JavaUtilList");
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)index {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSArray+JavaUtilList");
}

- (id<JavaUtilList>)subListWithInt:(jint)fromIndex
                           withInt:(jint)toIndex {
  return [self subarrayWithRange:NSMakeRange(fromIndex, (toIndex - fromIndex))];
}

@end

@implementation NSArrayIterator

- (instancetype)initWithArray:(NSArray *)array {
  if ((self = [self init])) {
    objectEnumerator_ = RETAIN_(array.objectEnumerator);
    nextObject_ = RETAIN_([objectEnumerator_ nextObject]);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [objectEnumerator_ release];
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
  id currentObject = AUTORELEASE(nextObject_);
  nextObject_ = RETAIN_([objectEnumerator_ nextObject]);
  return javaUnwrapNull(currentObject);
}

- (void)remove {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

// Empty class to force category to be loaded.
@implementation JreNSArrayListCategoryDummy
@end

// kotlin interop <<
