// kotlin interop >>

#import "NSDictionary+JavaUtilMap.h"
#import "NSDictionary+JavaUtilMap_PackagePrivate.h"

#import "NSArray+JavaUtilList.h"

#include "java/lang/UnsupportedOperationException.h"
#include "java/util/HashSet.h"
#include "java/util/Objects.h"
#include "java/util/function/BiConsumer.h"

@implementation NSDictionary (JavaUtilMap)

- (instancetype)initWithJavaUtilMap:(id<JavaUtilMap>)original {
  return [self initWithDictionary:javaWrapMap(nil_chk(original))];
}

- (id)java_clone {
  return AUTORELEASE([self copy]);
}

- (jint)size {
  return (jint) self.count;
}

- (jboolean)isEmpty {
  return self.size == 0;
}

- (jboolean)containsKeyWithId:(id)key {
  return [self objectForKey:javaWrapKey(key)] != nil;
}

- (jboolean)containsValueWithId:(id)value  {
  return [self.allValues containsObject:javaWrapNull(value)];
}

- (id __nullable)getWithId:(id)key {
  return javaUnwrapNull([self objectForKey:javaWrapKey(key)]);
}

- (id __nullable)putWithId:(id)key
                    withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)removeWithId:(id)key {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)putAllWithJavaUtilMap:(id<JavaUtilMap>)m {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)clear {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

//- (jboolean)isEqual:(id)o {
//}

- (NSUInteger)hash {
  __block jint h = 0;
  [self enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    h += ((jint) [javaUnwrapKey(key) hash] ^ (jint) [javaUnwrapNull(value) hash]);
  }];
  return h;
}

- (id<JavaUtilSet>)keySet {
  NSMutableSet *keySet = [NSMutableSet setWithCapacity:self.size];
  [self enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [keySet addObject:javaWrapNull(javaUnwrapKey(key))];
  }];

  return keySet;
}

- (id<JavaUtilCollection>)values {
  return self.allValues;
}

- (id<JavaUtilSet>)entrySet {
  id<JavaUtilSet> entrySet = AUTORELEASE(new_NSMutableSet_init());
  [self enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [entrySet addWithId:AUTORELEASE([self java_entryForKey:javaUnwrapKey(key)])];
  }];
  return entrySet;
}

- (id __nullable)getOrDefaultWithId:(id)key
                             withId:(id)defaultValue {
  id currentValue = [self objectForKey:javaWrapKey(key)];
  return currentValue != nil ? javaUnwrapNull(currentValue) : defaultValue;
}

- (void)forEachWithJavaUtilFunctionBiConsumer:(id<JavaUtilFunctionBiConsumer>)action {
  (void)nil_chk(action);
  if (self.size > 0) {
    NSEnumerator *enumerator = self.keyEnumerator;
    id key;
    while ((key = [enumerator nextObject])) {
      [action acceptWithId:javaUnwrapKey(key) withId:javaUnwrapNull([self objectForKey:key])];
    }
  }
}

- (void)replaceAllWithJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)function {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)putIfAbsentWithId:(id)key
                            withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeWithId:(id)key
                  withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)replaceWithId:(id)key
                   withId:(id)oldValue
                   withId:(id)newValue {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)replaceWithId:(id)key
                        withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)computeIfAbsentWithId:(id)key
          withJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)mappingFunction {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)computeIfPresentWithId:(id)key
         withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)computeWithId:(id)key
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (id __nullable)mergeWithId:(id)key
                      withId:(id)value
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (NSDictionary_Entry *)java_entryForKey:(id)key {
  return [[NSDictionary_Entry alloc] initWithDictionary:self key:key];
}

@end

@implementation NSDictionary_Key

- (instancetype)initWithKey:(id)key {
  NSAssert(![key isKindOfClass:NSDictionary_Key.class], @"Wrapping a NSDictionary_Key inside a NSDictionary_Key");
  if (self = [super init]) {
    key_ = RETAIN_(key);
  }
  return self;
}

- (instancetype)copyWithZone:(NSZone *)zone {
  return [[self.class allocWithZone:zone] initWithKey:key_];
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [key_ release];
  [super dealloc];
}
#endif

- (id __nullable)key {
  return key_;
}

- (BOOL)isEqual:(id)object {
  if (object == self) {
    return YES;
  }
  return JavaUtilObjects_equalsWithId_withId_(key_, javaUnwrapKey(object));
}

- (NSUInteger)hash {
  return [key_ hash];
}

- (NSString *)description {
  return [key_ description];
}

@end

@implementation NSDictionary_Entry

- (instancetype)initWithDictionary:(NSDictionary<id, id> *)dictionary key:(id)key {
  if ((self = [super init])) {
    dictionary_ = RETAIN_(dictionary);
    key_ = RETAIN_(key);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [dictionary_ release];
  [key_ release];
  [super dealloc];
}
#endif

- (id)getKey {
  return key_;
}

- (id)getValue {
  return [dictionary_ getWithId:key_];
}

- (id)setValueWithId:(id)object {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (BOOL)isEqual:(id)object {
  if (object == self) {
    return YES;
  }
  if ([object conformsToProtocol:@protocol(JavaUtilMap_Entry)]) {
    id<JavaUtilMap_Entry> other = (id) object;
    return JavaUtilObjects_equalsWithId_withId_(self.getKey, other.getKey)
        && JavaUtilObjects_equalsWithId_withId_(self.getValue, other.getValue);
  }
  return NO;
}

- (NSUInteger)hash {
  return [self.getKey hash] ^ [self.getValue hash];
}

- (NSString *)description {
  return [NSString stringWithFormat:@"%@=%@", self.getKey, self.getValue];
}

@end

// Empty class to force category to be loaded.
@implementation JreNSDictionaryMapCategoryDummy
@end

// kotlin interop <<
