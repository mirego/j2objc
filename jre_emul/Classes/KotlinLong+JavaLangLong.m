// kotlin interop >>

#import "KotlinLong+JavaLangLong.h"

#define J2OBJC_IMPORTED_BY_JAVA_IMPLEMENTATION 1




#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "IOSPrimitiveArray.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/CharSequence.h"
#include "java/lang/Character.h"
#include "java/lang/Deprecated.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/IndexOutOfBoundsException.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/Math.h"
#include "java/lang/NullPointerException.h"
#include "java/lang/NumberFormatException.h"
#include "java/lang/RuntimeException.h"
#include "java/lang/Short.h"
#include "java/lang/System.h"
#include "java/lang/annotation/Annotation.h"
#include "java/math/BigInteger.h"
#include "java/util/Objects.h"


@class NSString;

#if __has_feature(objc_arc)
#error "java/lang/Long must not be compiled with ARC (-fobjc-arc)"
#endif

#pragma clang diagnostic error "-Wreturn-type"
#pragma clang diagnostic ignored "-Wswitch"


@interface CommonLong () {
 @public
  /*!
   @brief The value of the <code>Long</code>.
   */
  jlong value_;
}

/*!
 @brief Return a BigInteger equal to the unsigned value of the
  argument.
 */
+ (JavaMathBigInteger *)toUnsignedBigIntegerWithLong:(jlong)i;

/*!
 @brief Format a long (treated as unsigned) into a String.
 @param val the value to format
 @param shift the log2 of the base to format in (4 for hex, 3 for octal, 1 for binary)
 */
+ (NSString *)toUnsignedString0WithLong:(jlong)i
                                withInt:(jint)shift;

@end

/*!
 @brief use serialVersionUID from JDK 1.0.2 for interoperability
 */
inline jlong CommonLong_get_serialVersionUID(void);
#define CommonLong_serialVersionUID 4290774380558885855LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonLong, serialVersionUID, jlong)

__attribute__((unused)) static JavaMathBigInteger *CommonLong_toUnsignedBigIntegerWithLong_(jlong i);

NSString *CommonLong_toUnsignedString0WithLong_withInt_(jlong i, jint shift);

__attribute__((unused)) static IOSObjectArray *CommonLong__Annotations$0(void);

__attribute__((unused)) static IOSObjectArray *CommonLong__Annotations$1(void);

@interface CommonLong_LongCache : NSObject

- (instancetype)init;

+ (void)fillValuesWithCommonLongArray:(IOSObjectArray *)values;

@end

J2OBJC_STATIC_INIT(CommonLong_LongCache)

inline IOSObjectArray *CommonLong_LongCache_get_cache(void);
static IOSObjectArray *CommonLong_LongCache_cache;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonLong_LongCache, cache, IOSObjectArray *)

__attribute__((unused)) static void CommonLong_LongCache_init(CommonLong_LongCache *self);

__attribute__((unused)) static CommonLong_LongCache *new_CommonLong_LongCache_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static CommonLong_LongCache *create_CommonLong_LongCache_init(void);

__attribute__((unused)) static void CommonLong_LongCache_fillValuesWithCommonLongArray_(IOSObjectArray *values);

J2OBJC_TYPE_LITERAL_HEADER(CommonLong_LongCache)


J2OBJC_INITIALIZED_DEFN(CommonLong)

extern jlong CommonLong_get_MIN_VALUE(void);

extern jlong CommonLong_get_MAX_VALUE(void);

extern IOSClass *CommonLong_get_TYPE(void);

extern jint CommonLong_get_SIZE(void);

extern jint CommonLong_get_BYTES(void);

extern jlong CommonLong_get_serialVersionUID(void);

IOSClass *CommonLong_TYPE;

@implementation CommonLong (JavaLangLong)

+ (NSString *)toStringWithLong:(jlong)i
                       withInt:(jint)radix {
  return CommonLong_toStringWithLong_withInt_(i, radix);
}

+ (NSString *)toUnsignedStringWithLong:(jlong)i
                               withInt:(jint)radix {
  return CommonLong_toUnsignedStringWithLong_withInt_(i, radix);
}

+ (JavaMathBigInteger *)toUnsignedBigIntegerWithLong:(jlong)i {
  return CommonLong_toUnsignedBigIntegerWithLong_(i);
}

+ (NSString *)toHexStringWithLong:(jlong)i {
  return CommonLong_toHexStringWithLong_(i);
}

+ (NSString *)toOctalStringWithLong:(jlong)i {
  return CommonLong_toOctalStringWithLong_(i);
}

+ (NSString *)toBinaryStringWithLong:(jlong)i {
  return CommonLong_toBinaryStringWithLong_(i);
}

+ (NSString *)toUnsignedString0WithLong:(jlong)i
                                withInt:(jint)shift {
  return CommonLong_toUnsignedString0WithLong_withInt_(i, shift);
}

+ (NSString *)toStringWithLong:(jlong)i {
  return CommonLong_toStringWithLong_(i);
}

+ (NSString *)toUnsignedStringWithLong:(jlong)i {
  return CommonLong_toUnsignedStringWithLong_(i);
}

+ (void)getCharsWithLong:(jlong)i
                 withInt:(jint)index
           withCharArray:(IOSCharArray *)buf {
  CommonLong_getCharsWithLong_withInt_withCharArray_(i, index, buf);
}

