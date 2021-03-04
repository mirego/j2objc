package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.function.PublicFunctionReturningBoolean;
import com.mirego.interop.java.test.function.PublicFunctionReturningCharacter;
import com.mirego.interop.java.test.function.PublicFunctionReturningDouble;
import com.mirego.interop.java.test.function.PublicFunctionReturningFloat;
import com.mirego.interop.java.test.function.PublicFunctionReturningInteger;
import com.mirego.interop.java.test.function.PublicFunctionReturningLong;
import com.mirego.interop.java.test.function.PublicFunctionReturningPrimitive;
import com.mirego.interop.java.test.function.PublicFunctionReturningShort;
import com.mirego.interop.java.test.function.PublicFunctionReturningString;
import com.mirego.interop.java.test.function.PublicFunctionReturningUnit;
import com.mirego.interop.java.test.function.PublicLocalFunction;
import com.mirego.interop.java.test.function.PublicSingleExpressionFunction;
import java.io.IOException;
import org.junit.Test;

public class FunctionTest extends GenerationTest {

  final private static String testPackage = "function/";

  // todo param names
//  @Test
//  public void testPublicExtensionFunction() throws IOException {
//
//    String className = PublicExtensionFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  @Test
  public void testPublicFunctionReturningBoolean() throws IOException {

    String className = PublicFunctionReturningBoolean.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangBoolean_valueOfWithBoolean_([classWithPublicFunctions returnBoolean])");
  }

  @Test
  public void testPublicFunctionReturningCharacter() throws IOException {

    String className = PublicFunctionReturningCharacter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangCharacter_valueOfWithChar_([classWithPublicFunctions returnCharacter])");
  }

  @Test
  public void testPublicFunctionReturningDouble() throws IOException {

    String className = PublicFunctionReturningDouble.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangDouble_valueOfWithDouble_([classWithPublicFunctions returnDouble])");
  }

  @Test
  public void testPublicFunctionReturningFloat() throws IOException {

    String className = PublicFunctionReturningFloat.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangFloat_valueOfWithFloat_([classWithPublicFunctions returnFloat])");
  }

  @Test
  public void testPublicFunctionReturningInteger() throws IOException {

    String className = PublicFunctionReturningInteger.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangInteger_valueOfWithInt_([classWithPublicFunctions returnInt])");
  }

  @Test
  public void testPublicFunctionReturningLong() throws IOException {

    String className = PublicFunctionReturningLong.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangLong_valueOfWithLong_([classWithPublicFunctions returnLong])");
  }

  @Test
  public void testPublicFunctionReturningPrimitive() throws IOException {

    String className = PublicFunctionReturningPrimitive.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions returnInt]");
  }

  @Test
  public void testPublicFunctionReturningShort() throws IOException {

    String className = PublicFunctionReturningShort.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "JavaLangShort_valueOfWithShort_([classWithPublicFunctions returnShort])");
  }

  @Test
  public void testPublicFunctionReturningString() throws IOException {

    String className = PublicFunctionReturningString.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions returnString]");
  }

  @Test
  public void testPublicFunctionReturningUnit() throws IOException {

    String className = PublicFunctionReturningUnit.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[classWithPublicFunctionReturningUnit returnUnit]");
  }

  // todo default parameter not working ... try @JvmOverloads ?
//  @Test
//  public void testPublicFunctionWithDefaultArguments() throws IOException {
//
//    String className = PublicFunctionWithDefaultArguments.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  // todo param names
//  @Test
//  public void testPublicInnerClassFunction() throws IOException {
//
//    String className = PublicInnerClassFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  // todo lambda is a property getter not working properly
//  @Test
//  public void testPublicLambdaFunction() throws IOException {
//
//    String className = PublicLambdaFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  @Test
  public void testPublicLocalFunction() throws IOException {

    String className = PublicLocalFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions localFunction]");
  }

  // todo param names
//  @Test
//  public void testPublicOverloadedFunction() throws IOException {
//
//    String className = PublicOverloadedFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  // todo param names
//  @Test
//  public void testPublicRecursiveFunction() throws IOException {
//
//    String className = PublicRecursiveFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  @Test
  public void testPublicSingleExpressionFunction() throws IOException {

    String className = PublicSingleExpressionFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions singleExpression]");
  }

  // todo static usage fixes needed
//  @Test
//  public void testPublicStaticFunction() throws IOException {
//
//    String className = PublicOverloadedFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  // todo param names
//  @Test
//  public void testPublicTailRecursiveFunction() throws IOException {
//
//    String className = PublicTailRecursiveFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  // todo param names
//  @Test
//  public void testPublicVariableArgumentsFunction() throws IOException {
//
//    String className = PublicVariableArgumentsFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }
}
