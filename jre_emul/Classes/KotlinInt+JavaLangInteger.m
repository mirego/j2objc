// kotlin interop >>

#import "KotlinInt+JavaLangInteger.h"

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "IOSPrimitiveArray.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Character.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/Math.h"
#include "java/lang/NullPointerException.h"
#include "java/lang/NumberFormatException.h"
#include "java/lang/RuntimeException.h"
#include "java/lang/Short.h"
#include "java/lang/System.h"

/*!
 @brief use serialVersionUID from JDK 1.0.2 for interoperability
 */
inline jlong CommonInt_get_serialVersionUID(void);
#define CommonInt_serialVersionUID 1360826667806852920LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonInt, serialVersionUID, jlong)

NSString *CommonInt_toUnsignedString0WithInt_withInt_(jint i, jint shift);

/*!
 @brief Cache to support the object identity semantics of autoboxing for values between
  -128 and 127 (inclusive) as required by JLS.
 The cache is initialized on first usage.
 */
@interface CommonInt_IntegerCache : NSObject

- (instancetype)init;

+ (void)fillValuesWithCommonIntArray:(IOSObjectArray *)values;

@end

J2OBJC_STATIC_INIT(CommonInt_IntegerCache)

inline IOSObjectArray *CommonInt_IntegerCache_get_cache(void);
static IOSObjectArray *CommonInt_IntegerCache_cache;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonInt_IntegerCache, cache, IOSObjectArray *)

__attribute__((unused)) static void CommonInt_IntegerCache_init(CommonInt_IntegerCache *self);

__attribute__((unused)) static CommonInt_IntegerCache *new_CommonInt_IntegerCache_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static CommonInt_IntegerCache *create_CommonInt_IntegerCache_init(void);

__attribute__((unused)) static void CommonInt_IntegerCache_fillValuesWithCommonIntArray_(IOSObjectArray *values);

J2OBJC_TYPE_LITERAL_HEADER(CommonInt_IntegerCache)

J2OBJC_INITIALIZED_DEFN(CommonInt)

IOSClass *CommonInt_TYPE;
IOSIntArray *CommonInt_sizeTable;

@implementation CommonInt (JavaLangInteger)

+ (jint)MIN_VALUE {
  return CommonInt_MIN_VALUE;
}

+ (jint)MAX_VALUE {
  return CommonInt_MAX_VALUE;
}

+ (IOSClass *)TYPE {
  return CommonInt_TYPE;
}

+ (IOSIntArray *)sizeTable {
  return CommonInt_sizeTable;
}

+ (jint)SIZE {
  return CommonInt_SIZE;
}

+ (jint)BYTES {
  return CommonInt_BYTES;
}

+ (NSString *)toStringWithInt:(jint)i
                      withInt:(jint)radix {
  return CommonInt_toStringWithInt_withInt_(i, radix);
}

+ (NSString *)toUnsignedStringWithInt:(jint)i
                              withInt:(jint)radix {
  return CommonInt_toUnsignedStringWithInt_withInt_(i, radix);
}

+ (NSString *)toHexStringWithInt:(jint)i {
  return CommonInt_toHexStringWithInt_(i);
}

+ (NSString *)toOctalStringWithInt:(jint)i {
  return CommonInt_toOctalStringWithInt_(i);
}

+ (NSString *)toBinaryStringWithInt:(jint)i {
  return CommonInt_toBinaryStringWithInt_(i);
}

+ (NSString *)toUnsignedString0WithInt:(jint)i
                               withInt:(jint)shift {
  return CommonInt_toUnsignedString0WithInt_withInt_(i, shift);
}

+ (NSString *)toStringWithInt:(jint)i {
  return CommonInt_toStringWithInt_(i);
}

+ (NSString *)toUnsignedStringWithInt:(jint)i {
  return CommonInt_toUnsignedStringWithInt_(i);
}

+ (void)getCharsWithInt:(jint)i
                withInt:(jint)index
          withCharArray:(IOSCharArray *)buf {
  CommonInt_getCharsWithInt_withInt_withCharArray_(i, index, buf);
}

+ (jint)stringSizeWithInt:(jint)x {
  return CommonInt_stringSizeWithInt_(x);
}

+ (jint)parseIntWithNSString:(NSString *)s
                     withInt:(jint)radix {
  return CommonInt_parseIntWithNSString_withInt_(s, radix);
}

