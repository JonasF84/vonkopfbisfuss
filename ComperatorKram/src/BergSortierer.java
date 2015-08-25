import java.util.*;

public class BergSortierer {
	LinkedList<Berg> berge = new LinkedList<Berg>();
	class Namensvergleich implements Comparator<Berg>{
		public int compare(Berg eins, Berg zwei){
			return eins.name.compareTo(zwei.name);
		}
	}
	
	class Hoehenvergleich implements Comparator<Berg>{
		public int compare(Berg eins, Berg zwei){
			return (eins.hoehe - zwei.hoehe);
		}
	}

	public static void main(String[] args) {
		new BergSortierer().los();

	}

	private void los() {
		berge.add(new Berg("Matterhorn", 4478));
		berge.add(new Berg("Dom", 4545));
		berge.add(new Berg("Nordend", 4609));
		berge.add(new Berg("Nadelhorn", 4327));
		
		System.out.println("Wie eingebgeben:\n" + berge);
		Namensvergleich nc = new Namensvergleich();
		Collections.sort(berge, nc);
		System.out.println("Nach Namen:\n" + berge);
		Hoehenvergleich hc = new Hoehenvergleich();
		Collections.sort(berge, hc);
		System.out.println("Nach Höhe:\n" + berge);
		
	}

}
