// kotlin interop >>

#ifndef _NSMutableSet_JavaHashSet_h
#define _NSMutableSet_JavaHashSet_h

#import "J2ObjC_header.h"
#import "NSMutableSet+JavaUtilSet.h"

@protocol JavaUtilCollection;

FOUNDATION_EXPORT NSMutableSet *create_NSMutableSet_init();
FOUNDATION_EXPORT NSMutableSet *create_NSMutableSet_initWithInt_(jint initialCapacity);
FOUNDATION_EXPORT NSMutableSet *create_NSMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT NSMutableSet *create_NSMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements);

FOUNDATION_EXPORT NSMutableSet *new_NSMutableSet_init() NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableSet *new_NSMutableSet_initWithInt_(jint initialCapacity) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableSet *new_NSMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) NS_RETURNS_RETAINED;
FOUNDATION_EXPORT NSMutableSet *new_NSMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT void NSMutableSet_init(NSMutableSet *self);
FOUNDATION_EXPORT void NSMutableSet_initWithInt_(NSMutableSet *self, jint initialCapacity);
FOUNDATION_EXPORT void NSMutableSet_initWithInt_withFloat_(NSMutableSet *self, jint initialCapacity, jfloat loadFactor);
FOUNDATION_EXPORT void NSMutableSet_initWithJavaUtilCollection_(NSMutableSet *self, id<JavaUtilCollection> elements);

J2OBJC_EMPTY_STATIC_INIT(NSMutableSet)

J2OBJC_TYPE_LITERAL_HEADER(NSMutableSet)

#endif /* _NSMutableSet_JavaHashSet_h */

// kotlin interop <<
