
public class EchoTestLauf {

	public static void main(String[] args) {
		Echo e1 = new Echo();
		Echo e2 = new Echo();
		int x = 0;
		
		while (x < 4) {
			e1.hallo();
			e1.z�hler = e1.z�hler + 1;
			if (x < 5) {
				e2.z�hler = e2.z�hler + 1;
			}
			
			if (x > 1) {
				e2.z�hler = e2.z�hler + 1; 
			}
			
			if (x == 3) {
				e2.z�hler = e2.z�hler + e1.z�hler;
			}
			
			x = x + 1;
		}
		System.out.println(e2.z�hler);
	}

}
