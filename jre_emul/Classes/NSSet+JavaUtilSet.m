// kotlin interop >>

#import "NSSet+JavaUtilSet.h"

#include "java/lang/UnsupportedOperationException.h"
#include "java/util/Iterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/Spliterators.h"

@interface NSSet_Iterator<ObjectType>: NSObject < JavaUtilIterator > {
@private
  NSEnumerator<ObjectType> *objectEnumerator_;
  id nextObject_;
}

- (instancetype)initWithSet:(NSSet<ObjectType> *)set;
@end

@implementation NSSet (JavaUtilSet)

- (instancetype)initWithJavaUtilCollection:(id<JavaUtilCollection>)elements {
  return [self initWithArray:javaWrapArray(nil_chk(elements))];
}

- (id)java_clone {
  return AUTORELEASE([self copy]);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSSet_Iterator alloc] initWithSet:self]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilSpliterators_spliteratorWithJavaUtilCollection_withInt_(self, (JavaUtilSpliterator_SIZED | JavaUtilSpliterator_DISTINCT));
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
  jint h = 0;
  for (id e in self) {
    h += (jint) [javaUnwrapNull(e) hash];
  }
  return h;
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (id<JavaUtilStreamStream>)parallelStream {
  return JavaUtilCollection_parallelStream(self);
}

@end

@implementation NSSet_Iterator

- (instancetype)initWithSet:(NSSet *)set {
  if (self = [self init]) {
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
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

// Empty class to force category to be loaded.
@implementation JreNSSetSetCategoryDummy
@end

// kotlin interop <<
