import java.io.*;
import java.net.*;
import java.util.*;

public class SehrEinfacherChatServer {
	
	ArrayList clientOutputFlows;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void run(){
			String nachricht;
			try{
				while((nachricht = reader.readLine()) != null){
					System.out.println("gelesen: " + nachricht);
					esAllenWeitersagen(nachricht);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new SehrEinfacherChatServer().los();
	}

	public void los() {
		clientOutputFlows = new ArrayList();
		
		try{
			ServerSocket serverSock = new ServerSocket(8090);
			
			while(true){
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputFlows.add(writer);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void esAllenWeitersagen(String nachricht){
		Iterator it = clientOutputFlows.iterator();
		PrintWriter writer;
		while(it.hasNext()){
			try{
				writer = (PrintWriter) it.next();
				writer.println(nachricht);
				writer.flush();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
