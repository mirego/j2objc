
import com.mirego.interop.java.test.enums.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class EnumsTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testSimpleEnumAccessValue1() {
        SimpleEnumAccessValue1 simpleEnumAccessValue1 = new SimpleEnumAccessValue1();
        assertEquals ("ENUMVALUE1", simpleEnumAccessValue1.main(args));
    }

    @Test
    public void testSimpleEnumAccessValue2() throws IOException {
        SimpleEnumAccessValue2 simpleEnumAccessValue2 = new SimpleEnumAccessValue2();
        assertEquals ("ENUM_VALUE2", simpleEnumAccessValue2.main(args));
    }

    @Test
    public void testSimpleEnumAccessValue3() throws IOException {
        SimpleEnumAccessValue3 simpleEnumAccessValue3 = new SimpleEnumAccessValue3();
        assertEquals ("ENUM_VALUE_3", simpleEnumAccessValue3.main(args));
    }
    
//    @Test
//    public void testSimpleEnumValues() throws IOException {
//        SimpleEnumValues simpleEnumValues = new SimpleEnumValues();
//        assertEquals ("ENUMVALUE1ENUM_VALUE2ENUM_VALUE_3", simpleEnumValues.main(args));
//    }

    @Test
    public void testSimpleEnumOrdinal() throws IOException {
        SimpleEnumOrdinal simpleEnumOrdinal = new SimpleEnumOrdinal();
        assertEquals (0, simpleEnumOrdinal.main(args));
    }

    @Test
    public void testSimpleEnumSwitchCase() throws IOException {
        SimpleEnumSwitchCase simpleEnumSwitchCase = new SimpleEnumSwitchCase();
        assertEquals (1, simpleEnumSwitchCase.main(args));
    }

    // todo need to cast access to property
//    @Test
//    public void testEnumWithPropertyAccessProperty() throws IOException {
//        EnumWithPropertyAccessProperty enumWithPropertyAccessProperty = new EnumWithPropertyAccessProperty();
//        assertEquals ("xx", enumWithPropertyAccessProperty.main(args));
//    }
}
