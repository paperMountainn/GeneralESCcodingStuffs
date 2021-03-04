package Week4;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

// write this myself
// sudiptac: include this for running parameterized tests
//which one will fail will be shown in the subscript
@RunWith(Parameterized.class)

public class ParameterizedQuickSort {
    public int[] actual;
    public int[] expected;

    // classic constructor
    public ParameterizedQuickSort(int[] expected, int[] actual) {
        this.actual = actual;
        this.expected = expected;
     }

    // sudiptac: decide the list of parameters to be sent to the class

    // writing the parameterized test is exactly the same as assertEquals() statements
    // not as intuitive as the normal assertEquals statements
    @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList (
                new Object [][] {
                        // expected, actual
                        // pass these 2 into the constructor and run the test automatically
                        {new int[] {1, 2, 3}, new int[]{3, 2, 1}},
                        {new int[] {1, 2, 3, 6}, new int[] {6, 3, 2, 1}}
                }
                );
    }

    // sudiptac: This test is invoked for each of the parameter sent via parameters()
    // assertarray equals is also available for Junit tests, but complete this first
    @Test public void sortingTest() {
        QuickSort sort = new QuickSort();
        sort.sort(actual);
        assertArrayEquals(expected, actual);
    }
// useless code
//    private boolean testArrayEqual(int[] expected, int[] input){
//
//        return true;
//    }
}
