// kotlin interop >>

#import "KotlinMutableSet+JavaHashSet.h"

#import "J2ObjC_common.h"
#import "J2ObjC_source.h"
#import "NSMutableSet+JavaUtilSet.h"
#import "NSSet+JavaUtilSet.h"

CommonMutableSet *create_CommonMutableSet_init() {
  return AUTORELEASE([[CommonMutableSet alloc] init]);
}

CommonMutableSet *create_CommonMutableSet_initWithInt_(jint initialCapacity) {
  return AUTORELEASE([[CommonMutableSet alloc] initWithInt:initialCapacity]);
}

CommonMutableSet *create_CommonMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return AUTORELEASE([[CommonMutableSet alloc] initWithInt:initialCapacity withFloat:loadFactor]);
}

CommonMutableSet *create_CommonMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return AUTORELEASE([[CommonMutableSet alloc] initWithJavaUtilCollection:elements]);
}

CommonMutableSet *new_CommonMutableSet_init() {
  return [[CommonMutableSet alloc] init];
}

CommonMutableSet *new_CommonMutableSet_initWithInt_(jint initialCapacity) {
  return [[CommonMutableSet alloc] initWithInt:initialCapacity];
}

CommonMutableSet *new_CommonMutableSet_initWithInt_withFloat_(jint initialCapacity, jfloat loadFactor) {
  return [[CommonMutableSet alloc] initWithInt:initialCapacity withFloat:loadFactor];
}

CommonMutableSet *new_CommonMutableSet_initWithJavaUtilCollection_(id<JavaUtilCollection> elements) {
  return [[CommonMutableSet alloc] initWithJavaUtilCollection:elements];
}

void CommonMutableSet_init(CommonMutableSet *self) {
  [self init];
}

void CommonMutableSet_initWithInt_(CommonMutableSet *self, jint initialCapacity) {
  [self initWithInt:initialCapacity];
}

void CommonMutableSet_initWithInt_withFloat_(CommonMutableSet *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInt:initialCapacity withFloat:loadFactor];
}

void CommonMutableSet_initWithJavaUtilCollection_(CommonMutableSet *self, id<JavaUtilCollection> elements) {
  [self initWithJavaUtilCollection:elements];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonMutableSet)

J2OBJC_NAME_MAPPING(CommonMutableSet, "java.util.HashSet", "CommonMutableSet")

// kotlin interop <<
