
public enum Instrumente { 
	BASSDRUM(35, "Bassdrum"), HIHAT(42, "Hi-Hat(geschlossen)"), HIHAT2(46, "Hi-Hat, offen"),
	SNAREDRUM(38, "Snaredrum"), CRASHBECKEN(49, "Crashbecken"), HÄNDEKLATSCHEN(39, "Händeklatschen"),
	TOMTOM(50, "Hohes Tom-Tom"),BONGO(60, "Hohes Bongo"), MARACAS(70, "Maracas"), TRILLERPFEIFE(72, "Trillerpfeife"),
	CONGA(64, "Tiefes Conga"), KUHGLOCKE(56, "Kuhglocke"), VIBRASLAP(58, "Vibraslap"), 
	TOMTOM2(47, "Tiefes Tom-Tom"), AGOGO(67, "Hohes Agogo"), CONGA2(63, "Hohe Conga, offen");

	private int id;
	private String name;
	
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}

	Instrumente(int id, String name){
		this.id = id;
		this.name = name;
	}
}

