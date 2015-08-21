import java.io.*;
import java.net.*;

public class TipDesTagesClient {
	
	public static void main(String[] args){
		TipDesTagesClient client = new TipDesTagesClient();
		client.los();
	}
	
	public void los(){
		try{
			Socket s = new Socket("127.0.0.1", 60127);
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
