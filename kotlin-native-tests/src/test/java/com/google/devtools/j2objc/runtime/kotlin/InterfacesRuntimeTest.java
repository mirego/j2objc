package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.interfaces.WithGenerics;
import com.mirego.interop.java.test.interfaces.WithInt;
import com.mirego.interop.java.test.interfaces.WithList;
import com.mirego.interop.java.test.interfaces.WithNullableInt;

public class InterfacesRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testInterfaceWithInt() {
    assertEquals(1, WithInt.main(NO_ARGS));
  }

  public void testInterfaceWithNullableInt() {
    assertEquals(1, WithNullableInt.main(NO_ARGS).intValue());
  }

  public void testInterfaceWithList() {
    assertEquals(1, WithList.main(NO_ARGS).get(0));
  }

  public void testInterfaceWithGenerics() {
    assertEquals(9, WithGenerics.main(NO_ARGS).intValue());
  }
}
