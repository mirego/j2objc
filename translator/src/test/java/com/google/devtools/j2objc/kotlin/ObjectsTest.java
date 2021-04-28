package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.objects.StaticMethodWithGenericParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithListParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithStringParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
import com.mirego.interop.java.test.objects.WithCompanionObject;
import com.mirego.interop.java.test.objects.WithNamedCompanionObject;
import com.mirego.interop.java.test.objects.WithObject;

import java.io.IOException;
import org.junit.Test;

public class ObjectsTest extends GenerationTest {

  final private static String testPackage = "objects/";

  @Test
  public void testStaticMethodWithoutParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithoutParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethodWithoutParamWithAnnotation];");
  }

  @Test
  public void testStaticMethodWithStringParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithStringParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethodWithStringParamWithAnnotationInput:@\"stringAsParam\"];");
  }

  @Test
  public void testStaticMethodWitGenericParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithGenericParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [[CommonObjectWithMethod objectWithMethod] staticMethodWithGenericParamInput:testString];");
  }

  // todo javautillist vs  NSarray
//  @Test
//  public void testStaticMethodWithListParamsWithAnnotation() throws IOException {
//
//    String className = StaticMethodWithListParamWithAnnotation.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxx");
//  }


  @Test
  public void testWithCompanionObject() throws IOException {

    String className = WithCompanionObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[CommonClassWithCompanionObjectCompanion companion].companionString");
    assertTranslation(translation, "[[CommonClassWithCompanionObjectCompanion companion] companionFunction]");
  }

  @Test
  public void testWithNamedCompanionObject() throws IOException {

    String className = WithNamedCompanionObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[CommonClassWithNamedCompanionObjectNamed named].companionString");
  }

  @Test
  public void testWithObject() throws IOException {

    String className = WithObject.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[CommonClassWithObjectNamed named].objectString");
  }
}
