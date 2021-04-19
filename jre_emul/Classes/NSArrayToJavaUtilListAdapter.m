
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
    [self unsupportedCallWithName:@"toArray"];
    return [IOSObjectArray arrayWithLength:0 type:NSObject_class_()];
}

- (jboolean)addWithId:(id)o {
    [self illegalCallWithName:@"addWithId"];
    return false;
}

- (jboolean)removeWithId:(id)o {
    [self illegalCallWithName:@"removeWithId"];
    return false;
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    [self illegalCallWithName:@"addAllWithJavaUtilCollection"];
    return false;
}

- (jboolean)addAllWithInt:(jint)i
   withJavaUtilCollection:(id<JavaUtilCollection>)collection {
    [self illegalCallWithName:@"addAllWithInt"];
    return false;
}

- (void)clear {
    [self illegalCallWithName:@"clear"];
}

- (id)getWithInt:(jint)i {
    return [_sourceArray objectAtIndex:i];
}

- (id)setWithInt:(jint)i
          withId:(id)o {
    [self illegalCallWithName:@"setWithInt"];
    return nil;
}

- (void)addWithInt:(jint)i
            withId:(id)o {
    [self illegalCallWithName:@"addWithInt"];
}

- (id)removeWithInt:(jint)i {
    [self illegalCallWithName:@"removeWithInt"];
    return nil;
}

- (jint)indexOfWithId:(id)o {
    return (jint)[_sourceArray indexOfObject:o];
}

- (jint)lastIndexOfWithId:(id)o {
    [self unsupportedCallWithName:@"lastIndexOfWithId"];
    return 0;
}

- (id<JavaUtilListIterator>)listIterator {
    return toJavaUtilListIterator(_sourceArray);
}

- (id<JavaUtilListIterator>)listIteratorWithInt:(jint)i {
    [self unsupportedCallWithName:@"listIteratorWithInt"];
    return nil;
}

- (id<JavaUtilList>)subListWithInt:(jint)i
                           withInt:(jint)i1 {
    NSArray *subArray = [_sourceArray subarrayWithRange:NSMakeRange(i, i1 - i)];
    return toJavaUtilList(subArray);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    [self illegalCallWithName:@"retainAllWithJavaUtilCollection"];
    return false;
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    [self illegalCallWithName:@"removeAllWithJavaUtilCollection"];
    return false;
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection {
    [self unsupportedCallWithName:@"containsAllWithJavaUtilCollection"];
    return false;
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)objects {
    [self unsupportedCallWithName:@"toArrayWithNSObjectArray"];
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
    [self illegalCallWithName:@"removeIfWithJavaUtilFunctionPredicate"];
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

- (void) illegalCallWithName:(NSString*)name {
    NSString *message = [NSString stringWithFormat:@"Cannot call %@ on NSArrayToJavaUtilListAdapter, use NSMutableArrayToJavaUtilListAdapter", name];
    @throw create_JavaLangException_initWithNSString_(message);
}

- (void) unsupportedCallWithName:(NSString*)name {
    NSString *message = [NSString stringWithFormat:@"Cannot call %@ on NSArrayToJavaUtilListAdapter, not implemented yet", name];
    @throw create_JavaLangException_initWithNSString_(message);
}

@end
