
import com.mirego.interop.java.test.objects.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class ObjectsTests extends TestCase {

    private static final String[] args = {""};

    @Test
    public void testStaticMethodWithoutParamsWithAnnotation() {
        StaticMethodWithoutParamWithAnnotation test = new StaticMethodWithoutParamWithAnnotation();
        assert(test.main(args) == "return");
    }
}