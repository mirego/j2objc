package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.annotations.ShellMethodCases;

public class AnnotationsTest extends GenerationTest {

  final private static String testPackage = "annotations/";

  public void testShellMethodReplacesImplementationByThrow() throws IOException {
    String className = ShellMethodCases.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertNotInTranslation(translation, "removed");
    assertNotInTranslation(translation, "return internal;");
    assertTranslation(translation, "@throw create_JavaLangIllegalArgumentException_initWithNSString_(@\"Method: getStringShell");
    assertTranslation(translation, "@throw create_JavaLangIllegalArgumentException_initWithNSString_(@\"Method: <init> was converted to");
    assertTranslation(translation, "@throw create_JavaLangIllegalArgumentException_initWithNSString_(@\"Method: getInternal was converted");
    assertTranslation(translation, "kept");
  }
}
