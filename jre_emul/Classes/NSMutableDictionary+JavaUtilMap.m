// kotlin interop >>

#import "NSMutableDictionary+JavaUtilMap.h"
#import "NSMutableDictionary+JavaUtilMap_PackagePrivate.h"

#include "java/lang/Float.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/IllegalStateException.h"
#include "java/lang/UnsupportedOperationException.h"
#include "java/util/Iterator.h"
#include "java/util/NoSuchElementException.h"
#include "java/util/Objects.h"
#include "java/util/Spliterators.h"
#include "java/util/function/BiFunction.h"
#include "java/util/function/Function.h"

@implementation NSMutableDictionary (JavaUtilMap)

- (instancetype)initWithInt:(jint)initialCapacity {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal initial capacity: %d", initialCapacity]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal initial capacity: %d", initialCapacity]);
  }
  if (loadFactor <= 0 || CommonFloat_isNaNWithFloat_(loadFactor)) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal load factor: %f", loadFactor]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (instancetype)initWithInt:(jint)initialCapacity withFloat:(jfloat)loadFactor withBoolean:(jboolean)accessOrder {
  if (initialCapacity < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal initial capacity: %d", initialCapacity]);
  }
  if (loadFactor <= 0 || CommonFloat_isNaNWithFloat_(loadFactor)) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_([NSString stringWithFormat:@"Illegal load factor: %f", loadFactor]);
  }
  return [self initWithCapacity:initialCapacity];
}

- (id)java_clone {
  return AUTORELEASE([[NSMutableDictionary alloc] initWithDictionary:self]);
}

// JavaUtilMap

- (id __nullable)putWithId:(id)key
                    withId:(id)value {
  key = javaWrapKey(key);
  id currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull([self objectForKey:key]));
  [self setObject:javaWrapNull(value) forKey:key];
  return currentValue;
}

- (id __nullable)removeWithId:(id)key {
  key = javaWrapKey(key);
  id currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull([self objectForKey:key]));
  [self removeObjectForKey:key];
  return currentValue;
}

- (void)putAllWithJavaUtilMap:(id<JavaUtilMap>)m {
  (void)nil_chk(m);
  m = m != self ? m : RETAIN_AND_AUTORELEASE([m java_clone]);
  id<JavaUtilIterator> iter = [m.entrySet iterator];
  while ([iter hasNext]) {
    id<JavaUtilMap_Entry> entry = [iter next];
    [self setObject:javaWrapNull(entry.getValue) forKey:javaWrapKey(entry.getKey)];
  }
}

- (void)clear {
  [self removeAllObjects];
}

- (id<JavaUtilSet>)keySet {
  return AUTORELEASE([[NSMutableDictionary_KeySet alloc] initWithMutableDictionary:self]);
}

- (id<JavaUtilCollection>)values {
  return AUTORELEASE([[NSMutableDictionary_Values alloc] initWithMutableDictionary:self]);
}

- (id<JavaUtilSet>)entrySet {
  return AUTORELEASE([[NSMutableDictionary_EntrySet alloc] initWithMutableDictionary:self]);
}

- (void)replaceAllWithJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)function {
  (void)nil_chk(function);
  NSMutableDictionary *entriesToReplace = [NSMutableDictionary dictionary];
  [self enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    id replacement = [function applyWithId:javaUnwrapKey(key) withId:javaUnwrapNull(value)];
    if (replacement != nil) {
      entriesToReplace[key] = javaWrapNull(replacement);
    }
  }];
  [self addEntriesFromDictionary:entriesToReplace];
}

- (id __nullable)putIfAbsentWithId:(id)key
                            withId:(id)value {
  key = javaWrapKey(key);
  id currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull([self objectForKey:key]));
  if (currentValue == nil) {
    [self setObject:javaWrapNull(value) forKey:key];
  }
  return currentValue;
}

- (jboolean)removeWithId:(id)key
                  withId:(id)value {
  key = javaWrapKey(key);
  id currentValue = [self objectForKey:key];
  if (currentValue != nil && JavaUtilObjects_equalsWithId_withId_(javaUnwrapNull(currentValue), value)) {
    [self removeObjectForKey:key];
    return true;
  } else {
    return false;
  }
}

- (jboolean)replaceWithId:(id)key
                   withId:(id)oldValue
                   withId:(id)newValue {
  key = javaWrapKey(key);
  id currentValue = [self objectForKey:key];
  if (currentValue != nil && JavaUtilObjects_equalsWithId_withId_(javaUnwrapNull(currentValue), oldValue)) {
    [self setObject:javaWrapNull(newValue) forKey:key];
    return true;
  } else {
    return false;
  }
}

