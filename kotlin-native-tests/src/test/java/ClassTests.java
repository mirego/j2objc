import com.mirego.interop.java.test.constructor.*;
import junit.framework.TestCase;
import org.junit.Test;

public class ClassTests extends TestCase {

    private static final String[] NO_ARGS = {""};

    @Test
    public void testClassVariable() {
        KotlinClassVariable testClass = new KotlinClassVariable();
        assertEquals("CommonClassWithDefaultConstructor", testClass.main(NO_ARGS));
      }
}
