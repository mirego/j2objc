// kotlin interop >>

package com.google.devtools.j2objc;

import com.google.devtools.j2objc.kotlin.ArrayTest;
import com.google.devtools.j2objc.kotlin.CheckTest;
import com.google.devtools.j2objc.kotlin.ClassesTest;
import com.google.devtools.j2objc.kotlin.CollectionsTest;
import com.google.devtools.j2objc.kotlin.ConstructorTest;
import com.google.devtools.j2objc.kotlin.DataClassTest;
import com.google.devtools.j2objc.kotlin.EnumsTest;
import com.google.devtools.j2objc.kotlin.FunctionTest;
import com.google.devtools.j2objc.kotlin.ImportsTest;
import com.google.devtools.j2objc.kotlin.InterfacesTest;
import com.google.devtools.j2objc.kotlin.NullSafetyTest;
import com.google.devtools.j2objc.kotlin.ObjectsTest;
import com.google.devtools.j2objc.kotlin.PropertyTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Returns a suite of all kotlin interop tests in this package.
 */
public class KotlinInteropTests {

  private static final Class<?>[] kotlinInteropClasses =
      new Class<?>[]{
          ArrayTest.class,
          CheckTest.class,
          ClassesTest.class,
          CollectionsTest.class,
          ConstructorTest.class,
          DataClassTest.class,
          EnumsTest.class,
          FunctionTest.class,
          ImportsTest.class,
          InterfacesTest.class,
          NullSafetyTest.class,
          ObjectsTest.class,
          PropertyTest.class,
      };

  public static Test suite() {
    return new TestSuite(kotlinInteropClasses);
  }
}

// kotlin interop <<
