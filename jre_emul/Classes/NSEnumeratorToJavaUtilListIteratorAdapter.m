
//MIREGO kotlin interop >>

#import "NSEnumeratorToJavaUtilListIteratorAdapter.h"
#include "java/lang/Exception.h"

@implementation NSEnumeratorToJavaUtilListIteratorAdapter

- (instancetype)initWithSourceEnumerator:(NSEnumerator *)sourceEnumerator
                              sourceSize:(NSUInteger)sourceSize{
    self = [super init];
    if (self) {
        _sourceEnumerator = sourceEnumerator;
        _sourceSize = sourceSize;
        _currentIndex = 0;
    }
    return self;
}

- (jboolean)hasNext {
    return _currentIndex < _sourceSize;
}

- (id)next {
    _currentIndex++;
    return [_sourceEnumerator nextObject];
}

- (jboolean)hasPrevious {
    unsupportedAdapterCallWithName(@"hasPrevious");
    return false;
}

- (id)previous {
    unsupportedAdapterCallWithName(@"previous");
    return nil;
}

- (jint)nextIndex {
    return _currentIndex;
}

- (jint)previousIndex {
    unsupportedAdapterCallWithName(@"previousIndex");
    return 0;
}

- (void)remove {
    illegalAdapterMutableCallWithName(@"remove");
}

- (void)setWithId:(id)o {
    illegalAdapterMutableCallWithName(@"setWithId");
}

- (void)addWithId:(id)o {
    illegalAdapterMutableCallWithName(@"addWithId");
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)arg0 {
    JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, arg0);
}

@end

//MIREGO <<
