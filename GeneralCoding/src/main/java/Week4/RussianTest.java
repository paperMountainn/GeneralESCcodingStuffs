package Week4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RussianTest {

    // pass for positive numbers
    @Test
    public void test1WB() {
        int expected = 12;
        int actual = Russian.multiply(6, 2);
        assertEquals(expected, actual);
        //question: should we assert the returned value is the exact value we expect?
    }

    // pass for o
    @Test
    public void test2WB() {
        int expected = 0;
        int actual = Russian.multiply(0, 0);
        assertEquals(expected, actual);
        //question: should we assert the returned value is the exact value we expect?
    }

    // fails for negative numbers
    @Test
    public void test3WB() {
        int expected = 36;
        int actual = Russian.multiply(-6, -6);
        assertEquals(expected, actual);
        //question: should we assert the returned value is the exact value we expect?
    }


    // fails for float
    // cannot compile
    @Test
    public void test4WB() {
        int expected = 36;
        int actual = Russian.multiply(6, 6); // suppose to put 6.0, 6.0 here but cant compile so left it as it is
        assertEquals(expected, actual);
    }


    // works to cover all branches
    @Test
    public void test1BB(){
        int expected = 30;
        int actual = Russian.multiply(6, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test2BB(){
        int expected = 12;
        int actual = Russian.multiply(6, 2);
        assertEquals(expected, actual);

    }

    // fault-based test
    // create mutant code called RussianMutant1
    // for RussianMutant1, when n is a multiple of 2, does not add to product
    // we then compare between the original method and the mutant method
    @Test
    public void faultBasedTes1t() {
        assertEquals(Russian.multiply(10, 10), 10 * 10);
    }

    @Test
    public void faultBasedTestMutant1() {
        assertNotEquals(RussianMutant1.multiply(10, 10), 10 * 10);
    }

    // create mutant code called RussianMutant2
    // for RussianMutant1, when n = 1, does not compute
    // we then compare between the original method and the mutant method

    @Test
    public void faultBasedTest2() {

        assertEquals(Russian.multiply(10, 10), 10 * 10);
    }

    @Test
    public void faultBasedTestMutant2() {
        assertNotEquals(RussianMutant2.multiply(10, 10), 10 * 10);
    }





}

