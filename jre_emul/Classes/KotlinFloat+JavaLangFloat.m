// kotlin interop >>

#import "KotlinFloat+JavaLangFloat.h"

#include "IOSClass.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/Math.h"
#include "java/lang/Short.h"
#include "sun/misc/DoubleConsts.h"
#include "sun/misc/FloatConsts.h"
#include "sun/misc/FloatingDecimal.h"

/*!
 @brief use serialVersionUID from JDK 1.0.2 for interoperability
 */
inline jlong CommonFloat_get_serialVersionUID(void);
#define CommonFloat_serialVersionUID -2671257302660747028LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, serialVersionUID, jlong)

J2OBJC_INITIALIZED_DEFN(CommonFloat)

IOSClass *CommonFloat_TYPE;

@implementation CommonFloat (JavaLangFloat)

+ (jfloat)POSITIVE_INFINITY {
  return CommonFloat_POSITIVE_INFINITY;
}

+ (jfloat)NEGATIVE_INFINITY {
  return CommonFloat_NEGATIVE_INFINITY;
}

+ (jfloat)NaN {
  return CommonFloat_NaN;
}

+ (jfloat)MAX_VALUE {
  return CommonFloat_MAX_VALUE;
}

+ (jfloat)MIN_NORMAL {
  return CommonFloat_MIN_NORMAL;
}

+ (jfloat)MIN_VALUE {
  return CommonFloat_MIN_VALUE;
}

+ (jint)MAX_EXPONENT {
  return CommonFloat_MAX_EXPONENT;
}

+ (jint)MIN_EXPONENT {
  return CommonFloat_MIN_EXPONENT;
}

+ (jint)SIZE {
  return CommonFloat_SIZE;
}

+ (jint)BYTES {
  return CommonFloat_BYTES;
}

+ (IOSClass *)TYPE {
  return CommonFloat_TYPE;
}

+ (NSString *)toStringWithFloat:(jfloat)f {
  return CommonFloat_toStringWithFloat_(f);
}

+ (NSString *)toHexStringWithFloat:(jfloat)f {
  return CommonFloat_toHexStringWithFloat_(f);
}

+ (CommonFloat *)valueOfWithNSString:(NSString *)s {
  return CommonFloat_valueOfWithNSString_(s);
}

+ (CommonFloat *)valueOfWithFloat:(jfloat)f {
  return CommonFloat_valueOfWithFloat_(f);
}

+ (jfloat)parseFloatWithNSString:(NSString *)s {
  return CommonFloat_parseFloatWithNSString_(s);
}

+ (jboolean)isNaNWithFloat:(jfloat)v {
  return CommonFloat_isNaNWithFloat_(v);
}

+ (jboolean)isInfiniteWithFloat:(jfloat)v {
  return CommonFloat_isInfiniteWithFloat_(v);
}

+ (jboolean)isFiniteWithFloat:(jfloat)f {
  return CommonFloat_isFiniteWithFloat_(f);
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonFloat_initWithNSString_(self, s);
  return self;
}

- (jboolean)isNaN {
  return CommonFloat_isNaNWithFloat_(self.floatValue);
}

- (jboolean)isInfinite {
  return CommonFloat_isInfiniteWithFloat_(self.floatValue);
}

- (NSString *)description {
  return CommonFloat_toStringWithFloat_(self.floatValue);
}

- (jbyte)charValue {
  return (jbyte) JreFpToInt(self.floatValue);
}

- (jshort)shortValue {
  return (jshort) JreFpToInt(self.floatValue);
}

- (jint)intValue {
  return JreFpToInt(self.floatValue);
}

- (jlong)longLongValue {
  return JreFpToLong(self.floatValue);
}

//- (jfloat)floatValue {
//  return (jfloat) self.floatValue;
//}

- (jdouble)doubleValue {
  return (jdouble) self.floatValue;
}

- (NSUInteger)hash {
  return CommonFloat_hashCodeWithFloat_(self.floatValue);
}

+ (jint)hashCodeWithFloat:(jfloat)value {
  return CommonFloat_hashCodeWithFloat_(value);
}

