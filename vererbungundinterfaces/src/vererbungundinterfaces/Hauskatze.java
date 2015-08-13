package vererbungundinterfaces;

public class Hauskatze extends Landtier implements Haustier, SuperPower {

	@Override
	public void nachEssenBetteln() {
		System.out.println("mooooouuuuw");
		
	}

	@Override
	public void spielen() {
		System.out.println("kchhhhh!");
		
	}

	@Override
	public void laserEinsetzen() {
		System.out.println("maaaauuu ziu ziu");
		
	}

	@Override
	public void feuerAtem() {
		System.out.println("meaoouuuuuw wusch wusch");
		
	}

}
