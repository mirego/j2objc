package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.nullsafety.WithDoubleBangOperator;
import java.io.IOException;
import org.junit.Test;

public class NullSafetyTest extends GenerationTest {

  final private static String testPackage = "nullsafety/";

  @Test
  public void testWithDoubleBangOperator() throws IOException {
    String className = WithDoubleBangOperator.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classForNullSafety doubleBang]");
  }

}
