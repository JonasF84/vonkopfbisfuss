import java.util.ArrayList;

public class TestLebenserhaltungsSim {
	

	public static void main(String[] args) 
	{
		int energieWS = 0;
		int energieK = 0;
		int anzahlWS = 0;
		int anzahlV2 = 0;
		int anzahlV3 = 0;
		ArrayList aList = new ArrayList();
		//V2Kühler v2 = new V2Kühler(aList);
		V3Kühler v3 = new V3Kühler(aList);
		for(int z=0; z < 20; z++){
			WärmespeicherBot speicher = new WärmespeicherBot(aList);
		}
		
		for (Object object : aList) {
			SimEinheit sim;
			sim = (SimEinheit)(object);
			if (sim.energieVerbrauch() == 2) {
				energieWS =  energieWS + sim.energieVerbrauch();
			}
			else if(sim.energieVerbrauch() == 4){
				energieK = energieK + sim.energieVerbrauch();
			}
			
			if (sim.botTyp.equals("Wärmespeicher")) {
				anzahlWS++;
			}
			else if (sim.botTyp.equals("V2Kühler")){
				anzahlV2++;
			}
			else if (sim.botTyp.equals("V3Kühler")){
				anzahlV3++;
			}
			
		}
		System.out.println("Energieverbrauch Wärmespeicher: " + energieWS);
		System.out.println("Energieverbrauch Kühler: " + energieK);
		System.out.println("Anzahl Wärmespeicher: " + anzahlWS);
		System.out.println("Anzahl V2Kühler: " + anzahlV2);
		System.out.println("Anzahl V3Kühler: " + anzahlV3);
		
	}
}
