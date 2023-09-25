// kotlin interop >>

#ifndef _NSMutableArray_JavaArrayList_h_
#define _NSMutableArray_JavaArrayList_h_

#import "J2ObjC_header.h"
#import "NSMutableArray+JavaUtilList.h"

@protocol JavaUtilCollection;

FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_init();
FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_initWithInt_(jint initialCapacity);
FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_initWithJavaUtilCollection_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_init() NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_initWithInt_(jint initialCapacity) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) NS_RETURNS_RETAINED;

@interface NSMutableArray<ObjectType> (JavaArrayList)

- (void)trimToSize;
- (void)ensureCapacityWithInt:(jint)minCapacity;

@end

J2OBJC_EMPTY_STATIC_INIT(NSMutableArray)

J2OBJC_TYPE_LITERAL_HEADER(NSMutableArray)

// Empty class to force category to be loaded.
@interface JreNSMutableArrayArrayListCategoryDummy : NSObject
@end

#endif /* _NSMutableArray_JavaArrayList_h_ */

// kotlin interop <<
