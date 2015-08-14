import java.util.ArrayList;
import java.util.Iterator;

public class V3Kühler extends V2Kühler {

	public V3Kühler(ArrayList lglist) {
		super(lglist);
		for (int g = 0; g < 10; g++) {
			lglist.add(new SimEinheit("V3Kühler"));
		}
	}

}
