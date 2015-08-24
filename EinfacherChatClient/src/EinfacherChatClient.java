import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EinfacherChatClient {
	
	JTextArea eingehend;
	JTextField ausgehend;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public static void main(String[] args) {
		EinfacherChatClient client = new EinfacherChatClient();
		client.los();
	}

	private void los() {
		JFrame frame = new JFrame("Einfacher Chat-Client");
		JPanel hauptPanel = new JPanel();
		eingehend = new JTextArea(15, 20);
		eingehend.setLineWrap(true);
		eingehend.setWrapStyleWord(true);
		eingehend.setEditable(false);
		JScrollPane fScroller = new JScrollPane(eingehend);
		fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ausgehend = new JTextField(20);
		JButton sendenButton = new JButton("Senden");
		sendenButton.addActionListener(new SendenButtonListener());
		hauptPanel.add(fScroller);
		hauptPanel.add(ausgehend);
		hauptPanel.add(sendenButton);
		netzwerkEinrichten();
		
		Thread readerThread = new Thread(new EingehendReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void netzwerkEinrichten(){
		try{
			sock = new Socket("127.0.0.1", 8090);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Netzwerkanbindung steht");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private class SendenButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				String message = ausgehend.getText();
				writer.println(message);
				writer.flush();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			ausgehend.setText("");
			ausgehend.requestFocus();

		}
		
	}
	
	public class EingehendReader implements Runnable{
		public void run(){
			String nachricht;
			try{
				while ((nachricht = reader.readLine()) != null){
					System.out.println("gelesen: " + nachricht);
					eingehend.append(nachricht + "\n");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
