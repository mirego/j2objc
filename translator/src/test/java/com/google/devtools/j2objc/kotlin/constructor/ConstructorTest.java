package com.google.devtools.j2objc.kotlin.constructor;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.constructor.WithoutConstructor;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConstructorTest extends GenerationTest {

    @Test
    public void testClassWithoutConstructor() throws IOException {
        String path = "/Users/lamontagne.guillaume/Dev/j2objc/translator/src/test/java/com/mirego/interop/java/test/constructor/WithoutConstructor.java";
        List<String> allLines = Files.readAllLines(Paths.get(path));
        // Remove the package lines
        allLines.remove(1);
        allLines.remove(0);

        String out = String.join(System.lineSeparator(), allLines);
        System.out.println(out);

        String translation = translateSourceFile(out, WithoutConstructor.class.getSimpleName(), WithoutConstructor.class.getSimpleName() + ".h");

//        String translation = translateSourceFile(
//                "import com.mirego.interop.kotlin.test.constructor.ClassWithoutConstructor;" +
//                        "class WithoutConstructor {" +
//                            "public WithoutConstructor() {}" +
//                            "public static ClassWithoutConstructor main(String[] args) {" +
//                                "final ClassWithoutConstructor withoutConstructor = new ClassWithoutConstructor();" +
//                                "return withoutConstructor;" +
//                            "}" +
//                        "}",
//                "WithoutConstructor", "WithoutConstructor.h"
//        );

        System.out.println(translation);
    }
}
