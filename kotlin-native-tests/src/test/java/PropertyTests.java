
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
    assert(backingFieldWithCustomGetter.main(args) == "xxxxxx");
  }

  @Test
  public void testBackingFieldWithCustomSetter() {
    BackingFieldWithCustomSetter backingFieldWithCustomSetter = new BackingFieldWithCustomSetter();
    assert(backingFieldWithCustomSetter.main(args) == "xxxxxx");
  }

  @Test
  public void testBackingPropertyWithCustomGetter() {
    BackingPropertyWithCustomGetter backingPropertyWithCustomGetter = new BackingPropertyWithCustomGetter();
    assert(backingPropertyWithCustomGetter.main(args) == "xxxxxx");
  }

  @Test
  public void testBackingPropertyWithCustomSetter() {
    BackingPropertyWithCustomSetter backingPropertyWithCustomSetter = new BackingPropertyWithCustomSetter();
    assert(backingPropertyWithCustomSetter.main(args) == "xxxxxx");
  }

  @Test
  public void testBooleanProperty() {
    BooleanProperty booleanProperty = new BooleanProperty();
    assert(booleanProperty.main(args));
  }

  @Test
  public void testByteProperty() {
    ByteProperty byteProperty = new ByteProperty();
    assert(byteProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testCharProperty() {
    CharProperty charProperty = new CharProperty();
    assert(charProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testDoubleProperty() {
    DoubleProperty doubleProperty = new DoubleProperty();
    assert(doubleProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testEscapedStringProperty() {
    EscapedStringProperty escapedStringProperty = new EscapedStringProperty();
    assert(escapedStringProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testFloatProperty() {
    FloatProperty floatProperty = new FloatProperty();
    assert(floatProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testIntProperty() {
    IntProperty intProperty = new IntProperty();
    assert(intProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testLateInitializedProperty() {
    LateInitializedProperty lateInitializedProperty = new LateInitializedProperty();
    assert(lateInitializedProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testLateNonInitializedProperty() {
    LateNonInitializedProperty lateNonInitializedProperty = new LateNonInitializedProperty();
    assert(lateNonInitializedProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testListProperty() {
    ListProperty listProperty = new ListProperty();
    assert(listProperty.main(args) == Arrays.asList(1));
  }

  @Test
  public void testLongProperty() {
    LongProperty longProperty = new LongProperty();
    assert(longProperty.main(args) == 0L);
  }

  @Test
  public void testNullableBooleanProperty() {
    NullableBooleanProperty nullableBooleanProperty = new NullableBooleanProperty();
    assert(nullableBooleanProperty.main(args));
  }

  @Test
  public void testNullableProperty() {
    NullableProperty nullableProperty = new NullableProperty();
    assert(nullableProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testPublicImmutablePropertyWithGeneratedGetter() {
    PublicImmutablePropertyWithGeneratedGetter publicImmutablePropertyWithGeneratedGetter = new PublicImmutablePropertyWithGeneratedGetter();
    assert(publicImmutablePropertyWithGeneratedGetter.main(args) == "xxxxxx");
  }

  @Test
  public void testPublicMutablePropertyWithGeneratedSetter() {
    PublicMutablePropertyWithGeneratedSetter publicMutablePropertyWithGeneratedSetter = new PublicMutablePropertyWithGeneratedSetter();
    assert(publicMutablePropertyWithGeneratedSetter.main(args) == "xxxxxx");
  }

  @Test
  public void testRawStringProperty() {
    RawStringProperty rawStringProperty = new RawStringProperty();
    assert(rawStringProperty.main(args) == "xxxxxx");
  }

  @Test
  public void testShortProperty() {
    ShortProperty shortProperty = new ShortProperty();
    assert(shortProperty.main(args) == 0);
  }

  @Test
  public void testStringProperty() {
    StringProperty stringProperty = new StringProperty();
    assert(stringProperty.main(args) == "xxxxxx");
  }
  
}
