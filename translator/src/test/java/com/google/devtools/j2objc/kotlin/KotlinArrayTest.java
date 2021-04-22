package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.array.Array1_length;
import com.mirego.interop.java.test.array.Array2_getAtIndex;
import com.mirego.interop.java.test.array.Array3_setAtIndex;
import com.mirego.interop.java.test.array.Array4_enhancedForLoop;

import org.junit.Test;

public class KotlinArrayTest extends GenerationTest {

    final private static String testPackage = "array/";

    @Test
    public void testArrayLength() throws Exception {
        String className = Array1_length.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
        assertTranslation(translation, "xxxxx");
    }

    @Test
    public void testArrayGet() throws Exception {
        String className = Array2_getAtIndex.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
        assertTranslation(translation, "xxxx");
    }

    @Test
    public void testArraySet() throws Exception {
        String className = Array3_setAtIndex.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
        assertTranslation(translation, "xxxxxx");
    }

    @Test
    public void testEnhancedForLoop() throws Exception {
        String className = Array4_enhancedForLoop.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
        assertTranslation(translation, "xxxxx");
    }

}
