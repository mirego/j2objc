
import com.mirego.interop.java.test.constructor.WithoutConstructor;

import org.junit.Test;

public class ConstructorTests {

    @Test
    public void testWithoutConstructor() {

        WithoutConstructor test = new WithoutConstructor();

        assert (test != null);
    }
}
