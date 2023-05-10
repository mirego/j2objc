// kotlin interop >>

#import "NSMutableDictionary+JavaUtilMap.h"
#import "NSMutableSet+JavaUtilSet.h"
#import "KotlinIterator+JavaIterator.h"
#import "J2ObjC_source.h"

#include "java/lang/Exception.h"
#include "java/util/Map.h"
#include "java/util/Set.h"

#define CHECK_IS_COMMON_MUTABLE_DICTIONARY()\
  if (![self isKindOfClass:CommonMutableDictionary.class]) {\
    @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), [NSString stringWithFormat:@"%@ is not a CommonMutableDictionary", NSStringFromClass(self.class)]);\
  }

CommonMutableDictionary *create_CommonMutableDictionary_init() {
  return RETAIN_([CommonHashMapBridge.shared create]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableDictionary *create_CommonMutableDictionary_initWithOriginal_(id<JavaUtilMap> original) {
  CommonMutableDictionary *map = [CommonHashMapBridge.shared create];
  if ([original isKindOfClass:NSDictionary.class]) {
    [(NSDictionary *)original enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
      [CommonHashMapBridge.shared putHashMap:map key:key value:value];
    }];
  } else {
    for (id<JavaUtilMap_Entry> entry in original.entrySet) {
      [CommonHashMapBridge.shared putHashMap:map key:entry.getKey value:entry.getValue];
    }
  }
  return RETAIN_(map);
}

CommonMutableDictionary *new_CommonMutableDictionary_init() {
  return RETAIN_([CommonHashMapBridge.shared create]);
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_(jint initialCapacity) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity]);
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_loadFactor_(jint initialCapacity, jfloat loadFactor) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  return RETAIN_([CommonHashMapBridge.shared createInitialCapacity:initialCapacity loadFactor:loadFactor]);
}

CommonMutableDictionary *new_CommonMutableDictionary_initWithOriginal_(id<JavaUtilMap> original) {
  CommonMutableDictionary *map = [CommonHashMapBridge.shared create];
  if ([original isKindOfClass:NSDictionary.class]) {
    [(NSDictionary *)original enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
      [CommonHashMapBridge.shared putHashMap:map key:key value:value];
    }];
  } else {
    for (id<JavaUtilMap_Entry> entry in original.entrySet) {
      [CommonHashMapBridge.shared putHashMap:map key:entry.getKey value:entry.getValue];
    }
  }
  return RETAIN_(map);
}

void CommonMutableDictionary_init(CommonMutableDictionary *self) {
  [self init];
}

void CommonMutableDictionary_initWithInitialCapacity_(CommonMutableDictionary *self, jint initialCapacity) {
  [self initWithInitialCapacity:initialCapacity];
}

void CommonMutableDictionary_initWithInitialCapacity_loadFactor_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor) {
  [self initWithInitialCapacity:initialCapacity loadFactor:loadFactor];
}

void CommonMutableDictionary_initWithInitialCapacity_loadFactor_accessOrder_(CommonMutableDictionary *self, jint initialCapacity, jfloat loadFactor, jboolean accessOrder) {
  [self initWithInitialCapacity:initialCapacity loadFactor:loadFactor accessOrder:accessOrder];
}

void CommonMutableDictionary_initWithOriginal_(CommonMutableDictionary *self, id<JavaUtilMap> original) {
  [self initWithOriginal:original];
}

@implementation NSMutableDictionary (JavaUtilMap)

- (instancetype)initWithInitialCapacity:(jint)initialCapacity {
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithInitialCapacity:(jint)initialCapacity loadFactor:(jfloat)loadFactor {
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithInitialCapacity:(jint)initialCapacity loadFactor:(jfloat)loadFactor accessOrder:(jboolean)accessOrder {
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithOriginal:(id<JavaUtilMap>)original {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
  return [self init];
}

// JavaUtilMap

- (jint)size {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared sizeHashMap:(id)self];
}

- (jboolean)isEmpty {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared isEmptyHashMap:(id)self];
}

- (jboolean)containsKeyWithId:(id)key {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared containsKeyHashMap:(id)self key:key];
}