+ (jint)parseIntWithNSString:(NSString *)s {
  return CommonInt_parseIntWithNSString_(s);
}

+ (jint)parseUnsignedIntWithNSString:(NSString *)s
                             withInt:(jint)radix {
  return CommonInt_parseUnsignedIntWithNSString_withInt_(s, radix);
}

+ (jint)parseUnsignedIntWithNSString:(NSString *)s {
  return CommonInt_parseUnsignedIntWithNSString_(s);
}

+ (CommonInt *)valueOfWithNSString:(NSString *)s
                           withInt:(jint)radix {
  return CommonInt_valueOfWithNSString_withInt_(s, radix);
}

+ (CommonInt *)valueOfWithNSString:(NSString *)s {
  return CommonInt_valueOfWithNSString_(s);
}

+ (CommonInt *)valueOfWithInt:(jint)i {
  return CommonInt_valueOfWithInt_(i);
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonInt_initWithNSString_(self, s);
  return self;
}

- (jbyte)charValue {
  return (jbyte) self.intValue;
}

- (jshort)shortValue {
  return (jshort) self.intValue;
}

//- (jint)intValue {
//  return self.intValue;
//}

- (jlong)longLongValue {
  return (jlong) self.intValue;
}

- (jfloat)floatValue {
  return (jfloat) self.intValue;
}

- (jdouble)doubleValue {
  return (jdouble) self.intValue;
}

- (NSString *)description {
  return CommonInt_toStringWithInt_(self.intValue);
}

- (NSUInteger)hash {
  return CommonInt_hashCodeWithInt_(self.intValue);
}

+ (jint)hashCodeWithInt:(jint)value {
  return CommonInt_hashCodeWithInt_(value);
}

- (jboolean)isEqual:(id)obj {
  if ([obj isKindOfClass:[CommonInt class]]) {
    return self.intValue == [((CommonInt *) nil_chk(((CommonInt *) obj))) intValue];
  }
  return false;
}

+ (CommonInt *)getIntegerWithNSString:(NSString *)nm {
  return CommonInt_getIntegerWithNSString_(nm);
}

+ (CommonInt *)getIntegerWithNSString:(NSString *)nm
                              withInt:(jint)val {
  return CommonInt_getIntegerWithNSString_withInt_(nm, val);
}

+ (CommonInt *)getIntegerWithNSString:(NSString *)nm
                        withCommonInt:(CommonInt *)val {
  return CommonInt_getIntegerWithNSString_withCommonInt_(nm, val);
}

+ (CommonInt *)decodeWithNSString:(NSString *)nm {
  return CommonInt_decodeWithNSString_(nm);
}

- (jint)compareToWithId:(CommonInt *)anotherInteger {
  cast_chk(anotherInteger, [CommonInt class]);
  return CommonInt_compareWithInt_withInt_(self.intValue, ((CommonInt *) nil_chk(anotherInteger)).intValue);
}

+ (jint)compareWithInt:(jint)x
               withInt:(jint)y {
  return CommonInt_compareWithInt_withInt_(x, y);
}

+ (jint)compareUnsignedWithInt:(jint)x
                       withInt:(jint)y {
  return CommonInt_compareUnsignedWithInt_withInt_(x, y);
}

+ (jlong)toUnsignedLongWithInt:(jint)x {
  return CommonInt_toUnsignedLongWithInt_(x);
}

+ (jint)divideUnsignedWithInt:(jint)dividend
                      withInt:(jint)divisor {
  return CommonInt_divideUnsignedWithInt_withInt_(dividend, divisor);
}

+ (jint)remainderUnsignedWithInt:(jint)dividend
                         withInt:(jint)divisor {
  return CommonInt_remainderUnsignedWithInt_withInt_(dividend, divisor);
}

+ (jint)highestOneBitWithInt:(jint)i {
  return CommonInt_highestOneBitWithInt_(i);
}

+ (jint)lowestOneBitWithInt:(jint)i {
  return CommonInt_lowestOneBitWithInt_(i);
}

+ (jint)numberOfLeadingZerosWithInt:(jint)i {
  return CommonInt_numberOfLeadingZerosWithInt_(i);
}

+ (jint)numberOfTrailingZerosWithInt:(jint)i {
  return CommonInt_numberOfTrailingZerosWithInt_(i);
}

+ (jint)bitCountWithInt:(jint)i {
  return CommonInt_bitCountWithInt_(i);
}

