// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSMutableArray_JavaUtilList_h_
#define _NSMutableArray_JavaUtilList_h_

#import "J2ObjC_header.h"
#import "NSArray+JavaUtilList.h"

#include "java/util/List.h"
#include "java/util/RandomAccess.h"

@interface NSMutableArray<ObjectType> (JavaUtilList) < JavaUtilList, JavaUtilRandomAccess >

- (instancetype)initWithInitialCapacity:(jint)initialCapacity;

@end

// Empty class to force category to be loaded.
@interface JreNSMutableArrayListCategoryDummy : NSObject
@end

#endif /* _NSMutableArray_JavaUtilList_h_ */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
