import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	ArrayList<DotCom> dotComs = new ArrayList<DotCom>();
	ArrayList<DotCom> deadDotComs = new ArrayList<DotCom>();
	ArrayList<String> dotComCoords = new ArrayList<String>();
	String[] coordB = {"a", "b", "c", "d", "e", "f", "g"};
	
	public void start(){
		int anzahlSchüsse = 0;
		boolean amLeben = true;
		Scanner sc = new Scanner(System.in);
		fillDotComCoords();
		dotComs.add(createDotCom());
		dotComs.add(createDotCom());
		dotComs.add(createDotCom());
		
		dotComs.get(0).setName("amazon.com");
		dotComs.get(1).setName("ebay.com");
		dotComs.get(2).setName("facebook.com");
		
		System.out.println("Willkommen zum DotCom-Versenken!");
		System.out.println("Es wurden drei DotComs der größe drei auf einem 7x7 Raster verteilt(a0-g6)");
		while (amLeben) {
			updateDotComs();
			if (dotComs.isEmpty()) {
				amLeben = false;
			}
			System.out.println("Wohin willst du schießen?");
			String shootCoord = sc.nextLine();
			anzahlSchüsse++;
			for(DotCom dotCom : dotComs){
				if (dotCom.treffer(shootCoord)) {
					System.out.println("Treffer!");
					
					if (dotCom.getOrte().isEmpty()) {
						System.out.println(dotCom.getName() +" wurde Versenkt!");
						deadDotComs.add(dotCom);
					}
				}
				else {
					System.out.println("Daneben!");
				}
			}
			
		}
		System.out.println("Alle DotComs wurden versenkt! Gratulation! Du hast " + anzahlSchüsse + " gebraucht!");
		sc.close();
	}
	private void fillDotComCoords() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++){
				dotComCoords.add(String.valueOf(i) + coordB[j]);
			}
		}	
	}
	public void updateDotComs() {
		for(DotCom dotCom : deadDotComs){
			dotComs.remove(dotCom);
		}
	}

	public DotCom createDotCom() {
		int random = createRandom();
		String coordinateA = dotComCoords.get(random);
		dotComCoords.remove(random);
		String coordinateB = dotComCoords.get(random);
		dotComCoords.remove(random);
		String coordinateC = dotComCoords.get(random);
		dotComCoords.remove(random);
		
	    return new DotCom(coordinateA, coordinateB, coordinateC);
	}

	private int createRandom() {
		return (int)(Math.random() * dotComCoords.size()-2);
	}		
}