+ (jint)rotateLeftWithInt:(jint)i
                  withInt:(jint)distance {
  return CommonInt_rotateLeftWithInt_withInt_(i, distance);
}

+ (jint)rotateRightWithInt:(jint)i
                   withInt:(jint)distance {
  return CommonInt_rotateRightWithInt_withInt_(i, distance);
}

+ (jint)reverseWithInt:(jint)i {
  return CommonInt_reverseWithInt_(i);
}

+ (jint)signumWithInt:(jint)i {
  return CommonInt_signumWithInt_(i);
}

+ (jint)reverseBytesWithInt:(jint)i {
  return CommonInt_reverseBytesWithInt_(i);
}

+ (jint)sumWithInt:(jint)a
           withInt:(jint)b {
  return CommonInt_sumWithInt_withInt_(a, b);
}

+ (jint)maxWithInt:(jint)a
           withInt:(jint)b {
  return CommonInt_maxWithInt_withInt_(a, b);
}

+ (jint)minWithInt:(jint)a
           withInt:(jint)b {
  return CommonInt_minWithInt_withInt_(a, b);
}

//- (const char *)objCType {
//  return "i";
//}
//
//- (void)getValue:(void *)buffer {
//  *((int *) buffer) = self.intValue;
//}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x109, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 3, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 5, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 6, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x10a, 7, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x109, 0, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 4, -1, -1, -1, -1 },
    { NULL, "V", 0x108, 8, 9, -1, -1, -1, -1 },
    { NULL, "I", 0x8, 10, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 11, 12, 13, -1, -1, -1 },
    { NULL, "I", 0x9, 11, 14, 13, -1, -1, -1 },
    { NULL, "I", 0x9, 15, 12, 13, -1, -1, -1 },
    { NULL, "I", 0x9, 15, 14, 13, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 16, 12, 13, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 16, 14, 13, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 16, 4, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 4, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 14, 13, -1, -1, -1 },
    { NULL, "B", 0x1, 17, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 18, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 19, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 19, 4, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 20, 21, -1, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 22, 14, -1, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 22, 12, -1, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 22, 23, -1, -1, -1, -1 },
    { NULL, "LCommonInt;", 0x9, 24, 14, 13, -1, -1, -1 },
    { NULL, "I", 0x1, 25, 26, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 27, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 28, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 29, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 30, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 31, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 32, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 33, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 34, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 35, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 36, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 37, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 38, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 39, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 40, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 41, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 42, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 43, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 44, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithInt:withInt:);
  methods[1].selector = @selector(toUnsignedStringWithInt:withInt:);
  methods[2].selector = @selector(toHexStringWithInt:);
  methods[3].selector = @selector(toOctalStringWithInt:);
  methods[4].selector = @selector(toBinaryStringWithInt:);
  methods[5].selector = @selector(toUnsignedString0WithInt:withInt:);
  methods[6].selector = @selector(toStringWithInt:);
  methods[7].selector = @selector(toUnsignedStringWithInt:);
  methods[8].selector = @selector(getCharsWithInt:withInt:withCharArray:);
  methods[9].selector = @selector(stringSizeWithInt:);
  methods[10].selector = @selector(parseIntWithNSString:withInt:);
  methods[11].selector = @selector(parseIntWithNSString:);
  methods[12].selector = @selector(parseUnsignedIntWithNSString:withInt:);
  methods[13].selector = @selector(parseUnsignedIntWithNSString:);
  methods[14].selector = @selector(valueOfWithNSString:withInt:);
  methods[15].selector = @selector(valueOfWithNSString:);
  methods[16].selector = @selector(valueOfWithInt:);
  methods[17].selector = @selector(initWithInt:);
  methods[18].selector = @selector(initWithNSString:);
  methods[19].selector = @selector(charValue);
  methods[20].selector = @selector(shortValue);
  methods[21].selector = @selector(intValue);
  methods[22].selector = @selector(longLongValue);
  methods[23].selector = @selector(floatValue);
  methods[24].selector = @selector(doubleValue);
  methods[25].selector = @selector(description);
  methods[26].selector = @selector(hash);
  methods[27].selector = @selector(hashCodeWithInt:);
  methods[28].selector = @selector(isEqual:);
  methods[29].selector = @selector(getIntegerWithNSString:);
  methods[30].selector = @selector(getIntegerWithNSString:withInt:);
  methods[31].selector = @selector(getIntegerWithNSString:withCommonInt:);
  methods[32].selector = @selector(decodeWithNSString:);
  methods[33].selector = @selector(compareToWithId:);
  methods[34].selector = @selector(compareWithInt:withInt:);
  methods[35].selector = @selector(compareUnsignedWithInt:withInt:);
  methods[36].selector = @selector(toUnsignedLongWithInt:);
  methods[37].selector = @selector(divideUnsignedWithInt:withInt:);
  methods[38].selector = @selector(remainderUnsignedWithInt:withInt:);
  methods[39].selector = @selector(highestOneBitWithInt:);
  methods[40].selector = @selector(lowestOneBitWithInt:);
  methods[41].selector = @selector(numberOfLeadingZerosWithInt:);
  methods[42].selector = @selector(numberOfTrailingZerosWithInt:);
  methods[43].selector = @selector(bitCountWithInt:);
  methods[44].selector = @selector(rotateLeftWithInt:withInt:);
  methods[45].selector = @selector(rotateRightWithInt:withInt:);
  methods[46].selector = @selector(reverseWithInt:);
  methods[47].selector = @selector(signumWithInt:);
  methods[48].selector = @selector(reverseBytesWithInt:);
  methods[49].selector = @selector(sumWithInt:withInt:);
  methods[50].selector = @selector(maxWithInt:withInt:);
  methods[51].selector = @selector(minWithInt:withInt:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MIN_VALUE", "I", .constantValue.asInt = CommonInt_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "I", .constantValue.asInt = CommonInt_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 45, 46, -1 },
    { "sizeTable", "[I", .constantValue.asLong = 0, 0x18, -1, 47, -1, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonInt_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonInt_BYTES, 0x19, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonInt_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "II", "toUnsignedString", "toHexString", "I", "toOctalString", "toBinaryString", "toUnsignedString0", "getChars", "II[C", "stringSize", "parseInt", "LNSString;I", "LJavaLangNumberFormatException;", "LNSString;", "parseUnsignedInt", "valueOf", "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "getInteger", "LNSString;LCommonInt;", "decode", "compareTo", "LCommonInt;", "compare", "compareUnsigned", "toUnsignedLong", "divideUnsigned", "remainderUnsigned", "highestOneBit", "lowestOneBit", "numberOfLeadingZeros", "numberOfTrailingZeros", "bitCount", "rotateLeft", "rotateRight", "reverse", "signum", "reverseBytes", "sum", "max", "min", &CommonInt_TYPE, "Ljava/lang/Class<Ljava/lang/Integer;>;", &CommonInt_sizeTable, "LCommonInt_IntegerCache;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Integer;>;" };
  static const J2ObjcClassInfo _CommonInt = { "Integer", "java.lang", ptrTable, methods, fields, 7, 0x11, 52, 8, -1, 48, -1, 49, -1 };
  return &_CommonInt;
}

+ (void)initialize {
  if (self == [CommonInt class]) {
    JreStrongAssign(&CommonInt_TYPE, [IOSClass_intArray(1) getComponentType]);
    JreStrongAssignAndConsume(&CommonInt_sizeTable, [IOSIntArray newArrayWithInts:(jint[]){ 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, CommonInt_MAX_VALUE } count:10]);
    J2OBJC_SET_INITIALIZED(CommonInt)
  }
}

@end

JNIEXPORT jstring Java_java_lang_Integer_toString__II(JNIEnv *_env_, jclass _cls_, jint i, jint radix);

NSString *CommonInt_toStringWithInt_withInt_(jint i, jint radix) {
  return (NSString *) Java_java_lang_Integer_toString__II(&J2ObjC_JNIEnv, CommonInt_class_(), i, radix);
}

NSString *CommonInt_toUnsignedStringWithInt_withInt_(jint i, jint radix) {
  CommonInt_initialize();
  return CommonLong_toUnsignedStringWithLong_withInt_(CommonInt_toUnsignedLongWithInt_(i), radix);
}

NSString *CommonInt_toHexStringWithInt_(jint i) {
  CommonInt_initialize();
  return CommonInt_toUnsignedString0WithInt_withInt_(i, 4);
}

NSString *CommonInt_toOctalStringWithInt_(jint i) {
  CommonInt_initialize();
  return CommonInt_toUnsignedString0WithInt_withInt_(i, 3);
}

NSString *CommonInt_toBinaryStringWithInt_(jint i) {
  CommonInt_initialize();
  return CommonInt_toUnsignedString0WithInt_withInt_(i, 1);
}

JNIEXPORT jstring Java_java_lang_Integer_toUnsignedString0(JNIEnv *_env_, jclass _cls_, jint i, jint shift);

NSString *CommonInt_toUnsignedString0WithInt_withInt_(jint i, jint shift) {
  return (NSString *) Java_java_lang_Integer_toUnsignedString0(&J2ObjC_JNIEnv, CommonInt_class_(), i, shift);
}

JNIEXPORT jstring Java_java_lang_Integer_toString__I(JNIEnv *_env_, jclass _cls_, jint i);

NSString *CommonInt_toStringWithInt_(jint i) {
  return (NSString *) Java_java_lang_Integer_toString__I(&J2ObjC_JNIEnv, CommonInt_class_(), i);
}

NSString *CommonInt_toUnsignedStringWithInt_(jint i) {
  CommonInt_initialize();
  return CommonLong_toStringWithLong_(CommonInt_toUnsignedLongWithInt_(i));
}

JNIEXPORT void Java_java_lang_Integer_getChars(JNIEnv *_env_, jclass _cls_, jint i, jint index, jarray buf);

void CommonInt_getCharsWithInt_withInt_withCharArray_(jint i, jint index, IOSCharArray *buf) {
  Java_java_lang_Integer_getChars(&J2ObjC_JNIEnv, CommonInt_class_(), i, index, buf);
}

jint CommonInt_stringSizeWithInt_(jint x) {
  CommonInt_initialize();
  for (jint i = 0; ; i++) if (x <= IOSIntArray_Get(nil_chk(CommonInt_sizeTable), i)) return i + 1;
}

jint CommonInt_parseIntWithNSString_withInt_(NSString *s, jint radix) {
  CommonInt_initialize();
  if (s == nil) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(@"s == null");
  }
  if (radix < JavaLangCharacter_MIN_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" less than Character.MIN_RADIX"));
  }
  if (radix > JavaLangCharacter_MAX_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" greater than Character.MAX_RADIX"));
  }
  jint result = 0;
  jboolean negative = false;
  jint i = 0;
  jint len = [s java_length];
  jint limit = -CommonInt_MAX_VALUE;
  jint multmin;
  jint digit;
  if (len > 0) {
    jchar firstChar = [s charAtWithInt:0];
    if (firstChar < '0') {
      if (firstChar == '-') {
        negative = true;
        limit = CommonInt_MIN_VALUE;
      }
      else if (firstChar != '+') @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
      if (len == 1) @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
      i++;
    }
    multmin = JreIntDiv(limit, radix);
    while (i < len) {
      digit = JavaLangCharacter_digitWithChar_withInt_([s charAtWithInt:i++], radix);
      if (digit < 0) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
      }
      if (result < multmin) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
      }
      result *= radix;
      if (result < limit + digit) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
      }
      result -= digit;
    }
  }
  else {
    @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
  }
  return negative ? result : -result;
}

