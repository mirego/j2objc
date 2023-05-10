// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSArray_JavaUtilList_h
#define _NSArray_JavaUtilList_h

#import "J2ObjC_header.h"

#include "java/util/List.h"

@interface NSArray<ObjectType> (JavaUtilList) < JavaUtilList >

- (instancetype)initWithElements:(id<JavaUtilCollection>)elements;

@end

// Empty class to force category to be loaded.
@interface JreNSArrayListCategoryDummy : NSObject
@end

#endif /* _NSArray_JavaUtilList_h */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
