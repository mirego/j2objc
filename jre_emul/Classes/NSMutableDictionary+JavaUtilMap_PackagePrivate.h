// kotlin interop >>

#ifndef _NSMutableDictionary_JavaUtilMap_PackagePrivate_h
#define _NSMutableDictionary_JavaUtilMap_PackagePrivate_h

#import "NSMutableDictionary+JavaUtilMap.h"

#import "NSDictionary+JavaUtilMap_PackagePrivate.h"
#import "J2ObjC_kotlinTypes.h"

#include "java/util/Collection.h"
#include "java/util/Iterator.h"
#include "java/util/Map.h"
#include "java/util/Set.h"

@interface NSMutableDictionary_Entry<KeyType, ObjectType> : NSDictionary_Entry<NSMutableDictionary<KeyType, ObjectType> *, KeyType, ObjectType>

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<KeyType, ObjectType> *)mutableDictionary key:(KeyType)key;
- (instancetype)initWithDictionary:(NSMutableDictionary<KeyType, ObjectType> *)dictionary key:(KeyType)key NS_UNAVAILABLE;

@end

@interface NSMutableDictionary_KeySet<KeyType, ObjectType> : NSObject < JavaUtilSet > {
@private
  NSMutableDictionary<KeyType, ObjectType> *mutableDictionary_;
}

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<KeyType, ObjectType> *)mutableDictionary;

@end

@interface NSMutableDictionary_KeySet_Iterator<KeyType, ObjectType> : NSObject < JavaUtilIterator > {
@protected
  NSMutableDictionary<KeyType, ObjectType> *mutableDictionary_;
@private
  NSEnumerator<KeyType> *keyEnumerator_;
  id currentKey_;
  id nextKey_;
}

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<KeyType, ObjectType> *)mutableDictionary;

@end

@interface NSMutableDictionary_Values<KeyType, ObjectType> : NSObject < JavaUtilCollection > {
@private
  NSMutableDictionary<KeyType, ObjectType> *mutableDictionary_;
}

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<KeyType, ObjectType> *)mutableDictionary;

@end

@interface NSMutableDictionary_Values_Iterator<KeyType, ObjectType> : NSMutableDictionary_KeySet_Iterator<KeyType, ObjectType>

@end

@interface NSMutableDictionary_EntrySet<KeyType, ObjectType> : NSObject < JavaUtilSet > {
@private
  NSMutableDictionary<KeyType, ObjectType> *mutableDictionary_;
}

- (instancetype)initWithMutableDictionary:(NSMutableDictionary<KeyType, ObjectType> *)mutableDictionary;

@end

@interface NSMutableDictionary_EntrySet_Iterator<KeyType, ObjectType> : NSMutableDictionary_KeySet_Iterator<KeyType, ObjectType>

@end

#endif /* _NSMutableDictionary_JavaUtilMap_PackagePrivate_h */

// kotlin interop <<
