
import com.mirego.interop.java.test.constructor.WithoutConstructor;
import junit.framework.TestCase;
import org.junit.Test;


public class Constructor2Tests extends TestCase {

    @Test
    public void testWithoutConstructor() {

        WithoutConstructor test = new WithoutConstructor();

        assert (test != null);
    }
}
