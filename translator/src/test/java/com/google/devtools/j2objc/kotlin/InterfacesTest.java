package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.interfaces.WithInt;
import com.mirego.interop.java.test.interfaces.WithList;
import com.mirego.interop.java.test.interfaces.WithNullableInt;
import java.io.IOException;
import org.junit.Test;

public class InterfacesTest extends GenerationTest {

  final private static String testPackage = "interfaces/";

  @Test
  public void testInterfaceWithInt() throws IOException {
    
    String className = WithInt.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithoutConstructor alloc] init]");
  }

  @Test
  public void testInterfaceWithNullableInt() throws IOException {

    String className = WithNullableInt.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithoutConstructor alloc] init]");
  }

  @Test
  public void testInterfaceWithList() throws IOException {

    String className = WithList.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithoutConstructor alloc] init]");
  }

}
