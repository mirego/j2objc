package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.check.InstanceOfOnAKotlinInterfaceAndClass;

public class CheckTest extends GenerationTest {

  final private static String testPackage = "check/";

  public void testInstanceOfOnAKotlinInterface() throws IOException {
    String className = InstanceOfOnAKotlinInterfaceAndClass.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "[(id) anObjectTypedAsAKotlinInterface isKindOfClass:[");
  }

  public void testInstanceOfCheckingForAKotlinInterface() throws IOException {
    String className = InstanceOfOnAKotlinInterfaceAndClass.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "[aJavaClass conformsToProtocol:@protocol(CommonInterfaceWithGenerics)]");
  }

  public void testInstanceOfCheckingForAKotlinClass() throws IOException {
    String className = InstanceOfOnAKotlinInterfaceAndClass.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "[aJavaClass isKindOfClass:[CommonClassWithGenerics class]]");
  }
}
