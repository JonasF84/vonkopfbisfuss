

public class ListenUndSoKram {

	public static void main(String[] args) {
		NormaleListe neueListe = new NormaleListe();
		neueListe.add("bla");
		neueListe.add("zwei");
		
		System.out.println(neueListe.toString());
		
		neueListe.remove(0);
		
		System.out.println(neueListe.toString());
		
		System.out.println(neueListe.get(0));
		
		
	}

}
