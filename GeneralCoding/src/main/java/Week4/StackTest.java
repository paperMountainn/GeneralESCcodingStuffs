package Week4;//package Week4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {
	private Stack<Integer> stack;
	// setUp method using @Before syntax
	// @Before methods are run before each test
	@Before 
	public void runBeforeEachTest()
	{
		System.out.println("setting up");
		
	    stack = new Stack<Integer>();
	}

	// tear-down method using @After
	// @After methods are run after each test
	// set-up and clean up activity
	// single test for one objective because might make debugging difficult
	@After 
	public void runAfterEachTest()
	{
	    stack = null;
		System.out.println("setting down");
	}

	@Test public void testToString()
	{
		System.out.println("testing");
	   stack.push(new Integer(1));
	   stack.push(new Integer(2));
	   assertEquals ("{2, 1}", stack.toString());
	}


	// test repo
	@Test
	public void test1(){
		boolean result = stack.repOK();
		assertTrue(result);
	}

	// test push
	@Test
	public void test2(){
		stack.push (new Integer (1));
		boolean result = stack.repOK();
		assertTrue(result);
	}

	// test pop
	@Test
	public void test3(){
		stack.pop();
		boolean result = stack.repOK();
		assertTrue(result);
	}

	// test push and pop
	@Test
	public void test4(){
		stack.push (new Integer (1));
		stack.pop();
		boolean result = stack.repOK();
		assertTrue(result);
	}



	// break down testRepoOk() into 4 different unit test

}
