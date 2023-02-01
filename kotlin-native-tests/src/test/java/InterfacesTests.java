
import com.mirego.interop.java.test.interfaces.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class InterfacesTests extends TestCase {

    private static final String[] args = {""};

    // @Test
    public void testInterfaceWithInt() {
        WithInt withInt = new WithInt();
        assertEquals(1, withInt.main(args));
    }

    @Test
    public void testInterfaceWithNullableInt() {
        WithNullableInt withNullableInt = new WithNullableInt();
        assertEquals(Integer.valueOf(1), withNullableInt.main(args));
    }

    // @Test
    public void testInterfaceWithList() {
        WithList withList = new WithList();
        List list = withList.main(args);
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void testInterfaceWithGenerics() {
        WithGenerics withGenerics = new WithGenerics();
        assertEquals(Integer.valueOf(9), withGenerics.main(args));
    }

}
