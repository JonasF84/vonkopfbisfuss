import java.util.Scanner;

public class ExceptionTestlauf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		try {
			tuRiskantes(test);
		} catch (MeineException e) {
			System.out.print("loes");
		}
		finally{
			System.out.print("e");
			System.out.println("n");
			
		}

	}

	private static void tuRiskantes(String test) throws MeineException {
		System.out.print("au");
		System.out.print("s");
		if ("ja".equals(test)) {
			throw new MeineException();
		}
		System.out.print("spa");
		System.out.print("nn");
	
		
	}

}
