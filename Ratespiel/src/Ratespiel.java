import java.io.IOException;
import java.util.Scanner;

public class Ratespiel {
	
	int anzahlDerSpieler;
	int zielZahl;
	int gewinner;
	Spieler[] spielerArray;
	Scanner in = new Scanner(System.in);
	
	public void starteSpiel(){
		System.out.println("Wie viele Spieler sollen teilnehmen?:");
		anzahlDerSpieler = in.nextInt();
		
		spielerArray = new Spieler[anzahlDerSpieler];
		for (int i = 0; i < spielerArray.length; i++) {
			spielerArray[i] = new Spieler();
			spielerArray[i].hatRecht = false;
		}
		
		zielZahl = (int) (Math.random() * 10);
		System.out.println("Ich denke mir eine Zahl zwischen 0 und 9 aus...");
		spieldurchgang();
		
	}
	
	private void spieldurchgang() {
		boolean spielBeendet = false;
		Scanner scanner = new Scanner(System.in);
		while (!spielBeendet) {
			for (int i = 0; i < spielerArray.length; i++) {
				System.out.println("Spieler " + (i+1) + " tippe eine Zahl:");
			
				int input = scanner.nextInt();
				spielerArray[i].zahl = input;		
			}
			if(gewinnÜberprüfung()){
				System.out.println("Wir haben einen Gewinner!");
				System.out.println("Spieler " + gewinner + " hat gewonnen!");
				spielBeendet = true;
			}
			else{
				System.out.println("Leider kein Gewinner dabei, raten wir noch mal!");
			}
		}	
	}

	public boolean gewinnÜberprüfung(){
		for (int i = 0; i < spielerArray.length; i++) {
			if(spielerArray[i].zahl == zielZahl){
				spielerArray[i].hatRecht = true;
			}
		}
		for (int i = 0; i < spielerArray.length; i++) {
			if(spielerArray[i].hatRecht){
				gewinner = i+1;
				return true;
			}
		}
		return false;
	}
}
