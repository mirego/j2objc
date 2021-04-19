
#import "NSArrayToJavaUtilListAdapter.h"

@implementation NSArrayToJavaUtilsListAdapter

- (instancetype)initWithSourceArray:(NSArray *)sourceArray {
    self = [super init];
    if (self) {
        _sourceArray = sourceArray;
    }
    return self;
}

- (jint)size {
  return 0;
}

- (jboolean)isEmpty {
  return false;
}

- (jboolean)containsWithId:(id)o {
  return false;
}

- (id<JavaUtilIterator>)iterator {
  return nil;
}

- (IOSObjectArray *)toArray {
  return [IOSObjectArray arrayWithLength:0 type:NSObject_class_()];
}

- (jboolean)addWithId:(id)o {
  return false;
}

- (jboolean)removeWithId:(id)o {
  return false;
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
  return false;
}

- (jboolean)addAllWithInt:(jint)i
   withJavaUtilCollection:(id<JavaUtilCollection>)collection {
  return false;
}

- (void)clear {
}

- (id)getWithInt:(jint)i {
  return nil;
}

- (id)setWithInt:(jint)i
          withId:(id)o {
  return nil;
}

- (void)addWithInt:(jint)i
            withId:(id)o {
}

- (id)removeWithInt:(jint)i {
  return nil;
}

- (jint)indexOfWithId:(id)o {
  return 0;
}

- (jint)lastIndexOfWithId:(id)o {
  return 0;
}

- (id<JavaUtilListIterator>)listIterator {
  return nil;
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)i {
  return nil;
}

- (id<JavaUtilList>)subListWithInt:(jint)i
                           withInt:(jint)i1 {
  return nil;
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
  return false;
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
  return false;
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
  return false;
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)objects {
  return [IOSObjectArray arrayWithLength:0 type:NSObject_class_()];
}

- (void)replaceAllWithJavaUtilFunctionUnaryOperator:(id<JavaUtilFunctionUnaryOperator>)arg0 {
  JavaUtilList_replaceAllWithJavaUtilFunctionUnaryOperator_(self, arg0);
}

- (void)sortWithJavaUtilComparator:(id<JavaUtilComparator>)arg0 {
  JavaUtilList_sortWithJavaUtilComparator_(self, arg0);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilList_spliterator(self);
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)arg0 {
  return JavaUtilCollection_removeIfWithJavaUtilFunctionPredicate_(self, arg0);
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (id<JavaUtilStreamStream>)parallelStream {
  return JavaUtilCollection_parallelStream(self);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)arg0 {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, arg0);
}

- (NSUInteger)countByEnumeratingWithState:(NSFastEnumerationState *)state objects:(__unsafe_unretained id *)stackbuf count:(NSUInteger)len {
  return JreDefaultFastEnumeration(self, state, stackbuf);
}

@end