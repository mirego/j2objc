
import com.mirego.interop.java.test.constructor.WithoutConstructor;

import org.junit.Test;

public class Constructor2Tests {

    @Test
    public void testWithoutConstructor() {

        WithoutConstructor test = new WithoutConstructor();

        assert (test != null);
    }
}
