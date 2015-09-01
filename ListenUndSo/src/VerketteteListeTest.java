import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith (Parameterized.class)
public class VerketteteListeTest {
	VerketteteListe liste;
	private int inputNumber;
	private String expectedResult;

	
	@Before
	public void initialize(){
		liste = new VerketteteListe();		
	}
	
	public VerketteteListeTest(int inputNumber, String expectedResult){
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection cases(){
		return Arrays.asList(new Object[][]{
			{1, "drei"},
			{-1, "ung�ltiger wert"},
			{7, "ung�ltiger wert"},
			{0, "zwei"},
			{4, "index ist zu gro�"}
		});
	}
			
	@Test
	public void getSizeAndAddTest(){
		liste.add("eins");
		liste.add("zwei");
		liste.add("drei");
		Assert.assertThat(liste.getSize(), equalTo(3));
	}
	
	@Test
	public void getTest(){
		liste.add("eins");
		liste.add("zwei");
		Assert.assertThat(liste.get(0), equalTo("eins"));
	}	
	
	@Test
	public void removeTest(){
		liste.add("eins");
		liste.add("zwei");
		liste.add("drei");
		liste.add("vier");
		liste.add("f�nf");
		
		try {
			liste.remove(inputNumber);
			Assert.assertThat(liste.get(inputNumber), equalTo(expectedResult));			
		} 
		catch (IndexOutOfBoundsException e) {
			Assert.assertThat(e.getMessage(), equalTo(expectedResult));
		}
	}
}