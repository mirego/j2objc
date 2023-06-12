package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.interfaces.WithGenerics;
import com.mirego.interop.java.test.interfaces.WithInt;
import com.mirego.interop.java.test.interfaces.WithIntProperty;
import com.mirego.interop.java.test.interfaces.WithList;
import com.mirego.interop.java.test.interfaces.WithNullableInt;
import com.mirego.interop.java.test.interfaces.WithStringProperty;

public class InterfacesTest extends GenerationTest {

  final private static String testPackage = "interfaces/";

  public void testInterfaceWithInt() throws IOException {

    String className = WithInt.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withInt convertInputInt:1];");
    assertTranslation(translation, "- (jint)convertInputInt:(jint)inputInt {\n"
        + "  return inputInt;\n"
        + "}");
  }

  public void testInterfaceIntProperty() throws IOException {

    String className = WithIntProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return NSString_java_valueOfInt_([withIntPropertyImplementation getCount]);");
    assertTranslation(translation, "- (jint)getCount {\n" +
        "  return 42;\n" +
        "}");
    assertTranslation(translation, "- (jint)count {\n" +
        "  return [self getCount];\n" +
        "}");
  }

  public void testInterfaceStringProperty() throws IOException {

    String className = WithStringProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withStringPropertyImplementation getKey];");

    assertTranslation(translation, "- (NSString *)getKey {\n" +
        "  return @\"this is the value of my key\";\n" +
        "}");

    assertTranslation(translation, "- (NSString *)key {\n" +
        "  return [self getKey];\n" +
        "}");
  }

  public void testInterfaceWithNullableInt() throws IOException {

    String className = WithNullableInt.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withNullableInt convertInputNullableInt:CommonInt_valueOfWithInt_(1)];");
    assertTranslation(translation, "- (CommonInt *)convertInputNullableInt:(CommonInt *)inputNullableInteger {\n"
        + "  return inputNullableInteger;\n"
        + "}");
  }

  public void testInterfaceWithList() throws IOException {

    String className = WithList.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withList convertInputList:JavaUtilArrays_asListWithNSObjectArray_([IOSObjectArray arrayWithObjects:(id[])"
        + "{ CommonInt_valueOfWithInt_(1) } count:1 type:CommonInt_class_()])];");
    assertTranslation(translation, "- (id<JavaUtilList>)convertInputList:(id<JavaUtilList>)inputList {\n"
        + "  return inputList;\n"
        + "}");
  }

  public void testInterfaceWithGenerics() throws IOException {

    String className = WithGenerics.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "convertInput:CommonInt_valueOfWithInt_(5)])) intValue]");
    assertTranslation(translation, "[process convertWithFunctionGenericOtherInput:CommonInt_valueOfWithInt_(3)])) intValue]");
    assertTranslation(translation, "[process convertWithAnotherFunctionGenericAnotherInput:CommonInt_valueOfWithInt_(1)])) intValue]");
  }
}
