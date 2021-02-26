
import com.mirego.interop.java.test.interfaces.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class InterfacesTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testInterfaceWithInt() {
        WithInt withInt = new WithInt();
        assert (withInt.main(args) == 1);
    }

    @Test
    public void testInterfaceWithNullableInt() {
        WithNullableInt withNullableInt = new WithNullableInt();
        assert (withNullableInt.main(args) == Integer.valueOf(1));
    }

    @Test
    public void testInterfaceWithList() {
        WithList withList = new WithList();
        List list = withList.main(args);
        assert (list.get(0) == Integer.valueOf(1));
    }
}
