// kotlin interop >>

#import "KotlinFloat+JavaLangFloat.h"

#define J2OBJC_IMPORTED_BY_JAVA_IMPLEMENTATION 1

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/Byte.h"
#include "java/lang/Deprecated.h"
#include "java/lang/Double.h"
#include "java/lang/Float.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/Math.h"
#include "java/lang/Short.h"
#include "java/lang/annotation/Annotation.h"
#include "sun/misc/FloatingDecimal.h"

#if __has_feature(objc_arc)
#error "java/lang/Float must not be compiled with ARC (-fobjc-arc)"
#endif

#pragma clang diagnostic error "-Wreturn-type"
#pragma clang diagnostic ignored "-Wswitch"

/*!
 @brief Returns an <code>Optional</code> containing the nominal descriptor for this
  instance, which is the instance itself.
 @return an <code>Optional</code> describing the Float instance
 @since 12
 @param lookup ignored
 @return the Float instance
 @since 12
 */
inline jlong CommonFloat_get_serialVersionUID(void);
#define CommonFloat_serialVersionUID -2671257302660747028LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, serialVersionUID, jlong)

__attribute__((unused)) static IOSObjectArray *CommonFloat__Annotations$0(void);

__attribute__((unused)) static IOSObjectArray *CommonFloat__Annotations$1(void);

__attribute__((unused)) static IOSObjectArray *CommonFloat__Annotations$2(void);

J2OBJC_INITIALIZED_DEFN(CommonFloat)

extern float CommonFloat_get_POSITIVE_INFINITY(void);

extern float CommonFloat_get_NEGATIVE_INFINITY(void);

extern float CommonFloat_get_NaN(void);

extern float CommonFloat_get_MAX_VALUE(void);

extern float CommonFloat_get_MIN_NORMAL(void);

extern float CommonFloat_get_MIN_VALUE(void);

extern jint CommonFloat_get_MAX_EXPONENT(void);

extern jint CommonFloat_get_MIN_EXPONENT(void);

extern jint CommonFloat_get_SIZE(void);

extern jint CommonFloat_get_BYTES(void);

extern IOSClass *CommonFloat_get_TYPE(void);

extern jlong CommonFloat_get_serialVersionUID(void);

IOSClass *CommonFloat_TYPE;

@implementation CommonFloat (JavaLangFloat)

+ (NSString *)toStringWithFloat:(float)f {
  return CommonFloat_toStringWithFloat_(f);
}

+ (NSString *)toHexStringWithFloat:(float)f {
  return CommonFloat_toHexStringWithFloat_(f);
}

+ (CommonFloat *)valueOfWithNSString:(NSString *)s {
  return CommonFloat_valueOfWithNSString_(s);
}

+ (CommonFloat *)valueOfWithFloat:(float)f {
  return CommonFloat_valueOfWithFloat_(f);
}

+ (float)parseFloatWithNSString:(NSString *)s {
  return CommonFloat_parseFloatWithNSString_(s);
}

+ (jboolean)isNaNWithFloat:(float)v {
  return CommonFloat_isNaNWithFloat_(v);
}

+ (jboolean)isInfiniteWithFloat:(float)v {
  return CommonFloat_isInfiniteWithFloat_(v);
}

+ (jboolean)isFiniteWithFloat:(float)f {
  return CommonFloat_isFiniteWithFloat_(f);
}

// kotlin interop >>
// `initWithFloat:` is provided by Common*; the override that used to populate a
// removed `value_` ivar has been deleted to avoid infinite recursion.
// kotlin interop <<

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)initWithDouble:(double)value {
  return [self initWithFloat:(float)value];
}
J2OBJC_IGNORE_DESIGNATED_END

- (instancetype)initWithNSString:(NSString *)s {
  return [self initWithFloat:CommonFloat_parseFloatWithNSString_(s)];
}

- (jboolean)isNaN {
  return CommonFloat_isNaNWithFloat_([self floatValue]);
}

- (jboolean)isInfinite {
  return CommonFloat_isInfiniteWithFloat_([self floatValue]);
}

- (NSString *)description {
  return CommonFloat_toStringWithFloat_([self floatValue]);
}

- (jbyte)charValue {
  return JreFpToByte([self floatValue]);
}

- (jshort)shortValue {
  return JreFpToShort([self floatValue]);
}

- (jint)intValue {
  return JreFpToInt([self floatValue]);
}

- (jlong)longLongValue {
  return JreFpToLong([self floatValue]);
}

