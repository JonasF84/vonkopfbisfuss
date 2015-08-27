import junit.framework.*;
public class JunitTestSuite {

	public static void main(String[] args) {
		TestSuite suite = new TestSuite(TestJUnit2.class, TestJunit3.class, TestJunit1.class);
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("Number of test cases = " + result.runCount());

	}

}
