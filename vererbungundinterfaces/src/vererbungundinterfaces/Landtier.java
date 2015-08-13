package vererbungundinterfaces;

public abstract class Landtier extends Tier {

	@Override
	public void bewegen() {
		System.out.println("Stampf Stampf");
	}
	
	public void trompeten(){
		System.out.println("Töröö");
	}

}