- (jboolean)isEqual:(id)obj {
  return ([obj isKindOfClass:[CommonFloat class]]) && (CommonFloat_floatToIntBitsWithFloat_(((CommonFloat *) nil_chk(((CommonFloat *) cast_chk(obj, [CommonFloat class])))).floatValue) == CommonFloat_floatToIntBitsWithFloat_(self.floatValue));
}

+ (jint)floatToIntBitsWithFloat:(jfloat)value {
  return CommonFloat_floatToIntBitsWithFloat_(value);
}

+ (jint)floatToRawIntBitsWithFloat:(jfloat)value {
  return CommonFloat_floatToRawIntBitsWithFloat_(value);
}

+ (jfloat)intBitsToFloatWithInt:(jint)bits {
  return CommonFloat_intBitsToFloatWithInt_(bits);
}

- (jint)compareToOther:(CommonFloat *)anotherFloat {
  cast_chk(anotherFloat, [CommonFloat class]);
  return CommonFloat_compareWithFloat_withFloat_(self.floatValue, ((CommonFloat *) nil_chk(anotherFloat)).floatValue);
}

+ (jint)compareWithFloat:(jfloat)f1
               withFloat:(jfloat)f2 {
  return CommonFloat_compareWithFloat_withFloat_(f1, f2);
}

+ (jfloat)sumWithFloat:(jfloat)a
             withFloat:(jfloat)b {
  return CommonFloat_sumWithFloat_withFloat_(a, b);
}

+ (jfloat)maxWithFloat:(jfloat)a
             withFloat:(jfloat)b {
  return CommonFloat_maxWithFloat_withFloat_(a, b);
}

+ (jfloat)minWithFloat:(jfloat)a
             withFloat:(jfloat)b {
  return CommonFloat_minWithFloat_withFloat_(a, b);
}

//- (const char *)objCType {
//  return "f";
//}