+ (jint)stringSizeWithLong:(jlong)x {
  return CommonLong_stringSizeWithLong_(x);
}

+ (jlong)parseLongWithNSString:(NSString *)s
                         withInt:(jint)radix {
  return CommonLong_parseLongWithNSString_withInt_(s, radix);
}

+ (jlong)parseLongWithJavaLangCharSequence:(id<JavaLangCharSequence>)s
                                     withInt:(jint)beginIndex
                                     withInt:(jint)endIndex
                                     withInt:(jint)radix {
  return CommonLong_parseLongWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, radix);
}

+ (jlong)parseLongWithNSString:(NSString *)s {
  return CommonLong_parseLongWithNSString_(s);
}

+ (jlong)parseUnsignedLongWithNSString:(NSString *)s
                                 withInt:(jint)radix {
  return CommonLong_parseUnsignedLongWithNSString_withInt_(s, radix);
}

+ (jlong)parseUnsignedLongWithJavaLangCharSequence:(id<JavaLangCharSequence>)s
                                             withInt:(jint)beginIndex
                                             withInt:(jint)endIndex
                                             withInt:(jint)radix {
  return CommonLong_parseUnsignedLongWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, radix);
}

+ (jlong)parseUnsignedLongWithNSString:(NSString *)s {
  return CommonLong_parseUnsignedLongWithNSString_(s);
}

+ (CommonLong *)valueOfWithNSString:(NSString *)s
                              withInt:(jint)radix {
  return CommonLong_valueOfWithNSString_withInt_(s, radix);
}

+ (CommonLong *)valueOfWithNSString:(NSString *)s {
  return CommonLong_valueOfWithNSString_(s);
}

+ (CommonLong *)valueOfWithLong:(jlong)l {
  return CommonLong_valueOfWithLong_(l);
}

