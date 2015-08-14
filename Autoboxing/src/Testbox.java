
public class Testbox {
	Integer i;
	int j;
	
	public static void main(String[] args) {
		Testbox t = new Testbox();
		t.los();
		

	}
	
	public void los(){
		j= i;
		System.out.println(j);
		System.out.println(i);
	}

}
