// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSMutableSet_JavaUtilSet_h
#define _NSMutableSet_JavaUtilSet_h

#import "J2ObjC_header.h"
#import "NSSet+JavaUtilSet.h"

#include "java/util/Set.h"

@interface NSMutableSet<ObjectType> (JavaUtilSet) < JavaUtilSet >

- (instancetype)initWithInitialCapacity:(jint)initialCapacity;
- (instancetype)initWithInitialCapacity:(jint)initialCapacity loadFactor:(jfloat)loadFactor;

@end

// Empty class to force category to be loaded.
@interface JreNSMutableSetSetCategoryDummy : NSObject
@end

#endif /* _NSMutableSet_JavaUtilSet_h */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
