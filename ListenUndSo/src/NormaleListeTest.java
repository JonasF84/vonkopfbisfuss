import org.junit.Test;
import org.junit.Assert;

public class NormaleListeTest {
	
	NormaleListe liste = new NormaleListe();
	
	//assertArrayEquals
	
	@Test
	public void getTest(){
		liste.add("eins");
		liste.add("zwei");
		liste.add("drei");
		//Assert.assertThat(actual, matcher);
		
		Assert.assertTrue(liste.size() >= 0);
	}
		
		

}
