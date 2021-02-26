package com.google.devtools.j2objc.kotlin.constructor;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.constructor.DefaultConstructor;
import com.mirego.interop.java.test.constructor.DefaultConstructorMultipleParameters;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithDefaultValue;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithInitBlock;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithMultipleInitBlocks;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithPrivateProperty;
import com.mirego.interop.java.test.constructor.SecondaryConstructor;
import com.mirego.interop.java.test.constructor.WithoutConstructor;

import org.junit.Test;

import java.io.IOException;

public class ConstructorTest extends GenerationTest {

  final private static String testPackage = "constructor/";

  @Test
  public void testClassWithoutConstructor() throws IOException {

    String className = WithoutConstructor.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithoutConstructor alloc] init]");
  }

  @Test
  public void testClassWithDefaultConstructor() throws IOException {

    String className = DefaultConstructor.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructor alloc] initWithName:@\"ClassWithDefaultConstructor\"]");
  }

  @Test
  public void testClassWithDefaultConstructorMultipleParameters() throws IOException {

    String className = DefaultConstructorMultipleParameters.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorMultipleParameters alloc] initWithFirstParameter:@\"First\" secondParameter:@\"Second\"]");
  }

  @Test
  public void testClassWithDefaultConstructorWithDefaultValue() throws IOException {

    String className = DefaultConstructorWithDefaultValue.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithDefaultValue alloc] init]");
  }

  @Test
  public void testClassWithDefaultConstructorWithInitBlock() throws IOException {

    String className = DefaultConstructorWithInitBlock.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithInitBlock alloc] initWithName:@\"ClassWithDefaultConstructorWithInitBlock\"]");
  }

  @Test
  public void testClassWithDefaultConstructorWithMultipleInitBlocks() throws IOException {

    String className = DefaultConstructorWithMultipleInitBlocks.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithMultipleInitBlocks alloc] initWithName:@\"ClassWithDefaultConstructorWithMultipleInitBlocks\"]");
  }

  @Test
  public void testClassWithDefaultConstructorWithPrivateProperty() throws IOException {

    String className = DefaultConstructorWithPrivateProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithPrivateProperty alloc] initWithName:@\"ClassWithDefaultConstructorWithPrivateProperty\"]");
  }

  @Test
  public void testClassWithSecondaryConstructor() throws IOException {

    String className = SecondaryConstructor.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithSecondaryConstructor alloc] init]");
  }
}
