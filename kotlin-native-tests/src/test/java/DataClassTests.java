
import com.mirego.interop.java.test.dataclass.*;
import junit.framework.TestCase;
import org.junit.Test;

public class DataClassTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testSimpleDataClassConstructor() {
        SimpleDataClassConstructor simpleDataClassConstructor = new SimpleDataClassConstructor();
        assert (simpleDataClassConstructor.main(args) != null);
    }

    @Test
    public void testSimpleDataGetter() {
        SimpleDataClassGetter simpleDataClassGetter = new SimpleDataClassGetter();
        assert (simpleDataClassGetter.main(args) == "dataClassName");
    }

    @Test
    public void testSimpleDataComponentGetter() {
        SimpleDataClassComponentGetter simpleDataClassComponentGetter = new SimpleDataClassComponentGetter();
        assert (simpleDataClassComponentGetter.main(args) == "dataClassName");
    }

    @Test
    public void testSimpleDataEquals() {
        SimpleDataClassEquals simpleDataClassEquals = new SimpleDataClassEquals();
        assert (simpleDataClassEquals.main(args) == true);
    }

// todo copy is called doCopy, but it's not worth fixing for now since it takes all params like the constructor.
//    @Test
//    public void testSimpleDataClassCopy() {
//        SimpleDataClassCopy simpleDataClassCopy = new SimpleDataClassCopy();
//        assert (simpleDataClassCopy.main(args) == true);
//    }
}
