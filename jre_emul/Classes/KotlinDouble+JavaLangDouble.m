// kotlin interop >>

#import "KotlinDouble+JavaLangDouble.h"

#include "IOSClass.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Character.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/Math.h"
#include "java/lang/Short.h"
#include "java/lang/StringBuilder.h"
#include "sun/misc/DoubleConsts.h"
#include "sun/misc/FloatingDecimal.h"

/*!
 @brief use serialVersionUID from JDK 1.0.2 for interoperability
 */
inline jlong CommonDouble_get_serialVersionUID(void);
#define CommonDouble_serialVersionUID -9172774392245257468LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonDouble, serialVersionUID, jlong)

J2OBJC_INITIALIZED_DEFN(CommonDouble)

IOSClass *CommonDouble_TYPE;

@implementation CommonDouble (JavaLangDouble)

+ (jdouble)POSITIVE_INFINITY {
  return CommonDouble_POSITIVE_INFINITY;
}

+ (jdouble)NEGATIVE_INFINITY {
  return CommonDouble_NEGATIVE_INFINITY;
}

+ (jdouble)NaN {
  return CommonDouble_NaN;
}

+ (jdouble)MAX_VALUE {
  return CommonDouble_MAX_VALUE;
}

+ (jdouble)MIN_NORMAL {
  return CommonDouble_MIN_NORMAL;
}

+ (jdouble)MIN_VALUE {
  return CommonDouble_MIN_VALUE;
}

+ (jint)MAX_EXPONENT {
  return CommonDouble_MAX_EXPONENT;
}

+ (jint)MIN_EXPONENT {
  return CommonDouble_MIN_EXPONENT;
}

+ (jint)SIZE {
  return CommonDouble_SIZE;
}

+ (jint)BYTES {
  return CommonDouble_BYTES;
}

+ (IOSClass *)TYPE {
  return CommonDouble_TYPE;
}

+ (NSString *)toStringWithDouble:(jdouble)d {
  return CommonDouble_toStringWithDouble_(d);
}

+ (NSString *)toHexStringWithDouble:(jdouble)d {
  return CommonDouble_toHexStringWithDouble_(d);
}

+ (CommonDouble *)valueOfWithNSString:(NSString *)s {
  return CommonDouble_valueOfWithNSString_(s);
}

+ (CommonDouble *)valueOfWithDouble:(jdouble)d {
  return CommonDouble_valueOfWithDouble_(d);
}

+ (jdouble)parseDoubleWithNSString:(NSString *)s {
  return CommonDouble_parseDoubleWithNSString_(s);
}

+ (jboolean)isNaNWithDouble:(jdouble)v {
  return CommonDouble_isNaNWithDouble_(v);
}

+ (jboolean)isInfiniteWithDouble:(jdouble)v {
  return CommonDouble_isInfiniteWithDouble_(v);
}

+ (jboolean)isFiniteWithDouble:(jdouble)d {
  return CommonDouble_isFiniteWithDouble_(d);
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonDouble_initWithNSString_(self, s);
  return self;
}

- (jboolean)isNaN {
  return CommonDouble_isNaNWithDouble_(self.doubleValue);
}

- (jboolean)isInfinite {
  return CommonDouble_isInfiniteWithDouble_(self.doubleValue);
}

- (NSString *)description {
  return CommonDouble_toStringWithDouble_(self.doubleValue);
}

- (jbyte)charValue {
  return (jbyte) JreFpToInt(self.doubleValue);
}

- (jshort)shortValue {
  return (jshort) JreFpToInt(self.doubleValue);
}

- (jint)intValue {
  return JreFpToInt(self.doubleValue);
}

- (jlong)longLongValue {
  return JreFpToLong(self.doubleValue);
}

- (jfloat)floatValue {
  return (jfloat) self.doubleValue;
}

//- (jdouble)doubleValue {
//  return (jdouble) self.doubleValue;
//}

- (NSUInteger)hash {
  return CommonDouble_hashCodeWithDouble_(self.doubleValue);
}

+ (jint)hashCodeWithDouble:(jdouble)value {
  return CommonDouble_hashCodeWithDouble_(value);
}

