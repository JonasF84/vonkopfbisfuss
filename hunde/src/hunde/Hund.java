package hunde;

public class Hund {
	int gr��e;
	String rasse;
	String name;
	
	public Hund(int x, String r, String n){
		this.gr��e = x;
		this.rasse = r;
		this.name = n;
	}
	
	void bellen(){
		System.out.println("WAU! WAU!");
	}
	
	void namenNennen(){
		System.out.println(name);
	}
	
	void gr��eMessen(){
		System.out.println(gr��e);
	}
	
	void rasseAngucken(){
		System.out.println(rasse);
	}
}
