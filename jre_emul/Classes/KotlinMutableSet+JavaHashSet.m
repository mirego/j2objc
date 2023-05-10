// kotlin interop >>

#import "KotlinMutableSet+JavaHashSet.h"
#import "J2ObjC_common.h"
#import "J2ObjC_source.h"

CommonMutableSet *create_CommonMutableSet_init() {
  return RETAIN_([CommonHashSetFactory.shared create]);
}

CommonMutableSet *create_CommonMutableSet_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonHashSetFactory.shared createInitialCapacity:initialCapacity]);
}

CommonMutableSet *create_CommonMutableSet_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor) {
  return RETAIN_([CommonHashSetFactory.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableSet *create_CommonMutableSet_initWithElements_(id<JavaUtilCollection> elements) {
  return RETAIN_([CommonHashSetFactory.shared createElements:javaWrapCollection(elements)]);
}

CommonMutableSet *new_CommonMutableSet_init() {
  return RETAIN_([CommonHashSetFactory.shared create]);
}

CommonMutableSet *new_CommonMutableSet_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonHashSetFactory.shared createInitialCapacity:initialCapacity]);
}

CommonMutableSet *new_CommonMutableSet_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor) {
  return RETAIN_([CommonHashSetFactory.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableSet *new_CommonMutableSet_initWithElements_(id<JavaUtilCollection> elements) {
  return RETAIN_([CommonHashSetFactory.shared createElements:javaWrapCollection(elements)]);
}

void CommonMutableSet_init(CommonMutableSet *self) {
  [self init];
}

void CommonMutableSet_initWithInitialCapacity_(CommonMutableSet *self, jint initialCapacity) {
  [self initWithInitialCapacity:initialCapacity];
}

void CommonMutableSet_initWithInitialCapacity_loadFactor_(CommonMutableSet *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInitialCapacity:initialCapacity loadFactor:loadFactor];
}

void CommonMutableSet_initWithElements_(CommonMutableSet *self, id<JavaUtilCollection> elements) {
  [self initWithElements:elements];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonMutableSet)

J2OBJC_NAME_MAPPING(CommonMutableSet, "java.util.HashSet", "CommonMutableSet")

// kotlin interop <<
