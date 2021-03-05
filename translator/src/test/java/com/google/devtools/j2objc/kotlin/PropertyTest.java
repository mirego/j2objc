package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;
import com.mirego.interop.java.test.property.BackingFieldWithCustomGetter;
import com.mirego.interop.java.test.property.BackingFieldWithCustomSetter;
import com.mirego.interop.java.test.property.BackingPropertyWithCustomSetter;
import com.mirego.interop.java.test.property.BooleanProperty;
import com.mirego.interop.java.test.property.ByteProperty;
import com.mirego.interop.java.test.property.CharProperty;
import com.mirego.interop.java.test.property.DoubleProperty;
import com.mirego.interop.java.test.property.EscapedStringProperty;
import com.mirego.interop.java.test.property.FloatProperty;
import com.mirego.interop.java.test.property.IntProperty;
import com.mirego.interop.java.test.property.LateInitializedProperty;
import com.mirego.interop.java.test.property.LongProperty;
import com.mirego.interop.java.test.property.NullableBooleanProperty;
import com.mirego.interop.java.test.property.NullableProperty;
import com.mirego.interop.java.test.property.PublicImmutablePropertyWithGeneratedGetter;
import com.mirego.interop.java.test.property.PublicMutablePropertyWithGeneratedSetter;
import com.mirego.interop.java.test.property.ShortProperty;
import com.mirego.interop.java.test.property.StringProperty;
import java.io.IOException;
import org.junit.Test;

public class PropertyTest extends GenerationTest {

  final private static String testPackage = "property/";

  @Test
  public void testBackingFieldWithCustomGetter() throws IOException {

    String className = BackingFieldWithCustomGetter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithBackingFieldCustomGetter backedField]");
  }

  // todo param names
  @Test
  public void testBackingFieldWithCustomSetter() throws IOException {

    String className = BackingFieldWithCustomSetter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "  [classWithBackingFieldCustomGetter setBackedField:@\"backed\"];\n"
                                          + "  return [classWithBackingFieldCustomGetter backedField];");
  }

  // todo getter not found
//  @Test
//  public void testBackingPropertyWithCustomGetter() throws IOException {
//
//    String className = BackingPropertyWithCustomGetter.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxxx");
//  }

  // todo setter not found
//  @Test
//  public void testBackingPropertyWithCustomSetter() throws IOException {
//
//    String className = BackingPropertyWithCustomSetter.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxxx");
//  }

  @Test
  public void testBooleanProperty() throws IOException {

    String className = BooleanProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithBooleanProperty boolean]");
  }

  @Test
  public void testByteProperty() throws IOException {

    String className = ByteProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithByteProperty byte]");
  }

  @Test
  public void testCharProperty() throws IOException {

    String className = CharProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithCharProperty char]");
  }

  @Test
  public void testDoubleProperty() throws IOException {

    String className = DoubleProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "[classWithDoubleProperty double]");
  }

  @Test
  public void testEscapedStringProperty() throws IOException {

    String className = EscapedStringProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "xxxxxxx");
  }

  @Test
  public void testFloatProperty() throws IOException {

    String className = FloatProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithFloatProperty float]");
  }

  @Test
  public void testIntProperty() throws IOException {

    String className = IntProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithIntProperty int]");
  }

  @Test
  public void testLongProperty() throws IOException {

    String className = LongProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithLongProperty long]");
  }

  @Test
  public void testShortProperty() throws IOException {

    String className = ShortProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithShortProperty short]");
  }

  @Test
  public void testStringProperty() throws IOException {

    String className = StringProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithStringProperty string]");
  }

  @Test
  public void testLateInitializedProperty() throws IOException {

    String className = LateInitializedProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [classWithBackingPropertyCustomSetter lateInitializedProperty]");
  }

  // todo throws in native test ... need to investigate
//  @Test
//  public void testLateNonInitializedProperty() throws IOException {
//
//    String className = LateNonInitializedProperty.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxxx");
//  }

  // todo param type not compatible
//  @Test
//  public void testListProperty() throws IOException {
//
//    String className = ListProperty.class.getSimpleName();
//    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
//
//    assertTranslation(translation, "xxxxxxx");
//  }

  @Test
  public void testNullableBooleanProperty() throws IOException {

    String className = NullableBooleanProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [((JavaLangBoolean *) nil_chk([classWithNullableBooleanProperty boolean])) booleanValue]");
  }

  @Test
  public void testNullableProperty() throws IOException {

    String className = NullableProperty.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [nullablePropertyClass nullableProperty]");
  }

  @Test
  public void testPublicImmutablePropertyWithGeneratedGetter() throws IOException {

    String className = PublicImmutablePropertyWithGeneratedGetter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "return [immutablePropertyClass immutableProperty]");
  }

  // todo param names
  @Test
  public void testPublicMutablePropertyWithGeneratedSetter() throws IOException {

    String className = PublicMutablePropertyWithGeneratedSetter.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(translation, "  [mutablePropertyClass setMutableProperty:@\"mutatedMutableProperty\"];\n"
                                          + "  return [mutablePropertyClass mutableProperty];");
  }
}
