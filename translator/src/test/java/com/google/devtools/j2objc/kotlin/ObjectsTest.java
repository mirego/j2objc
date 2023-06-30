package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.objects.AccessingJvmStaticWithStaticImport;
import com.mirego.interop.java.test.objects.JavaObjectCallToStringOnKotlinInterface;
import com.mirego.interop.java.test.objects.StaticMethodWithGenericParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithStringParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParam;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
import com.mirego.interop.java.test.objects.WithCompanionObject;
import com.mirego.interop.java.test.objects.WithNamedCompanionObject;
import com.mirego.interop.java.test.objects.WithObject;

public class ObjectsTest extends GenerationTest {

  final private static String testPackage = "objects/";

  public void testStaticMethodWithoutParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithoutParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethodWithoutParamWithAnnotation];");
  }

  public void testStaticMethodWithStringParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithStringParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethodWithStringParamWithAnnotationInput:@\"stringAsParam\"];");
  }

  public void testStaticMethodWitGenericParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithGenericParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [[CommonObjectWithMethod objectWithMethod] staticMethodWithGenericParamInput:testString];");
  }

  // todo javautillist vs  NSarray
//  public void testStaticMethodWithListParamsWithAnnotation() throws IOException {
//
//    String className = StaticMethodWithListParamWithAnnotation.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxx");
//  }

  public void testWithCompanionObject() throws IOException {

    String className = WithCompanionObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[CommonClassWithCompanionObjectCompanion companion].companionString");
    assertTranslation(translation, "[[CommonClassWithCompanionObjectCompanion companion] companionFunction]");
    assertTranslation(translation, "[[CommonClassWithCompanionObject companion] companionJvmStaticFunction]");
  }

  public void testWithNamedCompanionObject() throws IOException {

    String className = WithNamedCompanionObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "[CommonClassWithNamedCompanionObjectNamed named].companionString");
    assertTranslation(translation, "[[CommonClassWithNamedCompanionObject companion] companionJvmStaticFunction]");
  }

  public void testWithObject() throws IOException {

    String className = WithObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[CommonClassWithObjectNamed named].objectString");
  }

  public void testStaticMethodWithoutParams() throws IOException {

    String className = StaticMethodWithoutParam.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonObjectWithMethod objectWithMethod] staticMethodWithoutParam]");
  }

  public void testToStringOnKotlinInterface() throws IOException {
    String translation = translateJavaSourceFileForKotlinTest(JavaObjectCallToStringOnKotlinInterface.class.getSimpleName(), testPackage, ".m");
    assertTranslation(translation, "return [(id) aKotlinInterface description]");
  }

  public void testAccessingCompanionAndObjectJvmStaticMethodWithStaticImport() throws IOException {
    String translation = translateJavaSourceFileForKotlinTest(AccessingJvmStaticWithStaticImport.class.getSimpleName(), testPackage, ".m");
    assertTranslation(translation, "NSString *objectFunction = [[CommonObjectWithMethod shared] staticMethodWithoutParamWithAnnotation];");
    assertTranslation(translation, "NSString *companionFunction = [[CommonClassWithCompanionObject companion] companionJvmStaticFunction];");
  }
}