+ (CommonLong *)decodeWithNSString:(NSString *)nm {
  return CommonLong_decodeWithNSString_(nm);
}

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)initWithLongLong:(jlong)value {
  CommonLong_initWithLongLong_(self, value);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (instancetype)initWithNSString:(NSString *)s {
  CommonLong_initWithNSString_(self, s);
  return self;
}

- (jbyte)charValue {
  return (jbyte) value_;
}

- (jshort)shortValue {
  return (jshort) value_;
}

- (jint)intValue {
  return (jint) value_;
}

- (jlong)longLongValue {
  return value_;
}

- (float)floatValue {
  return (float) value_;
}

- (double)doubleValue {
  return (double) value_;
}

- (NSString *)description {
  return CommonLong_toStringWithLong_(value_);
}

- (NSUInteger)hash {
  return CommonLong_hashCodeWithLong_(value_);
}

+ (jint)hashCodeWithLong:(jlong)value {
  return CommonLong_hashCodeWithLong_(value);
}

- (jboolean)isEqual:(id)obj {
  if ([obj isKindOfClass:[CommonLong class]]) {
    return value_ == [((CommonLong *) obj) longLongValue];
  }
  return false;
}

+ (CommonLong *)getLongWithNSString:(NSString *)nm {
  return CommonLong_getLongWithNSString_(nm);
}

+ (CommonLong *)getLongWithNSString:(NSString *)nm
                             withLong:(jlong)val {
  return CommonLong_getLongWithNSString_withLong_(nm, val);
}

+ (CommonLong *)getLongWithNSString:(NSString *)nm
                     withCommonLong:(CommonLong *)val {
  return CommonLong_getLongWithNSString_withCommonLong_(nm, val);
}

- (jint)compareToWithId:(CommonLong *)anotherLong {
  cast_chk(anotherLong, [CommonLong class]);
  return CommonLong_compareWithLong_withLong_(self->value_, ((CommonLong *) nil_chk(anotherLong))->value_);
}

+ (jint)compareWithLong:(jlong)x
                  withLong:(jlong)y {
  return CommonLong_compareWithLong_withLong_(x, y);
}

+ (jint)compareUnsignedWithLong:(jlong)x
                          withLong:(jlong)y {
  return CommonLong_compareUnsignedWithLong_withLong_(x, y);
}

+ (jlong)divideUnsignedWithLong:(jlong)dividend
                         withLong:(jlong)divisor {
  return CommonLong_divideUnsignedWithLong_withLong_(dividend, divisor);
}

+ (jlong)remainderUnsignedWithLong:(jlong)dividend
                            withLong:(jlong)divisor {
  return CommonLong_remainderUnsignedWithLong_withLong_(dividend, divisor);
}

+ (jlong)highestOneBitWithLong:(jlong)i {
  return CommonLong_highestOneBitWithLong_(i);
}

+ (jlong)lowestOneBitWithLong:(jlong)i {
  return CommonLong_lowestOneBitWithLong_(i);
}

+ (jint)numberOfLeadingZerosWithLong:(jlong)i {
  return CommonLong_numberOfLeadingZerosWithLong_(i);
}

+ (jint)numberOfTrailingZerosWithLong:(jlong)i {
  return CommonLong_numberOfTrailingZerosWithLong_(i);
}

+ (jint)bitCountWithLong:(jlong)i {
  return CommonLong_bitCountWithLong_(i);
}

+ (jlong)rotateLeftWithLong:(jlong)i
                      withInt:(jint)distance {
  return CommonLong_rotateLeftWithLong_withInt_(i, distance);
}

+ (jlong)rotateRightWithLong:(jlong)i
                       withInt:(jint)distance {
  return CommonLong_rotateRightWithLong_withInt_(i, distance);
}

+ (jlong)reverseWithLong:(jlong)i {
  return CommonLong_reverseWithLong_(i);
}

+ (jint)signumWithLong:(jlong)i {
  return CommonLong_signumWithLong_(i);
}

+ (jlong)reverseBytesWithLong:(jlong)i {
  return CommonLong_reverseBytesWithLong_(i);
}

+ (jlong)sumWithLong:(jlong)a
              withLong:(jlong)b {
  return CommonLong_sumWithLong_withLong_(a, b);
}

+ (jlong)maxWithLong:(jlong)a
              withLong:(jlong)b {
  return CommonLong_maxWithLong_withLong_(a, b);
}

+ (jlong)minWithLong:(jlong)a
              withLong:(jlong)b {
  return CommonLong_minWithLong_withLong_(a, b);
}

- (const char *)objCType {
  return "q";
}

- (void)getValue:(void *)buffer {
  *((long long int *) buffer) = value_;
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x109, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "LJavaMathBigInteger;", 0xa, 3, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 5, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 6, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 7, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x10a, 8, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 0, 4, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 4, -1, -1, -1, -1 },
    { NULL, "V", 0x108, 9, 10, -1, -1, -1, -1 },
    { NULL, "I", 0x8, 11, 4, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 12, 13, 14, -1, -1, -1 },
    { NULL, "J", 0x9, 12, 15, 14, -1, -1, -1 },
    { NULL, "J", 0x9, 12, 16, 14, -1, -1, -1 },
    { NULL, "J", 0x9, 17, 13, 14, -1, -1, -1 },
    { NULL, "J", 0x9, 17, 15, 14, -1, -1, -1 },
    { NULL, "J", 0x9, 17, 16, 14, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 18, 13, 14, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 18, 16, 14, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 18, 4, -1, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 19, 16, 14, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 4, -1, -1, 20, -1 },
    { NULL, NULL, 0x1, -1, 16, 14, -1, 21, -1 },
    { NULL, "B", 0x1, 22, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 23, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 24, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 24, 4, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 25, 26, -1, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 27, 16, -1, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 27, 28, -1, -1, -1, -1 },
    { NULL, "LCommonLong;", 0x9, 27, 29, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 30, 31, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 32, 33, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 34, 33, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 35, 33, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 36, 33, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 37, 4, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 38, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 39, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 40, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 41, 4, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 42, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 43, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 44, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 45, 4, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 46, 4, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 47, 33, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 48, 33, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 49, 33, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithLong:withInt:);
  methods[1].selector = @selector(toUnsignedStringWithLong:withInt:);
  methods[2].selector = @selector(toUnsignedBigIntegerWithLong:);
  methods[3].selector = @selector(toHexStringWithLong:);
  methods[4].selector = @selector(toOctalStringWithLong:);
  methods[5].selector = @selector(toBinaryStringWithLong:);
  methods[6].selector = @selector(toUnsignedString0WithLong:withInt:);
  methods[7].selector = @selector(toStringWithLong:);
  methods[8].selector = @selector(toUnsignedStringWithLong:);
  methods[9].selector = @selector(getCharsWithLong:withInt:withCharArray:);
  methods[10].selector = @selector(stringSizeWithLong:);
  methods[11].selector = @selector(parseLongWithNSString:withInt:);
  methods[12].selector = @selector(parseLongWithJavaLangCharSequence:withInt:withInt:withInt:);
  methods[13].selector = @selector(parseLongWithNSString:);
  methods[14].selector = @selector(parseUnsignedLongWithNSString:withInt:);
  methods[15].selector = @selector(parseUnsignedLongWithJavaLangCharSequence:withInt:withInt:withInt:);
  methods[16].selector = @selector(parseUnsignedLongWithNSString:);
  methods[17].selector = @selector(valueOfWithNSString:withInt:);
  methods[18].selector = @selector(valueOfWithNSString:);
  methods[19].selector = @selector(valueOfWithLong:);
  methods[20].selector = @selector(decodeWithNSString:);
  methods[21].selector = @selector(initWithLongLong:);
  methods[22].selector = @selector(initWithNSString:);
  methods[23].selector = @selector(charValue);
  methods[24].selector = @selector(shortValue);
  methods[25].selector = @selector(intValue);
  methods[26].selector = @selector(longLongValue);
  methods[27].selector = @selector(floatValue);
  methods[28].selector = @selector(doubleValue);
  methods[29].selector = @selector(description);
  methods[30].selector = @selector(hash);
  methods[31].selector = @selector(hashCodeWithLong:);
  methods[32].selector = @selector(isEqual:);
  methods[33].selector = @selector(getLongWithNSString:);
  methods[34].selector = @selector(getLongWithNSString:withLong:);
  methods[35].selector = @selector(getLongWithNSString:withCommonLong:);
  methods[36].selector = @selector(compareToWithId:);
  methods[37].selector = @selector(compareWithLong:withLong:);
  methods[38].selector = @selector(compareUnsignedWithLong:withLong:);
  methods[39].selector = @selector(divideUnsignedWithLong:withLong:);
  methods[40].selector = @selector(remainderUnsignedWithLong:withLong:);
  methods[41].selector = @selector(highestOneBitWithLong:);
  methods[42].selector = @selector(lowestOneBitWithLong:);
  methods[43].selector = @selector(numberOfLeadingZerosWithLong:);
  methods[44].selector = @selector(numberOfTrailingZerosWithLong:);
  methods[45].selector = @selector(bitCountWithLong:);
  methods[46].selector = @selector(rotateLeftWithLong:withInt:);
  methods[47].selector = @selector(rotateRightWithLong:withInt:);
  methods[48].selector = @selector(reverseWithLong:);
  methods[49].selector = @selector(signumWithLong:);
  methods[50].selector = @selector(reverseBytesWithLong:);
  methods[51].selector = @selector(sumWithLong:withLong:);
  methods[52].selector = @selector(maxWithLong:withLong:);
  methods[53].selector = @selector(minWithLong:withLong:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MIN_VALUE", "J", .constantValue.asLong = CommonLong_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "J", .constantValue.asLong = CommonLong_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 50, 51, -1 },
    { "value_", "J", .constantValue.asLong = 0, 0x12, -1, -1, -1, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonLong_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonLong_BYTES, 0x19, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonLong_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "JI", "toUnsignedString", "toUnsignedBigInteger", "J", "toHexString", "toOctalString", "toBinaryString", "toUnsignedString0", "getChars", "JI[C", "stringSize", "parseLong", "LNSString;I", "LJavaLangNumberFormatException;", "LJavaLangCharSequence;III", "LNSString;", "parseUnsignedLong", "valueOf", "decode", (void *)&CommonLong__Annotations$0, (void *)&CommonLong__Annotations$1, "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "getLong", "LNSString;J", "LNSString;LCommonLong;", "compareTo", "LCommonLong;", "compare", "JJ", "compareUnsigned", "divideUnsigned", "remainderUnsigned", "highestOneBit", "lowestOneBit", "numberOfLeadingZeros", "numberOfTrailingZeros", "bitCount", "rotateLeft", "rotateRight", "reverse", "signum", "reverseBytes", "sum", "max", "min", &CommonLong_TYPE, "Ljava/lang/Class<Ljava/lang/Long;>;", "LCommonLong_LongCache;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Long;>;" };
  static const J2ObjcClassInfo _CommonLong = { "Long", "java.lang", ptrTable, methods, fields, 7, 0x11, 54, 7, -1, 52, -1, 53, -1 };
  return &_CommonLong;
}

+ (void)initialize {
  if (self == [CommonLong class]) {
    JreStrongAssign(&CommonLong_TYPE, [IOSClass_longArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonLong)
  }
}

@end

JNIEXPORT jstring Java_java_lang_Long_toString(JNIEnv *_env_, jclass _cls_, jlong i, jint radix);

NSString *CommonLong_toStringWithLong_withInt_(jlong i, jint radix) {
  return (NSString *) Java_java_lang_Long_toString(&J2ObjC_JNIEnv, CommonLong_class_(), i, radix);
}

NSString *CommonLong_toUnsignedStringWithLong_withInt_(jlong i, jint radix) {
  CommonLong_initialize();
  if (i >= 0) return CommonLong_toStringWithLong_withInt_(i, radix);
  else {
    switch (radix) {
      case 2:
      return CommonLong_toBinaryStringWithLong_(i);
      case 4:
      return CommonLong_toUnsignedString0WithLong_withInt_(i, 2);
      case 8:
      return CommonLong_toOctalStringWithLong_(i);
      case 10:
      {
        jlong quot = JreLongDiv((JreURShift64(i, 1)), 5);
        jlong rem = i - quot * 10;
        return JreStrcat("$J", CommonLong_toStringWithLong_(quot), rem);
      }
      case 16:
      return CommonLong_toHexStringWithLong_(i);
      case 32:
      return CommonLong_toUnsignedString0WithLong_withInt_(i, 5);
      default:
      return [((JavaMathBigInteger *) nil_chk(CommonLong_toUnsignedBigIntegerWithLong_(i))) toStringWithInt:radix];
    }
  }
}

JavaMathBigInteger *CommonLong_toUnsignedBigIntegerWithLong_(jlong i) {
  CommonLong_initialize();
  if (i >= 0LL) return JavaMathBigInteger_valueOfWithLong_(i);
  else {
    jint upper = (jint) (JreURShift64(i, 32));
    jint lower = (jint) i;
    return [((JavaMathBigInteger *) nil_chk([((JavaMathBigInteger *) nil_chk((JavaMathBigInteger_valueOfWithLong_(CommonInt_toUnsignedLongWithInt_(upper))))) shiftLeftWithInt:32])) addWithJavaMathBigInteger:JavaMathBigInteger_valueOfWithLong_(CommonInt_toUnsignedLongWithInt_(lower))];
  }
}

NSString *CommonLong_toHexStringWithLong_(jlong i) {
  CommonLong_initialize();
  return CommonLong_toUnsignedString0WithLong_withInt_(i, 4);
}

NSString *CommonLong_toOctalStringWithLong_(jlong i) {
  CommonLong_initialize();
  return CommonLong_toUnsignedString0WithLong_withInt_(i, 3);
}

NSString *CommonLong_toBinaryStringWithLong_(jlong i) {
  CommonLong_initialize();
  return CommonLong_toUnsignedString0WithLong_withInt_(i, 1);
}

JNIEXPORT jstring Java_java_lang_Long_toUnsignedString0(JNIEnv *_env_, jclass _cls_, jlong i, jint shift);

NSString *CommonLong_toUnsignedString0WithLong_withInt_(jlong i, jint shift) {
  return (NSString *) Java_java_lang_Long_toUnsignedString0(&J2ObjC_JNIEnv, CommonLong_class_(), i, shift);
}

NSString *CommonLong_toStringWithLong_(jlong i) {
  CommonLong_initialize();
  if (i == CommonLong_MIN_VALUE) return @"-9223372036854775808";
  jint size = (i < 0) ? CommonLong_stringSizeWithLong_(-i) + 1 : CommonLong_stringSizeWithLong_(i);
  IOSCharArray *buf = [IOSCharArray arrayWithLength:size];
  CommonLong_getCharsWithLong_withInt_withCharArray_(i, size, buf);
  return [NSString java_stringWithCharacters:buf];
}

NSString *CommonLong_toUnsignedStringWithLong_(jlong i) {
  CommonLong_initialize();
  return CommonLong_toUnsignedStringWithLong_withInt_(i, 10);
}

JNIEXPORT void Java_java_lang_Long_getChars(JNIEnv *_env_, jclass _cls_, jlong i, jint index, jarray buf);

void CommonLong_getCharsWithLong_withInt_withCharArray_(jlong i, jint index, IOSCharArray *buf) {
  Java_java_lang_Long_getChars(&J2ObjC_JNIEnv, CommonLong_class_(), i, index, buf);
}

jint CommonLong_stringSizeWithLong_(jlong x) {
  CommonLong_initialize();
  jint d = 1;
  if (x >= 0) {
    d = 0;
    x = -x;
  }
  jlong p = -10;
  for (jint i = 1; i < 19; i++) {
    if (x > p) return i + d;
    p = 10 * p;
  }
  return 19 + d;
}

jlong CommonLong_parseLongWithNSString_withInt_(NSString *s, jint radix) {
  CommonLong_initialize();
  if (s == nil) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(@"Cannot parse null string");
  }
  if (radix < JavaLangCharacter_MIN_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" less than Character.MIN_RADIX"));
  }
  if (radix > JavaLangCharacter_MAX_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" greater than Character.MAX_RADIX"));
  }
  jboolean negative = false;
  jint i = 0;
  jint len = [s java_length];
  jlong limit = -CommonLong_MAX_VALUE;
  if (len > 0) {
    unichar firstChar = [s charAtWithInt:0];
    if (firstChar < '0') {
      if (firstChar == '-') {
        negative = true;
        limit = CommonLong_MIN_VALUE;
      }
      else if (firstChar != '+') {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
      }
      if (len == 1) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
      }
      i++;
    }
    jlong multmin = JreLongDiv(limit, radix);
    jlong result = 0;
    while (i < len) {
      jint digit = JavaLangCharacter_digitWithChar_withInt_([s charAtWithInt:i++], radix);
      if (digit < 0 || result < multmin) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
      }
      result *= radix;
      if (result < limit + digit) {
        @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
      }
      result -= digit;
    }
    return negative ? result : -result;
  }
  else {
    @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
  }
}

