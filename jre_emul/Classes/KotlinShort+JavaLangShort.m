// kotlin interop >>

#import "KotlinShort+JavaLangShort.h"

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
#include "java/lang/NumberFormatException.h"
#include "java/lang/Short.h"
#include "java/lang/annotation/Annotation.h"



#if __has_feature(objc_arc)
#error "java/lang/Short must not be compiled with ARC (-fobjc-arc)"
#endif

#pragma clang diagnostic error "-Wreturn-type"
#pragma clang diagnostic ignored "-Wswitch"


@interface CommonShort () {
 @public
  /*!
   @brief The value of the <code>Short</code>.
   */
  jshort value_;
}

@end

/*!
 @brief use serialVersionUID from JDK 1.1.for interoperability
 */
inline jlong CommonShort_get_serialVersionUID(void);
#define CommonShort_serialVersionUID 7515723908773894738LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonShort, serialVersionUID, jlong)

__attribute__((unused)) static IOSObjectArray *CommonShort__Annotations$0(void);

__attribute__((unused)) static IOSObjectArray *CommonShort__Annotations$1(void);

/*!
 @brief Returns an <code>Optional</code> containing the nominal descriptor for this
  instance.
 @return an <code>Optional</code> describing the Short instance
 @since 15
 */
@interface CommonShort_ShortCache : NSObject

- (instancetype)init;

@end

J2OBJC_STATIC_INIT(CommonShort_ShortCache)

inline IOSObjectArray *CommonShort_ShortCache_get_cache(void);
static IOSObjectArray *CommonShort_ShortCache_cache;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonShort_ShortCache, cache, IOSObjectArray *)

inline IOSObjectArray *CommonShort_ShortCache_get_archivedCache(void);
inline IOSObjectArray *CommonShort_ShortCache_set_archivedCache(IOSObjectArray *value);
static IOSObjectArray *CommonShort_ShortCache_archivedCache;
J2OBJC_STATIC_FIELD_OBJ(CommonShort_ShortCache, archivedCache, IOSObjectArray *)

__attribute__((unused)) static void CommonShort_ShortCache_init(CommonShort_ShortCache *self);

__attribute__((unused)) static CommonShort_ShortCache *new_CommonShort_ShortCache_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static CommonShort_ShortCache *create_CommonShort_ShortCache_init(void);

J2OBJC_TYPE_LITERAL_HEADER(CommonShort_ShortCache)


J2OBJC_INITIALIZED_DEFN(CommonShort)

extern jshort CommonShort_get_MIN_VALUE(void);

extern jshort CommonShort_get_MAX_VALUE(void);

extern IOSClass *CommonShort_get_TYPE(void);

extern jint CommonShort_get_SIZE(void);

extern jint CommonShort_get_BYTES(void);

extern jlong CommonShort_get_serialVersionUID(void);

IOSClass *CommonShort_TYPE;

