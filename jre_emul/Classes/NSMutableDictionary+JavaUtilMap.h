// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSMutableDictionary_JavaUtilMap_h
#define _NSMutableDictionary_JavaUtilMap_h

#import "J2ObjC_header.h"
#import "J2ObjC_kotlinTypes.h"
#import "NSDictionary+JavaUtilMap.h"

#include "java/util/Collection.h"
#include "java/util/Map.h"

FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_init();
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithOriginal_(id<JavaUtilMap> original);

FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_init();
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithOriginal_(id<JavaUtilMap> original);

FOUNDATION_EXPORT void CommonMutableDictionary_init(CommonMutableDictionary *self);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInitialCapacity_(CommonMutableDictionary *self, jint initialCapacity);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInitialCapacity_loadFactor_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithOriginal_(CommonMutableDictionary *self, id<JavaUtilMap> original);

@interface NSMutableDictionary<KeyType, ObjectType> (JavaUtilMap) < JavaUtilMap >

- (instancetype)initWithInitialCapacity:(jint)initialCapacity;
- (instancetype)initWithInitialCapacity:(jint)initialCapacity loadFactor:(jfloat)loadFactor;
- (instancetype)initWithInitialCapacity:(jint)initialCapacity loadFactor:(jfloat)loadFactor accessOrder:(jboolean)accessOrder;
- (instancetype)initWithOriginal:(id<JavaUtilMap>)original;

@end

@interface CommonConcreteMutableEntry<K, V> (JavaUtilMap_Entry) < JavaUtilMap_Entry >
@end

J2OBJC_EMPTY_STATIC_INIT(CommonMutableDictionary)

J2OBJC_TYPE_LITERAL_HEADER(CommonMutableDictionary)

// Empty class to force category to be loaded.
@interface JreNSMutableDictionaryMapCategoryDummy : NSObject
@end

#endif /* _NSMutableDictionary_JavaUtilMap_h */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
