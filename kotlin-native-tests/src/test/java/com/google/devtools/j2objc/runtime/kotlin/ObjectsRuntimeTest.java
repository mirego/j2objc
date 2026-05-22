package com.google.devtools.j2objc.runtime.kotlin;

import com.mirego.interop.java.test.function.ConstructorAsFunctionReference;
import com.mirego.interop.java.test.function.TopLevelFunctionStaticallyImported;
import junit.framework.TestCase;

import com.mirego.interop.java.test.objects.AccessingJvmStaticWithStaticImport;
import com.mirego.interop.java.test.objects.StandAloneObjectInstance;
import com.mirego.interop.java.test.objects.StaticMethodStaticallyImported;
import com.mirego.interop.java.test.objects.StaticMethodWithGenericParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithStringParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParam;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
import com.mirego.interop.java.test.objects.WithCompanionObject;
import com.mirego.interop.java.test.objects.WithField;
import com.mirego.interop.java.test.objects.WithNamedCompanionObject;
import com.mirego.interop.java.test.objects.WithObject;

public class ObjectsRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testStandAloneObjectInstance() {
    assertEquals("StandAloneObject", StandAloneObjectInstance.main(NO_ARGS));
  }

  public void testStaticMethodWithoutParamsWithAnnotation() {
    assertEquals("return", StaticMethodWithoutParamWithAnnotation.main(NO_ARGS));
  }

  public void testStaticMethodWithStringParamsWithAnnotation() {
    assertEquals("stringAsParam", StaticMethodWithStringParamWithAnnotation.main(NO_ARGS));
  }

  public void testStaticMethodWithGenericParamsWithAnnotation() {
    assertEquals("stringGeneric", StaticMethodWithGenericParamWithAnnotation.main(NO_ARGS));
  }

  public void testStaticMethodStaticallyImported() {
    assertEquals("return", StaticMethodStaticallyImported.main(NO_ARGS));
  }

  public void testTopLevelFunctionStaticallyImported() {
    assertEquals("echoed value from aTopLevelFunction", TopLevelFunctionStaticallyImported.main(NO_ARGS));
  }

  public void testConstructorAsFunctionRef() {
    assertEquals("Constructor no params: ClassWithoutConstructor\n" +
                  "Constructor single param: VALUE_OF_THE_PARAM",
                  ConstructorAsFunctionReference.main(NO_ARGS));
  }

  // todo javautilList vs NSArray
  // public void testStaticMethodWithListParamsWithAnnotation() {
  //   assertNotNull(StaticMethodWithListParamWithAnnotation.main(NO_ARGS).get(0));
  // }

  public void testWithCompanionObject() {
    assertEquals("instanceString_instanceStringAsJvmField_companionString_companionStringAsJvmField_functionString_jvmStaticFunction", WithCompanionObject.main(NO_ARGS));
  }

  public void testWithNamedCompanionObject() {
    assertEquals("companionStringWithJvmField_namedCompanionString_jvmStaticFunction", WithNamedCompanionObject.main(NO_ARGS));
  }

  public void testWithField() {
    assertEquals("companionString_companionStringAsJvmField_functionString_jvmStaticFunction", WithField.main(NO_ARGS));
  }

  public void testWithObject() {
    assertEquals("objectString", WithObject.main(NO_ARGS));
  }

  public void testStaticMethodWithoutParams() {
    assertEquals("return", StaticMethodWithoutParam.main(NO_ARGS));
  }

  public void testAccessingCompanionJvmStaticMethodWithStaticImport() {
    assertEquals("return_jvmStaticFunction", AccessingJvmStaticWithStaticImport.main(NO_ARGS));
  }
}
