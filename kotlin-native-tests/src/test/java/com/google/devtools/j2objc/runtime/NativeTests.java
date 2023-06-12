package com.google.devtools.j2objc.runtime;

import com.google.devtools.j2objc.runtime.kotlin.ArrayRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.ClassRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.CollectionsRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.ConstructorRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.DataClassRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.EnumsRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.FunctionRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.InterfacesRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.NullSafetyRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.ObjectsRuntimeTest;
import com.google.devtools.j2objc.runtime.kotlin.PropertyRuntimeTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Returns a suite of all native tests in this package.
 */
public class NativeTests {

  private static final Class<?>[] nativeTests =
      new Class<?>[]{
          ArrayRuntimeTest.class,
          ClassRuntimeTest.class,
          CollectionsRuntimeTest.class,
          ConstructorRuntimeTest.class,
          DataClassRuntimeTest.class,
          EnumsRuntimeTest.class,
          FunctionRuntimeTest.class,
          InterfacesRuntimeTest.class,
          NullSafetyRuntimeTest.class,
          ObjectsRuntimeTest.class,
          PropertyRuntimeTest.class,
      };

  public static Test suite() {
    return new TestSuite(nativeTests);
  }
}
