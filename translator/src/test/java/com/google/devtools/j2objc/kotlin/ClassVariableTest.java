package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import org.junit.Test;

import java.io.IOException;

import com.mirego.interop.java.test.constructor.KotlinClassVariable;

public class ClassVariableTest extends GenerationTest {

  final private static String testPackage = "constructor/";

  @Test
  public void testKotlinClassVariable() throws IOException {
    String className = KotlinClassVariable.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "className_ = [IOSClass_fromClass(CommonClassWithDefaultConstructor.class) getName]");
    assertTranslation(translation, "interfaceName = [IOSClass_fromProtocol(@protocol(CommonInterfaceSimple)) getName]");
  }
}
