
import com.mirego.interop.java.test.objects.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class ObjectsTests extends TestCase {

    private static final String[] NO_ARGS = {""};

    @Test
    public void testStaticMethodWithoutParamsWithAnnotation() {
        StaticMethodWithoutParamWithAnnotation staticWithouParam = new StaticMethodWithoutParamWithAnnotation();
        assertEquals("return", staticWithouParam.main(NO_ARGS));
    }

    @Test
    public void testStaticMethodWithStringParamsWithAnnotation() {
        StaticMethodWithStringParamWithAnnotation staticWithStringParam = new StaticMethodWithStringParamWithAnnotation();
        assertEquals("stringAsParam", staticWithStringParam.main(NO_ARGS));
    }

    @Test
    public void testStaticMethodWithGenericParamsWithAnnotation() {
        StaticMethodWithGenericParamWithAnnotation staticMethodWithGenericParam = new StaticMethodWithGenericParamWithAnnotation();
        assertEquals("stringGeneric", staticMethodWithGenericParam.main(NO_ARGS));
    }

    // todo javautilList vs NSArray
//     @Test
//     public void testStaticMethodWithListParamsWithAnnotation() {
//         StaticMethodWithListParamWithAnnotation staticWithListParam = new StaticMethodWithListParamWithAnnotation();
//         assert(staticWithListParam.main(NO_ARGS).get(0) != null);
//     }

    @Test
    public void testWithCompanionObject() {
        WithCompanionObject withCompanionObject = new WithCompanionObject();
        assertEquals("companionStringfunctionString", withCompanionObject.main(NO_ARGS));
    }

    @Test
    public void testWithNamedCompanionObject() {
        WithNamedCompanionObject withNamedCompanionObject = new WithNamedCompanionObject();
        assertEquals("namedCompanionString", withNamedCompanionObject.main(NO_ARGS));
    }

    @Test
    public void testWithObject() {
        WithObject withObject = new WithObject();
        assertEquals("objectString", withObject.main(NO_ARGS));
    }

    @Test
    public void testStaticMethodWithoutParams() {
        StaticMethodWithoutParam staticMethodWithoutParam = new StaticMethodWithoutParam();
        assertEquals("return", staticMethodWithoutParam.main(NO_ARGS));
    }
}
