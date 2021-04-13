package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.constructor.KotlinClassVariable;

import org.junit.Test;

import java.io.IOException;

public class ClassVariableTest extends GenerationTest {

    final private static String testPackage = "constructor/";

    @Test
    public void testKotlinClassVariable() throws IOException {

        String className = KotlinClassVariable.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "IOSClass_fromClass(CommonClassWithDefaultConstructor.class)");
    }

}
