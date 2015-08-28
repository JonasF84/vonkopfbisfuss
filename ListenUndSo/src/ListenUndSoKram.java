

public class ListenUndSoKram {

	public static void main(String[] args) {
		VerketteteListe liste = new VerketteteListe();
		liste.add("eins"); // 0
		liste.add("zwei"); // 1
		liste.add("drei"); // 2
		liste.add("vier"); // 3
		liste.add("fünf"); // 4 
		liste.add("sechs"); // 5 
		liste.add("sieben"); // 6
		
		System.out.println(liste.getSize());
		
		
		liste.remove(6);
		liste.remove(5);
		liste.remove(0);
		System.out.println(liste.getSize());
		
	}

}
