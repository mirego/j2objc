// kotlin interop >>

#import "NSMutableArray+JavaArrayList.h"
#import "J2ObjC_common.h"
#import "J2ObjC_kotlinTypes.h"
#import "J2ObjC_source.h"

NSMutableArray *create_NSMutableArray_init() {
  return RETAIN_([CommonArrayListFactory.shared create]);
}

NSMutableArray *create_NSMutableArray_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonArrayListFactory.shared createInitialCapacity:initialCapacity]);
}

NSMutableArray *create_NSMutableArray_initWithElements_(id<JavaUtilCollection> elements) {
  return RETAIN_([CommonArrayListFactory.shared createElements:javaWrapCollection(elements)]);
}

NSMutableArray *new_NSMutableArray_init() {
  return RETAIN_([CommonArrayListFactory.shared create]);
}

NSMutableArray *new_NSMutableArray_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonArrayListFactory.shared createInitialCapacity:initialCapacity]);
}

NSMutableArray *new_NSMutableArray_initWithElements_(id<JavaUtilCollection> elements) {
  return RETAIN_([CommonArrayListFactory.shared createElements:javaWrapCollection(elements)]);
}

void NSMutableArray_init(NSMutableArray *self) {
  [self init];
}

void NSMutableArray_initWithInitialCapacity_(NSMutableArray *self, jint initialCapacity) {
  [self initWithInitialCapacity:initialCapacity];
}

void NSMutableArray_initWithElements_(NSMutableArray *self, id<JavaUtilCollection> elements) {
  [self initWithElements:elements];
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
