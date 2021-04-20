package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.interfaces.WithGenerics;
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

    assertTranslation(translation, "return [withInt convertInputInt:1];");
    assertTranslation(translation, "- (jint)convertInputInt:(jint)inputInt {\n"
        + "  return inputInt;\n"
        + "}");
  }

  @Test
  public void testInterfaceWithNullableInt() throws IOException {

    String className = WithNullableInt.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withNullableInt convertInputNullableInt:JavaLangInteger_valueOfWithInt_(1)];");
    assertTranslation(translation, "- (JavaLangInteger *)convertInputNullableInt:(JavaLangInteger *)inputNullableInteger {\n"
        + "  return inputNullableInteger;\n"
        + "}");
  }

  @Test
  public void testInterfaceWithList() throws IOException {

    String className = WithList.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [withList convertInputList:JavaUtilArrays_asListWithNSObjectArray_([IOSObjectArray arrayWithObjects:(id[])"
        + "{ JavaLangInteger_valueOfWithInt_(1) } count:1 type:JavaLangInteger_class_()])];");
    assertTranslation(translation, "- (id<JavaUtilList>)convertInputList:(id<JavaUtilList>)inputList {\n"
        + "  return inputList;\n"
        + "}");
  }

  @Test
  public void testInterfaceWithGenerics() throws IOException {

    String className = WithGenerics.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "convertInput:JavaLangInteger_valueOfWithInt_(5)])) intValue]");
    assertTranslation(translation, "[process convertWithFunctionGenericOtherInput:JavaLangInteger_valueOfWithInt_(3)])) intValue]");
    assertTranslation(translation, "[process convertWithAnotherFunctionGenericAnotherInput:JavaLangInteger_valueOfWithInt_(1)])) intValue]");
  }

}
