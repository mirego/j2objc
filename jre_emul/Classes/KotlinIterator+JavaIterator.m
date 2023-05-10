// kotlin interop >>

#import "KotlinIterator+JavaIterator.h"

#include "java/lang/Exception.h"

@implementation CommonConcreteIterator (JavaUtilIterator)

- (void)remove {
    @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteIterator+JavaUtilIterator");
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
    @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteIterator+JavaUtilIterator");
}

@end

@implementation CommonConcreteMutableIterator (JavaUtilIterator)

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
    @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteMutableIterator+JavaUtilIterator");
}

@end

@implementation CommonConcreteMutableListIterator (JavaUtilListIterator)

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
    @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteMutableListIterator+JavaUtilIterator");
}

- (void)setWithId:(id)e {
    [self setElement:e];
}

- (void)addWithId:(id)e {
    [self addElement:e];
}

@end

// Empty class to force category to be loaded.
@implementation JreIteratorCategoryDummy
@end

// kotlin interop <<
