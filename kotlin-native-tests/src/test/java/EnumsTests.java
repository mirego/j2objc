
import com.mirego.interop.java.test.enums.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class EnumsTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testSimpleEnumAccessValue1() {
        SimpleEnumAccessValue1 simpleEnumAccessValue1 = new SimpleEnumAccessValue1();
        assert (simpleEnumAccessValue1.main(args) == "ENUMVALUE1");
    }

    @Test
    public void testSimpleEnumAccessValue2() throws IOException {
        SimpleEnumAccessValue2 simpleEnumAccessValue2 = new SimpleEnumAccessValue2();
        assert (simpleEnumAccessValue2.main(args) == "ENUM_VALUE2");
    }

    @Test
    public void testSimpleEnumAccessValue3() throws IOException {
        SimpleEnumAccessValue3 simpleEnumAccessValue3 = new SimpleEnumAccessValue3();
        assert (simpleEnumAccessValue3.main(args) == "ENUM_VALUE_3");
    }

    // not working need to fix enum .values() access and return value in for loop is IOSObjectArray with does not seem to match KotlinArray
//    @Test
//    public void testSimpleEnumValues() throws IOException {
//        SimpleEnumValues simpleEnumValues = new SimpleEnumValues();
//        assert (simpleEnumValues.main(args) == "xxxxx");
//    }

    @Test
    public void testSimpleEnumOrdinal() throws IOException {
        SimpleEnumOrdinal simpleEnumOrdinal = new SimpleEnumOrdinal();
        assert (simpleEnumOrdinal.main(args) == 0);
    }

    @Test
    public void testSimpleEnumSwitchCase() throws IOException {
        SimpleEnumSwitchCase simpleEnumSwitchCase = new SimpleEnumSwitchCase();
        assert (simpleEnumSwitchCase.main(args) == 0);
    }

    @Test
    public void testEnumWithPropertyAccessProperty() throws IOException {
        EnumWithPropertyAccessProperty enumWithPropertyAccessProperty = new EnumWithPropertyAccessProperty();
        assert (enumWithPropertyAccessProperty.main(args) == "xx");
    }
}
