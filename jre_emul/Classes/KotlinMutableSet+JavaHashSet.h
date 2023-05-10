// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _KotlinMutableSet_JavaHashSet_h
#define _KotlinMutableSet_JavaHashSet_h

#import "J2ObjC_header.h"
#import "J2ObjC_kotlinTypes.h"
#import "NSMutableSet+JavaUtilSet.h"

@protocol JavaUtilCollection;

FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_init();
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithElements_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_init();
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithElements_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT void CommonMutableSet_init(CommonMutableSet *self);
FOUNDATION_EXPORT void CommonMutableSet_initWithInitialCapacity_(CommonMutableSet *self, jint initialCapacity);
FOUNDATION_EXPORT void CommonMutableSet_initWithInitialCapacity_loadFactor_(CommonMutableSet *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void CommonMutableSet_initWithElements_(CommonMutableSet *self, id<JavaUtilCollection> elements);

J2OBJC_EMPTY_STATIC_INIT(CommonMutableSet)

J2OBJC_TYPE_LITERAL_HEADER(CommonMutableSet)

#endif /* _KotlinMutableSet_JavaHashSet_h */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
