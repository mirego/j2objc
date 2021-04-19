//
//  NSEnumeratorToJavaUtilIteratorAdapter.h
//  jre_emul
//
//  Created by Guillaume Audet on 2021-04-19.
//

#ifndef NSEnumeratorToJavaUtilListIteratorAdapter_h
#define NSEnumeratorToJavaUtilListIteratorAdapter_h

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

#endif /* NSEnumeratorToJavaUtilListIteratorAdapter_h */