jlong CommonLong_parseLongWithJavaLangCharSequence_withInt_withInt_withInt_(id<JavaLangCharSequence> s, jint beginIndex, jint endIndex, jint radix) {
  CommonLong_initialize();
  JavaUtilObjects_requireNonNullWithId_(s);
  if (beginIndex < 0 || beginIndex > endIndex || endIndex > [((id<JavaLangCharSequence>) nil_chk(s)) java_length]) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  if (radix < JavaLangCharacter_MIN_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" less than Character.MIN_RADIX"));
  }
  if (radix > JavaLangCharacter_MAX_RADIX) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$I$", @"radix ", radix, @" greater than Character.MAX_RADIX"));
  }
  jboolean negative = false;
  jint i = beginIndex;
  jlong limit = -CommonLong_MAX_VALUE;
  if (i < endIndex) {
    unichar firstChar = [((id<JavaLangCharSequence>) nil_chk(s)) charAtWithInt:i];
    if (firstChar < '0') {
      if (firstChar == '-') {
        negative = true;
        limit = CommonLong_MIN_VALUE;
      }
      else if (firstChar != '+') {
        @throw nil_chk(JavaLangNumberFormatException_forCharSequenceWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, i));
      }
      i++;
    }
    if (i >= endIndex) {
      @throw nil_chk(JavaLangNumberFormatException_forCharSequenceWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, i));
    }
    jlong multmin = JreLongDiv(limit, radix);
    jlong result = 0;
    while (i < endIndex) {
      jint digit = JavaLangCharacter_digitWithChar_withInt_([s charAtWithInt:i], radix);
      if (digit < 0 || result < multmin) {
        @throw nil_chk(JavaLangNumberFormatException_forCharSequenceWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, i));
      }
      result *= radix;
      if (result < limit + digit) {
        @throw nil_chk(JavaLangNumberFormatException_forCharSequenceWithJavaLangCharSequence_withInt_withInt_withInt_(s, beginIndex, endIndex, i));
      }
      i++;
      result -= digit;
    }
    return negative ? result : -result;
  }
  else {
    @throw create_JavaLangNumberFormatException_initWithNSString_(@"");
  }
}

