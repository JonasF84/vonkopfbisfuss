import java.util.ArrayList;

public class DotCom {
	
	private String name;
	private ArrayList<String> orte = new ArrayList<String>();
	
	public DotCom(String koordA, String koordB, String koordC){
		orte.add(koordA);
		orte.add(koordB);
		orte.add(koordC);
	}
	public void setName(String x){
		name = x;
	}
	public String getName(){
		return name;
	}
	public void setOrte(String y){
		orte.add(y);
	}
	public ArrayList<String> getOrte(){
		return orte;
	}
	public boolean treffer(String koordinate){
		if (orte.contains(koordinate)) {
			orte.remove(koordinate);
			return true;
		}
		return false;
	}

}
