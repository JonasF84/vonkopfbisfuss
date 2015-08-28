import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class VerketteteListeTest {
	
	VerketteteListe liste = new VerketteteListe();
	
	
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
		liste.remove(1);
		
		Assert.assertThat(liste.get(1), equalTo("drei"));
		
		liste.remove(0);
		Assert.assertThat(liste.get(0), equalTo("drei"));
		
		liste.add("vier");
		liste.add("fünf");
		liste.remove(3);
		Assert.assertThat(liste.getSize(), equalTo(3));
	}
	

}
