package vererbungundinterfaces;

public class Haifisch extends Wassertier implements SuperPower {

	@Override
	public void laserEinsetzen() {
		System.out.println("wiu wiu wiu");
		
	}

	@Override
	public void feuerAtem() {
		System.out.println("woob... geht nicht :(");
		
	}

}
