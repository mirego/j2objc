// kotlin interop >>

#ifndef _NSMutableDictionary_JavaUtilMap_h
#define _NSMutableDictionary_JavaUtilMap_h

#import "J2ObjC_header.h"
#import "NSDictionary+JavaUtilMap.h"

#include "java/util/Map.h"

@interface NSMutableDictionary<KeyType, ObjectType> (JavaUtilMap) < JavaUtilMap >

- (instancetype)initWithInt:(jint)initialCapacity;
- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor;
- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor withBoolean:(jboolean)accessOrder;

@end

// Empty class to force category to be loaded.
@interface JreNSMutableDictionaryMapCategoryDummy : NSObject
@end

#endif /* _NSMutableDictionary_JavaUtilMap_h */

// kotlin interop <<
