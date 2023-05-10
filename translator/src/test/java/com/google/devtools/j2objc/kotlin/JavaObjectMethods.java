package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import org.junit.Test;

import java.io.IOException;

import com.mirego.interop.java.test.objects.JavaObjectCallToStringOnKotlinInterface;

public class JavaObjectMethods extends GenerationTest {

  final private static String testPackage = "objects/";

  @Test
  public void testToStringOnKotlinInterface() throws IOException {
    String translation = translateJavaSourceFileForKotlinTest(JavaObjectCallToStringOnKotlinInterface.class.getSimpleName(), testPackage, ".m");
    assertTranslation(translation, "return [(id) aKotlinInterface description]");
  }
}
