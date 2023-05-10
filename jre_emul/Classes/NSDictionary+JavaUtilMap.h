// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _NSDictionary_JavaUtilMap_h_
#define _NSDictionary_JavaUtilMap_h_

#import "J2ObjC_header.h"

#include "java/util/Map.h"

@interface NSDictionary<KeyType, ObjectType> (JavaUtilMap) < JavaUtilMap >
@end

// Empty class to force category to be loaded.
@interface JreNSDictionaryMapCategoryDummy : NSObject
@end

#endif /* _NSDictionary_JavaUtilMap_h_ */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
