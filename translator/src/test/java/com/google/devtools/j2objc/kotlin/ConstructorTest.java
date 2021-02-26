package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.constructor.DefaultConstructor;
import com.mirego.interop.java.test.constructor.DefaultConstructorMultipleParameters;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithInitBlock;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithIntParameter;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithListParameter;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithMultipleInitBlocks;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithMutableListParameter;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithNullableIntParameter;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithPrivateProperty;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithUserClassParameter;
import com.mirego.interop.java.test.constructor.SecondaryConstructor;
import com.mirego.interop.java.test.constructor.WithoutConstructor;
import java.io.IOException;
import org.junit.Test;

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

  // this test generates proper code, but this does not compile
//  @Test
//  public void testClassWithDefaultConstructorWithDefaultValue() throws IOException {
//
//    String className = DefaultConstructorWithDefaultValue.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithDefaultValue alloc] init]");
//  }

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

  @Test
  public void testClassWithDefaultConstructorWithIntParameter() throws IOException {

    String className = DefaultConstructorWithIntParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithIntParameter alloc] initWithIntParameter:1]");
  }

  @Test
  public void testClassWithDefaultConstructorWithNullableIntParameter() throws IOException {

    String className = DefaultConstructorWithNullableIntParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithNullableIntParameter alloc] "
        + "initWithNullableIntParameter:nullableInteger]");
  }

  @Test
  public void testClassWithDefaultConstructorWithListParameter() throws IOException {

    String className = DefaultConstructorWithListParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithListParameter alloc] "
        + "initWithListParameter:JavaUtilArrays_asListWithNSObjectArray_([IOSObjectArray arrayWithObjects:(id[])"
        + "{ JavaLangInteger_valueOfWithInt_(1) } count:1 type:JavaLangInteger_class_()])]");
  }

  @Test
  public void testClassWithDefaultConstructorWithMutableListParameter() throws IOException {

    String className = DefaultConstructorWithMutableListParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithMutableListParameter alloc] "
        + "initWithMutableListParemeter:JavaUtilArrays_asListWithNSObjectArray_([IOSObjectArray arrayWithObjects:(id[])"
        + "{ JavaLangInteger_valueOfWithInt_(1) } count:1 type:JavaLangInteger_class_()])]");
  }

  @Test
  public void testClassWithDefaultConstructorWithUserClassParameter() throws IOException {

    String className = DefaultConstructorWithUserClassParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[[CommonClassWithDefaultConstructorWithUserClassParameter alloc] "
        + "initWithUserClassParameter:[[CommonClassWithoutConstructor alloc] init]]");
  }
}
