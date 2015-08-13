import java.util.Scanner;

public class EinfachesDotComTestlauf {

	public static void main(String[] args) {
		EinfachesDotCom dotCom = new EinfachesDotCom();
		int anzahlTipps = 0;
		boolean lebt = true;
		int x = (int)(Math.random() * 5);
		int[] orte = {x, x+1, x+2};
		dotCom.setZellorte(orte);
		Scanner sc = new Scanner(System.in);
		
		while (lebt) {
			String tipp = sc.next();
			String ergebnis = dotCom.prüfDich(tipp);
			anzahlTipps = anzahlTipps + 1;
			if (ergebnis.equals("Versenkt")) {
				lebt = false;
			}
			
		}
		
		sc.close();
		
		
		
		System.out.println(anzahlTipps);

	}

}
