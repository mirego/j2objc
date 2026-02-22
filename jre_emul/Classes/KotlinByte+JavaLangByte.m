// kotlin interop >>

#import "KotlinByte+JavaLangByte.h"

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "IOSPrimitiveArray.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Character.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/NumberFormatException.h"
#include "java/lang/Short.h"

/*!
 @brief use serialVersionUID from JDK 1.1. for interoperability
 */
inline jlong CommonByte_get_serialVersionUID(void);
#define CommonByte_serialVersionUID -7183698231559129828LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonByte, serialVersionUID, jlong)

inline IOSCharArray *CommonByte_get_DIGITS(void);
static IOSCharArray *CommonByte_DIGITS;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonByte, DIGITS, IOSCharArray *)

inline IOSCharArray *CommonByte_get_UPPER_CASE_DIGITS(void);
static IOSCharArray *CommonByte_UPPER_CASE_DIGITS;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonByte, UPPER_CASE_DIGITS, IOSCharArray *)

@interface CommonByte_ByteCache : NSObject

- (instancetype)init;

+ (void)fillValuesWithCommonByteArray:(IOSObjectArray *)values;

@end

J2OBJC_STATIC_INIT(CommonByte_ByteCache)

inline IOSObjectArray *CommonByte_ByteCache_get_cache(void);
static IOSObjectArray *CommonByte_ByteCache_cache;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonByte_ByteCache, cache, IOSObjectArray *)

__attribute__((unused)) static void CommonByte_ByteCache_init(CommonByte_ByteCache *self);

__attribute__((unused)) static CommonByte_ByteCache *new_CommonByte_ByteCache_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static CommonByte_ByteCache *create_CommonByte_ByteCache_init(void);

__attribute__((unused)) static void CommonByte_ByteCache_fillValuesWithCommonByteArray_(IOSObjectArray *values);

J2OBJC_TYPE_LITERAL_HEADER(CommonByte_ByteCache)

J2OBJC_INITIALIZED_DEFN(CommonByte)

IOSClass *CommonByte_TYPE;

@implementation CommonByte (JavaLangByte)

+ (jbyte)MIN_VALUE {
  return CommonByte_MIN_VALUE;
}

+ (jbyte)MAX_VALUE {
  return CommonByte_MAX_VALUE;
}

+ (IOSClass *)TYPE {
  return CommonByte_TYPE;
}

+ (jint)SIZE {
  return CommonByte_SIZE;
}

+ (jint)BYTES {
  return CommonByte_BYTES;
}

+ (NSString *)toStringWithByte:(jbyte)b {
  return CommonByte_toStringWithByte_(b);
}

+ (CommonByte *)valueOfWithByte:(jbyte)b {
  return CommonByte_valueOfWithByte_(b);
}

+ (jbyte)parseByteWithNSString:(NSString *)s
                       withInt:(jint)radix {
  return CommonByte_parseByteWithNSString_withInt_(s, radix);
}

+ (jbyte)parseByteWithNSString:(NSString *)s {
  return CommonByte_parseByteWithNSString_(s);
}

+ (CommonByte *)valueOfWithNSString:(NSString *)s
                              withInt:(jint)radix {
  return CommonByte_valueOfWithNSString_withInt_(s, radix);
}

+ (CommonByte *)valueOfWithNSString:(NSString *)s {
  return CommonByte_valueOfWithNSString_(s);
}

+ (CommonByte *)decodeWithNSString:(NSString *)nm {
  return CommonByte_decodeWithNSString_(nm);
}

- (instancetype)initWithByte:(jbyte)value {
  CommonByte_initWithByte_(self, value);
  return self;
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonByte_initWithNSString_(self, s);
  return self;
}

- (id)copyWithZone:(NSZone *)zone {
  return RETAIN_(self);
}

//- (jbyte)charValue {
//  return (jbyte) self.charValue;
//}

- (jshort)shortValue {
  return (jshort) self.charValue;
}

- (jint)intValue {
  return (jint) self.charValue;
}

- (jlong)longLongValue {
  return (jlong) self.charValue;
}

- (jfloat)floatValue {
  return (jfloat) self.charValue;
}

