// kotlin interop >>

#ifndef _NSDictionary_JavaUtilMap_h_
#define _NSDictionary_JavaUtilMap_h_

#import "J2ObjC_header.h"

#include "java/util/Map.h"

@interface NSDictionary<KeyType, ObjectType> (JavaUtilMap) < JavaUtilMap >

- (instancetype)initWithJavaUtilMap:(id<JavaUtilMap>)original;

@end

// Empty class to force category to be loaded.
@interface JreNSDictionaryMapCategoryDummy : NSObject
@end

#endif /* _NSDictionary_JavaUtilMap_h_ */

// kotlin interop <<
