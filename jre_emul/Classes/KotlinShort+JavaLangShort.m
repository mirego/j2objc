// kotlin interop >>

#import "KotlinShort+JavaLangShort.h"

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/NumberFormatException.h"
#include "java/lang/Short.h"

/*!
 @brief use serialVersionUID from JDK 1.1. for interoperability
 */
inline jlong CommonShort_get_serialVersionUID(void);
#define CommonShort_serialVersionUID 7515723908773894738LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonShort, serialVersionUID, jlong)

@interface CommonShort_ShortCache : NSObject

- (instancetype)init;

+ (void)fillValuesWithCommonShortArray:(IOSObjectArray *)values;

@end

J2OBJC_STATIC_INIT(CommonShort_ShortCache)

inline IOSObjectArray *CommonShort_ShortCache_get_cache(void);
static IOSObjectArray *CommonShort_ShortCache_cache;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonShort_ShortCache, cache, IOSObjectArray *)

__attribute__((unused)) static void CommonShort_ShortCache_init(CommonShort_ShortCache *self);

__attribute__((unused)) static CommonShort_ShortCache *new_CommonShort_ShortCache_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static CommonShort_ShortCache *create_CommonShort_ShortCache_init(void);

__attribute__((unused)) static void CommonShort_ShortCache_fillValuesWithCommonShortArray_(IOSObjectArray *values);

J2OBJC_TYPE_LITERAL_HEADER(CommonShort_ShortCache)

J2OBJC_INITIALIZED_DEFN(CommonShort)

IOSClass *CommonShort_TYPE;

@implementation CommonShort (JavaLangShort)

+ (jshort)MIN_VALUE {
  return CommonShort_MIN_VALUE;
}

+ (jshort)MAX_VALUE {
  return CommonShort_MAX_VALUE;
}

+ (IOSClass *)TYPE {
  return CommonShort_TYPE;
}

+ (jint)SIZE {
  return CommonShort_SIZE;
}

+ (jint)BYTES {
  return CommonShort_BYTES;
}

+ (NSString *)toStringWithShort:(jshort)s {
  return CommonShort_toStringWithShort_(s);
}

+ (jshort)parseShortWithNSString:(NSString *)s
                         withInt:(jint)radix {
  return CommonShort_parseShortWithNSString_withInt_(s, radix);
}

+ (jshort)parseShortWithNSString:(NSString *)s {
  return CommonShort_parseShortWithNSString_(s);
}

+ (CommonShort *)valueOfWithNSString:(NSString *)s
                               withInt:(jint)radix {
  return CommonShort_valueOfWithNSString_withInt_(s, radix);
}

+ (CommonShort *)valueOfWithNSString:(NSString *)s {
  return CommonShort_valueOfWithNSString_(s);
}

+ (CommonShort *)valueOfWithShort:(jshort)s {
  return CommonShort_valueOfWithShort_(s);
}

+ (CommonShort *)decodeWithNSString:(NSString *)nm {
  return CommonShort_decodeWithNSString_(nm);
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonShort_initWithNSString_(self, s);
  return self;
}

- (id)copyWithZone:(NSZone *)zone {
  return RETAIN_(self);
}

- (jbyte)charValue {
  return (jbyte) self.shortValue;
}

//- (jshort)shortValue {
//  return (jshort) self.shortValue;
//}

- (jint)intValue {
  return (jint) self.shortValue;
}

- (jlong)longLongValue {
  return (jlong) self.shortValue;
}

- (jfloat)floatValue {
  return (jfloat) self.shortValue;
}

- (jdouble)doubleValue {
  return (jdouble) self.shortValue;
}

- (NSString *)description {
  return CommonInt_toStringWithInt_((jint) self.shortValue);
}

//- (NSUInteger)hash {
//  return CommonShort_hashCodeWithShort_(self.shortValue);
//}

+ (jint)hashCodeWithShort:(jshort)value {
  return CommonShort_hashCodeWithShort_(value);
}

//- (jboolean)isEqual:(id)obj {
//  if ([obj isKindOfClass:[CommonShort class]]) {
//    return self.shortValue == [((CommonShort *) nil_chk(((CommonShort *) obj))) shortValue];
//  }
//  return false;
//}

- (jint)compareToOther:(CommonShort *)anotherShort {
  cast_chk(anotherShort, [CommonShort class]);
  return CommonShort_compareWithShort_withShort_(self.shortValue, ((CommonShort *) nil_chk(anotherShort)).shortValue);
}

+ (jint)compareWithShort:(jshort)x
               withShort:(jshort)y {
  return CommonShort_compareWithShort_withShort_(x, y);
}

+ (jshort)reverseBytesWithShort:(jshort)i {
  return CommonShort_reverseBytesWithShort_(i);
}

+ (jint)toUnsignedIntWithShort:(jshort)x {
  return CommonShort_toUnsignedIntWithShort_(x);
}

