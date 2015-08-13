
public class MischMasch5 {

	public static void main(String[] args) {
		int x = 0;
		int y = 30;
		for(int auﬂen = 0; auﬂen < 3; auﬂen++){
			for(int innen = 4; innen > 1; innen--){
				x = x + 2;
				y = y - 2;
				if (x == 6) {
					break;
				}
				x = x + 3;
			}
			y = y - 2;
		}
		System.out.println(x + " " + y);
	}
}
