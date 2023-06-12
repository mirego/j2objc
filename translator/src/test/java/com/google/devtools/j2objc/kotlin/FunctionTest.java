package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import java.io.IOException;

import com.mirego.interop.java.test.function.FunctionReceivingCollectionParam;
import com.mirego.interop.java.test.function.PublicExtensionFunction;
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
import com.mirego.interop.java.test.function.PublicFunctionUsingKotlinTypeAsParameter;
import com.mirego.interop.java.test.function.PublicInnerClassFunction;
import com.mirego.interop.java.test.function.PublicLocalFunction;
import com.mirego.interop.java.test.function.PublicOverloadedFunction;
import com.mirego.interop.java.test.function.PublicRecursiveFunction;
import com.mirego.interop.java.test.function.PublicSingleExpressionFunction;
import com.mirego.interop.java.test.function.PublicTailRecursiveFunction;
import com.mirego.interop.java.test.function.UsingKotlinTopLevelFunction;

public class FunctionTest extends GenerationTest {

  final private static String testPackage = "function/";

  public void testPublicExtensionFunction() throws IOException {

    String className = PublicExtensionFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions extensionFunctionString:@\"extension\"]");
  }

  public void testPublicFunctionReturningBoolean() throws IOException {

    String className = PublicFunctionReturningBoolean.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return CommonBoolean_valueOfWithBoolean_([classWithPublicFunctions returnBoolean])");
  }

  public void testPublicFunctionReturningCharacter() throws IOException {

    String className = PublicFunctionReturningCharacter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return JavaLangCharacter_valueOfWithChar_([classWithPublicFunctions returnCharacter])");
  }

  public void testPublicFunctionReturningDouble() throws IOException {

    String className = PublicFunctionReturningDouble.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return CommonDouble_valueOfWithDouble_([classWithPublicFunctions returnDouble])");
  }

  public void testPublicFunctionReturningFloat() throws IOException {

    String className = PublicFunctionReturningFloat.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return CommonFloat_valueOfWithFloat_([classWithPublicFunctions returnFloat])");
  }

  public void testPublicFunctionReturningInteger() throws IOException {

    String className = PublicFunctionReturningInteger.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return CommonInt_valueOfWithInt_([classWithPublicFunctions returnInt])");
  }

  public void testPublicFunctionReturningLong() throws IOException {

    String className = PublicFunctionReturningLong.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "return CommonLong_valueOfWithLong_([classWithPublicFunctions returnLong])");
  }

  public void testPublicFunctionReturningPrimitive() throws IOException {

    String className = PublicFunctionReturningPrimitive.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions returnInt]");
  }

  public void testPublicFunctionReturningShort() throws IOException {

    String className = PublicFunctionReturningShort.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation,
        "CommonShort_valueOfWithShort_([classWithPublicFunctions returnShort])");
  }

  public void testPublicFunctionReturningString() throws IOException {

    String className = PublicFunctionReturningString.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions returnString]");
  }

  public void testPublicFunctionReturningUnit() throws IOException {

    String className = PublicFunctionReturningUnit.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[classWithPublicFunction returnUnit]");
  }

  // todo default parameter not working ... try @JvmOverloads ?
//  public void testPublicFunctionWithDefaultArguments() throws IOException {
//
//    String className = PublicFunctionWithDefaultArguments.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  public void testPublicInnerClassFunction() throws IOException {

    String className = PublicInnerClassFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return CommonInt_valueOfWithInt_([classWithPublicFunctions innerClassFunctionNumber1:1 number2:2]);");
  }

  public void testTopLevelFunction() throws IOException {

    String className = UsingKotlinTopLevelFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [CommonKotlinFileWithTopLevelFunctionKt aTopLevelFunctionParam1:@\"hello\"];");
  }

  // todo lambda is a property getter not working properly
//  public void testPublicLambdaFunction() throws IOException {
//
//    String className = PublicLambdaFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  public void testPublicLocalFunction() throws IOException {

    String className = PublicLocalFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions localFunction]");
  }

  public void testPublicOverloadedFunction() throws IOException {

    String className = PublicOverloadedFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions overloadedFunctionNumber:1];");
  }

  public void testPublicRecursiveFunction() throws IOException {

    String className = PublicRecursiveFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return CommonLong_valueOfWithLong_([classWithPublicFunctions recursiveFunctionNumber:4]);");
  }

  public void testPublicSingleExpressionFunction() throws IOException {

    String className = PublicSingleExpressionFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithPublicFunctions singleExpression]");
  }

  // todo static usage fixes needed
//  public void testPublicStaticFunction() throws IOException {
//
//    String className = PublicOverloadedFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  public void testPublicTailRecursiveFunction() throws IOException {

    String className = PublicTailRecursiveFunction.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return CommonLong_valueOfWithLong_([classWithPublicFunctions tailRecursiveFunctionN:4 accum:1]);");
  }

  // todo param names
//  public void testPublicVariableArgumentsFunction() throws IOException {
//
//    String className = PublicVariableArgumentsFunction.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxx");
//  }

  public void testFunctionHavingAKotlinTypeAsParameter_TheKotlinTypeInMethodNameDoesNotIncludeCommon() throws IOException {
    String className = PublicFunctionUsingKotlinTypeAsParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "" +
        "- (instancetype)initWithClassWithPublicFunctions:(CommonClassWithPublicFunctions *)constructorParam {");

    assertTranslation(translation, "" +
        "- (instancetype)initWithClassWithPublicFunctions:(CommonClassWithPublicFunctions *)constructorParam1\n" +
        "                            withInterfaceWithInt:(id<CommonInterfaceWithInt>)constructorParam2 {\n");

    assertTranslation(translation, "" +
        "- (void)aMethodUsingASingleTypeKotlinWithClassWithPublicFunctions:(CommonClassWithPublicFunctions *)param {");

    assertTranslation(translation, "" +
        "- (void)aMethodUsingManyTypeKotlinWithClassWithPublicFunctions:(CommonClassWithPublicFunctions *)param1\n" +
        "                                          withInterfaceWithInt:(id<CommonInterfaceWithInt>)param2 {");
  }

  public void testFunctionWithObjCName() throws IOException {
    String className = PublicFunctionUsingKotlinTypeAsParameter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[classWithPublicFunctions getWithString:@\"test\"]");
  }

  public void testReceivingMapCallsConvertToNSDictionary() throws Exception {
    String className = FunctionReceivingCollectionParam.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[testClass receiveList:javaListToNSMutableArray(stringList)];");
    assertTranslation(translation, "[testClass receiveSet:javaSetToKotlinMutableSet(stringSet)];");
    assertTranslation(translation, "[testClass receiveMap:javaMapToKotlinMutableDictionary(stringMap)];");
  }
}
