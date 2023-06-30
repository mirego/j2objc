// kotlin interop >>

#ifndef _NSDictionary_JavaUtilMap_PackagePrivate_h
#define _NSDictionary_JavaUtilMap_PackagePrivate_h

#import "NSDictionary+JavaUtilMap.h"

@class NSDictionary_Entry;

@interface NSDictionary<KeyType, ObjectType> (PrivatePackage)

- (NSDictionary_Entry *)java_entryForKey:(KeyType)key __attribute__((ns_returns_retained));

@end

@interface NSDictionary_Key<KeyType> : NSObject < NSCopying > {
@private
  KeyType key_;
}

- (instancetype)init NS_UNAVAILABLE;
- (instancetype)initWithKey:(KeyType __nullable)key;
- (KeyType __nullable)key;

@end

static inline id javaWrapKey(id key) {
  return [key conformsToProtocol:@protocol(NSCopying)] ? key : AUTORELEASE([[NSDictionary_Key alloc] initWithKey:key]);
}

static inline id javaUnwrapKey(id key) {
  return [key isKindOfClass:NSDictionary_Key.class] ? [key key] : key;
}

@interface NSDictionary_Entry<__covariant DictionaryType, KeyType, ObjectType> : NSObject < JavaUtilMap_Entry > {
@protected
  DictionaryType dictionary_;
  KeyType key_;
}

- (instancetype)initWithDictionary:(NSDictionary<KeyType, ObjectType> *)dictionary key:(KeyType)key;

@end

#endif /* _NSDictionary_JavaUtilMap_PackagePrivate_h */

// kotlin interop <<
