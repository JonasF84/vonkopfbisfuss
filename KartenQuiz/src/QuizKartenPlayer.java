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
	private JButton nächsteKarteButton;
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
		
		nächsteKarteButton = new JButton("Frage zeigen");
		nächsteKarteButton.addActionListener(new NächsteKarteListener());
		
		hauptPanel.add(fScroller);
		hauptPanel.add(nächsteKarteButton);
		
		JMenuBar menüLeiste = new JMenuBar();
		JMenu menüDatei = new JMenu("Datei");
		JMenuItem menüPunktLaden = new JMenuItem("Kartensatz laden");
		menüPunktLaden.addActionListener(new MenüÖffnenListener());
		menüDatei.add(menüPunktLaden);
		menüLeiste.add(menüDatei);
		
		frame.setJMenuBar(menüLeiste);
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	
	public class NächsteKarteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			if (istAntwortAngezeigt) {
				anzeige.setText(aktuelleKarte.getAntwort());
				nächsteKarteButton.setText("Nächste Karte");
				istAntwortAngezeigt = false;
			}
			else{
				if(aktuelleKarteIndex < kartenListe.size()){
					nächsteKarteZeigen();
				}
				else{
					anzeige.setText("Das war die letzte Karte");
					nächsteKarteButton.setEnabled(false);
				}
			}		
		}
	}
	
	public class MenüÖffnenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			JFileChooser dateiÖffnen = new JFileChooser();
			dateiÖffnen.showOpenDialog(frame);
			dateiLaden(dateiÖffnen.getSelectedFile());
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
		nächsteKarteZeigen();
	}
	
	private void karteErstellen(String zuParsendeZeile){
		String[] ergebnis = zuParsendeZeile.split("/");
		QuizKarte karte = new QuizKarte(ergebnis[0], ergebnis[1]);
		kartenListe.add(karte);
		System.out.println("Karte erstellt.");
	}
	
	private void nächsteKarteZeigen(){
		aktuelleKarte = kartenListe.get(aktuelleKarteIndex);
		aktuelleKarteIndex++;
		anzeige.setText(aktuelleKarte.getFrage());
		nächsteKarteButton.setText("Antwort zeigen");
		istAntwortAngezeigt = true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
