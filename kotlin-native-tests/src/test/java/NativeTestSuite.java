
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Returns a suite of all small tests in this package.
 */
public class NativeTestSuite {

    private static final Class<?>[] nativeTests =
        new Class<?>[]{
            ConstructorTests.class
        };

    public static Test suite() {
        return new TestSuite(nativeTests);
    }
}