
public class BooteTesten {

	public static void main(String[] args) {
		Boot b1 = new Boot();
		Segelboot b2 = new Segelboot();
		Ruderboot b3 = new Ruderboot();
		b2.setLänge(32);
		b1.bewegen();
		b3.bewegen();
		b2.bewegen();
	}

}
