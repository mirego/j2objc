
import com.mirego.interop.java.test.objects.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class ObjectsTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testStaticMethodWithoutParamsWithAnnotation() {
        StaticMethodWithoutParamWithAnnotation staticWithouParam = new StaticMethodWithoutParamWithAnnotation();
        assertEquals("return", staticWithouParam.main(args));
    }

    @Test
    public void testStaticMethodWithStringParamsWithAnnotation() {
        StaticMethodWithStringParamWithAnnotation staticWithStringParam = new StaticMethodWithStringParamWithAnnotation();
        assertEquals("stringAsParam", staticWithStringParam.main(args));
    }

    @Test
    public void testStaticMethodWithGenericParamsWithAnnotation() {
        StaticMethodWithGenericParamWithAnnotation staticMethodWithGenericParam = new StaticMethodWithGenericParamWithAnnotation();
        assertEquals("stringGeneric", staticMethodWithGenericParam.main(args));
    }

    // todo javautilList vs NSArray
    // @Test
    // public void testStaticMethodWithListParamsWithAnnotation() {
    //     StaticMethodWithListParamWithAnnotation staticWithListParam = new StaticMethodWithListParamWithAnnotation();
    //     assert(staticWithListParam.main(args).get(0) != null);
    // }
}
