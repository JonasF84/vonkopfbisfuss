
public class BierLied {

	public static void main(String[] args) {
		int bierAnzahl = 99;
		String wort = "Flaschen";
		
		while(bierAnzahl > 0){
			
			if (bierAnzahl == 1) {
				wort = "Flasche";
			}
			
			System.out.println(bierAnzahl + " " + wort + " Bier im Kühlschrank");
			System.out.println(bierAnzahl + " " + wort + " Bier.");
			System.out.println("Hol eine raus.");
			System.out.println("Und lass sie rumgehen.");
			bierAnzahl--;
			
			if (bierAnzahl > 0) {
				if (bierAnzahl == 1) {
					wort = "Flasche";
				}
				System.out.println(bierAnzahl + " " + wort + " Bier im Kühlschrank");	
			}
			else {
				System.out.println("Kein Bier mehr im Kühlschrank!");
			}
		}

	}

}
