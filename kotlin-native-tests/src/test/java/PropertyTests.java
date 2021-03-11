
import com.mirego.interop.java.test.property.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class PropertyTests extends TestCase {

  private static final String[] args = {""};
  
  @Test
  public void testBackingFieldWithCustomGetter() {
    BackingFieldWithCustomGetter backingFieldWithCustomGetter = new BackingFieldWithCustomGetter();
    assert(backingFieldWithCustomGetter.main(args) == "backed field");
  }
  
  @Test
  public void testBackingFieldWithCustomSetter() {
    BackingFieldWithCustomSetter backingFieldWithCustomSetter = new BackingFieldWithCustomSetter();
    assert(backingFieldWithCustomSetter.main(args) == "backed field");
  }
  
 @Test
 public void testBackingPropertyWithCustomGetter() {
   BackingPropertyWithCustomGetter backingPropertyWithCustomGetter = new BackingPropertyWithCustomGetter();
   assert(backingPropertyWithCustomGetter.main(args) == "backed property");
 }
 
 @Test
 public void testBackingPropertyWithCustomSetter() {
   BackingPropertyWithCustomSetter backingPropertyWithCustomSetter = new BackingPropertyWithCustomSetter();
   assert(backingPropertyWithCustomSetter.main(args) == "backed property");
 }

 @Test
 public void testBooleanProperty() {
   BooleanProperty booleanProperty = new BooleanProperty();
   assert(!booleanProperty.main(args));
 }

 @Test
 public void testByteProperty() {
   ByteProperty byteProperty = new ByteProperty();
   assert(byteProperty.main(args) == 1);
 }

 @Test
 public void testCharProperty() {
   CharProperty charProperty = new CharProperty();
   assert(charProperty.main(args) == 'a');
 }

 @Test
 public void testDoubleProperty() {
   DoubleProperty doubleProperty = new DoubleProperty();
   assert(doubleProperty.main(args) == 0.1D);
 }

 @Test
 public void testEscapedStringProperty() {
   EscapedStringProperty escapedStringProperty = new EscapedStringProperty();
   assert(escapedStringProperty.main(args) == "testString\n");
 }

 @Test
 public void testFloatProperty() {
   FloatProperty floatProperty = new FloatProperty();
   assert(floatProperty.main(args) == 0.1f);
 }

 @Test
 public void testIntProperty() {
   IntProperty intProperty = new IntProperty();
   assert(intProperty.main(args) == 1);
 }

 @Test
 public void testLateInitializedProperty() {
   LateInitializedProperty lateInitializedProperty = new LateInitializedProperty();
   assert(lateInitializedProperty.main(args) == "initialized");
 }

// todo this throws but we cannot catch it since java code does not throw
//  @Test
//  public void testLateNonInitializedProperty() {
//    LateNonInitializedProperty lateNonInitializedProperty = new LateNonInitializedProperty();
//     lateNonInitializedProperty.main(args);
//  }

// todo param type not compatible
//  @Test
//  public void testListProperty() {
//    ListProperty listProperty = new ListProperty();
//    assert(listProperty.main(args) == Arrays.asList(""));
//  }

 @Test
 public void testLongProperty() {
   LongProperty longProperty = new LongProperty();
   assert(longProperty.main(args) == 1L);
 }

 @Test
 public void testShortProperty() {
   ShortProperty shortProperty = new ShortProperty();
   assert(shortProperty.main(args) == 1);
 }

 @Test
 public void testStringProperty() {
   StringProperty stringProperty = new StringProperty();
   assert(stringProperty.main(args) == "testString");
 }

  @Test
  public void testCharSequenceProperty() {
    CharSequenceProperty charSequenceProperty = new CharSequenceProperty();
    assert(charSequenceProperty.main(args) == "1000");
  }

// todo this throw because j2objc adds a nilcheck ...
@Test
 public void testNullableBooleanProperty() {
   boolean nullPointerException = false;
   NullableBooleanProperty nullableBooleanProperty = new NullableBooleanProperty();
   try {
      nullableBooleanProperty.main(args);
   } catch (NullPointerException e) {
     nullPointerException = true;
   }
    assert(nullPointerException);
 }

 @Test
 public void testNullableProperty() {
   NullableProperty nullableProperty = new NullableProperty();
   assert(nullableProperty.main(args) == null);
 }

 @Test
 public void testPublicImmutablePropertyWithGeneratedGetter() {
   PublicImmutablePropertyWithGeneratedGetter publicImmutablePropertyWithGeneratedGetter = new PublicImmutablePropertyWithGeneratedGetter();
   assert(publicImmutablePropertyWithGeneratedGetter.main(args) == "immutableProperty");
 }
 
  @Test
  public void testPublicMutablePropertyWithGeneratedSetter() {
    PublicMutablePropertyWithGeneratedSetter publicMutablePropertyWithGeneratedSetter = new PublicMutablePropertyWithGeneratedSetter();
    assert(publicMutablePropertyWithGeneratedSetter.main(args) == "mutatedMutableProperty");
  }
}
