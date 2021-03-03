package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
import java.io.IOException;
import org.junit.Test;

public class ObjectsTest extends GenerationTest {

  final private static String testPackage = "objects/";

  @Test
  public void testStaticMethodWithoutParamsWithAnnotation() throws IOException {

    String className = StaticMethodWithoutParamWithAnnotation.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithObject classWithObject] staticMethodWithoutParamWithAnnotation]");
  }
}
