// kotlin interop >>

#ifndef _KotlinMutableDictionary_JavaHashMap_h
#define _KotlinMutableDictionary_JavaHashMap_h

#import "J2ObjC_header.h"
#import "J2ObjC_kotlinTypes.h"
#import "NSDictionary+JavaUtilMap.h"

FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_init();
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT CommonMutableDictionary *create_CommonMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original);

FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_init() __attribute__((ns_returns_retained));
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_(jint initialCapacity) __attribute__((ns_returns_retained));
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) __attribute__((ns_returns_retained));
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) __attribute__((ns_returns_retained));
FOUNDATION_EXPORT CommonMutableDictionary *new_CommonMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) __attribute__((ns_returns_retained));

FOUNDATION_EXPORT void CommonMutableDictionary_init(CommonMutableDictionary *self);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInt_(CommonMutableDictionary *self, jint initialCapacity);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInt_withFloat_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithInt_withFloat_withBoolean_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder);
FOUNDATION_EXPORT void CommonMutableDictionary_initWithJavaUtilMap_(CommonMutableDictionary *self, id<JavaUtilMap> original);

J2OBJC_EMPTY_STATIC_INIT(CommonMutableDictionary)

J2OBJC_TYPE_LITERAL_HEADER(CommonMutableDictionary)

#endif /* _KotlinMutableDictionary_JavaHashMap_h */

// kotlin interop <<
