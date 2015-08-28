import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class NormaleListeTest {
	
	NormaleListe liste = new NormaleListe();
	
	
	@Test
	public void sizeTest(){
		liste.add("eins");
		liste.add("zwei");
		liste.add("drei");
		Assert.assertTrue(liste.size() == 3);
	}
	
	@Test
	public void getAndAddTest(){
		liste.add("eins");
		liste.add("zwei");
		
		//Testing if the right value is returned and two out of index cases
		Assert.assertThat(liste.get(0), equalTo("eins"));
		Assert.assertThat(liste.get(4), equalTo(null));
		Assert.assertThat(liste.get(-4), equalTo(null));
	}
	
	@Test
	public void removeTest(){
		liste.add("eins");
		liste.add("zwei");
		liste.add("drei");
		//Testing if the right value is returned
		liste.remove(1);
		Assert.assertThat(liste.get(1), equalTo("drei"));
		
		//Creating a new List for matching
		NormaleListe neueListe = new NormaleListe();
		for (int i = 0; i < liste.size(); i++) {
			neueListe.add(liste.get(i));
		}
		
		//Testing two out of index cases
		liste.remove(-4);
		for (int i = 0; i < liste.size(); i++) {
			Assert.assertThat(liste.get(i), equalTo(neueListe.get(i)));
		}
		
		liste.remove(20);
		for (int i = 0; i < liste.size(); i++) {
			Assert.assertThat(liste.get(i), equalTo(neueListe.get(i)));
		}
	}
	
	@Test
	public void toStringTest(){
		liste.add("eins");
		liste.add("zwei");
		
		Assert.assertThat(liste.toString(), equalTo("eins zwei "));
	}
	
		
		

}
