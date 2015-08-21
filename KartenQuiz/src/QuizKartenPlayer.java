import java.util.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class QuizKartenPlayer {
	
	private JTextArea anzeige;
	private ArrayList<QuizKarte> kartenListe;
	private QuizKarte aktuelleKarte;
	private int aktuelleKarteIndex;
	private JFrame frame;
	private JButton n�chsteKarteButton;
	private boolean istAntwortAngezeigt;

	public static void main(String[] args) {
		QuizKartenPlayer reader = new QuizKartenPlayer();
		reader.los();
		

	}

	private void los() {
		frame = new JFrame("Quizkarten-Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = new JPanel();
		Font bigFont = new Font("sansserif", Font.BOLD, 24);
		
		anzeige = new JTextArea(10, 20);
		anzeige.setFont(bigFont);
		anzeige.setLineWrap(true);
		anzeige.setWrapStyleWord(true);
		anzeige.setEditable(false);
		
		JScrollPane fScroller = new JScrollPane(anzeige);
		fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		n�chsteKarteButton = new JButton("Frage zeigen");
		n�chsteKarteButton.addActionListener(new N�chsteKarteListener());
		
		hauptPanel.add(fScroller);
		hauptPanel.add(n�chsteKarteButton);
		
		JMenuBar men�Leiste = new JMenuBar();
		JMenu men�Datei = new JMenu("Datei");
		JMenuItem men�PunktLaden = new JMenuItem("Kartensatz laden");
		men�PunktLaden.addActionListener(new Men��ffnenListener());
		men�Datei.add(men�PunktLaden);
		men�Leiste.add(men�Datei);
		
		frame.setJMenuBar(men�Leiste);
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	
	public class N�chsteKarteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			if (istAntwortAngezeigt) {
				anzeige.setText(aktuelleKarte.getAntwort());
				n�chsteKarteButton.setText("N�chste Karte");
				istAntwortAngezeigt = false;
			}
			else{
				if(aktuelleKarteIndex < kartenListe.size()){
					n�chsteKarteZeigen();
				}
				else{
					anzeige.setText("Das war die letzte Karte");
					n�chsteKarteButton.setEnabled(false);
				}
			}		
		}
	}
	
	public class Men��ffnenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			JFileChooser datei�ffnen = new JFileChooser();
			datei�ffnen.showOpenDialog(frame);
			dateiLaden(datei�ffnen.getSelectedFile());
		}
		
	}
	
	private void dateiLaden(File datei){
		kartenListe = new ArrayList<QuizKarte>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while((zeile = reader.readLine()) != null){
				karteErstellen(zeile);
			}
			reader.close();
		}
		catch(Exception e){
			System.out.println("Konnte Kartendatei nicht lesen.");
			e.printStackTrace();
		}
		n�chsteKarteZeigen();
	}
	
	private void karteErstellen(String zuParsendeZeile){
		String[] ergebnis = zuParsendeZeile.split("/");
		QuizKarte karte = new QuizKarte(ergebnis[0], ergebnis[1]);
		kartenListe.add(karte);
		System.out.println("Karte erstellt.");
	}
	
	private void n�chsteKarteZeigen(){
		aktuelleKarte = kartenListe.get(aktuelleKarteIndex);
		aktuelleKarteIndex++;
		anzeige.setText(aktuelleKarte.getFrage());
		n�chsteKarteButton.setText("Antwort zeigen");
		istAntwortAngezeigt = true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
