
public class Dreiecke {
	double fl�che;
	int h�he;
	int breite;

	public static void main(String[] args) {
		Dreiecke[] dr = new Dreiecke[4];
		int x = 0;
		while (x < 4) {
			dr[x] = new Dreiecke();
			dr[x].h�he = (x + 1) * 2;
			dr[x].breite = x + 4;
			dr[x].setFl�che();
			System.out.print("Dreieck "+x+", Fl�che");
			System.out.println(" = " + dr[x].fl�che);
			x = x + 1;
		}
		int y = x;
		x = 27;
		Dreiecke d5 = dr[2];
		dr[2].fl�che = 343;
		System.out.print("y = " + y);
		System.out.println(", d5 Fl�che = "+d5.fl�che);

	}

	private void setFl�che() {
		fl�che = (h�he * breite) / 2;
		
	}

}