jint CommonInt_parseIntWithNSString_(NSString *s) {
  CommonInt_initialize();
  return CommonInt_parseIntWithNSString_withInt_(s, 10);
}

jint CommonInt_parseUnsignedIntWithNSString_withInt_(NSString *s, jint radix) {
  CommonInt_initialize();
  if (s == nil) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(@"null");
  }
  jint len = [s java_length];
  if (len > 0) {
    jchar firstChar = [s charAtWithInt:0];
    if (firstChar == '-') {
      @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"Illegal leading minus sign on unsigned string %s.", [IOSObjectArray arrayWithObjects:(id[]){ s } count:1 type:NSObject_class_()]));
    }
    else {
      if (len <= 5 || (radix == 10 && len <= 9)) {
        return CommonInt_parseIntWithNSString_withInt_(s, radix);
      }
      else {
        jlong ell = CommonLong_parseLongWithNSString_withInt_(s, radix);
        if ((ell & (jlong) 0xffffffff00000000LL) == 0) {
          return (jint) ell;
        }
        else {
          @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"String value %s exceeds range of unsigned int.", [IOSObjectArray arrayWithObjects:(id[]){ s } count:1 type:NSObject_class_()]));
        }
      }
    }
  }
  else {
    @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_(s));
  }
}

jint CommonInt_parseUnsignedIntWithNSString_(NSString *s) {
  CommonInt_initialize();
  return CommonInt_parseUnsignedIntWithNSString_withInt_(s, 10);
}

