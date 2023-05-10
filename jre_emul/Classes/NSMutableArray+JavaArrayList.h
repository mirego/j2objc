// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSMutableArray_JavaArrayList_h_
#define _NSMutableArray_JavaArrayList_h_

#import "J2ObjC_header.h"
#import "NSMutableArray+JavaUtilList.h"

@protocol JavaUtilCollection;

FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_init();
FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT NSMutableArray *create_NSMutableArray_initWithElements_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_init();
FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT NSMutableArray *new_NSMutableArray_initWithElements_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT void NSMutableArray_init(NSMutableArray *self);
FOUNDATION_EXPORT void NSMutableArray_initWithInitialCapacity_(NSMutableArray *self, jint initialCapacity);
FOUNDATION_EXPORT void NSMutableArray_initWithElements_(NSMutableArray *self, id<JavaUtilCollection> elements);

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

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