// kotlin interop >>
// `floatValue` is inherited from NSNumber; the previous category override used a `value_`
// ivar that no longer exists, so the override has been removed.
// kotlin interop <<

- (double)doubleValue {
  return (double) [self floatValue];
}

- (NSUInteger)hash {
  return CommonFloat_hashCodeWithFloat_([self floatValue]);
}

+ (jint)hashCodeWithFloat:(float)value {
  return CommonFloat_hashCodeWithFloat_(value);
}

- (jboolean)isEqual:(id)obj {
  return ([obj isKindOfClass:[CommonFloat class]])
      && (CommonFloat_floatToIntBitsWithFloat_(
              [((CommonFloat *) nil_chk(((CommonFloat *) cast_chk(obj, [CommonFloat class])))) floatValue])
          == CommonFloat_floatToIntBitsWithFloat_([self floatValue]));
}

+ (jint)floatToIntBitsWithFloat:(float)value {
  return CommonFloat_floatToIntBitsWithFloat_(value);
}

+ (jint)floatToRawIntBitsWithFloat:(float)value {
  return CommonFloat_floatToRawIntBitsWithFloat_(value);
}

+ (float)intBitsToFloatWithInt:(jint)bits {
  return CommonFloat_intBitsToFloatWithInt_(bits);
}

- (jint)compareToWithId:(CommonFloat *)anotherFloat {
  cast_chk(anotherFloat, [CommonFloat class]);
  return CommonFloat_compareWithFloat_withFloat_([self floatValue], [((CommonFloat *) nil_chk(anotherFloat)) floatValue]);
}

+ (jint)compareWithFloat:(float)f1
                  withFloat:(float)f2 {
  return CommonFloat_compareWithFloat_withFloat_(f1, f2);
}

+ (float)sumWithFloat:(float)a
            withFloat:(float)b {
  return CommonFloat_sumWithFloat_withFloat_(a, b);
}

+ (float)maxWithFloat:(float)a
            withFloat:(float)b {
  return CommonFloat_maxWithFloat_withFloat_(a, b);
}

+ (float)minWithFloat:(float)a
            withFloat:(float)b {
  return CommonFloat_minWithFloat_withFloat_(a, b);
}

- (const char *)objCType {
  return "f";
}

- (void)getValue:(void *)buffer {
  *((float *) buffer) = [self floatValue];
}

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
    { NULL, NULL, 0x1, -1, 1, -1, -1, 10, -1 },
    { NULL, NULL, 0x1, -1, 11, -1, -1, 12, -1 },
    { NULL, NULL, 0x1, -1, 4, 5, -1, 13, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "B", 0x1, 14, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 15, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 16, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 16, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 17, 18, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 19, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x109, 20, 1, -1, -1, -1, -1 },
    { NULL, "F", 0x109, 21, 22, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 23, 24, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 25, 26, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 27, 26, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 28, 26, -1, -1, -1, -1 },
    { NULL, "F", 0x9, 29, 26, -1, -1, -1, -1 },
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
  methods[26].selector = @selector(compareToWithId:);
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
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 30, 31, -1 },
    { "[self floatValue]", "F", .constantValue.asLong = 0, 0x12, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonFloat_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "F", "toHexString", "valueOf", "LNSString;", "LJavaLangNumberFormatException;", "parseFloat", "isNaN", "isInfinite", "isFinite", (void *)&CommonFloat__Annotations$0, "D", (void *)&CommonFloat__Annotations$1, (void *)&CommonFloat__Annotations$2, "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "floatToIntBits", "floatToRawIntBits", "intBitsToFloat", "I", "compareTo", "LCommonFloat;", "compare", "FF", "sum", "max", "min", &CommonFloat_TYPE, "Ljava/lang/Class<Ljava/lang/Float;>;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Float;>;" };
  static const J2ObjcClassInfo _CommonFloat = { "Float", "java.lang", ptrTable, methods, fields, 7, 0x11, 31, 13, -1, -1, -1, 32, -1 };
  return &_CommonFloat;
}

