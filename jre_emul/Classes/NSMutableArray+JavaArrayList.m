// kotlin interop >>

#import "NSMutableArray+JavaArrayList.h"

#import "J2ObjC_common.h"
#import "J2ObjC_kotlinTypes.h"
#import "J2ObjC_source.h"

NSMutableArray *create_NSMutableArray_init() {
  return AUTORELEASE([[NSMutableArray alloc] init]);
}

NSMutableArray *create_NSMutableArray_initWithInt_(jint initialCapacity) {
  return AUTORELEASE([[NSMutableArray alloc] initWithInt:initialCapacity]);
}

NSMutableArray *create_NSMutableArray_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return AUTORELEASE([[NSMutableArray alloc] initWithJavaUtilCollection:elements]);
}

NSMutableArray *new_NSMutableArray_init() {
  return [[NSMutableArray alloc] init];
}

NSMutableArray *new_NSMutableArray_initWithInt_(jint initialCapacity) {
  return [[NSMutableArray alloc] initWithInt:initialCapacity];
}

NSMutableArray *new_NSMutableArray_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return [[NSMutableArray alloc] initWithJavaUtilCollection:elements];
}

@implementation NSMutableArray (JavaArrayList)

- (void)trimToSize {
  // NOP
}

- (void)ensureCapacityWithInt:(jint)minCapacity {
  // NOP
}

@end

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(NSMutableArray)

J2OBJC_NAME_MAPPING(NSMutableArray, "java.util.ArrayList", "NSMutableArray")

// Empty class to force category to be loaded.
@implementation JreNSMutableArrayArrayListCategoryDummy
@end

// kotlin interop <<
