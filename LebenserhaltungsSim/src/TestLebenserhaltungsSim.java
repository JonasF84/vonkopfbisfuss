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
		//V2K�hler v2 = new V2K�hler(aList);
		V3K�hler v3 = new V3K�hler(aList);
		for(int z=0; z < 20; z++){
			W�rmespeicherBot speicher = new W�rmespeicherBot(aList);
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
			
			if (sim.botTyp.equals("W�rmespeicher")) {
				anzahlWS++;
			}
			else if (sim.botTyp.equals("V2K�hler")){
				anzahlV2++;
			}
			else if (sim.botTyp.equals("V3K�hler")){
				anzahlV3++;
			}
			
		}
		System.out.println("Energieverbrauch W�rmespeicher: " + energieWS);
		System.out.println("Energieverbrauch K�hler: " + energieK);
		System.out.println("Anzahl W�rmespeicher: " + anzahlWS);
		System.out.println("Anzahl V2K�hler: " + anzahlV2);
		System.out.println("Anzahl V3K�hler: " + anzahlV3);
		
	}
}