- (jboolean)isEqual:(id)obj {
  return ([obj isKindOfClass:[CommonDouble class]]) && (CommonDouble_doubleToLongBitsWithDouble_(((CommonDouble *) nil_chk(((CommonDouble *) cast_chk(obj, [CommonDouble class])))).doubleValue) == CommonDouble_doubleToLongBitsWithDouble_(self.doubleValue));
}

+ (jlong)doubleToLongBitsWithDouble:(jdouble)value {
  return CommonDouble_doubleToLongBitsWithDouble_(value);
}

+ (jlong)doubleToRawLongBitsWithDouble:(jdouble)value {
  return CommonDouble_doubleToRawLongBitsWithDouble_(value);
}

+ (jdouble)longBitsToDoubleWithLong:(jlong)bits {
  return CommonDouble_longBitsToDoubleWithLong_(bits);
}

- (jint)compareToWithId:(CommonDouble *)anotherDouble {
  cast_chk(anotherDouble, [CommonDouble class]);
  return CommonDouble_compareWithDouble_withDouble_(self.doubleValue, ((CommonDouble *) nil_chk(anotherDouble)).doubleValue);
}

+ (jint)compareWithDouble:(jdouble)d1
               withDouble:(jdouble)d2 {
  return CommonDouble_compareWithDouble_withDouble_(d1, d2);
}

+ (jdouble)sumWithDouble:(jdouble)a
              withDouble:(jdouble)b {
  return CommonDouble_sumWithDouble_withDouble_(a, b);
}

+ (jdouble)maxWithDouble:(jdouble)a
              withDouble:(jdouble)b {
  return CommonDouble_maxWithDouble_withDouble_(a, b);
}

+ (jdouble)minWithDouble:(jdouble)a
              withDouble:(jdouble)b {
  return CommonDouble_minWithDouble_withDouble_(a, b);
}

//- (const char *)objCType {
//  return "d";
//}

