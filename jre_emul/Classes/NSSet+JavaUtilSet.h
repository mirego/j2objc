// kotlin interop >>

#ifndef _NSSet_JavaUtilSet_h
#define _NSSet_JavaUtilSet_h

#import "J2ObjC_header.h"

#include "java/util/Set.h"

@interface NSSet<ObjectType> (JavaUtilSet) < JavaUtilSet >

- (instancetype)initWithJavaUtilCollection:(id<JavaUtilCollection>)elements;

@end

// Empty class to force category to be loaded.
@interface JreNSSetSetCategoryDummy : NSObject
@end

#endif /* _NSSet_JavaUtilSet_h */

// kotlin interop <<