- (id __nullable)replaceWithId:(id)key
                        withId:(id)value {
  key = javaWrapKey(key);
  id currentValue = [self objectForKey:key];
  if (currentValue != nil) {
    currentValue = RETAIN_AND_AUTORELEASE(javaUnwrapNull(currentValue));
    [self setObject:javaWrapNull(value) forKey:key];
    return currentValue;
  } else {
    return nil;
  }
}

- (id __nullable)computeIfAbsentWithId:(id)key_
          withJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)mappingFunction {
  (void)nil_chk(mappingFunction);
  id key = javaWrapKey(key_);
  id oldValue = javaUnwrapNull([self objectForKey:key]);
  if (oldValue == nil) {
    id newValue = [mappingFunction applyWithId:key_];
    if (newValue != nil) {
      [self setObject:newValue forKey:key];
      return newValue;
    }
  }
  return oldValue;
}

- (id __nullable)computeIfPresentWithId:(id)key_
         withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  (void)nil_chk(remappingFunction);
  id key = javaWrapKey(key_);
  id oldValue = javaUnwrapNull([self objectForKey:key]);
  if (oldValue != nil) {
    id newValue = [remappingFunction applyWithId:key_ withId:oldValue];
    if (newValue != nil) {
      [self setObject:newValue forKey:key];
      return newValue;
    } else {
      [self removeObjectForKey:key];
      return nil;
    }
  } else {
    return nil;
  }
}

- (id __nullable)computeWithId:(id)key_
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  (void)nil_chk(remappingFunction);
  id key = javaWrapKey(key_);
  id oldValue = [self objectForKey:key];
  id newValue = [remappingFunction applyWithId:key_ withId:javaUnwrapNull(oldValue)];
  if (newValue == nil) {
    if (oldValue != nil) {
      [self removeObjectForKey:key];
    }
    return nil;
  } else {
    [self setObject:newValue forKey:key];
    return newValue;
  }
}

- (id __nullable)mergeWithId:(id)key
                      withId:(id)value
withJavaUtilFunctionBiFunction:(id<JavaUtilFunctionBiFunction>)remappingFunction {
  (void)nil_chk(remappingFunction);
  (void)nil_chk(value);
  key = javaWrapKey(key);
  id oldValue = javaUnwrapNull([self objectForKey:key]);
  id newValue = (oldValue == nil) ? value : [remappingFunction applyWithId:oldValue withId:value];
  if (newValue == nil) {
    [self removeObjectForKey:key];
  } else {
    [self setObject:newValue forKey:key];
  }
  return newValue;
}

- (NSDictionary_Entry *)java_entryForKey:(id)key {
  return [[NSMutableDictionary_Entry alloc] initWithMutableDictionary:self key:key];
}

@end

@implementation NSMutableDictionary_Entry

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<id, id> *)dictionary key:(id)key {
  return [super initWithDictionary:dictionary key:key];
}

- (id)setValueWithId:(id)object {
  return [dictionary_ putWithId:key_ withId:object];
}

@end

@implementation NSMutableDictionary_KeySet

- (instancetype)initWithMutableDictionary:(NSMutableDictionary *)mutableDictionary {
  if ((self = [super init])) {
    mutableDictionary_ = RETAIN_(mutableDictionary);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableDictionary_ release];
  [super dealloc];
}
#endif

- (NSUInteger)countByEnumeratingWithState:(NSFastEnumerationState *)state
                                  objects:(__unsafe_unretained id *)buffer
                                    count:(NSUInteger)len {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableDictionary_KeySet_Iterator alloc] initWithMutableDictionary:mutableDictionary_]);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilSpliterators_spliteratorWithJavaUtilCollection_withInt_(self, JavaUtilSpliterator_SIZED | JavaUtilSpliterator_DISTINCT);
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)addWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)clear {
  [mutableDictionary_ clear];
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)containsWithId:(id)o {
  return [mutableDictionary_ containsKeyWithId:o];
}

- (jboolean)isEmpty {
  return [mutableDictionary_ isEmpty];
}

- (NSUInteger)hash {
  return [[mutableDictionary_ allKeys] hash];
}

- (NSString *)description {
  return [NSString stringWithFormat:@"{%@}", [[mutableDictionary_ allKeys] description]];
}

- (jboolean)isEqual:(id)o {
  NSMutableSet *keySet = [NSMutableSet setWithCapacity:mutableDictionary_.count];
  [mutableDictionary_ enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [keySet addObject:javaWrapNull(javaUnwrapKey(key))];
  }];
  return [keySet isEqualToSet:javaWrapSet(o)];
}

