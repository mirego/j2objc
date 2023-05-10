// kotlin interop >>

#import "NSDictionary+JavaUtilMap.h"

#include "java/lang/Exception.h"
#include "java/lang/UnsupportedOperationException.h"
#include "java/util/HashSet.h"
#include "java/util/function/BiConsumer.h"

@interface NSDictionary_Entry : NSObject<JavaUtilMap_Entry> {
@private
  NSDictionary *dictionary_;
  id key_;
}

- (instancetype)initWithDictionary:(NSDictionary *)dictionary key:(id)key;
@end

@implementation NSDictionary (JavaUtilMap)

- (jint)size {
  return (jint) self.count;
}

- (jboolean)isEmpty {
  return self.count == 0;
}

- (jboolean)containsKeyWithId:(id)key {
  return [self objectForKey:javaWrapNull(key)] != nil;
}

- (jboolean)containsValueWithId:(id)value  {
  return [self.allValues containsObject:javaWrapNull(value)];
}

- (id __nullable)getWithId:(id)key {
  return javaUnwrapNull([self objectForKey:javaWrapNull(key)]);
}

- (id __nullable)putWithId:(id)key
                    withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id __nullable)removeWithId:(id)key {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)putAllWithJavaUtilMap:(id<JavaUtilMap>)m {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (void)clear {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id<JavaUtilSet>)keySet {
  return [NSSet setWithArray:self.allKeys];
}

- (id<JavaUtilCollection>)values {
  return self.allValues;
}

- (id<JavaUtilSet>)entrySet {
  id<JavaUtilSet> set = AUTORELEASE(create_CommonMutableSet_init()); // FIXME FLA Fix later to use LinkedHashSet
  for (id key in self) {
    NSDictionary_Entry *entry =
        AUTORELEASE([[NSDictionary_Entry alloc]
                      initWithDictionary:self key:key]);
    [set addWithId:entry];
  }

  return set;
}

- (id __nullable)getOrDefaultWithId:(id)key
                             withId:(id)defaultValue {
  return javaUnwrapNull([self objectForKey:javaWrapNull(key)]) ?: defaultValue;
}

- (void)forEachWithJavaUtilFunctionBiConsumer:(id<JavaUtilFunctionBiConsumer>)action {
  (void)nil_chk(action);
  if (self.count > 0) {
    NSEnumerator *enumerator = self.keyEnumerator;
    id key;
    while ((key = [enumerator nextObject])) {
      [action acceptWithId:key withId:javaUnwrapNull([self objectForKey:key])];
    }
  }
}

- (void)replaceAllWithJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)function {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id __nullable)putIfAbsentWithId:(id)key
                            withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)removeWithId:(id)key
                  withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (jboolean)replaceWithId:(id)key
                   withId:(id)oldValue
                   withId:(id)newValue {
  @throw create_JavaLangUnsupportedOperationException_init();
}

- (id __nullable)replaceWithId:(id)key
                        withId:(id)value {
  @throw create_JavaLangUnsupportedOperationException_init();
}


- (id __nullable)computeIfAbsentWithId:(id)key
          withJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)mappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSDictionary+JavaUtilMap");
}

- (id __nullable)computeIfPresentWithId:(id)key
         withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSDictionary+JavaUtilMap");
}

- (id __nullable)computeWithId:(id)key
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw unsupportedAdapterCallWithName(NSStringFromSelector(_cmd), @"NSDictionary+JavaUtilMap");
}

- (id __nullable)mergeWithId:(id)key
                      withId:(id)value
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  @throw create_JavaLangUnsupportedOperationException_init();
}

@end

@implementation NSDictionary_Entry

- (instancetype)initWithDictionary:(NSDictionary *)dictionary key:(id)key {
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
  return javaUnwrapNull(key_);
}

- (id)getValue {
  return javaUnwrapNull([dictionary_ objectForKey:key_]);
}

- (id)setValueWithId:(id)object {
  @throw create_JavaLangUnsupportedOperationException_init();
}

@end

// Empty class to force category to be loaded.
@implementation JreNSDictionaryMapCategoryDummy
@end

// kotlin interop <<
