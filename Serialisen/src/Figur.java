import java.io.Serializable;

public class Figur implements Serializable {
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	public Figur(String name){
		this.name = name;
	}

}
