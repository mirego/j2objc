// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSSet_JavaUtilSet_h
#define _NSSet_JavaUtilSet_h

#import "J2ObjC_header.h"

#include "java/util/Set.h"

@interface NSSet<ObjectType> (JavaUtilSet) < JavaUtilSet >

- (instancetype)initWithElements:(id<JavaUtilCollection>)elements;

@end

// Empty class to force category to be loaded.
@interface JreNSSetSetCategoryDummy : NSObject
@end

#endif /* _NSSet_JavaUtilSet_h */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
