package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.objects.StaticMethodWithGenericParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithStringParamWithAnnotation;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParam;
import com.mirego.interop.java.test.objects.StaticMethodWithoutParamWithAnnotation;
import com.mirego.interop.java.test.objects.WithCompanionObject;
import com.mirego.interop.java.test.objects.WithNamedCompanionObject;
import com.mirego.interop.java.test.objects.WithObject;

public class ObjectsRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testStaticMethodWithoutParamsWithAnnotation() {
    assertEquals("return", StaticMethodWithoutParamWithAnnotation.main(NO_ARGS));
  }

  public void testStaticMethodWithStringParamsWithAnnotation() {
    assertEquals("stringAsParam", StaticMethodWithStringParamWithAnnotation.main(NO_ARGS));
  }

  public void testStaticMethodWithGenericParamsWithAnnotation() {
    assertEquals("stringGeneric", StaticMethodWithGenericParamWithAnnotation.main(NO_ARGS));
  }

  // todo javautilList vs NSArray
  // public void testStaticMethodWithListParamsWithAnnotation() {
  //   assertNotNull(StaticMethodWithListParamWithAnnotation.main(NO_ARGS).get(0));
  // }

  public void testWithCompanionObject() {
    assertEquals("companionString_functionString_jvmStaticFunction", WithCompanionObject.main(NO_ARGS));
  }

  public void testWithNamedCompanionObject() {
    assertEquals("namedCompanionString_jvmStaticFunction", WithNamedCompanionObject.main(NO_ARGS));
  }

  public void testWithObject() {
    assertEquals("objectString", WithObject.main(NO_ARGS));
  }

  public void testStaticMethodWithoutParams() {
    assertEquals("return", StaticMethodWithoutParam.main(NO_ARGS));
  }
}
