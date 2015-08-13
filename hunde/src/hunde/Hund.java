package hunde;

public class Hund {
	int größe;
	String rasse;
	String name;
	
	public Hund(int x, String r, String n){
		this.größe = x;
		this.rasse = r;
		this.name = n;
	}
	
	void bellen(){
		System.out.println("WAU! WAU!");
	}
	
	void namenNennen(){
		System.out.println(name);
	}
	
	void größeMessen(){
		System.out.println(größe);
	}
	
	void rasseAngucken(){
		System.out.println(rasse);
	}
}
