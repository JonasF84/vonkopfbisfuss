import java.util.Date;

public class DatumTest {

	public static void main(String[] args) {
		Date heute = new Date();
		System.out.println(String.format("%tc", heute));
		System.out.println(String.format("%tr", heute));
		System.out.println(String.format("%tA, %td. %tB", heute, heute, heute));
		System.out.println(String.format("%tA, %<td. %<tB", heute));
	}

}
