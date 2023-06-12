package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.nullsafety.WithDoubleBangOperator;

public class NullSafetyTest extends GenerationTest {

  final private static String testPackage = "nullsafety/";

  public void testWithDoubleBangOperator() throws IOException {
    String className = WithDoubleBangOperator.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classForNullSafety doubleBang]");
  }
}
