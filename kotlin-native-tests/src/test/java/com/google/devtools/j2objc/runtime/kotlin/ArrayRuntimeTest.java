package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.array.Array1_length;
import com.mirego.interop.java.test.array.Array2_getAtIndex;
import com.mirego.interop.java.test.array.Array3_setAtIndex;
import com.mirego.interop.java.test.array.Array4_enhancedForLoop;

public class ArrayRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testArrayLength() {
    assertEquals("Empty: 0 - Single: 1 - Many: 5", Array1_length.main(NO_ARGS));
  }

  public void testArrayGet() {
    assertEquals("Item at index[3]: d", Array2_getAtIndex.main(NO_ARGS));
  }

  public void testArraySet() {
    assertEquals("From Java --> Item at index[3]: ZZZ\n" +
        "From Kotlin --> Item at index[3]: ZZZ", Array3_setAtIndex.main(NO_ARGS));
  }

  public void testEnhancedForLoop() {
    assertEquals("[abcde]", Array4_enhancedForLoop.main(NO_ARGS));
  }
}
