package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.collections.LoopThroughList;
import com.mirego.interop.java.test.collections.LoopThroughMutableList;

public class CollectionsTest extends GenerationTest {

  final private static String testPackage = "collections/";

  public void testLoopThroughList() throws IOException {

    String className = LoopThroughList.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "id<JavaUtilList> list = kotlinLists.list;");
  }

  public void testLoopThroughMutableList() throws IOException {

    String className = LoopThroughMutableList.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "id<JavaUtilList> list = kotlinLists.mutableList;");
  }
}