- (id<JavaUtilStreamStream>)parallelStream {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeWithId:(id)o {
  o = javaWrapKey(o);
  if ([mutableDictionary_ objectForKey:o] != nil) {
    [mutableDictionary_ removeObjectForKey:o];
    return true;
  } else {
    return false;
  }
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    id key = javaWrapKey([iter next]);
    if ([mutableDictionary_ objectForKey:key] != nil) {
      [mutableDictionary_ removeObjectForKey:key];
      modified = true;
    }
  }
  return modified;
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  (void)nil_chk(filter);
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  jboolean modified = false;
  (void)nil_chk(c);
  c = c != self ? c : RETAIN_AND_AUTORELEASE([c java_clone]);
  id<JavaUtilIterator> iter = [c iterator];
  while ([iter hasNext]) {
    id key = javaWrapKey([iter next]);
    if ([mutableDictionary_ objectForKey:key] == nil) {
      [mutableDictionary_ removeObjectForKey:key];
      modified = true;
    }
  }
  return modified;
}

- (jint)size {
  return [mutableDictionary_ size];
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (IOSObjectArray *)toArray {
  return [self toArrayWithNSObjectArray:[IOSObjectArray arrayWithLength:self.size type:NSObject_class_()]];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  NSMutableSet *keySet = [NSMutableSet setWithCapacity:mutableDictionary_.count];
  [mutableDictionary_ enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [keySet addObject:javaWrapNull(javaUnwrapKey(key))];
  }];
  return [keySet toArrayWithNSObjectArray:a];
}

@end

@implementation NSMutableDictionary_KeySet_Iterator

- (instancetype)initWithMutableDictionary:(NSMutableDictionary *)mutableDictionary {
  if ((self = [super init])) {
    mutableDictionary_ = RETAIN_(mutableDictionary);
    keyEnumerator_ = RETAIN_(mutableDictionary.allKeys.objectEnumerator);
    nextKey_ = RETAIN_([keyEnumerator_ nextObject]);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableDictionary_ release];
  [keyEnumerator_ release];
  [currentKey_ release];
  [nextKey_ release];
  [super dealloc];
}
#endif

- (jboolean)hasNext {
  return nextKey_ != nil;
}

- (id)next {
  if (nextKey_ == nil) {
    @throw create_JavaUtilNoSuchElementException_init();
  }
  RELEASE_(currentKey_);
  currentKey_ = RETAIN_AND_AUTORELEASE(nextKey_);
  nextKey_ = RETAIN_([keyEnumerator_ nextObject]);
  return javaUnwrapKey(currentKey_);
}

- (void)remove {
  if (currentKey_ == nil) {
    @throw create_JavaLangIllegalStateException_init();
  }
  [mutableDictionary_ removeObjectForKey:currentKey_];
}

- (void)forEachRemainingWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaUtilIterator_forEachRemainingWithJavaUtilFunctionConsumer_(self, action);
}

@end

@implementation NSMutableDictionary_Values

- (instancetype)initWithMutableDictionary:(NSMutableDictionary *)mutableDictionary {
  if ((self = [super init])) {
    mutableDictionary_ = RETAIN_(mutableDictionary);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableDictionary_ release];
  [super dealloc];
}
#endif

- (NSUInteger)countByEnumeratingWithState:(NSFastEnumerationState *)state
                                  objects:(__unsafe_unretained id *)buffer
                                    count:(NSUInteger)len {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)addWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)clear {
  [mutableDictionary_ clear];
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  return [[mutableDictionary_ allValues] containsAllWithJavaUtilCollection:c];
}

- (jboolean)containsWithId:(id)o {
  return [[mutableDictionary_ allValues] containsWithId:o];
}

- (jboolean)isEmpty {
  return [mutableDictionary_ isEmpty];
}

- (NSUInteger)hash {
  return [[mutableDictionary_ allValues] hash];
}

- (jboolean)isEqual:(id)o {
  return [[mutableDictionary_ allKeys] isEqualToArray:javaWrapCollection(o)];
}

- (NSString *)description {
 return [[mutableDictionary_ allValues] description];
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableDictionary_Values_Iterator alloc] initWithMutableDictionary:mutableDictionary_]);
}

