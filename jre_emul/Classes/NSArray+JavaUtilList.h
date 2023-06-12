// kotlin interop >>

#ifndef _NSArray_JavaUtilList_h
#define _NSArray_JavaUtilList_h

#import "J2ObjC_header.h"

#include "java/util/List.h"

@interface NSArray<ObjectType> (JavaUtilList) < JavaUtilList >

- (instancetype)initWithJavaUtilCollection:(id<JavaUtilCollection>)elements;

@end

// Empty class to force category to be loaded.
@interface JreNSArrayListCategoryDummy : NSObject
@end

#endif /* _NSArray_JavaUtilList_h */

// kotlin interop <<
