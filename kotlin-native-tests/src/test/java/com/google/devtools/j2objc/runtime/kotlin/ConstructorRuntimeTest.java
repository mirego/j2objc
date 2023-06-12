package com.google.devtools.j2objc.runtime.kotlin;

import junit.framework.TestCase;

import com.mirego.interop.java.test.constructor.DefaultConstructor;
import com.mirego.interop.java.test.constructor.DefaultConstructorMultipleParameters;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithInitBlock;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithIntParameter;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithMultipleInitBlocks;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithPrivateProperty;
import com.mirego.interop.java.test.constructor.DefaultConstructorWithUserClassParameter;
import com.mirego.interop.java.test.constructor.SecondaryConstructor;
import com.mirego.interop.java.test.constructor.WithoutConstructor;

// FIXME None of these tests make any sense, they test nothing
public class ConstructorRuntimeTest extends TestCase {

  public void testWithoutConstructor() {
    WithoutConstructor withoutConstructor = new WithoutConstructor();
    assertNotNull(withoutConstructor);
  }

  public void testClassWithDefaultConstructor() {
    DefaultConstructor defaultConstructor = new DefaultConstructor();
    assertNotNull(defaultConstructor);
  }

  public void testClassWithDefaultConstructorMultipleParameters() {
    DefaultConstructorMultipleParameters defaultConstructorMultipleParameters = new DefaultConstructorMultipleParameters();
    assertNotNull(defaultConstructorMultipleParameters);
  }

  //  public void testClassWithDefaultConstructorWithDefaultValue() {
  //    DefaultConstructorWithDefaultValue defaultConstructorWithDefaultValue = new DefaultConstructorWithDefaultValue();
  //    assertNotNull(defaultConstructorWithDefaultValue);
  //  }

  public void testClassWithDefaultConstructorWithInitBlock() {
    DefaultConstructorWithInitBlock defaultConstructorWithInitBlock = new DefaultConstructorWithInitBlock();
    assertNotNull(defaultConstructorWithInitBlock);
  }

  public void testClassWithDefaultConstructorWithMultipleInitBlocks() {
    DefaultConstructorWithMultipleInitBlocks defaultConstructorWithMultipleInitBlocks = new DefaultConstructorWithMultipleInitBlocks();
    assertNotNull(defaultConstructorWithMultipleInitBlocks);
  }

  public void testClassWithDefaultConstructorWithPrivateProperty() {
    DefaultConstructorWithPrivateProperty defaultConstructorWithPrivateProperty = new DefaultConstructorWithPrivateProperty();
    assertNotNull(defaultConstructorWithPrivateProperty);
  }

  public void testClassWithSecondaryConstructor() {
    SecondaryConstructor secondaryConstructor = new SecondaryConstructor();
    assertNotNull(secondaryConstructor);
  }

  public void testClassWithDefaultConstructorWithIntParameter() {
    DefaultConstructorWithIntParameter defaultConstructorWithIntParameter = new DefaultConstructorWithIntParameter();
    assertNotNull(defaultConstructorWithIntParameter);
  }

  // public void testClassWithDefaultConstructorWithNullableIntParameter() {
  //   DefaultConstructorWithNullableIntParameter defaultConstructorWithNullableIntParameter = new DefaultConstructorWithNullableIntParameter();
  //   assertNotNull(defaultConstructorWithNullableIntParameter);
  // }

  // public void testClassWithDefaultConstructorWithListParameter() {
  //   DefaultConstructorWithListParameter defaultConstructorWithListParameter = new DefaultConstructorWithListParameter();
  //   assertNotNull(defaultConstructorWithListParameter);
  // }

  // public void testClassWithDefaultConstructorWithMutableListParameter() {
  //   DefaultConstructorWithMutableListParameter defaultConstructorWithMutableListParameter = new DefaultConstructorWithMutableListParameter();
  //   assertNotNull(defaultConstructorWithMutableListParameter);
  // }

  public void testClassWithDefaultConstructorWithUserClassParameter() {
    DefaultConstructorWithUserClassParameter defaultConstructorWithUserClassParameter = new DefaultConstructorWithUserClassParameter();
    assertNotNull(defaultConstructorWithUserClassParameter);
  }

  public void testClassWithUnderscoresInItsName() {
    DefaultConstructorWithUserClassParameter defaultConstructorWithUserClassParameter = new DefaultConstructorWithUserClassParameter();
    assertNotNull(defaultConstructorWithUserClassParameter);
  }
}
