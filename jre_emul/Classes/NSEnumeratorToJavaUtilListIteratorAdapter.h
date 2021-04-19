
//MIREGO kotlin interop >>

#ifndef _NSEnumeratorToJavaUtilListIteratorAdapter_h
#define _NSEnumeratorToJavaUtilListIteratorAdapter_h

#import "J2ObjC_common.h"

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#include "java/util/ListIterator.h"

@protocol JavaUtilListIterator;

@interface NSEnumeratorToJavaUtilListIteratorAdapter : NSObject < JavaUtilListIterator >

@property (strong, nonatomic) NSEnumerator *sourceEnumerator;
@property (readonly) NSUInteger sourceSize;
@property jint currentIndex;

#pragma mark Public

- (instancetype)initWithSourceEnumerator:(NSEnumerator *)sourceEnumerator
                              sourceSize:(NSUInteger)sourceSize;

- (void)addWithId:(id)o;

- (jboolean)hasNext;

- (jboolean)hasPrevious;

- (id)next;

- (jint)nextIndex;

- (id)previous;

- (jint)previousIndex;

- (void)remove;

- (void)setWithId:(id)o;

@end

#endif /* _NSEnumeratorToJavaUtilListIteratorAdapter_h */

//MIREGO <<
