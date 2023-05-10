package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import com.mirego.interop.java.test.function.FunctionReceivingCollectionParam;

public class MethodInvocationWithCollectionParamsTest extends GenerationTest {

  final private static String testPackage = "function/";

  public void testReceivingMapCallsConvertToNSDictionary() throws Exception {
    String className = FunctionReceivingCollectionParam.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[testClass receiveList:javaListToNSMutableArray(stringList)];");
    assertTranslation(translation, "[testClass receiveSet:javaSetToKotlinMutableSet(stringSet)];");
    assertTranslation(translation, "[testClass receiveMap:javaMapToKotlinMutableDictionary(stringMap)];");
  }
}
