package com.google.devtools.j2objc.kotlin.constructor;

import com.google.devtools.j2objc.GenerationTest;

import org.junit.Test;

import java.io.IOException;

public class ConstructorTest extends GenerationTest {

    @Test
    public void testClassWithoutConstructor() throws IOException {
        String translation = translateSourceFile(
                "import com.mirego.interop.kotlin.test.constructor.ClassWithoutConstructor;" +
                        "class WithoutConstructor {" +
                            "public WithoutConstructor() {}" +
                            "public static ClassWithoutConstructor main(String[] args) {" +
                                "final ClassWithoutConstructor withoutConstructor = new ClassWithoutConstructor();" +
                                "return withoutConstructor;" +
                            "}" +
                        "}",
                "WithoutConstructor", "WithoutConstructor.h"
        );

        System.out.println(translation);
    }
}
