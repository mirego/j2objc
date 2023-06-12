package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.dataclass.SimpleDataClassConstructor;
import com.mirego.interop.java.test.dataclass.SimpleDataClassEquals;
import com.mirego.interop.java.test.dataclass.SimpleDataClassGetter;

public class DataClassRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testSimpleDataClassConstructor() {
    assertNotNull(SimpleDataClassConstructor.main(NO_ARGS));
  }

  public void testSimpleDataGetter() {
    assertEquals("dataClassName", SimpleDataClassGetter.main(NO_ARGS));
  }

  // TODO component{n} seems to be broken after update to Kotlin 1.8.0
  // public void testSimpleDataComponentGetter() {
  //   assertEquals("dataClassName", SimpleDataClassComponentGetter.main(args));
  // }

  public void testSimpleDataEquals() {
    assertTrue(SimpleDataClassEquals.main(NO_ARGS));
  }

  // TODO copy is called doCopy, but it's not worth fixing for now since it takes all params like the constructor.
  // public void testSimpleDataClassCopy() {
  //   assertTrue(SimpleDataClassCopy.main(args));
  // }
}
