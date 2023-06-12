package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.classes.CallingGetClassOnInstanceOfInterface;
import com.mirego.interop.java.test.classes.KotlinClassVariable;

public class ClassesTest extends GenerationTest {

  final private static String testPackage = "classes/";

  public void testKotlinClassVariable() throws IOException {
    String className = KotlinClassVariable.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "IOSClass_fromClass(CommonClassWithDefaultConstructor.class)");
    assertTranslation(translation, "IOSClass_fromProtocol(@protocol(CommonInterfaceSimple))");
  }

  public void testKotlinGetClassOnInstanceOfInterface() throws IOException {
    String className = CallingGetClassOnInstanceOfInterface.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "IOSClass_fromClass([((CommonClassImplementingSimpleInterface *) nil_chk(classImplementingSimpleInterface)) class]);");
    assertTranslation(translation, "IOSClass_fromClass([((id) nil_chk(interfaceSimple)) class])");
  }
}
