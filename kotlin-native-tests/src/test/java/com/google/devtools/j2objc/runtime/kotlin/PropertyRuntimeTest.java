package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.property.BackingFieldWithCustomGetter;
import com.mirego.interop.java.test.property.BackingFieldWithCustomSetter;
import com.mirego.interop.java.test.property.BackingPropertyWithCustomGetter;
import com.mirego.interop.java.test.property.BackingPropertyWithCustomSetter;
import com.mirego.interop.java.test.property.BooleanProperty;
import com.mirego.interop.java.test.property.ByteProperty;
import com.mirego.interop.java.test.property.CharProperty;
import com.mirego.interop.java.test.property.CharSequenceProperty;
import com.mirego.interop.java.test.property.DoubleProperty;
import com.mirego.interop.java.test.property.EscapedStringProperty;
import com.mirego.interop.java.test.property.FloatProperty;
import com.mirego.interop.java.test.property.IntProperty;
import com.mirego.interop.java.test.property.LateInitializedProperty;
import com.mirego.interop.java.test.property.LongProperty;
import com.mirego.interop.java.test.property.NullableBooleanProperty;
import com.mirego.interop.java.test.property.NullableProperty;
import com.mirego.interop.java.test.property.PropertyAnnotatedWithJvmField;
import com.mirego.interop.java.test.property.PropertyAnnotatedWithJvmFieldInsideAnEnum;
import com.mirego.interop.java.test.property.PublicImmutablePropertyWithGeneratedGetter;
import com.mirego.interop.java.test.property.PublicMutablePropertyWithGeneratedSetter;
import com.mirego.interop.java.test.property.ShortProperty;
import com.mirego.interop.java.test.property.StringProperty;

public class PropertyRuntimeTest extends TestCase {

  private static final String[] args = {""};

  public void testBackingFieldWithCustomGetter() {
    assertEquals("backed field", BackingFieldWithCustomGetter.main(args));
  }

  public void testBackingFieldWithCustomSetter() {
    assertEquals("backed field", BackingFieldWithCustomSetter.main(args));
  }

  public void testBackingPropertyWithCustomGetter() {
    assertEquals("backed property", BackingPropertyWithCustomGetter.main(args));
  }

  public void testBackingPropertyWithCustomSetter() {
    assertEquals("backed property", BackingPropertyWithCustomSetter.main(args));
  }

  public void testBooleanProperty() {
    assertFalse(BooleanProperty.main(args));
  }

  public void testByteProperty() {
    assertEquals(1, ByteProperty.main(args));
  }

  public void testCharProperty() {
    assertEquals('a', CharProperty.main(args));
  }

  public void testDoubleProperty() {
    assertEquals(0.1D, DoubleProperty.main(args));
  }

  public void testEscapedStringProperty() {
    assertEquals("testString\n", EscapedStringProperty.main(args));
  }

  public void testFloatProperty() {
    assertEquals(0.1f, FloatProperty.main(args));
  }

  public void testIntProperty() {
    assertEquals(1, IntProperty.main(args));
  }

  public void testLateInitializedProperty() {
    assertEquals("initialized", LateInitializedProperty.main(args));
  }

// todo this throws but we cannot catch it since java code does not throw
//  public void testLateNonInitializedProperty() {
//    LateNonInitializedProperty.main(args);
//  }

// todo param type not compatible
//  public void testListProperty() {
//    assertEquals(Arrays.asList(""), ListProperty.main(args));
//  }

  public void testLongProperty() {
    assertEquals(1L, LongProperty.main(args));
  }

  public void testShortProperty() {
    assertEquals(1, ShortProperty.main(args));
  }

  public void testStringProperty() {
    assertEquals("testString", StringProperty.main(args));
  }

  public void testCharSequenceProperty() {
    assertEquals("1000", CharSequenceProperty.main(args));
  }

  // todo this throw because j2objc adds a nil_chk ...
  public void testNullableBooleanProperty() {
    boolean nullPointerException = false;
    try {
      NullableBooleanProperty.main(args);
    } catch (NullPointerException e) {
      nullPointerException = true;
    }
    assert (nullPointerException);
  }

  public void testNullableProperty() {
    assertNull(NullableProperty.main(args));
  }

  public void testPublicImmutablePropertyWithGeneratedGetter() {
    assertEquals("immutableProperty", PublicImmutablePropertyWithGeneratedGetter.main(args));
  }

  public void testPublicMutablePropertyWithGeneratedSetter() {
    assertEquals("mutatedMutableProperty", PublicMutablePropertyWithGeneratedSetter.main(args));
  }

  public void testPropertyWithJvmField() {
    assertEquals("ClassWithJvmFieldProperty", PropertyAnnotatedWithJvmField.main(args));
  }

  public void testPropertyAnnotatedWithJvmFieldInsideAnEnum() {
    assertTrue(PropertyAnnotatedWithJvmFieldInsideAnEnum.main(args));
  }
}
