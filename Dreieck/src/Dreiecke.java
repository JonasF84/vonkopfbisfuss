
public class Dreiecke {
	double fläche;
	int höhe;
	int breite;

	public static void main(String[] args) {
		Dreiecke[] dr = new Dreiecke[4];
		int x = 0;
		while (x < 4) {
			dr[x] = new Dreiecke();
			dr[x].höhe = (x + 1) * 2;
			dr[x].breite = x + 4;
			dr[x].setFläche();
			System.out.print("Dreieck "+x+", Fläche");
			System.out.println(" = " + dr[x].fläche);
			x = x + 1;
		}
		int y = x;
		x = 27;
		Dreiecke d5 = dr[2];
		dr[2].fläche = 343;
		System.out.print("y = " + y);
		System.out.println(", d5 Fläche = "+d5.fläche);

	}

	private void setFläche() {
		fläche = (höhe * breite) / 2;
		
	}

}
