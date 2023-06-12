// kotlin interop >>

#import "KotlinMutableDictionary+JavaHashMap.h"

#import "J2ObjC_common.h"
#import "J2ObjC_source.h"
#import "NSDictionary+JavaUtilMap.h"
#import "NSMutableDictionary+JavaUtilMap.h"

CommonMutableDictionary *create_CommonMutableDictionary_init() {
  return AUTORELEASE([[CommonMutableDictionary alloc] init]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_(jint initialCapacity) {
  return AUTORELEASE([[CommonMutableDictionary alloc] initWithInt:initialCapacity]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return AUTORELEASE([[CommonMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return AUTORELEASE([[CommonMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) {
  return AUTORELEASE([[CommonMutableDictionary alloc] initWithJavaUtilMap:original]);
}

CommonMutableDictionary *new_CommonMutableDictionary_init() {
  return [[CommonMutableDictionary alloc] init];
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_(jint initialCapacity) {
  return [[CommonMutableDictionary alloc] initWithInt:initialCapacity];
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return [[CommonMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInt_withFloat_withBoolean_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return [[CommonMutableDictionary alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithJavaUtilMap_(id<JavaUtilMap> original) {
  return [[CommonMutableDictionary alloc] initWithJavaUtilMap:original];
}

void CommonMutableDictionary_init(CommonMutableDictionary *self) {
  [self init];
}

void CommonMutableDictionary_initWithInt_(CommonMutableDictionary *self, jint initialCapacity) {
  [self initWithInt:initialCapacity];
}

void CommonMutableDictionary_initWithInt_withFloat_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInt:initialCapacity withFloat:loadFactor];
}

void CommonMutableDictionary_initWithInt_withFloat_withBoolean_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  [self initWithInt:initialCapacity withFloat:loadFactor withBoolean:accessOrder];
}

void CommonMutableDictionary_initWithJavaUtilMap_(CommonMutableDictionary *self, id<JavaUtilMap> original) {
  [self initWithJavaUtilMap:original];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonMutableDictionary)

J2OBJC_NAME_MAPPING(CommonMutableDictionary, "java.util.HashMap", "CommonMutableDictionary")

// kotlin interop <<
