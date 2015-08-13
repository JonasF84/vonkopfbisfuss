
public class EchoTestLauf {

	public static void main(String[] args) {
		Echo e1 = new Echo();
		Echo e2 = new Echo();
		int x = 0;
		
		while (x < 4) {
			e1.hallo();
			e1.zähler = e1.zähler + 1;
			if (x < 5) {
				e2.zähler = e2.zähler + 1;
			}
			
			if (x > 1) {
				e2.zähler = e2.zähler + 1; 
			}
			
			if (x == 3) {
				e2.zähler = e2.zähler + e1.zähler;
			}
			
			x = x + 1;
		}
		System.out.println(e2.zähler);
	}

}