@implementation CommonShort (JavaLangShort)

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

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)initWithShort:(jshort)value {
  CommonShort_initWithShort_(self, value);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (instancetype)initWithNSString:(NSString *)s {
  CommonShort_initWithNSString_(self, s);
  return self;
}

- (jbyte)charValue {
  return (jbyte) value_;
}

- (jshort)shortValue {
  return value_;
}

- (jint)intValue {
  return (jint) value_;
}

- (jlong)longLongValue {
  return (jlong) value_;
}

- (float)floatValue {
  return (float) value_;
}

- (double)doubleValue {
  return (double) value_;
}

- (NSString *)description {
  return CommonInt_toStringWithInt_((jint) value_);
}

- (NSUInteger)hash {
  return CommonShort_hashCodeWithShort_(value_);
}

+ (jint)hashCodeWithShort:(jshort)value {
  return CommonShort_hashCodeWithShort_(value);
}

- (jboolean)isEqual:(id)obj {
  if ([obj isKindOfClass:[CommonShort class]]) {
    return value_ == [((CommonShort *) obj) shortValue];
  }
  return false;
}

- (jint)compareToWithId:(CommonShort *)anotherShort {
  cast_chk(anotherShort, [CommonShort class]);
  return CommonShort_compareWithShort_withShort_(self->value_, ((CommonShort *) nil_chk(anotherShort))->value_);
}

+ (jint)compareWithShort:(jshort)x
                  withShort:(jshort)y {
  return CommonShort_compareWithShort_withShort_(x, y);
}

+ (jint)compareUnsignedWithShort:(jshort)x
                          withShort:(jshort)y {
  return CommonShort_compareUnsignedWithShort_withShort_(x, y);
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

- (const char *)objCType {
  return "s";
}

- (void)getValue:(void *)buffer {
  *((short int *) buffer) = value_;
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x9, 0, 1, -1, -1, -1, -1 },
    { NULL, "S", 0x9, 2, 3, 4, -1, -1, -1 },
    { NULL, "S", 0x9, 2, 5, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 3, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 5, 4, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 6, 1, -1, -1, -1, -1 },
    { NULL, "LCommonShort;", 0x9, 7, 5, 4, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, 8, -1 },
    { NULL, NULL, 0x1, -1, 5, 4, -1, 9, -1 },
    { NULL, "B", 0x1, 10, -1, -1, -1, -1, -1 },
    { NULL, "S", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "J", 0x1, 11, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "D", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 0, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 12, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 12, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 13, 14, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 15, 16, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 17, 18, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 19, 18, -1, -1, -1, -1 },
    { NULL, "S", 0x9, 20, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 21, 1, -1, -1, -1, -1 },
    { NULL, "J", 0x9, 22, 1, -1, -1, -1, -1 },
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
  methods[19].selector = @selector(compareToWithId:);
  methods[20].selector = @selector(compareWithShort:withShort:);
  methods[21].selector = @selector(compareUnsignedWithShort:withShort:);
  methods[22].selector = @selector(reverseBytesWithShort:);
  methods[23].selector = @selector(toUnsignedIntWithShort:);
  methods[24].selector = @selector(toUnsignedLongWithShort:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "MIN_VALUE", "S", .constantValue.asShort = CommonShort_MIN_VALUE, 0x19, -1, -1, -1, -1 },
    { "MAX_VALUE", "S", .constantValue.asShort = CommonShort_MAX_VALUE, 0x19, -1, -1, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 23, 24, -1 },
    { "value_", "S", .constantValue.asLong = 0, 0x12, -1, -1, -1, -1 },
    { "SIZE", "I", .constantValue.asInt = CommonShort_SIZE, 0x19, -1, -1, -1, -1 },
    { "BYTES", "I", .constantValue.asInt = CommonShort_BYTES, 0x19, -1, -1, -1, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonShort_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "toString", "S", "parseShort", "LNSString;I", "LJavaLangNumberFormatException;", "LNSString;", "valueOf", "decode", (void *)&CommonShort__Annotations$0, (void *)&CommonShort__Annotations$1, "byteValue", "longValue", "hashCode", "equals", "LNSObject;", "compareTo", "LCommonShort;", "compare", "SS", "compareUnsigned", "reverseBytes", "toUnsignedInt", "toUnsignedLong", &CommonShort_TYPE, "Ljava/lang/Class<Ljava/lang/Short;>;", "LCommonShort_ShortCache;", "Ljava/lang/Number;Ljava/lang/Comparable<Ljava/lang/Short;>;" };
  static const J2ObjcClassInfo _CommonShort = { "Short", "java.lang", ptrTable, methods, fields, 7, 0x11, 25, 7, -1, 25, -1, 26, -1 };
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
  NSNumber_init(self);
  self->value_ = value;
}

CommonShort *new_CommonShort_initWithShort_(jshort value) {
  J2OBJC_NEW_IMPL(CommonShort, initWithShort_, value)
}

CommonShort *create_CommonShort_initWithShort_(jshort value) {
  J2OBJC_CREATE_IMPL(CommonShort, initWithShort_, value)
}

void CommonShort_initWithNSString_(CommonShort *self, NSString *s) {
  NSNumber_init(self);
  self->value_ = CommonShort_parseShortWithNSString_withInt_(s, 10);
}

CommonShort *new_CommonShort_initWithNSString_(NSString *s) {
  J2OBJC_NEW_IMPL(CommonShort, initWithNSString_, s)
}

CommonShort *create_CommonShort_initWithNSString_(NSString *s) {
  J2OBJC_CREATE_IMPL(CommonShort, initWithNSString_, s)
}

jint CommonShort_hashCodeWithShort_(jshort value) {
  CommonShort_initialize();
  return (jint) value;
}

jint CommonShort_compareWithShort_withShort_(jshort x, jshort y) {
  CommonShort_initialize();
  return x - y;
}

jint CommonShort_compareUnsignedWithShort_withShort_(jshort x, jshort y) {
  CommonShort_initialize();
  return CommonShort_toUnsignedIntWithShort_(x) - CommonShort_toUnsignedIntWithShort_(y);
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

IOSObjectArray *CommonShort__Annotations$0() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

IOSObjectArray *CommonShort__Annotations$1() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated(false, @"") } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonShort)

J2OBJC_INITIALIZED_DEFN(CommonShort_ShortCache)

extern IOSObjectArray *CommonShort_ShortCache_get_cache(void);

extern IOSObjectArray *CommonShort_ShortCache_get_archivedCache(void);
extern IOSObjectArray *CommonShort_ShortCache_set_archivedCache(IOSObjectArray *value);

@implementation CommonShort_ShortCache

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  CommonShort_ShortCache_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x2, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "cache", "[LCommonShort;", .constantValue.asLong = 0, 0x18, -1, 0, -1, -1 },
    { "archivedCache", "[LCommonShort;", .constantValue.asLong = 0, 0x8, -1, 1, -1, -1 },
  };
  static const void *ptrTable[] = { &CommonShort_ShortCache_cache, &CommonShort_ShortCache_archivedCache, "LCommonShort;" };
  static const J2ObjcClassInfo _CommonShort_ShortCache = { "ShortCache", "java.lang", ptrTable, methods, fields, 7, 0xa, 1, 2, 2, -1, -1, -1, -1 };
  return &_CommonShort_ShortCache;
}

+ (void)initialize {
  if (self == [CommonShort_ShortCache class]) {
    {
      jint size = -(-128) + 127 + 1;
      if (CommonShort_ShortCache_archivedCache == nil || CommonShort_ShortCache_archivedCache->size_ != size) {
        IOSObjectArray *c = [IOSObjectArray arrayWithLength:size type:CommonShort_class_()];
        jshort value = -128;
        for (jint i = 0; i < size; i++) {
          IOSObjectArray_SetAndConsume(c, i, new_CommonShort_initWithShort_(value++));
        }
        JreStrongAssign(&CommonShort_ShortCache_archivedCache, c);
      }
      JreStrongAssign(&CommonShort_ShortCache_cache, CommonShort_ShortCache_archivedCache);
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

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonShort_ShortCache)

// kotlin interop <<
