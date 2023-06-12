// kotlin interop >>

#ifndef _NSMutableSet_JavaUtilSet_h
#define _NSMutableSet_JavaUtilSet_h

#import "J2ObjC_header.h"
#import "NSSet+JavaUtilSet.h"

#include "java/util/Set.h"

@interface NSMutableSet<ObjectType> (JavaUtilSet) < JavaUtilSet >

- (instancetype)initWithInt:(jint)initialCapacity;
- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor;

@end

// Empty class to force category to be loaded.
@interface JreNSMutableSetSetCategoryDummy : NSObject
@end

#endif /* _NSMutableSet_JavaUtilSet_h */

// kotlin interop <<