- (jboolean)containsValueWithId:(id)value {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared containsValueHashMap:(id)self value:value];
}

- (id __nullable)getWithId:(id)key {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return javaUnwrapNull([CommonHashMapBridge.shared getHashMap:(id)self key:key]);
}

- (id __nullable)putWithId:(id)key
                  withId:(id)value {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return javaUnwrapNull([CommonHashMapBridge.shared putHashMap:(id)self key:key value:value]);
}

- (id __nullable)removeWithId:(id)key {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return javaUnwrapNull([CommonHashMapBridge.shared removeHashMap:(id)self key:key]);
}

- (void)putAllWithJavaUtilMap:(id<JavaUtilMap>)m {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  if ([m isKindOfClass:NSDictionary.class]) {
    [CommonHashMapBridge.shared putAllHashMap:(id)self from:(id)m];
  } else {
    NSMutableDictionary *mutableDictionary = [NSMutableDictionary dictionary];
    for (id<JavaUtilMap_Entry> entry in m.entrySet) {
      [CommonHashMapBridge.shared putHashMap:(id)self key:entry.getKey value:entry.getValue];
    }
  }
}

- (void)clear {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  [CommonHashMapBridge.shared clearHashMap:(id)self];
}

- (id<JavaUtilSet>)keySet {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared keysHashMap:(id)self];
}

- (id<JavaUtilCollection>)values {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared valuesHashMap:(id)self];
}

- (id<JavaUtilSet>)entrySet {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared entriesHashMap:(id)self];
}

//- (jboolean)isEqual:(id)o {
//   CHECK_IS_COMMON_MUTABLE_DICTIONARY()
//   return [CommonHashMapBridge.shared equalsHashMap:self other:o];
//}

//- (NSUInteger)hash {
//  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
//  return [CommonHashMapBridge.shared hashCodeHashMap:self];
//}

- (id __nullable)getOrDefaultWithId:(id)key
                             withId:(id)defaultValue {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared getOrDefaultHashMap:(id)self key:key defaultValue:defaultValue];
}

- (void)forEachWithJavaUtilFunctionBiConsumer:(id<JavaUtilFunctionBiConsumer>)action {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

- (void)replaceAllWithJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)function {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

- (id __nullable)putIfAbsentWithId:(id)key
                            withId:(id)value {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared putIfAbsentHashMap:(id)self key:key value:value];
}

- (jboolean)removeWithId:(id)key
                  withId:(id)value {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared removeHashMap:(id)self key:key value:value];
}

- (jboolean)replaceWithId:(id)key
                   withId:(id)oldValue
                   withId:(id)newValue {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared replaceHashMap:(id)self key:key oldValue:oldValue newValue:newValue];
}

- (id __nullable)replaceWithId:(id)key
                        withId:(id)value {
  CHECK_IS_COMMON_MUTABLE_DICTIONARY()
  return [CommonHashMapBridge.shared replaceHashMap:(id)self key:key value:value];
}

- (id __nullable)computeIfAbsentWithId:(id)key
          withJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)mappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

- (id __nullable)computeIfPresentWithId:(id)key
         withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

- (id __nullable)computeWithId:(id)key
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

- (id __nullable)mergeWithId:(id)key
                      withId:(id)value
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSMutableDictionary+JavaUtilMap");
}

@end

@implementation CommonConcreteMutableEntry (JavaUtilMap_Entry)

- (id)getKey {
  return javaUnwrapNull(self.key);
}

- (id)getValue {
  return javaUnwrapNull(self.value);
}

- (id)setValueWithId:(id)value {
  return javaUnwrapNull([self setValueNewValue:value]);
}

- (jboolean)isEqual:(id)o {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteMutableEntry+JavaUtilMap_Entry");
}

- (NSUInteger)hash {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"CommonConcreteMutableEntry+JavaUtilMap_Entry");
}

@end

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonMutableDictionary)

J2OBJC_NAME_MAPPING(CommonMutableDictionary, "java.util.HashMap", "CommonMutableDictionary")

// Empty class to force category to be loaded.
@implementation JreNSMutableDictionaryMapCategoryDummy
@end

// kotlin interop <<
