// kotlin interop >>

#ifndef _NSMutableArray_JavaUtilList_h_
#define _NSMutableArray_JavaUtilList_h_

#import "J2ObjC_header.h"
#import "NSArray+JavaUtilList.h"

#include "java/util/List.h"
#include "java/util/RandomAccess.h"

@interface NSMutableArray<ObjectType> (JavaUtilList) < JavaUtilList, JavaUtilRandomAccess >

- (instancetype)initWithInt:(jint)initialCapacity;

@end

// Empty class to force category to be loaded.
@interface JreNSMutableArrayListCategoryDummy : NSObject
@end

#endif /* _NSMutableArray_JavaUtilList_h_ */

// kotlin interop <<
