
import com.mirego.interop.java.test.constructor.*;
import junit.framework.TestCase;
import org.junit.Test;

public class ConstructorTests extends TestCase {

    @Test
    public void testWithoutConstructor() {
        WithoutConstructor withoutConstructor = new WithoutConstructor();
        assert (withoutConstructor != null);
    }

     @Test
     public void testClassWithDefaultConstructor() {
         DefaultConstructor defaultConstructor = new DefaultConstructor();
         assert (defaultConstructor != null);
     }

     @Test
     public void testClassWithDefaultConstructorMultipleParameters() {
         DefaultConstructorMultipleParameters defaultConstructorMultipleParameters = new DefaultConstructorMultipleParameters();
         assert (defaultConstructorMultipleParameters != null);
     }

     @Test
     public void testClassWithDefaultConstructorWithDefaultValue() {
         DefaultConstructorWithDefaultValue defaultConstructorWithDefaultValue = new DefaultConstructorWithDefaultValue();
         assert (defaultConstructorWithDefaultValue != null);
     }

     @Test
     public void testClassWithDefaultConstructorWithInitBlock() {
         DefaultConstructorWithInitBlock defaultConstructorWithInitBlock = new DefaultConstructorWithInitBlock();
         assert (defaultConstructorWithInitBlock != null);
     }

     @Test
     public void testClassWithDefaultConstructorWithMultipleInitBlocks() {
         DefaultConstructorWithMultipleInitBlocks defaultConstructorWithMultipleInitBlocks = new DefaultConstructorWithMultipleInitBlocks();
         assert (defaultConstructorWithMultipleInitBlocks != null);
     }

     @Test
     public void testClassWithDefaultConstructorWithPrivateProperty() {
         DefaultConstructorWithPrivateProperty defaultConstructorWithPrivateProperty = new DefaultConstructorWithPrivateProperty();
         assert (defaultConstructorWithPrivateProperty != null);
     }

     @Test
     public void testClassWithSecondaryConstructor() {
         SecondaryConstructor secondaryConstructor = new SecondaryConstructor();
         assert (secondaryConstructor != null);
     }

      @Test
      public void testClassWithDefaultConstructorWithIntParameter() {
          DefaultConstructorWithIntParameter defaultConstructorWithIntParameter = new DefaultConstructorWithIntParameter();
          assert (defaultConstructorWithIntParameter != null);
      }

      @Test
      public void testClassWithDefaultConstructorWithNullableIntParameter() {
        DefaultConstructorWithNullableIntParameter defaultConstructorWithNullableIntParameter = new DefaultConstructorWithNullableIntParameter();
        assert (defaultConstructorWithNullableIntParameter != null);
      }

      @Test
      public void testClassWithDefaultConstructorWithListParameter() {
        DefaultConstructorWithListParameter defaultConstructorWithListParameter = new DefaultConstructorWithListParameter();
        assert (defaultConstructorWithListParameter != null);
      }

      @Test
      public void testClassWithDefaultConstructorWithMutableListParameter() {
        DefaultConstructorWithMutableListParameter defaultConstructorWithMutableListParameter = new DefaultConstructorWithMutableListParameter();
        assert (defaultConstructorWithMutableListParameter != null);
      }

      @Test
      public void testClassWithDefaultConstructorWithUserClassParameter() {
        DefaultConstructorWithUserClassParameter defaultConstructorWithUserClassParameter = new DefaultConstructorWithUserClassParameter();
        assert (defaultConstructorWithUserClassParameter != null);
      }
}
