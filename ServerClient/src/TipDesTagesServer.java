import java.io.*;
import java.net.*;

public class TipDesTagesServer {
	
	String[] tipListe = {"Iss weniger Süßkram!", "Sei nett zu Jonas!", "Sei nett zu Lea",
			"Nerf-Guns machen Spaß!"};
	
	public void los(){
		try{
			ServerSocket serverSock = new ServerSocket(60127);
			
			while(true){
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String tip = getTip();
				writer.println(tip);
				writer.close();
				System.out.println(tip);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private String getTip(){
		int zufallszahl = (int) (Math.random() * tipListe.length);
		return tipListe[zufallszahl];
	}

	public static void main(String[] args) {
		TipDesTagesServer server = new TipDesTagesServer();
		server.los();
	}

}
