package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.classes.CallingGetClassOnInstanceOfInterface;
import com.mirego.interop.java.test.classes.KotlinClassVariable;

public class ClassRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testClassVariable() {
    assertTrue(KotlinClassVariable.main(NO_ARGS));
  }

  public void testGetClassOnInstance() {
    assertTrue(CallingGetClassOnInstanceOfInterface.main(NO_ARGS));
  }
}
