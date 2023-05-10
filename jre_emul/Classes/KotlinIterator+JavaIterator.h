// kotlin interop >>

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _KotlinIterator_JavaIterator_
#define _KotlinIterator_JavaIterator_

#import "J2ObjC_common.h"
#import "J2ObjC_kotlinTypes.h"

#include "java/util/Iterator.h"
#include "java/util/ListIterator.h"

@interface CommonConcreteIterator<T> (JavaUtilIterator) <JavaUtilIterator>
@end

@interface CommonConcreteMutableIterator<T> (JavaUtilIterator) <JavaUtilIterator>
@end

@interface CommonConcreteMutableListIterator<T> (JavaUtilListIterator) <JavaUtilListIterator>
@end

// Empty class to force category to be loaded.
@interface JreIteratorCategoryDummy : NSObject
@end

#endif /* _KotlinIterator_JavaIterator_ */

#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
