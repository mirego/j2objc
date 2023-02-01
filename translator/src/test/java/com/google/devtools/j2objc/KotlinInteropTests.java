// kotlin interop >>

package com.google.devtools.j2objc;

import com.google.devtools.j2objc.kotlin.ConstructorTest;
import com.google.devtools.j2objc.kotlin.DataClassTest;
import com.google.devtools.j2objc.kotlin.EnumsTest;
import com.google.devtools.j2objc.kotlin.FunctionTest;
import com.google.devtools.j2objc.kotlin.InterfacesTest;
import com.google.devtools.j2objc.kotlin.ObjectsTest;
import com.google.devtools.j2objc.kotlin.PropertyTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Returns a suite of all kotlin interop tests in this package.
 */
public class KotlinInteropTests {

  private static final Class<?>[] kotlinInteropClasses =
      new Class<?>[] {
              ConstructorTest.class,
              InterfacesTest.class,
              FunctionTest.class,
              InterfacesTest.class,
              ObjectsTest.class,
              PropertyTest.class,
              DataClassTest.class,
              EnumsTest.class,
      };


  public static Test suite() {
    return new TestSuite(kotlinInteropClasses);
  }
}

// kotlin interop <<
