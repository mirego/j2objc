package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.collections.LoopThroughList;
import com.mirego.interop.java.test.collections.LoopThroughMutableList;

public class CollectionsRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testLoopThroughList() {
    assertEquals("ABCDE", LoopThroughList.main(NO_ARGS));
  }

  public void testLoopThroughMutableList() {
    assertEquals("12345", LoopThroughMutableList.main(NO_ARGS));
  }
}