- (jdouble)doubleValue {
  return (jdouble) self.charValue;
}

- (NSString *)description {
  return CommonInt_toStringWithInt_((jint) self.charValue);
}

//- (NSUInteger)hash {
//  return CommonByte_hashCodeWithByte_((jbyte) self.charValue);
//}

+ (jint)hashCodeWithByte:(jbyte)value {
  return CommonByte_hashCodeWithByte_(value);
}

//- (jboolean)isEqual:(id)obj {
//  if ([obj isKindOfClass:[CommonByte class]]) {
//    return ((jbyte) self.charValue) == ((jbyte) [((CommonByte *) nil_chk(((CommonByte *) obj))) charValue]);
//  }
//  return false;
//}

- (jint)compareToOther:(CommonByte *)anotherByte {
  cast_chk(anotherByte, [CommonByte class]);
  return CommonByte_compareWithByte_withByte_((jbyte) self.charValue, (jbyte) ((CommonByte *) nil_chk(anotherByte)).charValue);
}

+ (jint)compareWithByte:(jbyte)x
               withByte:(jbyte)y {
  return CommonByte_compareWithByte_withByte_(x, y);
}

+ (jint)toUnsignedIntWithByte:(jbyte)x {
  return CommonByte_toUnsignedIntWithByte_(x);
}

+ (jlong)toUnsignedLongWithByte:(jbyte)x {
  return CommonByte_toUnsignedLongWithByte_(x);
}

+ (NSString *)toHexStringWithByte:(jbyte)b
                      withBoolean:(jboolean)upperCase {
  return CommonByte_toHexStringWithByte_withBoolean_(b, upperCase);
}

//- (const char *)objCType {
//  return "c";
//}

