
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
}
