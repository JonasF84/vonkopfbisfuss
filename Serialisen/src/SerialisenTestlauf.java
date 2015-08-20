import java.io.*;

public class SerialisenTestlauf {

	public static void main(String[] args) {
		Figur eins = new Figur("Elb");
		Figur zwei = new Figur("Zwerg");
		Figur drei = new Figur("Zauberer");
		
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Figur.ser"));
			os.writeObject(eins);
			os.writeObject(zwei);
			os.writeObject(drei);
			os.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		eins = null;
		zwei = null;
		drei = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Figur.ser"));
			Figur einsWieder = (Figur)is.readObject();
			Figur zweiWieder = (Figur)is.readObject();
			Figur dreiWieder = (Figur)is.readObject();
			is.close();
			
			System.out.println(einsWieder.getName());
			System.out.println(zweiWieder.getName());
			System.out.println(dreiWieder.getName());
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
