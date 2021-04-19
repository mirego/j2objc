
//MIREGO kotlin interop >>

#import "NSArrayToJavaUtilListAdapter.h"
#import "NSEnumeratorToJavaUtilListIteratorAdapter.h"
#include "java/lang/Exception.h"

@implementation NSArrayToJavaUtilsListAdapter

- (instancetype)initWithSourceArray:(NSArray *)sourceArray {
    self = [super init];
    if (self) {
        _sourceArray = sourceArray;
    }
    return self;
}

- (jint)size {
    return (jint)_sourceArray.count;
}

- (jboolean)isEmpty {
    return _sourceArray.count == 0;
}

- (jboolean)containsWithId:(id)o {
    return [_sourceArray containsObject:o];
}

- (id<JavaUtilIterator>)iterator {
    return toJavaUtilListIterator(_sourceArray);
}

- (IOSObjectArray *)toArray {
    unsupportedAdapterCallWithName(@"toArray");
    return [IOSObjectArray arrayWithLength:0 type:NSObject_class_()];
}

- (jboolean)addWithId:(id)o {
    illegalAdapterMutableCallWithName(@"addWithId");
    return false;
}

- (jboolean)removeWithId:(id)o {
    illegalAdapterMutableCallWithName(@"removeWithId");
    return false;
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    illegalAdapterMutableCallWithName(@"addAllWithJavaUtilCollection");
    return false;
}

- (jboolean)addAllWithInt:(jint)i
   withJavaUtilCollection:(id<JavaUtilCollection>)collection {
    illegalAdapterMutableCallWithName(@"addAllWithInt");
    return false;
}

- (void)clear {
    illegalAdapterMutableCallWithName(@"clear");
}

- (id)getWithInt:(jint)i {
    return [_sourceArray objectAtIndex:i];
}

- (id)setWithInt:(jint)i
          withId:(id)o {
    illegalAdapterMutableCallWithName(@"setWithInt");
    return nil;
}

- (void)addWithInt:(jint)i
            withId:(id)o {
    illegalAdapterMutableCallWithName(@"addWithInt");
}

- (id)removeWithInt:(jint)i {
    illegalAdapterMutableCallWithName(@"removeWithInt");
    return nil;
}

- (jint)indexOfWithId:(id)o {
    return (jint)[_sourceArray indexOfObject:o];
}

- (jint)lastIndexOfWithId:(id)o {
    unsupportedAdapterCallWithName(@"lastIndexOfWithId");
    return 0;
}

- (id<JavaUtilListIterator>)listIterator {
    return toJavaUtilListIterator(_sourceArray);
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)i {
    unsupportedAdapterCallWithName(@"listIteratorWithInt");
    return nil;
}

- (id<JavaUtilList>)subListWithInt:(jint)i
                           withInt:(jint)i1 {
    NSArray *subArray = [_sourceArray subarrayWithRange:NSMakeRange(i, i1 - i)];
    return toJavaUtilList(subArray);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    illegalAdapterMutableCallWithName(@"retainAllWithJavaUtilCollection");
    return false;
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    illegalAdapterMutableCallWithName(@"removeAllWithJavaUtilCollection");
    return false;
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    unsupportedAdapterCallWithName(@"containsAllWithJavaUtilCollection");
    return false;
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)objects {
    unsupportedAdapterCallWithName(@"toArrayWithNSObjectArray");
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
    illegalAdapterMutableCallWithName(@"removeIfWithJavaUtilFunctionPredicate");
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

//MIREGO <<
