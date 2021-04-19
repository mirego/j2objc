
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
    [self unsupportedCallWithName:@"hasPrevious"];
  return false;
}

- (id)previous {
    [self unsupportedCallWithName:@"previous"];
  return nil;
}

- (jint)nextIndex {
  return _currentIndex;
}

- (jint)previousIndex {
    [self unsupportedCallWithName:@"previousIndex"];
  return 0;
}

- (void)remove {
    [self illegalCallWithName:@"remove"];
}

- (void)setWithId:(id)o {
    [self illegalCallWithName:@"setWithId"];
}

- (void)addWithId:(id)o {
    [self illegalCallWithName:@"addWithId"];
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)arg0 {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, arg0);
}

- (void) illegalCallWithName:(NSString*)name {
    NSString *message = [NSString stringWithFormat:@"Cannot call %@ on NSEnumeratorToJavaUtilListIteratorAdapter", name];
    @throw create_JavaLangException_initWithNSString_(message);
}

- (void) unsupportedCallWithName:(NSString*)name {
    NSString *message = [NSString stringWithFormat:@"Cannot call %@ on NSEnumeratorToJavaUtilListIteratorAdapter, not implemented yet", name];
    @throw create_JavaLangException_initWithNSString_(message);
}

@end

//MIREGO <<
