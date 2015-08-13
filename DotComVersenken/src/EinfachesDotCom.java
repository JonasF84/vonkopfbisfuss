import java.util.ArrayList;

public class EinfachesDotCom {
	
	private ArrayList<String> zellOrte;
	private int anzahlTreffer = 0;

	public void setZellorte(ArrayList<String> orte) {
		zellOrte = orte;
		
	}

	public String prüfDich(String stringTipp) {
		int tipp = Integer.parseInt(stringTipp);
		String ergebnis = "Vorbei";
		for (int zelle : zellOrte) {
			if (tipp == zelle) {
				ergebnis = "Treffer";
				anzahlTreffer = anzahlTreffer + 1;
				break;
			}
		}
		if (anzahlTreffer == zellOrte.length) {
			ergebnis = "Versenkt";
		}
		System.out.println(ergebnis);
		return ergebnis;
	}

}
