import java.util.ArrayList;
import java.util.Iterator;

public class V3K�hler extends V2K�hler {

	public V3K�hler(ArrayList lglist) {
		super(lglist);
		for (int g = 0; g < 10; g++) {
			lglist.add(new SimEinheit("V3K�hler"));
		}
	}

}
