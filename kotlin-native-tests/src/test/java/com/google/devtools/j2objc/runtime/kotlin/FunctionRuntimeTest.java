package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.function.CallingGlobalFunctions;
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
import com.mirego.interop.java.test.function.PublicInnerClassFunction;
import com.mirego.interop.java.test.function.PublicLocalFunction;
import com.mirego.interop.java.test.function.PublicOverloadedFunction;
import com.mirego.interop.java.test.function.PublicRecursiveFunction;
import com.mirego.interop.java.test.function.PublicSingleExpressionFunction;
import com.mirego.interop.java.test.function.PublicTailRecursiveFunction;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionAny;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionBooleanArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionByteArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionCharArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionDoubleArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionFloatArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionIntArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionLongArray;
import com.mirego.interop.java.test.function.PublicVariableArgumentsFunctionShortArray;

public class FunctionRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testPublicExtensionFunction() {
    assertEquals("xtension", PublicExtensionFunction.main(NO_ARGS));
  }

  public void testPublicFunctionReturningBoolean() {
    assertFalse(PublicFunctionReturningBoolean.main(NO_ARGS));
  }

  public void testPublicFunctionReturningCharacter() {
    assertEquals('a', PublicFunctionReturningCharacter.main(NO_ARGS).charValue());
  }

  public void testPublicFunctionReturningDouble() {
    assertEquals(1.0D, PublicFunctionReturningDouble.main(NO_ARGS));
  }

  public void testPublicFunctionReturningFloat() {
    assertEquals(1.0f, PublicFunctionReturningFloat.main(NO_ARGS));
  }

  public void testPublicFunctionReturningInteger() {
    assertEquals(1, PublicFunctionReturningInteger.main(NO_ARGS).intValue());
  }

  public void testPublicFunctionReturningLong() {
    assertEquals(1L, (long) PublicFunctionReturningLong.main(NO_ARGS));
  }

  public void testPublicFunctionReturningPrimitive() {
    assertEquals(1L, PublicFunctionReturningPrimitive.main(NO_ARGS));
  }

  public void testPublicFunctionReturningShort() {
    assertEquals(1, PublicFunctionReturningShort.main(NO_ARGS).shortValue());
  }

  public void testPublicFunctionReturningString() {
    assertEquals("testString", PublicFunctionReturningString.main(NO_ARGS));
  }

  public void testPublicFunctionReturningUnit() {
    PublicFunctionReturningUnit.main(NO_ARGS);
  }

  // todo default not working try @JvmOverload
//  public void testPublicFunctionWithDefaultArguments() {
//    assertEquals("string1 string2", PublicFunctionWithDefaultArguments.main(NO_ARGS));
//  }

  public void testPublicInnerClassFunction() {
    assertEquals(3, PublicInnerClassFunction.main(NO_ARGS).intValue());
  }

  // todo `.invoke` not available
//  public void testPublicLambdaFunction() {
//    assertEquals(2, PublicLambdaFunction.main(NO_ARGS));
//  }

  public void testPublicLocalFunction() {
    assertEquals("local function", PublicLocalFunction.main(NO_ARGS));
  }

  public void testPublicOverloadedFunction() {
    assertEquals("1", PublicOverloadedFunction.main(NO_ARGS));
  }

  public void testPublicRecursiveFunction() {
    assertEquals(24, PublicRecursiveFunction.main(NO_ARGS).longValue());
  }

  public void testPublicSingleExpressionFunction() {
    assertEquals("single expression", PublicSingleExpressionFunction.main(NO_ARGS));
  }

// todo using static issues
//  public void testPublicStaticFunction() {
//    assertEquals("staticString", PublicStaticFunction.main(NO_ARGS));
//  }

  public void testPublicTailRecursiveFunction() {
    assertEquals(24, PublicTailRecursiveFunction.main(NO_ARGS).longValue());
  }

  public void testCallingGlobalFunctions() {
    assertEquals("globalFunction-getString_globalExtensionFunction-getWithMessage_false", CallingGlobalFunctions.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionAny() {
    assertEquals("true,a,abc,1,2.2", PublicVariableArgumentsFunctionAny.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionBooleanArray() {
    assertEquals("false,true", PublicVariableArgumentsFunctionBooleanArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionByteArray() {
    assertEquals("1,2,3,4", PublicVariableArgumentsFunctionByteArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionCharArray() {
    assertEquals("a,b,c", PublicVariableArgumentsFunctionCharArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionDoubleArray() {
    assertEquals("1.1,2.2,3.3,4.4", PublicVariableArgumentsFunctionDoubleArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionFloatArray() {
    assertEquals("1.1,2.2,3.3,4.4", PublicVariableArgumentsFunctionFloatArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionIntArray() {
    assertEquals("1,2,3,4", PublicVariableArgumentsFunctionIntArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionLongArray() {
    assertEquals("1,2,3,4", PublicVariableArgumentsFunctionLongArray.main(NO_ARGS));
  }

  public void testPublicVariableArgumentsFunctionShortArray() {
    assertEquals("1,2,3,4", PublicVariableArgumentsFunctionShortArray.main(NO_ARGS));
  }
}