jlong CommonLong_parseLongWithNSString_(NSString *s) {
  CommonLong_initialize();
  return CommonLong_parseLongWithNSString_withInt_(s, 10);
}

jlong CommonLong_parseUnsignedLongWithNSString_withInt_(NSString *s, jint radix) {
  CommonLong_initialize();
  if (s == nil) {
    @throw create_JavaLangNumberFormatException_initWithNSString_(@"Cannot parse null string");
  }
  jint len = [s java_length];
  if (len > 0) {
    unichar firstChar = [s charAtWithInt:0];
    if (firstChar == '-') {
      @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"Illegal leading minus sign on unsigned string %s.", [IOSObjectArray arrayWithObjects:(id[]){ s } count:1 type:NSObject_class_()]));
    }
    else {
      if (len <= 12 || (radix == 10 && len <= 18)) {
        return CommonLong_parseLongWithNSString_withInt_(s, radix);
      }
      jlong first = CommonLong_parseLongWithJavaLangCharSequence_withInt_withInt_withInt_(s, 0, len - 1, radix);
      jint second = JavaLangCharacter_digitWithChar_withInt_([s charAtWithInt:len - 1], radix);
      if (second < 0) {
        @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$$", @"Bad digit at end of ", s));
      }
      jlong result = first * radix + second;
      jint guard = radix * (jint) (JreURShift64(first, 57));
      if (guard >= 128 || (result >= 0 && guard >= 128 - JavaLangCharacter_MAX_RADIX)) {
        @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"String value %s exceeds range of unsigned long.", [IOSObjectArray arrayWithObjects:(id[]){ s } count:1 type:NSObject_class_()]));
      }
      return result;
    }
  }
  else {
    @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(s, radix));
  }
}

