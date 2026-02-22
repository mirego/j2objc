// kotlin interop >>

#import "NSMutableDictionary+JavaHashMap.h"

#import "J2ObjC_common.h"
#import "J2ObjC_source.h"
#import "NSDictionary+JavaUtilMap.h"
#import "NSMutableDictionary+JavaUtilMap.h"

NSMutableDictionary *create_NSMutableDictionary_init() {
  return AUTORELEASE([[NSMutableDictionary alloc] init]);
}

NSMutableDictionary *create_NSMutableDictionary_initWithInt_(jint initialCapacity) {
  return AUTORELEASE([[NSMutableDictionary alloc] initWithInt:initialCapacity]);
}

NSMutableDictionary *create_NSMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return AUTORELEASE([[NSMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

NSMutableDictionary *create_NSMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return AUTORELEASE([[NSMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

NSMutableDictionary *create_NSMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) {
  return AUTORELEASE([[NSMutableDictionary alloc] initWithJavaUtilMap:original]);
}

NSMutableDictionary *new_NSMutableDictionary_init() {
  return [[NSMutableDictionary alloc] init];
}

NSMutableDictionary *new_NSMutableDictionary_initWithInt_(jint initialCapacity) {
  return [[NSMutableDictionary alloc] initWithInt:initialCapacity];
}

NSMutableDictionary *new_NSMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return [[NSMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

NSMutableDictionary *new_NSMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return [[NSMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

NSMutableDictionary *new_NSMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) {
  return [[NSMutableDictionary alloc] initWithJavaUtilMap:original];
}

void NSMutableDictionary_init(NSMutableDictionary *self) {
  [self init];
}

void NSMutableDictionary_initWithInt_(NSMutableDictionary *self, jint initialCapacity) {
  [self initWithInt:initialCapacity];
}

void NSMutableDictionary_initWithInt_withFloat_(NSMutableDictionary *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInt:initialCapacity withFloat:loadFactor];
}

void NSMutableDictionary_initWithInt_withFloat_withBoolean_(NSMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  [self initWithInt:initialCapacity withFloat:loadFactor withBoolean:accessOrder];
}

void NSMutableDictionary_initWithJavaUtilMap_(NSMutableDictionary *self, id<JavaUtilMap> original) {
  [self initWithJavaUtilMap:original];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(NSMutableDictionary)

J2OBJC_NAME_MAPPING(NSMutableDictionary, "java.util.HashMap", "NSMutableDictionary")

// kotlin interop <<
