package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.objects.*;

import java.io.IOException;
import org.junit.Test;

public class ObjectsTest extends GenerationTest {

  final private static String testPackage = "objects/";

  @Test
  public void testStaticMethod_WithoutParam_WithAnnotationJvmStatic() throws IOException {

    String className = StaticMethod_WithoutParam_WithAnnotationJvmStatic.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethod_WithoutParam_WithAnnotationJvmStatic];");
  }

  @Test
  public void testStaticMethod_WithStringParam_WithAnnotationJvmStatic() throws IOException {

    String className = StaticMethod_WithStringParam_WithAnnotationJvmStatic.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "NSString *returnValue = [[CommonObjectWithMethod objectWithMethod] staticMethod_WithStringParam_WithAnnotationJvmStaticInput:@\"stringAsParam\"];");
  }

    @Test
    public void testObjectInstanceMethod_WithoutAnnotationJvmStatic() throws IOException {
        String className = ObjectInstanceMethod_WithoutAnnotationJvmStatic.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "NSString *returnValue = JreRetainedLocalValue([[CommonObjectWithMethod objectWithMethod] objectInstanceMethod_WithoutAnnotationJvmStatic]);");
    }

  @Test
  public void testStaticMethod_WithGenericParam() throws IOException {

    String className = StaticMethod_WithGenericParam.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [[CommonObjectWithMethod objectWithMethod] staticMethod_WithGenericParamInput:testString];");
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