jlong CommonLong_parseUnsignedLongWithJavaLangCharSequence_withInt_withInt_withInt_(id<JavaLangCharSequence> s, jint beginIndex, jint endIndex, jint radix) {
  CommonLong_initialize();
  JavaUtilObjects_requireNonNullWithId_(s);
  if (beginIndex < 0 || beginIndex > endIndex || endIndex > [((id<JavaLangCharSequence>) nil_chk(s)) java_length]) {
    @throw create_JavaLangIndexOutOfBoundsException_init();
  }
  jint start = beginIndex;
  jint len = endIndex - beginIndex;
  if (len > 0) {
    unichar firstChar = [((id<JavaLangCharSequence>) nil_chk(s)) charAtWithInt:start];
    if (firstChar == '-') {
      @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"Illegal leading minus sign on unsigned string %s.", [IOSObjectArray arrayWithObjects:(id[]){ [s subSequenceFrom:start to:start + len] } count:1 type:NSObject_class_()]));
    }
    else {
      if (len <= 12 || (radix == 10 && len <= 18)) {
        return CommonLong_parseLongWithJavaLangCharSequence_withInt_withInt_withInt_(s, start, start + len, radix);
      }
      jlong first = CommonLong_parseLongWithJavaLangCharSequence_withInt_withInt_withInt_(s, start, start + len - 1, radix);
      jint second = JavaLangCharacter_digitWithChar_withInt_([s charAtWithInt:start + len - 1], radix);
      if (second < 0) {
        @throw create_JavaLangNumberFormatException_initWithNSString_(JreStrcat("$@", @"Bad digit at end of ", [s subSequenceFrom:start to:start + len]));
      }
      jlong result = first * radix + second;
      jint guard = radix * (jint) (JreURShift64(first, 57));
      if (guard >= 128 || (result >= 0 && guard >= 128 - JavaLangCharacter_MAX_RADIX)) {
        @throw create_JavaLangNumberFormatException_initWithNSString_(NSString_java_formatWithNSString_withNSObjectArray_(@"String value %s exceeds range of unsigned long.", [IOSObjectArray arrayWithObjects:(id[]){ [s subSequenceFrom:start to:start + len] } count:1 type:NSObject_class_()]));
      }
      return result;
    }
  }
  else {
    @throw nil_chk(JavaLangNumberFormatException_forInputStringWithNSString_withInt_(@"", radix));
  }
}

jlong CommonLong_parseUnsignedLongWithNSString_(NSString *s) {
  CommonLong_initialize();
  return CommonLong_parseUnsignedLongWithNSString_withInt_(s, 10);
}

CommonLong *CommonLong_valueOfWithNSString_withInt_(NSString *s, jint radix) {
  CommonLong_initialize();
  return CommonLong_valueOfWithLong_(CommonLong_parseLongWithNSString_withInt_(s, radix));
}

CommonLong *CommonLong_valueOfWithNSString_(NSString *s) {
  CommonLong_initialize();
  return CommonLong_valueOfWithLong_(CommonLong_parseLongWithNSString_withInt_(s, 10));
}

CommonLong *CommonLong_valueOfWithLong_(jlong l) {
  CommonLong_initialize();
  jint offset = 128;
  if (l >= -128 && l <= 127) {
    return IOSObjectArray_Get(nil_chk(JreLoadStatic(CommonLong_LongCache, cache)), (jint) l + offset);
  }
  return create_CommonLong_initWithLongLong_(l);
}

