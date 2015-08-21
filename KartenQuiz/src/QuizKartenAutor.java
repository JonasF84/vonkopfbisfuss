import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizKartenAutor {
	private JTextArea frage;
	private JTextArea antwort;
	private ArrayList<QuizKarte> kartenListe;
	private JFrame frame;
	
	public static void main(String[] args){
		QuizKartenAutor editor = new QuizKartenAutor();
		editor.los();
	}

	private void los() {
		frame = new JFrame("Quizkarten-Autor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		frage = new JTextArea(6, 20);
		frage.setLineWrap(true);
		frage.setWrapStyleWord(true);
		frage.setFont(bigFont);
		
		JScrollPane fScroller = new JScrollPane(frage);
		fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		antwort = new JTextArea(6, 20);
		antwort.setLineWrap(true);
		antwort.setWrapStyleWord(true);
		antwort.setFont(bigFont);
		
		JScrollPane aScroller = new JScrollPane(antwort);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton n�chsteKarteButton = new JButton("N�chste Karte");
		
		kartenListe = new ArrayList<QuizKarte>();
		
		JLabel fLabel = new JLabel("Die Frage lautet:");
		JLabel aLabel = new JLabel("Die Antwort lautet:");
		
		mainPanel.add(fLabel);
		mainPanel.add(fScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(n�chsteKarteButton);
		n�chsteKarteButton.addActionListener(new N�chsteKarteListener());
		JMenuBar men�leiste = new JMenuBar();
		JMenu men�Datei = new JMenu("Datei");
		JMenuItem men�PunktNeu = new JMenuItem("Neu");
		JMenuItem men�PunktSpeichern = new JMenuItem("Speichern");
		
		men�PunktNeu.addActionListener(new Men�NeuListener());
		men�PunktSpeichern.addActionListener(new Men�SpeichernListener());
		
		men�Datei.add(men�PunktNeu);
		men�Datei.add(men�PunktSpeichern);
		men�leiste.add(men�Datei);
		frame.setJMenuBar(men�leiste);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	
	public class N�chsteKarteListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent ev){
			QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
			kartenListe.add(karte);
			karteAbr�umen();
		}
	}
	
	public class Men�SpeichernListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
			kartenListe.add(karte);
			JFileChooser dateiWahl = new JFileChooser();
			dateiWahl.showSaveDialog(frame);
			dateiSpeichern(dateiWahl.getSelectedFile());
			
		}
		
	}
	
	public class Men�NeuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			kartenListe.clear();
			karteAbr�umen();
		}
		
	}
	
	private void karteAbr�umen(){
		frage.setText("");
		antwort.setText("");
		frage.requestFocus();
	}
	
	private void dateiSpeichern(File datei){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
			for(QuizKarte karte : kartenListe){
				writer.write(karte.getFrage() + "/");
				writer.write(karte.getAntwort() + "/" + "\n");
			}
			writer.close();
		}
		catch(IOException e){
			System.out.println("Kartenliste konnte nicht geschrieben werden.");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