+ (jlong)toUnsignedLongWithShort:(jshort)x {
  return CommonShort_toUnsignedLongWithShort_(x);
}

//- (const char *)objCType {
//  return "s";
//}

//- (void)getValue:(void *)buffer {
//  *((short int *) buffer) = self.shortValue;
//}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x9, 0, 1, -1, -1, -1, -1 },
    { NULL, "S", 0x9, 2, 3, 4, -1, -1, -1 },
    { NULL, "S", 0x9, 2, 5, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 3, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 5, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 1, -1, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 7, 5, 4, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 5, 4, -1, -1, -1 },
    { NULL, "B", 0x1, 8, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 9, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 10, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 10, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 11, 12, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 13, 14, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 15, 16, -1, -1, -1, -1 },
    { NULL, "S", 0x9, 17, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 18, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 19, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithShort:);
  methods[1].selector = @selector(parseShortWithNSString:withInt:);
  methods[2].selector = @selector(parseShortWithNSString:);
  methods[3].selector = @selector(valueOfWithNSString:withInt:);
  methods[4].selector = @selector(valueOfWithNSString:);
  methods[5].selector = @selector(valueOfWithShort:);
  methods[6].selector = @selector(decodeWithNSString:);
  methods[7].selector = @selector(initWithShort:);
  methods[8].selector = @selector(initWithNSString:);
  methods[9].selector = @selector(charValue);
  methods[10].selector = @selector(shortValue);
  methods[11].selector = @selector(intValue);
  methods[12].selector = @selector(longLongValue);
  methods[13].selector = @selector(floatValue);
  methods[14].selector = @selector(doubleValue);
  methods[15].selector = @selector(description);
  methods[16].selector = @selector(hash);
  methods[17].selector = @selector(hashCodeWithShort:);
  methods[18].selector = @selector(isEqual:);
  methods[19].selector = @selector(compareToOther:);
  methods[20].selector = @selector(compareWithShort:withShort:);
  methods[21].selector = @selector(reverseBytesWithShort:);
  methods[22].selector = @selector(toUnsignedIntWithShort:);
  methods[23].selector = @selector(toUnsignedLongWithShort:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MIN_VALUE", "S", .constantValue.asShort = CommonShort_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "S", .constantValue.asShort = CommonShort_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 20, 21, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonShort_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonShort_BYTES, 0x19, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonShort_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "S", "parseShort", "LNSString;I", "LJavaLangNumberFormatException;", "LNSString;", "valueOf", "decode", "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "compareTo", "LCommonShort;", "compare", "SS", "reverseBytes", "toUnsignedInt", "toUnsignedLong", &CommonShort_TYPE, "Ljava/lang/Class<Ljava/lang/Short;>;", "LCommonShort_ShortCache;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Short;>;" };
  static const J2ObjcClassInfo _CommonShort = { "Short", "java.lang", ptrTable, methods, fields, 7, 0x11, 24, 6, -1, 22, -1, 23, -1 };
  return &_CommonShort;
}

+ (void)initialize {
  if (self == [CommonShort class]) {
    JreStrongAssign(&CommonShort_TYPE, [IOSClass_shortArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonShort)
  }
}

@end

NSString *CommonShort_toStringWithShort_(jshort s) {
  CommonShort_initialize();
  return CommonInt_toStringWithInt_withInt_((jint) s, 10);
}

jshort CommonShort_parseShortWithNSString_withInt_(NSString *s, jint radix) {
  CommonShort_initialize();
  jint i = CommonInt_parseIntWithNSString_withInt_(s, radix);
  if (i < CommonShort_MIN_VALUE || i > CommonShort_MAX_VALUE) @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$$$I", @"Value out of range. Value:\"", s, @"\" Radix:", radix));
  return (jshort) i;
}

jshort CommonShort_parseShortWithNSString_(NSString *s) {
  CommonShort_initialize();
  return CommonShort_parseShortWithNSString_withInt_(s, 10);
}

CommonShort *CommonShort_valueOfWithNSString_withInt_(NSString *s, jint radix) {
  CommonShort_initialize();
  return CommonShort_valueOfWithShort_(CommonShort_parseShortWithNSString_withInt_(s, radix));
}

CommonShort *CommonShort_valueOfWithNSString_(NSString *s) {
  CommonShort_initialize();
  return CommonShort_valueOfWithNSString_withInt_(s, 10);
}

CommonShort *CommonShort_valueOfWithShort_(jshort s) {
  CommonShort_initialize();
  jint offset = 128;
  jint sAsInt = s;
  if (sAsInt >= -128 && sAsInt <= 127) {
    return IOSObjectArray_Get(nil_chk(JreLoadStatic(CommonShort_ShortCache, cache)), sAsInt + offset);
  }
  return create_CommonShort_initWithShort_(s);
}

