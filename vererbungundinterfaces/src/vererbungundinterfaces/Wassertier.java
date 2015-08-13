package vererbungundinterfaces;

public abstract class Wassertier extends Tier {

	@Override
	public void bewegen() {
		System.out.println("Schwimm Schwimm");	
	}
	public void atmen(){
		super.atmen();
		System.out.println("Blubediblub");
	}

}