//- (void)getValue:(void *)buffer {
//  *((double *) buffer) = self.doubleValue;
//}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x9, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "LCommonDouble;", 0x9, 3, 4, 5, -1, -1, -1 },
    { NULL, "LCommonDouble;", 0x9, 3, 1, -1, -1, -1, -1 },
    { NULL, "D", 0x9, 6, 4, 5, -1, -1, -1 },
    { NULL, "Z", 0x9, 7, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 8, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 9, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 4, 5, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "B", 0x1, 10, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 11, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 12, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 12, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 13, 14, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 15, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x109, 16, 1, -1, -1, -1, -1 },
    { NULL, "D", 0x109, 17, 18, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 19, 20, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 21, 22, -1, -1, -1, -1 },
    { NULL, "D", 0x9, 23, 22, -1, -1, -1, -1 },
    { NULL, "D", 0x9, 24, 22, -1, -1, -1, -1 },
    { NULL, "D", 0x9, 25, 22, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithDouble:);
  methods[1].selector = @selector(toHexStringWithDouble:);
  methods[2].selector = @selector(valueOfWithNSString:);
  methods[3].selector = @selector(valueOfWithDouble:);
  methods[4].selector = @selector(parseDoubleWithNSString:);
  methods[5].selector = @selector(isNaNWithDouble:);
  methods[6].selector = @selector(isInfiniteWithDouble:);
  methods[7].selector = @selector(isFiniteWithDouble:);
  methods[8].selector = @selector(initWithDouble:);
  methods[9].selector = @selector(initWithNSString:);
  methods[10].selector = @selector(isNaN);
  methods[11].selector = @selector(isInfinite);
  methods[12].selector = @selector(description);
  methods[13].selector = @selector(charValue);
  methods[14].selector = @selector(shortValue);
  methods[15].selector = @selector(intValue);
  methods[16].selector = @selector(longLongValue);
  methods[17].selector = @selector(floatValue);
  methods[18].selector = @selector(doubleValue);
  methods[19].selector = @selector(hash);
  methods[20].selector = @selector(hashCodeWithDouble:);
  methods[21].selector = @selector(isEqual:);
  methods[22].selector = @selector(doubleToLongBitsWithDouble:);
  methods[23].selector = @selector(doubleToRawLongBitsWithDouble:);
  methods[24].selector = @selector(longBitsToDoubleWithLong:);
  methods[25].selector = @selector(compareToWithId:);
  methods[26].selector = @selector(compareWithDouble:withDouble:);
  methods[27].selector = @selector(sumWithDouble:withDouble:);
  methods[28].selector = @selector(maxWithDouble:withDouble:);
  methods[29].selector = @selector(minWithDouble:withDouble:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "POSITIVE_INFINITY", "D", .constantValue.asDouble = CommonDouble_POSITIVE_INFINITY, 0x19, -1, -1, -1, -1 },
    { "NEGATIVE_INFINITY", "D", .constantValue.asDouble = CommonDouble_NEGATIVE_INFINITY, 0x19, -1, -1, -1, -1 },
    { "NaN", "D", .constantValue.asDouble = CommonDouble_NaN, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "D", .constantValue.asDouble = CommonDouble_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "MIN_NORMAL", "D", .constantValue.asDouble = CommonDouble_MIN_NORMAL, 0x19, -1, -1, -1, -1 },
    { "MIN_VALUE", "D", .constantValue.asDouble = CommonDouble_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_EXPONENT", "I", .constantValue.asInt = CommonDouble_MAX_EXPONENT, 0x19, -1, -1, -1, -1 },
    { "MIN_EXPONENT", "I", .constantValue.asInt = CommonDouble_MIN_EXPONENT, 0x19, -1, -1, -1, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonDouble_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonDouble_BYTES, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 26, 27, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonDouble_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "D", "toHexString", "valueOf", "LNSString;", "LJavaLangNumberFormatException;", "parseDouble", "isNaN", "isInfinite", "isFinite", "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "doubleToLongBits", "doubleToRawLongBits", "longBitsToDouble", "J", "compareTo", "LCommonDouble;", "compare", "DD", "sum", "max", "min", &CommonDouble_TYPE, "Ljava/lang/Class<Ljava/lang/Double;>;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Double;>;" };
  static const J2ObjcClassInfo _CommonDouble = { "Double", "java.lang", ptrTable, methods, fields, 7, 0x11, 30, 13, -1, -1, -1, 28, -1 };
  return &_CommonDouble;
}

+ (void)initialize {
  if (self == [CommonDouble class]) {
    JreStrongAssign(&CommonDouble_TYPE, [IOSClass_doubleArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonDouble)
  }
}

@end

NSString *CommonDouble_toStringWithDouble_(jdouble d) {
  CommonDouble_initialize();
  return SunMiscFloatingDecimal_toJavaFormatStringWithDouble_(d);
}

NSString *CommonDouble_toHexStringWithDouble_(jdouble d) {
  CommonDouble_initialize();
  if (!CommonDouble_isFiniteWithDouble_(d)) return CommonDouble_toStringWithDouble_(d);
  else {
    JavaLangStringBuilder *answer = create_JavaLangStringBuilder_initWithInt_(24);
    if (JavaLangMath_copySignWithDouble_withDouble_(1.0, d) == -1.0) [answer appendWithNSString:@"-"];
    [answer appendWithNSString:@"0x"];
    d = JavaLangMath_absWithDouble_(d);
    if (d == 0.0) {
      [answer appendWithNSString:@"0.0p0"];
    }
    else {
      jboolean subnormal = (d < SunMiscDoubleConsts_MIN_NORMAL);
      jlong signifBits = (CommonDouble_doubleToLongBitsWithDouble_(d) & SunMiscDoubleConsts_SIGNIF_BIT_MASK) | (jlong) 0x1000000000000000LL;
      [answer appendWithNSString:subnormal ? @"0." : @"1."];
      NSString *signif = [((NSString *) nil_chk(CommonLong_toHexStringWithLong_(signifBits))) java_substring:3 endIndex:16];
      [answer appendWithNSString:[((NSString *) nil_chk(signif)) isEqual:@"0000000000000"] ? @"0" : [signif java_replaceFirst:@"0{1,12}$" withReplacement:@""]];
      [answer appendWithChar:'p'];
      [answer appendWithInt:subnormal ? SunMiscDoubleConsts_MIN_EXPONENT : JavaLangMath_getExponentWithDouble_(d)];
    }
    return [answer description];
  }
}

CommonDouble *CommonDouble_valueOfWithNSString_(NSString *s) {
  CommonDouble_initialize();
  return create_CommonDouble_initWithDouble_(CommonDouble_parseDoubleWithNSString_(s));
}

CommonDouble *CommonDouble_valueOfWithDouble_(jdouble d) {
  CommonDouble_initialize();
  return create_CommonDouble_initWithDouble_(d);
}

jdouble CommonDouble_parseDoubleWithNSString_(NSString *s) {
  CommonDouble_initialize();
  return SunMiscFloatingDecimal_parseDoubleWithNSString_(s);
}

jboolean CommonDouble_isNaNWithDouble_(jdouble v) {
  CommonDouble_initialize();
  return (v != v);
}

jboolean CommonDouble_isInfiniteWithDouble_(jdouble v) {
  CommonDouble_initialize();
  return (v == CommonDouble_POSITIVE_INFINITY) || (v == CommonDouble_NEGATIVE_INFINITY);
}

jboolean CommonDouble_isFiniteWithDouble_(jdouble d) {
  CommonDouble_initialize();
  return JavaLangMath_absWithDouble_(d) <= SunMiscDoubleConsts_MAX_VALUE;
}

void CommonDouble_initWithDouble_(CommonDouble *self, jdouble value) {
  [self initWithDouble:value];
}

CommonDouble *new_CommonDouble_initWithDouble_(jdouble value) {
  J2OBJC_NEW_IMPL(CommonDouble, initWithDouble_, value)
}

CommonDouble *create_CommonDouble_initWithDouble_(jdouble value) {
  J2OBJC_CREATE_IMPL(CommonDouble, initWithDouble_, value)
}

void CommonDouble_initWithNSString_(CommonDouble *self, NSString *s) {
  [self initWithDouble:CommonDouble_parseDoubleWithNSString_(s)];
}

CommonDouble *new_CommonDouble_initWithNSString_(NSString *s) {
  J2OBJC_NEW_IMPL(CommonDouble, initWithNSString_, s)
}

CommonDouble *create_CommonDouble_initWithNSString_(NSString *s) {
  J2OBJC_CREATE_IMPL(CommonDouble, initWithNSString_, s)
}

jint CommonDouble_hashCodeWithDouble_(jdouble value) {
  CommonDouble_initialize();
  jlong bits = CommonDouble_doubleToLongBitsWithDouble_(value);
  return (jint) (bits ^ (JreURShift64(bits, 32)));
}

jlong CommonDouble_doubleToLongBitsWithDouble_(jdouble value) {
  CommonDouble_initialize();
  jlong result = CommonDouble_doubleToRawLongBitsWithDouble_(value);
  if (((result & SunMiscDoubleConsts_EXP_BIT_MASK) == SunMiscDoubleConsts_EXP_BIT_MASK) && (result & SunMiscDoubleConsts_SIGNIF_BIT_MASK) != 0LL) result = (jlong) 0x7ff8000000000000LL;
  return result;
}

jlong CommonDouble_doubleToRawLongBitsWithDouble_(jdouble value) {
  CommonDouble_initialize();
  return *(long long *) &value;
}

jdouble CommonDouble_longBitsToDoubleWithLong_(jlong bits) {
  CommonDouble_initialize();
  return *(double *) &bits;
}

jint CommonDouble_compareWithDouble_withDouble_(jdouble d1, jdouble d2) {
  CommonDouble_initialize();
  if (d1 < d2) return -1;
  if (d1 > d2) return 1;
  jlong thisBits = CommonDouble_doubleToLongBitsWithDouble_(d1);
  jlong anotherBits = CommonDouble_doubleToLongBitsWithDouble_(d2);
  return (thisBits == anotherBits ? 0 : (thisBits < anotherBits ? -1 : 1));
}

jdouble CommonDouble_sumWithDouble_withDouble_(jdouble a, jdouble b) {
  CommonDouble_initialize();
  return a + b;
}

jdouble CommonDouble_maxWithDouble_withDouble_(jdouble a, jdouble b) {
  CommonDouble_initialize();
  return JavaLangMath_maxWithDouble_withDouble_(a, b);
}

jdouble CommonDouble_minWithDouble_withDouble_(jdouble a, jdouble b) {
  CommonDouble_initialize();
  return JavaLangMath_minWithDouble_withDouble_(a, b);
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonDouble)

J2OBJC_NAME_MAPPING(CommonDouble, "java.lang.Double", "CommonDouble")

// Empty class to force category to be loaded.
@implementation JreDoubleCategoryDummy
@end

// kotlin interop <<
