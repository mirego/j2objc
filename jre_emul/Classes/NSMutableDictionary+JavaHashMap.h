// kotlin interop >>

#ifndef _NSMutableDictionary_JavaHashMap_h
#define _NSMutableDictionary_JavaHashMap_h

#import "J2ObjC_header.h"
#import "NSDictionary+JavaUtilMap.h"

FOUNDATION_EXPORT NSMutableDictionary *create_NSMutableDictionary_init();
FOUNDATION_EXPORT NSMutableDictionary *create_NSMutableDictionary_initWithInt_(jint initialCapacity);
FOUNDATION_EXPORT NSMutableDictionary *create_NSMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT NSMutableDictionary *create_NSMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT NSMutableDictionary *create_NSMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original);

FOUNDATION_EXPORT NSMutableDictionary *new_NSMutableDictionary_init() NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableDictionary *new_NSMutableDictionary_initWithInt_(jint initialCapacity) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableDictionary *new_NSMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableDictionary *new_NSMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableDictionary *new_NSMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT void NSMutableDictionary_init(NSMutableDictionary *self);
FOUNDATION_EXPORT void NSMutableDictionary_initWithInt_(NSMutableDictionary *self, jint initialCapacity);
FOUNDATION_EXPORT void NSMutableDictionary_initWithInt_withFloat_(NSMutableDictionary *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void NSMutableDictionary_initWithInt_withFloat_withBoolean_(NSMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT void NSMutableDictionary_initWithJavaUtilMap_(NSMutableDictionary *self, id<JavaUtilMap> original);

J2OBJC_EMPTY_STATIC_INIT(NSMutableDictionary)

J2OBJC_TYPE_LITERAL_HEADER(NSMutableDictionary)

#endif /* _NSMutableDictionary_JavaHashMap_h */

// kotlin interop <<