- (id<JavaUtilStreamStream>)parallelStream {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeWithId:(id)o {
  NSMutableArray *keysToRemove = [NSMutableArray array];
  [mutableDictionary_ enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    if (JavaUtilObjects_equalsWithId_withId_(javaUnwrapNull(value), o)) {
      [keysToRemove addObject:key];
    }
  }];
  if (keysToRemove.count != 0) {
    [mutableDictionary_ removeObjectsForKeys:keysToRemove];
    return true;
  } else {
    return false;
  }
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jint)size {
  return [mutableDictionary_ size];
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilSpliterators_spliteratorWithJavaUtilCollection_withInt_(self, JavaUtilSpliterator_SIZED);
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (IOSObjectArray *)toArray {
  return [self toArrayWithNSObjectArray:[IOSObjectArray arrayWithLength:self.size type:NSObject_class_()]];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  return [[mutableDictionary_ allValues] toArrayWithNSObjectArray:a];
}

@end

@implementation NSMutableDictionary_Values_Iterator

- (id)next {
  return [mutableDictionary_ getWithId:[super next]];
}

@end

@implementation NSMutableDictionary_EntrySet

- (instancetype)initWithMutableDictionary:(NSMutableDictionary *)mutableDictionary {
  if ((self = [super init])) {
    mutableDictionary_ = RETAIN_(mutableDictionary);
  }
  return self;
}

#if ! __has_feature(objc_arc)
- (void)dealloc {
  [mutableDictionary_ release];
  [super dealloc];
}
#endif

- (NSUInteger)countByEnumeratingWithState:(NSFastEnumerationState *)state
                                  objects:(__unsafe_unretained id *)buffer
                                    count:(NSUInteger)len {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)forEachWithJavaUtilFunctionConsumer:(id<JavaUtilFunctionConsumer>)action {
  JavaLangIterable_forEachWithJavaUtilFunctionConsumer_(self, action);
}

- (id<JavaUtilIterator>)iterator {
  return AUTORELEASE([[NSMutableDictionary_EntrySet_Iterator alloc] initWithMutableDictionary:mutableDictionary_]);
}

- (id<JavaUtilSpliterator>)spliterator {
  return JavaUtilSpliterators_spliteratorWithJavaUtilCollection_withInt_(self, JavaUtilSpliterator_SIZED | JavaUtilSpliterator_DISTINCT);
}

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)addWithId:(id)e {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (void)clear {
  [mutableDictionary_ clear];
}

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)containsWithId:(id<JavaUtilMap_Entry>)o {
  id value = RETAIN_AND_AUTORELEASE([mutableDictionary_ getWithId:[o getKey]]);
  return value != nil && JavaUtilObjects_equalsWithId_withId_(value, [o getValue]);
}

- (jboolean)isEmpty {
  return [mutableDictionary_ isEmpty];
}

- (NSUInteger)hash {
  return [mutableDictionary_ hash];
}

- (jboolean)isEqual:(id)o {
  NSMutableSet *entrySet = [NSMutableSet setWithCapacity:mutableDictionary_.count];
  [mutableDictionary_ enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [entrySet addObject:AUTORELEASE([mutableDictionary_ java_entryForKey:javaUnwrapKey(key)])];
  }];
  return [entrySet isEqualToSet:javaWrapSet(o)];
}

- (NSString *)description {
  return [mutableDictionary_ description];
}

- (id<JavaUtilStreamStream>)parallelStream {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeWithId:(id)o {
  id key = javaWrapKey([o getKey]);
  id value = [mutableDictionary_ objectForKey:key];
  if (value != nil && JavaUtilObjects_equalsWithId_withId_(javaUnwrapNull(value), [o getValue])) {
    [mutableDictionary_ removeObjectForKey:key];
    return true;
  } else {
    return false;
  }
}

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)removeIfWithJavaUtilFunctionPredicate:(id<JavaUtilFunctionPredicate>)filter {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)c {
  @throw create_JavaLangUnsupportedOperationException_initWithNSString_([NSString stringWithFormat:@"[%@ %@]", NSStringFromClass(self.class), NSStringFromSelector(_cmd)]);
}

- (jint)size {
  return [mutableDictionary_ size];
}

- (id<JavaUtilStreamStream>)stream {
  return JavaUtilCollection_stream(self);
}

- (IOSObjectArray *)toArray {
  return [self toArrayWithNSObjectArray:[IOSObjectArray arrayWithLength:self.size type:NSObject_class_()]];
}

- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)a {
  NSMutableSet *entrySet = [NSMutableSet setWithCapacity:mutableDictionary_.count];
  [mutableDictionary_ enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL *stop) {
    [entrySet addObject:AUTORELEASE([mutableDictionary_ java_entryForKey:javaUnwrapKey(key)])];
  }];
  return [entrySet toArrayWithNSObjectArray:a];
}

@end

@implementation NSMutableDictionary_EntrySet_Iterator

- (id)next {
  return AUTORELEASE([mutableDictionary_ java_entryForKey:[super next]]);
}

@end

// Empty class to force category to be loaded.
@implementation JreNSMutableDictionaryMapCategoryDummy
@end

// kotlin interop <<
