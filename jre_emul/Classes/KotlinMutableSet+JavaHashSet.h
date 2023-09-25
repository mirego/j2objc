// kotlin interop >>

#ifndef _KotlinMutableSet_JavaHashSet_h
#define _KotlinMutableSet_JavaHashSet_h

#import "J2ObjC_header.h"
#import "J2ObjC_kotlinTypes.h"
#import "NSMutableSet+JavaUtilSet.h"

@protocol JavaUtilCollection;

FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_init();
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithInt_(jint initialCapacity);
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT CommonMutableSet *create_CommonMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_init() NS_RETURNS_RETAINED;
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithInt_(jint initialCapacity) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT CommonMutableSet *new_CommonMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT void CommonMutableSet_init(CommonMutableSet *self);
FOUNDATION_EXPORT void CommonMutableSet_initWithInt_(CommonMutableSet *self, jint initialCapacity);
FOUNDATION_EXPORT void CommonMutableSet_initWithInt_withFloat_(CommonMutableSet *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void CommonMutableSet_initWithJavaUtilCollection_(CommonMutableSet *self, id<JavaUtilCollection> elements);

J2OBJC_EMPTY_STATIC_INIT(CommonMutableSet)

J2OBJC_TYPE_LITERAL_HEADER(CommonMutableSet)

#endif /* _KotlinMutableSet_JavaHashSet_h */

// kotlin interop <<
