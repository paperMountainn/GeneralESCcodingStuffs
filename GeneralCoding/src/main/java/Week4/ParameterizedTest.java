package Week4;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

// sudiptac: include this for running parameterized tests
// Template for Parameterized tests
@RunWith(Parameterized.class)

public class ParameterizedTest {
	public int sum, a, b;
    
	// classic constructor
	public ParameterizedTest (int sum, int a, int b) { 
    	this.sum = sum; 
    	this.a = a; 
    	this.b = b; 
    }

	 // sudiptac: decide the list of parameters to be sent to the class

	// writing the parameterized test is exactly the same as assertEquals() statements
	// not as intuitive as the normal assertEquals statements
   @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList (new Object [][] {{0, 0, 0}, {2, 1, 1}, {2, 2, 2}});
    }

	 // sudiptac: This test is invoked for each of the parameter sent via parameters()	
   @Test public void additionTest() { 

		assertEquals(sum, Sum.sum(a, b));
   }
}
