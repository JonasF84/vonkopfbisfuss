package vererbungundinterfaces;

public class TierTestRun {

	public static void main(String[] args) {
		Tier[] tierListe = new Tier[4];
		SuperPower[] powerListe = new SuperPower[2];
		
		Haifisch tigerhai = new Haifisch();
		Tiger schnuffel = new Tiger();
		Hauskatze emma = new Hauskatze();
		Goldfisch bert = new Goldfisch();
		
		tierListe[0] = tigerhai;
		tierListe[1] = schnuffel;
		tierListe[2] = emma;
		tierListe[3] = bert;
		
		powerListe[0] = tigerhai;
		powerListe[1] = emma;
		
		for (int i = 0; i < tierListe.length; i++) {
			tierListe[i].bewegen();
			if (i == 2) {
				Hauskatze neuneu = (Hauskatze)tierListe[i];
				neuneu.nachEssenBetteln();
			}
		}
		for (int i = 0; i < powerListe.length; i++) {
			powerListe[i].feuerAtem();
			powerListe[i].laserEinsetzen();
		}
		
		schnuffel.bewegen();
		schnuffel.atmen();
		emma.nachEssenBetteln();
		bert.nachEssenBetteln();
		bert.bewegen();
		tigerhai.bewegen();
		bert.atmen();
		
		Hauskatze neu = (Hauskatze)tierListe[2];
		neu.laserEinsetzen();

	}

}
