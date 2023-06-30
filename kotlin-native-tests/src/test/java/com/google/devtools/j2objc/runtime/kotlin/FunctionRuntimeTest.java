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

// todo incompatible types
//  public void testPublicVariableArgumentsFunction() {
//    assertEquals(10, PublicVariableArgumentsFunction.main(NO_ARGS));
//  }

  public void testCallingGlobalFunctions() {
    assertEquals("globalFunction-getString_globalExtensionFunction-getWithMessage_false", CallingGlobalFunctions.main(NO_ARGS));
  }
}