CommonLong *CommonLong_decodeWithNSString_(NSString *nm) {
  CommonLong_initialize();
  jint radix = 10;
  jint index = 0;
  jboolean negative = false;
  CommonLong *result;
  if ([((NSString *) nil_chk(nm)) isEmpty]) @throw create_JavaLangNumberFormatException_initWithNSString_(@"Zero length string");
  unichar firstChar = [nm charAtWithInt:0];
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
    result = CommonLong_valueOfWithNSString_withInt_([nm java_substring:index], radix);
    result = negative ? CommonLong_valueOfWithLong_(-[((CommonLong *) nil_chk(result)) longLongValue]) : result;
  }
  @catch (JavaLangNumberFormatException *e) {
    NSString *constant = negative ? (JreStrcat("C$", '-', [nm java_substring:index])) : [nm java_substring:index];
    result = CommonLong_valueOfWithNSString_withInt_(constant, radix);
  }
  return result;
}

void CommonLong_initWithLongLong_(CommonLong *self, jlong value) {
  NSNumber_init(self);
  self->value_ = value;
}

CommonLong *new_CommonLong_initWithLongLong_(jlong value) {
  J2OBJC_NEW_IMPL(CommonLong, initWithLongLong_, value)
}

CommonLong *create_CommonLong_initWithLongLong_(jlong value) {
  J2OBJC_CREATE_IMPL(CommonLong, initWithLongLong_, value)
}

void CommonLong_initWithNSString_(CommonLong *self, NSString *s) {
  NSNumber_init(self);
  self->value_ = CommonLong_parseLongWithNSString_withInt_(s, 10);
}

CommonLong *new_CommonLong_initWithNSString_(NSString *s) {
  J2OBJC_NEW_IMPL(CommonLong, initWithNSString_, s)
}

CommonLong *create_CommonLong_initWithNSString_(NSString *s) {
  J2OBJC_CREATE_IMPL(CommonLong, initWithNSString_, s)
}

jint CommonLong_hashCodeWithLong_(jlong value) {
  CommonLong_initialize();
  return (jint) (value ^ (JreURShift64(value, 32)));
}

CommonLong *CommonLong_getLongWithNSString_(NSString *nm) {
  CommonLong_initialize();
  return CommonLong_getLongWithNSString_withCommonLong_(nm, nil);
}

CommonLong *CommonLong_getLongWithNSString_withLong_(NSString *nm, jlong val) {
  CommonLong_initialize();
  CommonLong *result = CommonLong_getLongWithNSString_withCommonLong_(nm, nil);
  return (result == nil) ? CommonLong_valueOfWithLong_(val) : result;
}

CommonLong *CommonLong_getLongWithNSString_withCommonLong_(NSString *nm, CommonLong *val) {
  CommonLong_initialize();
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
      return CommonLong_decodeWithNSString_(v);
    }
    @catch (JavaLangNumberFormatException *e) {
    }
  }
  return val;
}

jint CommonLong_compareWithLong_withLong_(jlong x, jlong y) {
  CommonLong_initialize();
  return (x < y) ? -1 : ((x == y) ? 0 : 1);
}

jint CommonLong_compareUnsignedWithLong_withLong_(jlong x, jlong y) {
  CommonLong_initialize();
  return CommonLong_compareWithLong_withLong_(x + CommonLong_MIN_VALUE, y + CommonLong_MIN_VALUE);
}

jlong CommonLong_divideUnsignedWithLong_withLong_(jlong dividend, jlong divisor) {
  CommonLong_initialize();
  if (divisor >= 0) {
    jlong q = JreLShift64(JreLongDiv((JreURShift64(dividend, 1)), divisor), 1);
    jlong r = dividend - q * divisor;
    return q + (JreURShift64((r | ~(r - divisor)), (CommonLong_SIZE - 1)));
  }
  return JreURShift64((dividend & ~(dividend - divisor)), (CommonLong_SIZE - 1));
}

jlong CommonLong_remainderUnsignedWithLong_withLong_(jlong dividend, jlong divisor) {
  CommonLong_initialize();
  if (divisor >= 0) {
    jlong q = JreLShift64(JreLongDiv((JreURShift64(dividend, 1)), divisor), 1);
    jlong r = dividend - q * divisor;
    return r - ((JreRShift64(~(r - divisor), (CommonLong_SIZE - 1))) & divisor);
  }
  return dividend - ((JreRShift64((dividend & ~(dividend - divisor)), (CommonLong_SIZE - 1))) & divisor);
}

jlong CommonLong_highestOneBitWithLong_(jlong i) {
  CommonLong_initialize();
  return i & (JreURShift64(CommonLong_MIN_VALUE, CommonLong_numberOfLeadingZerosWithLong_(i)));
}

jlong CommonLong_lowestOneBitWithLong_(jlong i) {
  CommonLong_initialize();
  return i & -i;
}

jint CommonLong_numberOfLeadingZerosWithLong_(jlong i) {
  CommonLong_initialize();
  jint x = (jint) (JreURShift64(i, 32));
  return x == 0 ? 32 + CommonInt_numberOfLeadingZerosWithInt_((jint) i) : CommonInt_numberOfLeadingZerosWithInt_(x);
}

jint CommonLong_numberOfTrailingZerosWithLong_(jlong i) {
  CommonLong_initialize();
  jint x = (jint) i;
  return x == 0 ? 32 + CommonInt_numberOfTrailingZerosWithInt_((jint) (JreURShift64(i, 32))) : CommonInt_numberOfTrailingZerosWithInt_(x);
}

