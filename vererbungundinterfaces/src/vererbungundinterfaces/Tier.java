package vererbungundinterfaces;

public abstract class Tier {
	int gr��e;
	int gewicht;
	
	public abstract void bewegen();
	
	public void atmen(){
		System.out.println("Atme Atme");
	}

}
