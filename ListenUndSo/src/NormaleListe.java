import org.junit.Ignore;

@Ignore
public class NormaleListe {
	
	String[] datastructure;
	

	public NormaleListe() {
		datastructure = new String[0];
	}

	public String get(int index) {
		if (index < datastructure.length && index >= 0) {
			return datastructure[index];
		}
		else{
			return null;
		}	
	}

	public int size() {	
		return datastructure.length;
	}
	
	public void add(String a){
		String[] newArray = new String[datastructure.length + 1];
		for (int i = 0; i < datastructure.length; i++) {
			newArray[i] = datastructure[i];
		}
		newArray[datastructure.length] = a;
		datastructure = newArray;
	}
	
	public void remove(int index){
		if (index >= 0 && index < datastructure.length) {
			String[] newArray = new String[datastructure.length - 1];
			for (int i = 0; i < datastructure.length; i++) {
				if (i < index) {
					newArray[i] = datastructure[i];
				}
				if (i > index ) {
					newArray[i-1] = datastructure[i];
				}
			}
			datastructure = newArray;
		}
		else{
			System.out.println("index " + index + " is out of bounds");
		}
	}
	
	public String toString(){
		String out ="";
		for (int i = 0; i < datastructure.length; i++) {
			out += datastructure[i] + " ";
		}
		return out;
	}
	
}
