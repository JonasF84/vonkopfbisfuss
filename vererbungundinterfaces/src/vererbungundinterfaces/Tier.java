package vererbungundinterfaces;

public abstract class Tier {
	int größe;
	int gewicht;
	
	public abstract void bewegen();
	
	public void atmen(){
		System.out.println("Atme Atme");
	}

}
