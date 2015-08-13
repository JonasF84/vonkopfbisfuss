
public class Von76 extends Clowns  {

	public static void main(String[] args) {
		Nasen[]i = new Nasen[3];
		i[0] = new Akte();
		i[1] = new Clowns();
		i[2] = new Von76();
		
		for (int x = 0; x < 3; x++) {
			System.out.println(i[x].iMethode() + " " + i[x].getClass());
			
		}

	}

}
