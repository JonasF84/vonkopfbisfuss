import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestJunit3 extends TestCase {
	protected double fValue1;
	protected double fValue2;
	
	@Before
	public void setUp(){
		fValue1 = 2.0;
		fValue2 = 3.0;
	}
	
	@Test
	public void testAdd(){
		System.out.println("Number of Test Cases = " + this.countTestCases());
		
		String name = this.getName();
		System.out.println("Test Case Name = " + name);
		
		this.setName("testNewAdd");
		String newName = this.getName();
		System.out.println("Update Test Case Name = " + newName);
	}
	
	public void tearDown(){
		
	}

}
