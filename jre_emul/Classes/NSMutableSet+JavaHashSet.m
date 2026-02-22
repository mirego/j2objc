// kotlin interop >>

#import "NSMutableSet+JavaHashSet.h"

#import "J2ObjC_common.h"
#import "J2ObjC_source.h"
#import "NSMutableSet+JavaUtilSet.h"
#import "NSSet+JavaUtilSet.h"

NSMutableSet *create_NSMutableSet_init() {
  return AUTORELEASE([[NSMutableSet alloc] init]);
}

NSMutableSet *create_NSMutableSet_initWithInt_(jint initialCapacity) {
  return AUTORELEASE([[NSMutableSet alloc] initWithInt:initialCapacity]);
}

NSMutableSet *create_NSMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return AUTORELEASE([[NSMutableSet alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

NSMutableSet *create_NSMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return AUTORELEASE([[NSMutableSet alloc] initWithJavaUtilCollection:elements]);
}

NSMutableSet *new_NSMutableSet_init() {
  return [[NSMutableSet alloc] init];
}

NSMutableSet *new_NSMutableSet_initWithInt_(jint initialCapacity) {
  return [[NSMutableSet alloc] initWithInt:initialCapacity];
}

NSMutableSet *new_NSMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return [[NSMutableSet alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

NSMutableSet *new_NSMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return [[NSMutableSet alloc] initWithJavaUtilCollection:elements];
}

void NSMutableSet_init(NSMutableSet *self) {
  [self init];
}

void NSMutableSet_initWithInt_(NSMutableSet *self, jint initialCapacity) {
  [self initWithInt:initialCapacity];
}

void NSMutableSet_initWithInt_withFloat_(NSMutableSet *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInt:initialCapacity withFloat:loadFactor];
}

void NSMutableSet_initWithJavaUtilCollection_(NSMutableSet *self, id<JavaUtilCollection> elements) {
  [self initWithJavaUtilCollection:elements];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(NSMutableSet)

J2OBJC_NAME_MAPPING(NSMutableSet, "java.util.HashSet", "NSMutableSet")

// kotlin interop <<