//- (void)getValue:(void *)buffer {
//  *((char *) buffer) = (jbyte) self.charValue;
//}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x9, 0, 1, -1, -1, -1, -1 },
    { NULL, "LCommonByte;", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "B", 0x9, 3, 4, 5, -1, -1, -1 },
    { NULL, "B", 0x9, 3, 6, 5, -1, -1, -1 },
    { NULL, "LCommonByte;", 0x9, 2, 4, 5, -1, -1, -1 },
    { NULL, "LCommonByte;", 0x9, 2, 6, 5, -1, -1, -1 },
    { NULL, "LCommonByte;", 0x9, 7, 6, 5, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 6, 5, -1, -1, -1 },
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
    { NULL, "I", 0x9, 17, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 18, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 19, 20, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithByte:);
  methods[1].selector = @selector(valueOfWithByte:);
  methods[2].selector = @selector(parseByteWithNSString:withInt:);
  methods[3].selector = @selector(parseByteWithNSString:);
  methods[4].selector = @selector(valueOfWithNSString:withInt:);
  methods[5].selector = @selector(valueOfWithNSString:);
  methods[6].selector = @selector(decodeWithNSString:);
  methods[7].selector = @selector(initWithByte:);
  methods[8].selector = @selector(initWithNSString:);
  methods[9].selector = @selector(charValue);
  methods[10].selector = @selector(shortValue);
  methods[11].selector = @selector(intValue);
  methods[12].selector = @selector(longLongValue);
  methods[13].selector = @selector(floatValue);
  methods[14].selector = @selector(doubleValue);
  methods[15].selector = @selector(description);
  methods[16].selector = @selector(hash);
  methods[17].selector = @selector(hashCodeWithByte:);
  methods[18].selector = @selector(isEqual:);
  methods[19].selector = @selector(compareToOther:);
  methods[20].selector = @selector(compareWithByte:withByte:);
  methods[21].selector = @selector(toUnsignedIntWithByte:);
  methods[22].selector = @selector(toUnsignedLongWithByte:);
  methods[23].selector = @selector(toHexStringWithByte:withBoolean:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MIN_VALUE", "B", .constantValue.asChar = CommonByte_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "B", .constantValue.asChar = CommonByte_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 21, 22, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonByte_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonByte_BYTES, 0x19, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonByte_serialVersionUID, 0x1a, -1, -1, -1, -1 },
    { "DIGITS", "[C", .constantValue.asLong = 0, 0x1a, -1, 23, -1, -1 },
    { "UPPER_CASE_DIGITS", "[C", .constantValue.asLong = 0, 0x1a, -1, 24, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "B", "valueOf", "parseByte", "LNSString;I", "LJavaLangNumberFormatException;", "LNSString;", "decode", "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "compareTo", "LCommonByte;", "compare", "BB", "toUnsignedInt", "toUnsignedLong", "toHexString", "BZ", &CommonByte_TYPE, "Ljava/lang/Class<Ljava/lang/Byte;>;", &CommonByte_DIGITS, &CommonByte_UPPER_CASE_DIGITS, "LCommonByte_ByteCache;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Byte;>;" };
  static const J2ObjcClassInfo _CommonByte = { "Byte", "java.lang", ptrTable, methods, fields, 7, 0x11, 24, 8, -1, 25, -1, 26, -1 };
  return &_CommonByte;
}

+ (void)initialize {
  if (self == [CommonByte class]) {
    JreStrongAssign(&CommonByte_TYPE, [IOSClass_byteArray(1) getComponentType]);
    JreStrongAssignAndConsume(&CommonByte_DIGITS, [IOSCharArray newArrayWithChars:(jchar[]){ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } count:36]);
    JreStrongAssignAndConsume(&CommonByte_UPPER_CASE_DIGITS, [IOSCharArray newArrayWithChars:(jchar[]){ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' } count:36]);
    J2OBJC_SET_INITIALIZED(CommonByte)
  }
}

@end

NSString *CommonByte_toStringWithByte_(jbyte b) {
  CommonByte_initialize();
  return CommonInt_toStringWithInt_withInt_((jint) b, 10);
}

CommonByte *CommonByte_valueOfWithByte_(jbyte b) {
  CommonByte_initialize();
  jint offset = 128;
  return IOSObjectArray_Get(nil_chk(JreLoadStatic(CommonByte_ByteCache, cache)), (jint) b + offset);
}

jbyte CommonByte_parseByteWithNSString_withInt_(NSString *s, jint radix) {
  CommonByte_initialize();
  jint i = CommonInt_parseIntWithNSString_withInt_(s, radix);
  if (i < CommonByte_MIN_VALUE || i > CommonByte_MAX_VALUE) @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$$$I", @"Value out of range. Value:\"", s, @"\" Radix:", radix));
  return (jbyte) i;
}

jbyte CommonByte_parseByteWithNSString_(NSString *s) {
  CommonByte_initialize();
  return CommonByte_parseByteWithNSString_withInt_(s, 10);
}

CommonByte *CommonByte_valueOfWithNSString_withInt_(NSString *s, jint radix) {
  CommonByte_initialize();
  return CommonByte_valueOfWithByte_(CommonByte_parseByteWithNSString_withInt_(s, radix));
}

CommonByte *CommonByte_valueOfWithNSString_(NSString *s) {
  CommonByte_initialize();
  return CommonByte_valueOfWithNSString_withInt_(s, 10);
}

CommonByte *CommonByte_decodeWithNSString_(NSString *nm) {
  CommonByte_initialize();
  jint i = [((CommonInt *) nil_chk(CommonInt_decodeWithNSString_(nm))) intValue];
  if (i < CommonByte_MIN_VALUE || i > CommonByte_MAX_VALUE) @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$$", @"Value ", i, @" out of range from input ", nm));
  return CommonByte_valueOfWithByte_((jbyte) i);
}

void CommonByte_initWithByte_(CommonByte *self, jbyte value) {
  [self initWithChar:value];
}

CommonByte *new_CommonByte_initWithByte_(jbyte value) {
  return [[CommonByte alloc] initWithChar:value];
}

CommonByte *create_CommonByte_initWithByte_(jbyte value) {
  return [CommonByte numberWithChar:value];
}

void CommonByte_initWithNSString_(CommonByte *self, NSString *s) {
  [self initWithChar:CommonByte_parseByteWithNSString_withInt_(s, 10)];
}

CommonByte *new_CommonByte_initWithNSString_(NSString *s) {
  return [[CommonByte alloc] initWithChar:CommonByte_parseByteWithNSString_withInt_(s, 10)];
}

CommonByte *create_CommonByte_initWithNSString_(NSString *s) {
  return [CommonByte numberWithChar:CommonByte_parseByteWithNSString_withInt_(s, 10)];
}

jint CommonByte_hashCodeWithByte_(jbyte value) {
  return (jint) CommonByte_valueOfWithByte_(value).hash;
}

jint CommonByte_compareWithByte_withByte_(jbyte x, jbyte y) {
  CommonByte_initialize();
  return x - y;
}

jint CommonByte_toUnsignedIntWithByte_(jbyte x) {
  CommonByte_initialize();
  return ((jint) x) & (jint) 0xff;
}

jlong CommonByte_toUnsignedLongWithByte_(jbyte x) {
  CommonByte_initialize();
  return ((jlong) x) & (jlong) 0xffLL;
}

NSString *CommonByte_toHexStringWithByte_withBoolean_(jbyte b, jboolean upperCase) {
  CommonByte_initialize();
  IOSCharArray *digits = upperCase ? CommonByte_UPPER_CASE_DIGITS : CommonByte_DIGITS;
  IOSCharArray *buf = [IOSCharArray arrayWithLength:2];
  *IOSCharArray_GetRef(buf, 0) = IOSCharArray_Get(digits, (JreRShift32(b, 4)) & (jint) 0xf);
  *IOSCharArray_GetRef(buf, 1) = IOSCharArray_Get(digits, b & (jint) 0xf);
  return [NSString java_stringWithCharacters:buf offset:0 length:2];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonByte)

J2OBJC_NAME_MAPPING(CommonByte, "java.lang.Byte", "CommonByte")

J2OBJC_INITIALIZED_DEFN(CommonByte_ByteCache)

@implementation CommonByte_ByteCache

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  CommonByte_ByteCache_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (void)fillValuesWithCommonByteArray:(IOSObjectArray *)values {
  CommonByte_ByteCache_fillValuesWithCommonByteArray_(values);
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
  methods[1].selector = @selector(fillValuesWithCommonByteArray:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "cache", "[LCommonByte;", .constantValue.asLong = 0, 0x18, -1, 2, -1, -1 },
  };
  static const void *ptrTable[] = { "fillValues", "[LCommonByte;", &CommonByte_ByteCache_cache, "LCommonByte;" };
  static const J2ObjcClassInfo _CommonByte_ByteCache = { "ByteCache", "java.lang", ptrTable, methods, fields, 7, 0xa, 2, 1, 3, -1, -1, -1, -1 };
  return &_CommonByte_ByteCache;
}

+ (void)initialize {
  if (self == [CommonByte_ByteCache class]) {
    JreStrongAssignAndConsume(&CommonByte_ByteCache_cache, [IOSObjectArray newArrayWithLength:-(-128) + 127 + 1 type:CommonByte_class_()]);
    {
      CommonByte_ByteCache_fillValuesWithCommonByteArray_(CommonByte_ByteCache_cache);
    }
    J2OBJC_SET_INITIALIZED(CommonByte_ByteCache)
  }
}

@end

void CommonByte_ByteCache_init(CommonByte_ByteCache *self) {
  NSObject_init(self);
}

CommonByte_ByteCache *new_CommonByte_ByteCache_init() {
  J2OBJC_NEW_IMPL(CommonByte_ByteCache, init)
}

CommonByte_ByteCache *create_CommonByte_ByteCache_init() {
  J2OBJC_CREATE_IMPL(CommonByte_ByteCache, init)
}

void CommonByte_ByteCache_fillValuesWithCommonByteArray_(IOSObjectArray *values) {
  CommonByte_ByteCache_initialize();
  Class self = [CommonByte class];
  size_t objSize = class_getInstanceSize(self);
  uintptr_t ptr = (uintptr_t)calloc(objSize, 256);
  id *buf = values->buffer_;
  for (jint i = -128; i < 128; i++) {
    id obj = objc_constructInstance(self, (void *)ptr);
    CommonByte_initWithByte_(obj, (jbyte)i);
    *(buf++) = obj;
    ptr += objSize;
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonByte_ByteCache)

// Empty class to force category to be loaded.
@implementation JreKotlinByteCategoryDummy
@end

// kotlin interop <<