//- (void)getValue:(void *)buffer {
//  *((float *) buffer) = self.floatValue;
//}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x9, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "LCommonFloat;", 0x9, 3, 4, 5, -1, -1, -1 },
    { NULL, "LCommonFloat;", 0x9, 3, 1, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 6, 4, 5, -1, -1, -1 },
    { NULL, "Z", 0x9, 7, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 8, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 9, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 10, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 4, 5, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "B", 0x1, 11, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 12, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 13, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 13, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 14, 15, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 16, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x109, 17, 1, -1, -1, -1, -1 },
    { NULL, "F", 0x109, 18, 19, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 20, 21, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 22, 23, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 24, 23, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 25, 23, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 26, 23, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(toStringWithFloat:);
  methods[1].selector = @selector(toHexStringWithFloat:);
  methods[2].selector = @selector(valueOfWithNSString:);
  methods[3].selector = @selector(valueOfWithFloat:);
  methods[4].selector = @selector(parseFloatWithNSString:);
  methods[5].selector = @selector(isNaNWithFloat:);
  methods[6].selector = @selector(isInfiniteWithFloat:);
  methods[7].selector = @selector(isFiniteWithFloat:);
  methods[8].selector = @selector(initWithFloat:);
  methods[9].selector = @selector(initWithDouble:);
  methods[10].selector = @selector(initWithNSString:);
  methods[11].selector = @selector(isNaN);
  methods[12].selector = @selector(isInfinite);
  methods[13].selector = @selector(description);
  methods[14].selector = @selector(charValue);
  methods[15].selector = @selector(shortValue);
  methods[16].selector = @selector(intValue);
  methods[17].selector = @selector(longLongValue);
  methods[18].selector = @selector(floatValue);
  methods[19].selector = @selector(doubleValue);
  methods[20].selector = @selector(hash);
  methods[21].selector = @selector(hashCodeWithFloat:);
  methods[22].selector = @selector(isEqual:);
  methods[23].selector = @selector(floatToIntBitsWithFloat:);
  methods[24].selector = @selector(floatToRawIntBitsWithFloat:);
  methods[25].selector = @selector(intBitsToFloatWithInt:);
  methods[26].selector = @selector(compareToOther:);
  methods[27].selector = @selector(compareWithFloat:withFloat:);
  methods[28].selector = @selector(sumWithFloat:withFloat:);
  methods[29].selector = @selector(maxWithFloat:withFloat:);
  methods[30].selector = @selector(minWithFloat:withFloat:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "POSITIVE_INFINITY", "F", .constantValue.asFloat = CommonFloat_POSITIVE_INFINITY, 0x19, -1, -1, -1, -1 },
    { "NEGATIVE_INFINITY", "F", .constantValue.asFloat = CommonFloat_NEGATIVE_INFINITY, 0x19, -1, -1, -1, -1 },
    { "NaN", "F", .constantValue.asFloat = CommonFloat_NaN, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "F", .constantValue.asFloat = CommonFloat_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "MIN_NORMAL", "F", .constantValue.asFloat = CommonFloat_MIN_NORMAL, 0x19, -1, -1, -1, -1 },
    { "MIN_VALUE", "F", .constantValue.asFloat = CommonFloat_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_EXPONENT", "I", .constantValue.asInt = CommonFloat_MAX_EXPONENT, 0x19, -1, -1, -1, -1 },
    { "MIN_EXPONENT", "I", .constantValue.asInt = CommonFloat_MIN_EXPONENT, 0x19, -1, -1, -1, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonFloat_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonFloat_BYTES, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 27, 28, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonFloat_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "F", "toHexString", "valueOf", "LNSString;", "LJavaLangNumberFormatException;", "parseFloat", "isNaN", "isInfinite", "isFinite", "D", "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "floatToIntBits", "floatToRawIntBits", "intBitsToFloat", "I", "compareTo", "LCommonFloat;", "compare", "FF", "sum", "max", "min", &CommonFloat_TYPE, "Ljava/lang/Class<Ljava/lang/Float;>;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Float;>;" };
  static const J2ObjcClassInfo _CommonFloat = { "Float", "java.lang", ptrTable, methods, fields, 7, 0x11, 31, 13, -1, -1, -1, 29, -1 };
  return &_CommonFloat;
}

+ (void)initialize {
  if (self == [CommonFloat class]) {
    JreStrongAssign(&CommonFloat_TYPE, [IOSClass_floatArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonFloat)
  }
}

@end

NSString *CommonFloat_toStringWithFloat_(jfloat f) {
  CommonFloat_initialize();
  return SunMiscFloatingDecimal_toJavaFormatStringWithFloat_(f);
}

NSString *CommonFloat_toHexStringWithFloat_(jfloat f) {
  CommonFloat_initialize();
  if (JavaLangMath_absWithFloat_(f) < SunMiscFloatConsts_MIN_NORMAL && f != 0.0f) {
    NSString *s = CommonDouble_toHexStringWithDouble_(JavaLangMath_scalbWithDouble_withInt_((jdouble) f, SunMiscDoubleConsts_MIN_EXPONENT - SunMiscFloatConsts_MIN_EXPONENT));
    return [((NSString *) nil_chk(s)) java_replaceFirst:@"p-1022$" withReplacement:@"p-126"];
  }
  else return CommonDouble_toHexStringWithDouble_(f);
}

CommonFloat *CommonFloat_valueOfWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return create_CommonFloat_initWithFloat_(CommonFloat_parseFloatWithNSString_(s));
}

CommonFloat *CommonFloat_valueOfWithFloat_(jfloat f) {
  CommonFloat_initialize();
  return create_CommonFloat_initWithFloat_(f);
}

jfloat CommonFloat_parseFloatWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return SunMiscFloatingDecimal_parseFloatWithNSString_(s);
}

jboolean CommonFloat_isNaNWithFloat_(jfloat v) {
  CommonFloat_initialize();
  return (v != v);
}

jboolean CommonFloat_isInfiniteWithFloat_(jfloat v) {
  CommonFloat_initialize();
  return (v == CommonFloat_POSITIVE_INFINITY) || (v == CommonFloat_NEGATIVE_INFINITY);
}

jboolean CommonFloat_isFiniteWithFloat_(jfloat f) {
  CommonFloat_initialize();
  return JavaLangMath_absWithFloat_(f) <= SunMiscFloatConsts_MAX_VALUE;
}

void CommonFloat_initWithFloat_(CommonFloat *self, jfloat value) {
  [self initWithFloat:value];
}

CommonFloat *new_CommonFloat_initWithFloat_(jfloat value) {
  J2OBJC_NEW_IMPL(CommonFloat, initWithFloat_, value)
}

CommonFloat *create_CommonFloat_initWithFloat_(jfloat value) {
  J2OBJC_CREATE_IMPL(CommonFloat, initWithFloat_, value)
}

void CommonFloat_initWithDouble_(CommonFloat *self, jdouble value) {
  [self initWithFloat:(jfloat)value];
}

CommonFloat *new_CommonFloat_initWithDouble_(jdouble value) {
  J2OBJC_NEW_IMPL(CommonFloat, initWithDouble_, value)
}

CommonFloat *create_CommonFloat_initWithDouble_(jdouble value) {
  J2OBJC_CREATE_IMPL(CommonFloat, initWithDouble_, value)
}

void CommonFloat_initWithNSString_(CommonFloat *self, NSString *s) {
  [self initWithFloat:CommonFloat_parseFloatWithNSString_(s)];
}

CommonFloat *new_CommonFloat_initWithNSString_(NSString *s) {
  J2OBJC_NEW_IMPL(CommonFloat, initWithNSString_, s)
}

CommonFloat *create_CommonFloat_initWithNSString_(NSString *s) {
  J2OBJC_CREATE_IMPL(CommonFloat, initWithNSString_, s)
}

jint CommonFloat_hashCodeWithFloat_(jfloat value) {
  CommonFloat_initialize();
  return CommonFloat_floatToIntBitsWithFloat_(value);
}

jint CommonFloat_floatToIntBitsWithFloat_(jfloat value) {
  CommonFloat_initialize();
  jint result = CommonFloat_floatToRawIntBitsWithFloat_(value);
  if (((result & SunMiscFloatConsts_EXP_BIT_MASK) == SunMiscFloatConsts_EXP_BIT_MASK) && (result & SunMiscFloatConsts_SIGNIF_BIT_MASK) != 0) result = (jint) 0x7fc00000;
  return result;
}

jint CommonFloat_floatToRawIntBitsWithFloat_(jfloat value) {
  CommonFloat_initialize();
  return *(int *) &value;
}

jfloat CommonFloat_intBitsToFloatWithInt_(jint bits) {
  CommonFloat_initialize();
  return *(float *) &bits;
}

jint CommonFloat_compareWithFloat_withFloat_(jfloat f1, jfloat f2) {
  CommonFloat_initialize();
  if (f1 < f2) return -1;
  if (f1 > f2) return 1;
  jint thisBits = CommonFloat_floatToIntBitsWithFloat_(f1);
  jint anotherBits = CommonFloat_floatToIntBitsWithFloat_(f2);
  return (thisBits == anotherBits ? 0 : (thisBits < anotherBits ? -1 : 1));
}

jfloat CommonFloat_sumWithFloat_withFloat_(jfloat a, jfloat b) {
  CommonFloat_initialize();
  return a + b;
}

jfloat CommonFloat_maxWithFloat_withFloat_(jfloat a, jfloat b) {
  CommonFloat_initialize();
  return JavaLangMath_maxWithFloat_withFloat_(a, b);
}

jfloat CommonFloat_minWithFloat_withFloat_(jfloat a, jfloat b) {
  CommonFloat_initialize();
  return JavaLangMath_minWithFloat_withFloat_(a, b);
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonFloat)

J2OBJC_NAME_MAPPING(CommonFloat, "java.lang.Float", "CommonFloat")

// Empty class to force category to be loaded.
@implementation JreKotlinFloatCategoryDummy
@end

// kotlin interop <<