CommonInt *CommonInt_valueOfWithNSString_withInt_(NSString *s, jint radix) {
  CommonInt_initialize();
  return CommonInt_valueOfWithInt_(CommonInt_parseIntWithNSString_withInt_(s, radix));
}

CommonInt *CommonInt_valueOfWithNSString_(NSString *s) {
  CommonInt_initialize();
  return CommonInt_valueOfWithInt_(CommonInt_parseIntWithNSString_withInt_(s, 10));
}

CommonInt *CommonInt_valueOfWithInt_(jint i) {
  CommonInt_initialize();
  return i >= 128 || i < -128 ? create_CommonInt_initWithInt_(i) : IOSObjectArray_Get(nil_chk(JreLoadStatic(CommonInt_IntegerCache, cache)), i + 128);
}

void CommonInt_initWithInt_(CommonInt *self, jint value) {
  [self initWithInt:value];
}

CommonInt *new_CommonInt_initWithInt_(jint value) {
  J2OBJC_NEW_IMPL(CommonInt, initWithInt_, value)
}

CommonInt *create_CommonInt_initWithInt_(jint value) {
  J2OBJC_CREATE_IMPL(CommonInt, initWithInt_, value)
}

void CommonInt_initWithNSString_(CommonInt *self, NSString *s) {
  [self initWithInt:CommonInt_parseIntWithNSString_withInt_(s, 10)];
}