jint CommonLong_bitCountWithLong_(jlong i) {
  CommonLong_initialize();
  i = i - ((JreURShift64(i, 1)) & (jlong) 0x5555555555555555LL);
  i = (i & (jlong) 0x3333333333333333LL) + ((JreURShift64(i, 2)) & (jlong) 0x3333333333333333LL);
  i = (i + (JreURShift64(i, 4))) & (jlong) 0x0f0f0f0f0f0f0f0fLL;
  i = i + (JreURShift64(i, 8));
  i = i + (JreURShift64(i, 16));
  i = i + (JreURShift64(i, 32));
  return (jint) i & (jint) 0x7f;
}

jlong CommonLong_rotateLeftWithLong_withInt_(jlong i, jint distance) {
  CommonLong_initialize();
  return (JreLShift64(i, distance)) | (JreURShift64(i, -distance));
}

jlong CommonLong_rotateRightWithLong_withInt_(jlong i, jint distance) {
  CommonLong_initialize();
  return (JreURShift64(i, distance)) | (JreLShift64(i, -distance));
}

jlong CommonLong_reverseWithLong_(jlong i) {
  CommonLong_initialize();
  i = (JreLShift64((i & (jlong) 0x5555555555555555LL), 1)) | ((JreURShift64(i, 1)) & (jlong) 0x5555555555555555LL);
  i = (JreLShift64((i & (jlong) 0x3333333333333333LL), 2)) | ((JreURShift64(i, 2)) & (jlong) 0x3333333333333333LL);
  i = (JreLShift64((i & (jlong) 0x0f0f0f0f0f0f0f0fLL), 4)) | ((JreURShift64(i, 4)) & (jlong) 0x0f0f0f0f0f0f0f0fLL);
  return CommonLong_reverseBytesWithLong_(i);
}

jint CommonLong_signumWithLong_(jlong i) {
  CommonLong_initialize();
  return (jint) ((JreRShift64(i, 63)) | (JreURShift64(-i, 63)));
}

jlong CommonLong_reverseBytesWithLong_(jlong i) {
  CommonLong_initialize();
  i = (JreLShift64((i & (jlong) 0x00ff00ff00ff00ffLL), 8)) | ((JreURShift64(i, 8)) & (jlong) 0x00ff00ff00ff00ffLL);
  return (JreLShift64(i, 48)) | (JreLShift64((i & (jlong) 0xffff0000LL), 16)) | ((JreURShift64(i, 16)) & (jlong) 0xffff0000LL) | (JreURShift64(i, 48));
}

jlong CommonLong_sumWithLong_withLong_(jlong a, jlong b) {
  CommonLong_initialize();
  return a + b;
}

jlong CommonLong_maxWithLong_withLong_(jlong a, jlong b) {
  CommonLong_initialize();
  return JavaLangMath_maxWithLong_withLong_(a, b);
}

jlong CommonLong_minWithLong_withLong_(jlong a, jlong b) {
  CommonLong_initialize();
  return JavaLangMath_minWithLong_withLong_(a, b);
}

IOSObjectArray *CommonLong__Annotations$0() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"9") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

IOSObjectArray *CommonLong__Annotations$1() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"9") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonLong)

J2OBJC_INITIALIZED_DEFN(CommonLong_LongCache)

extern IOSObjectArray *CommonLong_LongCache_get_cache(void);

@implementation CommonLong_LongCache

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  CommonLong_LongCache_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (void)fillValuesWithCommonLongArray:(IOSObjectArray *)values {
  CommonLong_LongCache_fillValuesWithCommonLongArray_(values);
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
  methods[1].selector = @selector(fillValuesWithCommonLongArray:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "cache", "[LCommonLong;", .constantValue.asLong = 0, 0x18, -1, 2, -1, -1 },
  };
  static const void *ptrTable[] = { "fillValues", "[LCommonLong;", &CommonLong_LongCache_cache, "LCommonLong;" };
  static const J2ObjcClassInfo _CommonLong_LongCache = { "LongCache", "java.lang", ptrTable, methods, fields, 7, 0xa, 2, 1, 3, -1, -1, -1, -1 };
  return &_CommonLong_LongCache;
}

+ (void)initialize {
  if (self == [CommonLong_LongCache class]) {
    JreStrongAssignAndConsume(&CommonLong_LongCache_cache, [IOSObjectArray newArrayWithLength:256 type:CommonLong_class_()]);
    {
      CommonLong_LongCache_fillValuesWithCommonLongArray_(CommonLong_LongCache_cache);
    }
    J2OBJC_SET_INITIALIZED(CommonLong_LongCache)
  }
}

@end

void CommonLong_LongCache_init(CommonLong_LongCache *self) {
  NSObject_init(self);
}

CommonLong_LongCache *new_CommonLong_LongCache_init() {
  J2OBJC_NEW_IMPL(CommonLong_LongCache, init)
}

CommonLong_LongCache *create_CommonLong_LongCache_init() {
  J2OBJC_CREATE_IMPL(CommonLong_LongCache, init)
}

void CommonLong_LongCache_fillValuesWithCommonLongArray_(IOSObjectArray *values) {
  CommonLong_LongCache_initialize();
  Class self = [CommonLong class];
  size_t objSize = class_getInstanceSize(self);
  uintptr_t ptr = (uintptr_t)calloc(objSize, 256);
  id *buf = values->buffer_;
  for (jint i = -128; i < 128; i++) {
    id obj = objc_constructInstance(self, (void *)ptr);
    CommonLong_initWithLongLong_(obj, i);
    *(buf++) = obj;
    ptr += objSize;
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonLong_LongCache)

// kotlin interop <<
