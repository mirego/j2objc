
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
        assert(staticWithouParam.main(args) == "return");
    }

    @Test
    public void testStaticMethodWithStringParamsWithAnnotation() {
        StaticMethodWithStringParamWithAnnotation staticWithStringParam = new StaticMethodWithStringParamWithAnnotation();
        assert(staticWithStringParam.main(args) == "stringAsParam");
    }

    // todo javautilList vs NSArray
    // @Test
    // public void testStaticMethodWithListParamsWithAnnotation() {
    //     StaticMethodWithListParamWithAnnotation staticWithListParam = new StaticMethodWithListParamWithAnnotation();
    //     assert(staticWithListParam.main(args).get(0) != null);
    // }
}
