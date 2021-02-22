package com.google.devtools.j2objc.kotlin.constructor;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.constructor.WithoutConstructor;

import org.junit.Test;

import java.io.IOException;

public class ConstructorTest extends GenerationTest {

  final private static String testPackage = "constructor/";

  @Test
  public void testClassWithoutConstructor() throws IOException {

    String className = WithoutConstructor.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[ComMiregoInteropKotlinTestConstructorClassWithoutConstructor alloc] init]");
  }
}
