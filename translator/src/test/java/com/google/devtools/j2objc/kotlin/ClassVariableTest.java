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
import com.mirego.interop.java.test.constructor.KotlinClassVariable;
import com.mirego.interop.java.test.constructor.SecondaryConstructor;
import com.mirego.interop.java.test.constructor.WithoutConstructor;

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
