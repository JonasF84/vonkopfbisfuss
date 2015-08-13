package vererbungundinterfaces;

public class Goldfisch extends Wassertier implements Haustier {

	@Override
	public void nachEssenBetteln() {
		System.out.println("Blub Blub");
		
	}

	@Override
	public void spielen() {
		System.out.println("Blubber");
		
	}

}
