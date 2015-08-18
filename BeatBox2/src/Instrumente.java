
public enum Instrumente { 
	BASSDRUM(35, "Bassdrum"), HIHAT(42, "Hi-Hat(geschlossen)");

	private int id;
	private String name;

	Instrumente(int id, String name){
		this.id = id;
		this.name = name;
	}
}

