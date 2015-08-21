import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EinfacherChatClient {
	
	JTextField ausgehend;
	PrintWriter writer;
	Socket sock;

	public static void main(String[] args) {
		EinfacherChatClient client = new EinfacherChatClient();
		client.los();
	}

	private void los() {
		JFrame frame = new JFrame("Einfacher Chat-Client");
		JPanel hauptPanel = new JPanel();
		ausgehend = new JTextField(20);
		JButton sendenButton = new JButton("Senden");
		sendenButton.addActionListener(new SendenButtonListener());
		hauptPanel.add(ausgehend);
		hauptPanel.add(sendenButton);
		netzwerkEinrichten();
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void netzwerkEinrichten(){
		try{
			sock = new Socket("127.0.0.1", 8090);
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
				writer.println(ausgehend.getText());
				writer.flush();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			ausgehend.setText("");
			ausgehend.requestFocus();

		}
		
	}
}
