import com.mirego.interop.java.test.array.*;
import junit.framework.TestCase;
import org.junit.Test;

public class ArrayTests extends TestCase {

    private static final String[] NO_ARGS = {""};

    @Test
    public void testArrayLength() {
        Array1_length array1_length = new Array1_length();
        assertEquals("Empty: 0 - Single: 1 - Many: 5", array1_length.main(NO_ARGS));
    }

    @Test
    public void testArrayGet() {
        Array2_getAtIndex array2_getAtIndex = new Array2_getAtIndex();
        assertEquals("Item at index[3]: d", array2_getAtIndex.main(NO_ARGS));
    }

    @Test
    public void testArraySet() {
        Array3_setAtIndex array3_setAtIndex = new Array3_setAtIndex();
        assertEquals("From Java --> Item at index[3]: ZZZ\n" +
                "From Kotlin --> Item at index[3]: ZZZ", array3_setAtIndex.main(NO_ARGS));
    }

    @Test
    public void testEnhancedForLoop() {
        Array4_enhancedForLoop array4_enhancedForLoop = new Array4_enhancedForLoop();
        assertEquals("[abcde]", array4_enhancedForLoop.main(NO_ARGS));
    }

}
