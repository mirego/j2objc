import com.mirego.interop.java.test.collections.*;
import junit.framework.TestCase;
import org.junit.Test;

public class CollectionsTests extends TestCase {

    private static final String[] NO_ARGS = {""};

    @Test
    public void testLoopThroughtList() {
        LoopThroughList loopThroughList = new LoopThroughList();
        assertEquals("ABCDE", loopThroughList.main(NO_ARGS));
    }

    @Test
    public void testLoopThroughtMutableList() {
        LoopThroughMutableList loopThroughMutableList = new LoopThroughMutableList();
        assertEquals("12345", loopThroughMutableList.main(NO_ARGS));
    }
}