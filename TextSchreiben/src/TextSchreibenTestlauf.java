import java.io.*;

public class TextSchreibenTestlauf {

	public static void main(String[] args) {
		try{
			FileWriter writer = new FileWriter("duda.txt");
			writer.write("Huhu, was geht?");
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
