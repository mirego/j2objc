// kotlin interop >>

#import "NSSet+JavaUtilSet.h"

#include "java/lang/UnsupportedOperationException.h"
#include "java/util/Iterator.h"
#include "java/util/NoSuchElementException.h"

@interface NSSetIterator<ObjectType>: NSObject < JavaUtilIterator > {
@private
  NSEnumerator<ObjectType> *objectEnumerator_;
  id nextObject_;
}

- (instancetype)initWithSet:(NSSet<ObjectType> *)set;
@end

@implementation NSSet (JavaUtilSet)

- (instancetype)initWithElements:(id<JavaUtilCollection>)elements {
  return [self initWithArray:javaWrapCollection(elements)];
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSSetIterator alloc] initWithSet:self]);
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
  return [IOSObjectArray arrayWithNSArray:self.allObjects type:NSObject_class_()];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  NSUInteger size = self.count;
  if (a->size_ < size) {
    a = [IOSObjectArray newArrayWithLength:size type:NSObject_class_()];
  }

  __block NSUInteger index = 0;
  [self enumerateObjectsUsingBlock:^(id object, BOOL *stop) {
    [a replaceObjectAtIndex:index++ withObject:javaUnwrapNull(object)];
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
  return [self isSubsetOfSet:javaWrapCollection(c)];
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
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

@end

@implementation NSSetIterator

- (instancetype)initWithSet:(NSSet *)set {
  if ((self = [self init])) {
    objectEnumerator_ = RETAIN_(set.objectEnumerator);
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
@implementation JreNSSetSetCategoryDummy
@end

// kotlin interop <<