+ (void)initialize {
  if (self == [CommonFloat class]) {
    JreStrongAssign(&CommonFloat_TYPE, [IOSClass_floatArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonFloat)
  }
}

@end

NSString *CommonFloat_toStringWithFloat_(float f) {
  CommonFloat_initialize();
  return SunMiscFloatingDecimal_toJavaFormatStringWithFloat_(f);
}

NSString *CommonFloat_toHexStringWithFloat_(float f) {
  CommonFloat_initialize();
  if (JavaLangMath_absWithFloat_(f) < CommonFloat_MIN_NORMAL && f != 0.0f) {
    NSString *s = CommonDouble_toHexStringWithDouble_(JavaLangMath_scalbWithDouble_withInt_((double) f, CommonDouble_MIN_EXPONENT - CommonFloat_MIN_EXPONENT));
    return [((NSString *) nil_chk(s)) java_replaceFirst:@"p-1022$" withReplacement:@"p-126"];
  }
  else return CommonDouble_toHexStringWithDouble_(f);
}

CommonFloat *CommonFloat_valueOfWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return create_CommonFloat_initWithFloat_(CommonFloat_parseFloatWithNSString_(s));
}

CommonFloat *CommonFloat_valueOfWithFloat_(float f) {
  CommonFloat_initialize();
  return create_CommonFloat_initWithFloat_(f);
}

float CommonFloat_parseFloatWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return SunMiscFloatingDecimal_parseFloatWithNSString_(s);
}

jboolean CommonFloat_isNaNWithFloat_(float v) {
  CommonFloat_initialize();
  return (v != v);
}

jboolean CommonFloat_isInfiniteWithFloat_(float v) {
  CommonFloat_initialize();
  return (v == CommonFloat_POSITIVE_INFINITY) || (v == CommonFloat_NEGATIVE_INFINITY);
}

jboolean CommonFloat_isFiniteWithFloat_(float f) {
  CommonFloat_initialize();
  return JavaLangMath_absWithFloat_(f) <= CommonFloat_MAX_VALUE;
}

CommonFloat *new_CommonFloat_initWithFloat_(float value) {
  CommonFloat_initialize();
  return [[CommonFloat alloc] initWithFloat:value];
}

CommonFloat *create_CommonFloat_initWithFloat_(float value) {
  CommonFloat_initialize();
  return [CommonFloat numberWithFloat:value];
}

CommonFloat *new_CommonFloat_initWithDouble_(double value) {
  CommonFloat_initialize();
  return [[CommonFloat alloc] initWithFloat:value];
}

CommonFloat *create_CommonFloat_initWithDouble_(double value) {
  CommonFloat_initialize();
  return [CommonFloat numberWithFloat:value];
}

CommonFloat *new_CommonFloat_initWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return [[CommonFloat alloc] initWithFloat:CommonFloat_parseFloatWithNSString_(s)];
}

CommonFloat *create_CommonFloat_initWithNSString_(NSString *s) {
  CommonFloat_initialize();
  return [CommonFloat numberWithFloat:CommonFloat_parseFloatWithNSString_(s)];
}

jint CommonFloat_hashCodeWithFloat_(float value) {
  CommonFloat_initialize();
  return CommonFloat_floatToIntBitsWithFloat_(value);
}

jint CommonFloat_floatToIntBitsWithFloat_(float value) {
  CommonFloat_initialize();
  if (!CommonFloat_isNaNWithFloat_(value)) {
    return CommonFloat_floatToRawIntBitsWithFloat_(value);
  }
  return (jint) 0x7fc00000;
}

jint CommonFloat_floatToRawIntBitsWithFloat_(float value) {
  CommonFloat_initialize();
  return *(int *) &value;
}

float CommonFloat_intBitsToFloatWithInt_(jint bits) {
  CommonFloat_initialize();
  return *(float *) &bits;
}

jint CommonFloat_compareWithFloat_withFloat_(float f1, float f2) {
  CommonFloat_initialize();
  if (f1 < f2) return -1;
  if (f1 > f2) return 1;
  jint thisBits = CommonFloat_floatToIntBitsWithFloat_(f1);
  jint anotherBits = CommonFloat_floatToIntBitsWithFloat_(f2);
  return (thisBits == anotherBits ? 0 : (thisBits < anotherBits ? -1 : 1));
}

float CommonFloat_sumWithFloat_withFloat_(float a, float b) {
  CommonFloat_initialize();
  return a + b;
}

float CommonFloat_maxWithFloat_withFloat_(float a, float b) {
  CommonFloat_initialize();
  return JavaLangMath_maxWithFloat_withFloat_(a, b);
}

float CommonFloat_minWithFloat_withFloat_(float a, float b) {
  CommonFloat_initialize();
  return JavaLangMath_minWithFloat_withFloat_(a, b);
}

IOSObjectArray *CommonFloat__Annotations$0() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

IOSObjectArray *CommonFloat__Annotations$1() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

IOSObjectArray *CommonFloat__Annotations$2() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonFloat)

// kotlin interop <<
