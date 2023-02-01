package com.google.devtools.j2objc.kotlin;


import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.dataclass.SimpleDataClassComponentGetter;
import com.mirego.interop.java.test.dataclass.SimpleDataClassConstructor;
import com.mirego.interop.java.test.dataclass.SimpleDataClassEquals;
import com.mirego.interop.java.test.dataclass.SimpleDataClassGetter;

import java.io.IOException;
import org.junit.Test;

public class DataClassTest extends GenerationTest {

    final private static String testPackage = "dataclass/";

    @Test
    public void testSimpleDataClassConstructor() throws IOException {

        String className = SimpleDataClassConstructor.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "[[CommonSimpleDataClass alloc] initWithName:@\"dataClassName\" number:1]");
    }

    @Test
    public void testSimpleDataClassGetter() throws IOException {

        String className = SimpleDataClassGetter.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return simpleDataClass.name;");
    }

    @Test
    public void testSimpleDataClassComponentGetter() throws IOException {

        String className = SimpleDataClassComponentGetter.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [simpleDataClass component1];");
    }

    @Test
    public void testSimpleDataClassEquals() throws IOException {

        String className = SimpleDataClassEquals.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [simpleDataClass isEqual:simpleDataClass2];");
    }
}
