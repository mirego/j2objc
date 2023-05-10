// kotlin interop >>

#import "KotlinBoolean+JavaLangBoolean.h"

#include "IOSClass.h"
#include "J2ObjC_source.h"
#include "java/lang/Boolean.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/Integer.h"
#include "java/lang/Long.h"
#include "java/lang/NullPointerException.h"
#include "java/lang/RuntimeException.h"
#include "java/lang/System.h"

#include "java/lang/Exception.h"

/*!
 @brief use serialVersionUID from JDK 1.0.2 for interoperability
 */
inline jlong CommonBoolean_get_serialVersionUID(void);
#define CommonBoolean_serialVersionUID -3665804199014368530LL
J2OBJC_STATIC_FIELD_CONSTANT(CommonBoolean, serialVersionUID, jlong)

J2OBJC_INITIALIZED_DEFN(CommonBoolean)

CommonBoolean *CommonBoolean_TRUE;
CommonBoolean *CommonBoolean_FALSE;
IOSClass *CommonBoolean_TYPE;

@implementation CommonBoolean (JavaLangBoolean)

+ (CommonBoolean *)TRUE_ {
  return CommonBoolean_TRUE;
}

+ (CommonBoolean *)FALSE_ {
  return CommonBoolean_FALSE;
}

+ (IOSClass *)TYPE {
  return CommonBoolean_TYPE;
}

- (instancetype)initWithBoolean:(jboolean)value {
  CommonBoolean_initWithBoolean_(self, value);
  return self;
}

- (instancetype)initWithNSString:(NSString *)s {
  CommonBoolean_initWithNSString_(self, s);
  return self;
}

+ (jboolean)parseBooleanWithNSString:(NSString *)s {
  return CommonBoolean_parseBooleanWithNSString_(s);
}

- (jboolean)booleanValue {
  return self.boolValue;
}

+ (CommonBoolean *)valueOfWithBoolean:(jboolean)b {
  return CommonBoolean_valueOfWithBoolean_(b);
}

+ (CommonBoolean *)valueOfWithNSString:(NSString *)s {
  return CommonBoolean_valueOfWithNSString_(s);
}

+ (NSString *)toStringWithBoolean:(jboolean)b {
  return CommonBoolean_toStringWithBoolean_(b);
}

- (NSString *)description {
  return self.boolValue ? @"true" : @"false";
}

- (NSUInteger)hash {
  return CommonBoolean_hashCodeWithBoolean_(self.boolValue);
}

+ (jint)hashCodeWithBoolean:(jboolean)value {
  return CommonBoolean_hashCodeWithBoolean_(value);
}

- (jboolean)isEqual:(id)obj {
  if ([obj isKindOfClass:[CommonBoolean class]]) {
    return self.boolValue == [((CommonBoolean *) nil_chk(((CommonBoolean *) obj))) booleanValue];
  }
  return false;
}

+ (jboolean)getBooleanWithNSString:(NSString *)name {
  return CommonBoolean_getBooleanWithNSString_(name);
}

- (jint)compareToWithId:(CommonBoolean *)b {
  cast_chk(b, [CommonBoolean class]);
  return CommonBoolean_compareWithBoolean_withBoolean_(self.boolValue, ((CommonBoolean *) nil_chk(b)).boolValue);
}

+ (jint)compareWithBoolean:(jboolean)x
               withBoolean:(jboolean)y {
  return CommonBoolean_compareWithBoolean_withBoolean_(x, y);
}

+ (jboolean)logicalAndWithBoolean:(jboolean)a
                      withBoolean:(jboolean)b {
  return CommonBoolean_logicalAndWithBoolean_withBoolean_(a, b);
}

+ (jboolean)logicalOrWithBoolean:(jboolean)a
                     withBoolean:(jboolean)b {
  return CommonBoolean_logicalOrWithBoolean_withBoolean_(a, b);
}

+ (jboolean)logicalXorWithBoolean:(jboolean)a
                      withBoolean:(jboolean)b {
  return CommonBoolean_logicalXorWithBoolean_withBoolean_(a, b);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 2, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LCommonBoolean;", 0x9, 3, 0, -1, -1, -1, -1 },
    { NULL, "LCommonBoolean;", 0x9, 3, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x9, 4, 0, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 4, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 5, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 5, 0, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 6, 7, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 8, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 9, 10, -1, -1, -1, -1 },
    { NULL, "I", 0x9, 11, 12, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 13, 12, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 14, 12, -1, -1, -1, -1 },
    { NULL, "Z", 0x9, 15, 12, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initWithBoolean:);
  methods[1].selector = @selector(initWithNSString:);
  methods[2].selector = @selector(parseBooleanWithNSString:);
  methods[3].selector = @selector(booleanValue);
  methods[4].selector = @selector(valueOfWithBoolean:);
  methods[5].selector = @selector(valueOfWithNSString:);
  methods[6].selector = @selector(toStringWithBoolean:);
  methods[7].selector = @selector(description);
  methods[8].selector = @selector(hash);
  methods[9].selector = @selector(hashCodeWithBoolean:);
  methods[10].selector = @selector(isEqual:);
  methods[11].selector = @selector(getBooleanWithNSString:);
  methods[12].selector = @selector(compareToWithId:);
  methods[13].selector = @selector(compareWithBoolean:withBoolean:);
  methods[14].selector = @selector(logicalAndWithBoolean:withBoolean:);
  methods[15].selector = @selector(logicalOrWithBoolean:withBoolean:);
  methods[16].selector = @selector(logicalXorWithBoolean:withBoolean:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "TRUE", "LCommonBoolean;", .constantValue.asLong = 0, 0x19, -1, 16, -1, -1 },
    { "FALSE", "LCommonBoolean;", .constantValue.asLong = 0, 0x19, -1, 17, -1, -1 },
    { "TYPE", "LIOSClass;", .constantValue.asLong = 0, 0x19, -1, 18, 19, -1 },
    { "serialVersionUID", "J", .constantValue.asLong = CommonBoolean_serialVersionUID, 0x1a, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "Z", "LNSString;", "parseBoolean", "valueOf", "toString", "hashCode", "equals", "LNSObject;", "getBoolean", "compareTo", "LCommonBoolean;", "compare", "ZZ", "logicalAnd", "logicalOr", "logicalXor", &CommonBoolean_TRUE, &CommonBoolean_FALSE, &CommonBoolean_TYPE, "Ljava/lang/Class<Ljava/lang/Boolean;>;", "Ljava/lang/Object;Ljava/io/Serializable;Ljava/lang/Comparable<Ljava/lang/Boolean;>;" };
  static const J2ObjcClassInfo _CommonBoolean = { "Boolean", "java.lang", ptrTable, methods, fields, 7, 0x11, 17, 5, -1, -1, -1, 20, -1 };
  return &_CommonBoolean;
}

