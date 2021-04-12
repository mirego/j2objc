package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue1;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue2;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue3;
import com.mirego.interop.java.test.enums.SimpleEnumOrdinal;
import com.mirego.interop.java.test.enums.SimpleEnumValues;
import com.mirego.interop.java.test.enums.SimpleEnumSwitchCase;
import com.mirego.interop.java.test.enums.EnumWithPropertyAccessProperty;

import java.io.IOException;
import org.junit.Test;

public class EnumsTest extends GenerationTest {

    final private static String testPackage = "enums/";

    @Test
    public void testSimpleEnumAccessValue1() throws IOException {

        String className = SimpleEnumAccessValue1.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [((CommonSimpleEnum *) nil_chk(CommonSimpleEnum.enumvalue1)) description];");
    }

    @Test
    public void testSimpleEnumAccessValue2() throws IOException {

        String className = SimpleEnumAccessValue2.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [((CommonSimpleEnum *) nil_chk(CommonSimpleEnum.enumValue2)) description];");
    }

    @Test
    public void testSimpleEnumAccessValue3() throws IOException {

        String className = SimpleEnumAccessValue3.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [((CommonSimpleEnum *) nil_chk(CommonSimpleEnum.enumValue3)) description];");
    }

    // not working need to fix enum .values() access and return value in for loop is IOSObjectArray with does not seem to match KotlinArray
//    @Test
//    public void testSimpleEnumValues() throws IOException {
//
//        String className = SimpleEnumValues.class.getSimpleName();
//        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//        assertTranslation(translation, "xxxxx");
//    }

    @Test
    public void testSimpleEnumOrdinal() throws IOException {

        String className = SimpleEnumOrdinal.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "return [((CommonSimpleEnum *) nil_chk(CommonSimpleEnum.enumvalue1)) ordinal];");
    }

    @Test
    public void testSimpleEnumSwitchCase() throws IOException {

        String className = SimpleEnumSwitchCase.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "xxx");
    }

    @Test
    public void testEnumWithPropertyAccessProperty() throws IOException {

        String className = EnumWithPropertyAccessProperty.class.getSimpleName();
        String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

        assertTranslation(translation, "xxx");
    }
}