CommonInt *new_CommonInt_initWithNSString_(NSString *s) {
  J2OBJC_NEW_IMPL(CommonInt, initWithNSString_, s)
}

CommonInt *create_CommonInt_initWithNSString_(NSString *s) {
  J2OBJC_CREATE_IMPL(CommonInt, initWithNSString_, s)
}

jint CommonInt_hashCodeWithInt_(jint value) {
  CommonInt_initialize();
  return value;
}

CommonInt *CommonInt_getIntegerWithNSString_(NSString *nm) {
  CommonInt_initialize();
  return CommonInt_getIntegerWithNSString_withCommonInt_(nm, nil);
}

CommonInt *CommonInt_getIntegerWithNSString_withInt_(NSString *nm, jint val) {
  CommonInt_initialize();
  CommonInt *result = CommonInt_getIntegerWithNSString_withCommonInt_(nm, nil);
  return (result == nil) ? CommonInt_valueOfWithInt_(val) : result;
}

CommonInt *CommonInt_getIntegerWithNSString_withCommonInt_(NSString *nm, CommonInt *val) {
  CommonInt_initialize();
  NSString *v = nil;
  @try {
    v = JavaLangSystem_getPropertyWithNSString_(nm);
  }
  @catch (JavaLangIllegalArgumentException *e) {
  }
  @catch (JavaLangNullPointerException *e) {
  }
  if (v != nil) {
    @try {
      return CommonInt_decodeWithNSString_(v);
    }
    @catch (JavaLangNumberFormatException *e) {
    }
  }
  return val;
}

CommonInt *CommonInt_decodeWithNSString_(NSString *nm) {
  CommonInt_initialize();
  jint radix = 10;
  jint index = 0;
  jboolean negative = false;
  CommonInt *result;
  if ([((NSString *) nil_chk(nm)) java_length] == 0) @throw create_JavaLangNumberFormatException_initWithNSString_(@"Zero length string");
  jchar firstChar = [nm charAtWithInt:0];
  if (firstChar == '-') {
    negative = true;
    index++;
  }
  else if (firstChar == '+') index++;
  if ([nm java_hasPrefix:@"0x" offset:index] || [nm java_hasPrefix:@"0X" offset:index]) {
    index += 2;
    radix = 16;
  }
  else if ([nm java_hasPrefix:@"#" offset:index]) {
    index++;
    radix = 16;
  }
  else if ([nm java_hasPrefix:@"0" offset:index] && [nm java_length] > 1 + index) {
    index++;
    radix = 8;
  }
  if ([nm java_hasPrefix:@"-" offset:index] || [nm java_hasPrefix:@"+" offset:index]) @throw create_JavaLangNumberFormatException_initWithNSString_(@"Sign character in wrong position");
  @try {
    result = CommonInt_valueOfWithNSString_withInt_([nm java_substring:index], radix);
    result = negative ? CommonInt_valueOfWithInt_(-[((CommonInt *) nil_chk(result)) intValue]) : result;
  }
  @catch (JavaLangNumberFormatException *e) {
    NSString *constant = negative ? (JreStrcat("C$", '-', [nm java_substring:index])) : [nm java_substring:index];
    result = CommonInt_valueOfWithNSString_withInt_(constant, radix);
  }
  return result;
}

