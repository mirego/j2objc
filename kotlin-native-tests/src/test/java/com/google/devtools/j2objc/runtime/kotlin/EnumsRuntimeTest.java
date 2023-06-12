package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.enums.EnumValuesWithStaticProperties;
import com.mirego.interop.java.test.enums.EnumWithPropertyAccessProperty;
import com.mirego.interop.java.test.enums.EnumWithPropertyWithFunction;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue1;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue2;
import com.mirego.interop.java.test.enums.SimpleEnumAccessValue3;
import com.mirego.interop.java.test.enums.SimpleEnumOrdinal;
import com.mirego.interop.java.test.enums.SimpleEnumSwitchCase;
import com.mirego.interop.java.test.enums.SimpleEnumValues;

public class EnumsRuntimeTest extends TestCase {

  private static final String[] NO_ARGS = {""};

  public void testSimpleEnumAccessValue1() {
    assertEquals("ENUMVALUE1", SimpleEnumAccessValue1.main(NO_ARGS));
  }

  public void testSimpleEnumAccessValue2() {
    assertEquals("ENUM_VALUE2", SimpleEnumAccessValue2.main(NO_ARGS));
  }

  public void testSimpleEnumAccessValue3() {
    assertEquals("ENUM_VALUE_3", SimpleEnumAccessValue3.main(NO_ARGS));
  }

  public void testSimpleEnumValues() {
    assertEquals("ENUMVALUE1ENUM_VALUE2ENUM_VALUE_3", SimpleEnumValues.main(NO_ARGS));
  }

  public void testSimpleEnumOrdinal() {
    assertEquals(0, SimpleEnumOrdinal.main(NO_ARGS));
  }

  public void testSimpleEnumSwitchCase() {
    assertEquals(1, SimpleEnumSwitchCase.main(NO_ARGS));
  }

  public void testEnumWithPropertyAccessProperty() {
    assertEquals("ENUMVALUE1_TEST", EnumWithPropertyAccessProperty.main(NO_ARGS));
  }

  public void testEnumWithPropertyWithFunction() {
    assertEquals("ENUMVALUE1_TESTFUN", EnumWithPropertyWithFunction.main(NO_ARGS));
  }

  public void testEnumValuesWithStaticProperties() {
    assertEquals("ENUMVALUE1ENUM_VALUE2ENUM_VALUE_3", EnumValuesWithStaticProperties.main(NO_ARGS));
  }
}
