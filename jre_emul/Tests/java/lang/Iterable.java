package java.lang;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjobin on 15-01-15.
 */
public class Iterable extends TestCase {

    public void testMutablePtrChange() {
        List<String> firstList = new ArrayList<String>();

        for(String str : firstList) {

        }

    }

}
