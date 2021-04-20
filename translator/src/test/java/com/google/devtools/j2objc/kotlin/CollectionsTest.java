package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.collections.LoopThroughList;
import com.mirego.interop.java.test.collections.LoopThroughMutableList;

import org.junit.Test;

import java.io.IOException;

public class CollectionsTest extends GenerationTest {

    final private static String testPackage = "collections/";

    @Test
    public void testLoopThroughtList() throws IOException {

        String className = LoopThroughList.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "id<JavaUtilList> list = toJavaUtilList(kotlinLists.list);");
    }

    @Test
    public void testLoopThroughtMutableList() throws IOException {

        String className = LoopThroughMutableList.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "id<JavaUtilList> list = toJavaUtilList(kotlinLists.mutableList);");
    }
}