jint CommonInt_compareWithInt_withInt_(jint x, jint y) {
  CommonInt_initialize();
  return (x < y) ? -1 : ((x == y) ? 0 : 1);
}

jint CommonInt_compareUnsignedWithInt_withInt_(jint x, jint y) {
  CommonInt_initialize();
  return CommonInt_compareWithInt_withInt_(x + CommonInt_MIN_VALUE, y + CommonInt_MIN_VALUE);
}

jlong CommonInt_toUnsignedLongWithInt_(jint x) {
  CommonInt_initialize();
  return ((jlong) x) & (jlong) 0xffffffffLL;
}

jint CommonInt_divideUnsignedWithInt_withInt_(jint dividend, jint divisor) {
  CommonInt_initialize();
  return (jint) (JreLongDiv(CommonInt_toUnsignedLongWithInt_(dividend), CommonInt_toUnsignedLongWithInt_(divisor)));
}

jint CommonInt_remainderUnsignedWithInt_withInt_(jint dividend, jint divisor) {
  CommonInt_initialize();
  return (jint) (JreLongMod(CommonInt_toUnsignedLongWithInt_(dividend), CommonInt_toUnsignedLongWithInt_(divisor)));
}

jint CommonInt_highestOneBitWithInt_(jint i) {
  CommonInt_initialize();
  i |= (JreRShift32(i, 1));
  i |= (JreRShift32(i, 2));
  i |= (JreRShift32(i, 4));
  i |= (JreRShift32(i, 8));
  i |= (JreRShift32(i, 16));
  return i - (JreURShift32(i, 1));
}

jint CommonInt_lowestOneBitWithInt_(jint i) {
  CommonInt_initialize();
  return i & -i;
}

jint CommonInt_numberOfLeadingZerosWithInt_(jint i) {
  CommonInt_initialize();
  if (i == 0) return 32;
  jint n = 1;
  if (JreURShift32(i, 16) == 0) {
    n += 16;
    JreLShiftAssignInt(&i, 16);
  }
  if (JreURShift32(i, 24) == 0) {
    n += 8;
    JreLShiftAssignInt(&i, 8);
  }
  if (JreURShift32(i, 28) == 0) {
    n += 4;
    JreLShiftAssignInt(&i, 4);
  }
  if (JreURShift32(i, 30) == 0) {
    n += 2;
    JreLShiftAssignInt(&i, 2);
  }
  n -= JreURShift32(i, 31);
  return n;
}

jint CommonInt_numberOfTrailingZerosWithInt_(jint i) {
  CommonInt_initialize();
  jint y;
  if (i == 0) return 32;
  jint n = 31;
  y = JreLShift32(i, 16);
  if (y != 0) {
    n = n - 16;
    i = y;
  }
  y = JreLShift32(i, 8);
  if (y != 0) {
    n = n - 8;
    i = y;
  }
  y = JreLShift32(i, 4);
  if (y != 0) {
    n = n - 4;
    i = y;
  }
  y = JreLShift32(i, 2);
  if (y != 0) {
    n = n - 2;
    i = y;
  }
  return n - (JreURShift32((JreLShift32(i, 1)), 31));
}

jint CommonInt_bitCountWithInt_(jint i) {
  CommonInt_initialize();
  i = i - ((JreURShift32(i, 1)) & (jint) 0x55555555);
  i = (i & (jint) 0x33333333) + ((JreURShift32(i, 2)) & (jint) 0x33333333);
  i = (i + (JreURShift32(i, 4))) & (jint) 0x0f0f0f0f;
  i = i + (JreURShift32(i, 8));
  i = i + (JreURShift32(i, 16));
  return i & (jint) 0x3f;
}

jint CommonInt_rotateLeftWithInt_withInt_(jint i, jint distance) {
  CommonInt_initialize();
  return (JreLShift32(i, distance)) | (JreURShift32(i, -distance));
}

jint CommonInt_rotateRightWithInt_withInt_(jint i, jint distance) {
  CommonInt_initialize();
  return (JreURShift32(i, distance)) | (JreLShift32(i, -distance));
}

