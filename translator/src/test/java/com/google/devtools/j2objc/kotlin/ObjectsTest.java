package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.objects.StaticMethodWithListParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithStringParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
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

  // todo javautillist vs  NSarray
//  @Test
//  public void testStaticMethodWithListParamsWithAnnotation() throws IOException {
//
//    String className = StaticMethodWithListParamWithAnnotation.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxx");
//  }
}