+ (void)initialize {
  if (self == [CommonBoolean class]) {
    JreStrongAssignAndConsume(&CommonBoolean_TRUE, new_CommonBoolean_initWithBoolean_(true));
    JreStrongAssignAndConsume(&CommonBoolean_FALSE, new_CommonBoolean_initWithBoolean_(false));
    JreStrongAssign(&CommonBoolean_TYPE, [IOSClass_booleanArray(1) getComponentType]);
    J2OBJC_SET_INITIALIZED(CommonBoolean)
  }
}

@end

void CommonBoolean_initWithBoolean_(CommonBoolean *self, jboolean value) {
  [self initWithBool:value];
}

CommonBoolean *new_CommonBoolean_initWithBoolean_(jboolean value) {
  return [CommonBoolean numberWithBool:value];
}

CommonBoolean *create_CommonBoolean_initWithBoolean_(jboolean value) {
  return [CommonBoolean numberWithBool:value];
}

void CommonBoolean_initWithNSString_(CommonBoolean *self, NSString *s) {
  [self initWithBool:CommonBoolean_parseBooleanWithNSString_(s)];
}

CommonBoolean *new_CommonBoolean_initWithNSString_(NSString *s) {
  return [CommonBoolean numberWithBool:CommonBoolean_parseBooleanWithNSString_(s)];
}

CommonBoolean *create_CommonBoolean_initWithNSString_(NSString *s) {
  return [CommonBoolean numberWithBool:CommonBoolean_parseBooleanWithNSString_(s)];
}

jboolean CommonBoolean_parseBooleanWithNSString_(NSString *s) {
  CommonBoolean_initialize();
  return ((s != nil) && [((NSString *) nil_chk(s)) java_equalsIgnoreCase:@"true"]);
}

CommonBoolean *CommonBoolean_valueOfWithBoolean_(jboolean b) {
  CommonBoolean_initialize();
  return (b ? CommonBoolean_TRUE : CommonBoolean_FALSE);
}

CommonBoolean *CommonBoolean_valueOfWithNSString_(NSString *s) {
  CommonBoolean_initialize();
  return CommonBoolean_parseBooleanWithNSString_(s) ? CommonBoolean_TRUE : CommonBoolean_FALSE;
}

NSString *CommonBoolean_toStringWithBoolean_(jboolean b) {
  CommonBoolean_initialize();
  return b ? @"true" : @"false";
}

jint CommonBoolean_hashCodeWithBoolean_(jboolean value) {
  CommonBoolean_initialize();
  return value ? 1231 : 1237;
}

jboolean CommonBoolean_getBooleanWithNSString_(NSString *name) {
  CommonBoolean_initialize();
  jboolean result = false;
  @try {
    result = CommonBoolean_parseBooleanWithNSString_(JavaLangSystem_getPropertyWithNSString_(name));
  }
  @catch (JavaLangIllegalArgumentException *e) {
  }
  @catch (JavaLangNullPointerException *e) {
  }
  return result;
}

jint CommonBoolean_compareWithBoolean_withBoolean_(jboolean x, jboolean y) {
  CommonBoolean_initialize();
  return (x == y) ? 0 : (x ? 1 : -1);
}

jboolean CommonBoolean_logicalAndWithBoolean_withBoolean_(jboolean a, jboolean b) {
  CommonBoolean_initialize();
  return a && b;
}

jboolean CommonBoolean_logicalOrWithBoolean_withBoolean_(jboolean a, jboolean b) {
  CommonBoolean_initialize();
  return a || b;
}

jboolean CommonBoolean_logicalXorWithBoolean_withBoolean_(jboolean a, jboolean b) {
  CommonBoolean_initialize();
  return a ^ b;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CommonBoolean)

J2OBJC_NAME_MAPPING(CommonBoolean, "java.lang.Boolean", "CommonBoolean")

// Empty class to force category to be loaded.
@implementation JreBooleanCategoryDummy
@end

// kotlin interop <<