jint CommonInt_reverseWithInt_(jint i) {
  CommonInt_initialize();
  i = (JreLShift32((i & (jint) 0x55555555), 1)) | ((JreURShift32(i, 1)) & (jint) 0x55555555);
  i = (JreLShift32((i & (jint) 0x33333333), 2)) | ((JreURShift32(i, 2)) & (jint) 0x33333333);
  i = (JreLShift32((i & (jint) 0x0f0f0f0f), 4)) | ((JreURShift32(i, 4)) & (jint) 0x0f0f0f0f);
  i = (JreLShift32(i, 24)) | (JreLShift32((i & (jint) 0xff00), 8)) | ((JreURShift32(i, 8)) & (jint) 0xff00) | (JreURShift32(i, 24));
  return i;
}

jint CommonInt_signumWithInt_(jint i) {
  CommonInt_initialize();
  return (JreRShift32(i, 31)) | (JreURShift32(-i, 31));
}

jint CommonInt_reverseBytesWithInt_(jint i) {
  CommonInt_initialize();
  return ((JreURShift32(i, 24))) | ((JreRShift32(i, 8)) & (jint) 0xFF00) | ((JreLShift32(i, 8)) & (jint) 0xFF0000) | ((JreLShift32(i, 24)));
}

jint CommonInt_sumWithInt_withInt_(jint a, jint b) {
  CommonInt_initialize();
  return a + b;
}

jint CommonInt_maxWithInt_withInt_(jint a, jint b) {
  CommonInt_initialize();
  return JavaLangMath_maxWithInt_withInt_(a, b);
}

jint CommonInt_minWithInt_withInt_(jint a, jint b) {
  CommonInt_initialize();
  return JavaLangMath_minWithInt_withInt_(a, b);
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonInt)

J2OBJC_NAME_MAPPING(CommonInt, "java.lang.Integer", "CommonInt")

J2OBJC_INITIALIZED_DEFN(CommonInt_IntegerCache)

@implementation CommonInt_IntegerCache

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  CommonInt_IntegerCache_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (void)fillValuesWithCommonIntArray:(IOSObjectArray *)values {
  CommonInt_IntegerCache_fillValuesWithCommonIntArray_(values);
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
  methods[1].selector = @selector(fillValuesWithCommonIntArray:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "cache", "[LCommonInt;", .constantValue.asLong = 0, 0x18, -1, 2, -1, -1 },
  };
  static const void *ptrTable[] = { "fillValues", "[LCommonInt;", &CommonInt_IntegerCache_cache, "LCommonInt;" };
  static const J2ObjcClassInfo _CommonInt_IntegerCache = { "IntegerCache", "java.lang", ptrTable, methods, fields, 7, 0xa, 2, 1, 3, -1, -1, -1, -1 };
  return &_CommonInt_IntegerCache;
}

+ (void)initialize {
  if (self == [CommonInt_IntegerCache class]) {
    JreStrongAssignAndConsume(&CommonInt_IntegerCache_cache, [IOSObjectArray newArrayWithLength:256 type:CommonInt_class_()]);
    {
      CommonInt_IntegerCache_fillValuesWithCommonIntArray_(CommonInt_IntegerCache_cache);
    }
    J2OBJC_SET_INITIALIZED(CommonInt_IntegerCache)
  }
}

@end

void CommonInt_IntegerCache_init(CommonInt_IntegerCache *self) {
  NSObject_init(self);
}

CommonInt_IntegerCache *new_CommonInt_IntegerCache_init() {
  J2OBJC_NEW_IMPL(CommonInt_IntegerCache, init)
}

CommonInt_IntegerCache *create_CommonInt_IntegerCache_init() {
  J2OBJC_CREATE_IMPL(CommonInt_IntegerCache, init)
}

void CommonInt_IntegerCache_fillValuesWithCommonIntArray_(IOSObjectArray *values) {
  CommonInt_IntegerCache_initialize();
  Class self = [CommonInt class];
  size_t objSize = class_getInstanceSize(self);
  uintptr_t ptr = (uintptr_t)calloc(objSize, 256);
  id *buf = values->buffer_;
  for (jint i = -128; i < 128; i++) {
    id obj = objc_constructInstance(self, (void *)ptr);
    CommonInt_initWithInt_(obj, i);
    *(buf++) = obj;
    ptr += objSize;
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonInt_IntegerCache)

// Empty class to force category to be loaded.
@implementation JreKotlinIntCategoryDummy
@end

// kotlin interop <<
