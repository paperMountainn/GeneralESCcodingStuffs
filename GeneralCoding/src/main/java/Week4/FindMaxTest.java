package Week4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindMaxTest {
    private FindMax findMax;
    // setUp method using @Before syntax
    // @Before methods are run before each test
    @Before
    public void runBeforeEachTest()
    {
        System.out.println("setting up");

    }

    @Test
    public void testMaxOk(){
        int[] list = {5,6,17,8,2};
        int max = FindMax.max(list);
        assertEquals(17, max );
    }

    @Test(expected = AssertionError.class)
    public void testMaxOk1(){
        int[] list = {5,6,17,8,2,18};
        int max = FindMax.max(list);
        assertEquals(18, max );
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMaxOk2(){
        int[] list = {};
        int max = FindMax.max(list);
    }

    // before this, we write unit tests and then it throws an error
    // if it throws an error, we complain to the developer to change something
    // we only use expected if we EXPECT the function to throw an exception, which is WHAT THE DEVELOPER WANTS
    // in this context, we assume that we DO NOT HAVE MODIFICATION RIGHTS TO FindMax

    // tear-down method using @After
    // @After methods are run after each test
    // set-up and clean up activity
    // single test for one objective because might make debugging difficult
    @After
    public void runAfterEachTest()
    {
        System.out.println("setting down");
    }
}