CommonShort *CommonShort_decodeWithNSString_(NSString *nm) {
  CommonShort_initialize();
  jint i = [((CommonInt *) nil_chk(CommonInt_decodeWithNSString_(nm))) intValue];
  if (i < CommonShort_MIN_VALUE || i > CommonShort_MAX_VALUE) @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$$", @"Value ", i, @" out of range from input ", nm));
  return CommonShort_valueOfWithShort_((jshort) i);
}

void CommonShort_initWithShort_(CommonShort *self, jshort value) {
  [self initWithShort:value];
}

CommonShort *new_CommonShort_initWithShort_(jshort value) {
  return [[CommonShort alloc] initWithShort:value];
}

CommonShort *create_CommonShort_initWithShort_(jshort value) {
  return [CommonShort numberWithShort:value];
}

void CommonShort_initWithNSString_(CommonShort *self, NSString *s) {
  [self initWithShort:CommonShort_parseShortWithNSString_withInt_(s, 10)];
}

CommonShort *new_CommonShort_initWithNSString_(NSString *s) {
  return [[CommonShort alloc] initWithShort:CommonShort_parseShortWithNSString_withInt_(s, 10)];
}

CommonShort *create_CommonShort_initWithNSString_(NSString *s) {
  return [CommonShort numberWithShort:CommonShort_parseShortWithNSString_withInt_(s, 10)];
}

jint CommonShort_hashCodeWithShort_(jshort value) {
  return (jint) CommonShort_valueOfWithShort_(value).hash;
}

jint CommonShort_compareWithShort_withShort_(jshort x, jshort y) {
  CommonShort_initialize();
  return x - y;
}

jshort CommonShort_reverseBytesWithShort_(jshort i) {
  CommonShort_initialize();
  return (jshort) ((JreRShift32((i & (jint) 0xFF00), 8)) | (JreLShift32(i, 8)));
}

jint CommonShort_toUnsignedIntWithShort_(jshort x) {
  CommonShort_initialize();
  return ((jint) x) & (jint) 0xffff;
}

jlong CommonShort_toUnsignedLongWithShort_(jshort x) {
  CommonShort_initialize();
  return ((jlong) x) & (jlong) 0xffffLL;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonShort)

J2OBJC_NAME_MAPPING(CommonShort, "java.lang.Short", "CommonShort")

J2OBJC_INITIALIZED_DEFN(CommonShort_ShortCache)

@implementation CommonShort_ShortCache

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  CommonShort_ShortCache_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (void)fillValuesWithCommonShortArray:(IOSObjectArray *)values {
  CommonShort_ShortCache_fillValuesWithCommonShortArray_(values);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x2, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x10a, 0, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(fillValuesWithCommonShortArray:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "cache", "[LCommonShort;", .constantValue.asLong = 0, 0x18, -1, 2, -1, -1 },
  };
  static const void *ptrTable[] = { "fillValues", "[LCommonShort;", &CommonShort_ShortCache_cache, "LCommonShort;" };
  static const J2ObjcClassInfo _CommonShort_ShortCache = { "ShortCache", "java.lang", ptrTable, methods, fields, 7, 0xa, 2, 1, 3, -1, -1, -1, -1 };
  return &_CommonShort_ShortCache;
}

+ (void)initialize {
  if (self == [CommonShort_ShortCache class]) {
    JreStrongAssignAndConsume(&CommonShort_ShortCache_cache, [IOSObjectArray newArrayWithLength:256 type:CommonShort_class_()]);
    {
      CommonShort_ShortCache_fillValuesWithCommonShortArray_(CommonShort_ShortCache_cache);
    }
    J2OBJC_SET_INITIALIZED(CommonShort_ShortCache)
  }
}

@end

void CommonShort_ShortCache_init(CommonShort_ShortCache *self) {
  NSObject_init(self);
}

CommonShort_ShortCache *new_CommonShort_ShortCache_init() {
  J2OBJC_NEW_IMPL(CommonShort_ShortCache, init)
}

CommonShort_ShortCache *create_CommonShort_ShortCache_init() {
  J2OBJC_CREATE_IMPL(CommonShort_ShortCache, init)
}

void CommonShort_ShortCache_fillValuesWithCommonShortArray_(IOSObjectArray *values) {
  CommonShort_ShortCache_initialize();
  Class self = [CommonShort class];
  size_t objSize = class_getInstanceSize(self);
  uintptr_t ptr = (uintptr_t)calloc(objSize, 256);
  id *buf = values->buffer_;
  for (jint i = -128; i < 128; i++) {
    id obj = objc_constructInstance(self, (void *)ptr);
    CommonShort_initWithShort_(obj, (jshort)i);
    *(buf++) = obj;
    ptr += objSize;
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonShort_ShortCache)

// Empty class to force category to be loaded.
@implementation JreKotlinShortCategoryDummy
@end

// kotlin interop <<
