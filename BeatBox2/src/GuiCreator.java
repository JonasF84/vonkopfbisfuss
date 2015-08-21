import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;



public class GuiCreator {
	JPanel hauptPanel;
	ArrayList<JCheckBox> checkboxListe;
	ArrayList<int[]> trackLists;
	JFrame derFrame;
	int anzahlCheckBoxen = 256;
	Box buttonBox;
	Player player;
	
	private MidiUtil midiUtil;
	
	public GuiCreator(MidiUtil midiUtil, Player player){
		this.midiUtil = midiUtil;
		this.player = player;
	}
	
	Instrumente[] inst = {Instrumente.BASSDRUM, Instrumente.HIHAT, Instrumente.HIHAT2, Instrumente.SNAREDRUM, 
			Instrumente.CRASHBECKEN, Instrumente.HÄNDEKLATSCHEN, Instrumente.TOMTOM, Instrumente.BONGO, 
			Instrumente.MARACAS, Instrumente.TRILLERPFEIFE, Instrumente.CONGA, Instrumente.KUHGLOCKE,
			Instrumente.VIBRASLAP, Instrumente.TOMTOM2, Instrumente.AGOGO, Instrumente.CONGA2};
	
	
	public void guiErstellen() {
		derFrame = new JFrame("Cyber-BeatBox");
		derFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel hintergrund = new JPanel(layout);
		hintergrund.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkboxListe = new ArrayList<JCheckBox>();
		buttonBox = new Box(BoxLayout.Y_AXIS);
		
		createButton("Starten", new MeinStartListener());
		createButton("Stoppen", new MeinStoppListener());
		createButton("Schneller", new MeinSchnellerListener());
		createButton("Langsamer", new MeinLangsamerListener());
		
		JMenuBar menüleiste = new JMenuBar();
		JMenu menüPattern = new JMenu("Pattern");
		JMenuItem menüPunktSpeichern = new JMenuItem("Speichern");
		JMenuItem menüPunktLaden = new JMenuItem("Laden");
		JMenuItem menüPunktNeu = new JMenuItem("Neu");
		
		menüPunktNeu.addActionListener(new MeinNeuListener());
		menüPunktSpeichern.addActionListener(new MeinSendenListener());
		menüPunktLaden.addActionListener(new MeinEinlesenListener());
		
		menüPattern.add(menüPunktNeu);
		menüPattern.add(menüPunktSpeichern);
		menüPattern.add(menüPunktLaden);
		menüleiste.add(menüPattern);
		
			
		Box namensBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < inst.length; i++) {
			namensBox.add(new Label(inst[i].getName()));
		}
		
		hintergrund.add(BorderLayout.EAST, buttonBox);
		hintergrund.add(BorderLayout.WEST, namensBox);
		
		derFrame.getContentPane().add(hintergrund);
		
		GridLayout raster = new GridLayout(16,16);
		raster.setVgap(1);
		raster.setHgap(1);
		hauptPanel = new JPanel(raster);
		hintergrund.add(BorderLayout.CENTER, hauptPanel);
		
		for (int i = 0; i < anzahlCheckBoxen; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxListe.add(c);
			hauptPanel.add(c);
		}
		
		derFrame.setJMenuBar(menüleiste);
		derFrame.setBounds(50, 50, 300, 300);
		derFrame.pack();
		derFrame.setVisible(true);
		
	}
	
	private void createButton(String name, ActionListener listener) {
		JButton button = new JButton(name);
		button.addActionListener(listener);
		buttonBox.add(button);
		
	}
	
	private ArrayList<int[]> checkBoxes() {
		int[] trackListe = null;
		trackLists = new ArrayList<int[]>();
		
		for (int i = 0; i < 16; i++) {
			trackListe = new int[16];
			int taste = inst[i].getId();
			
			for (int j = 0; j < 16; j++) {
				JCheckBox jc = checkboxListe.get(j + (16*i));
				if (jc.isSelected()) {
					trackListe[j] = taste;
				}
				else{
					trackListe[j] = 0;
				}
			}
			trackLists.add(trackListe);
		}
		return trackLists;	
	}

	public class MeinStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			player.trackErstellenUndStarten(checkBoxes());
		}
	}
	
	public class MeinStoppListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			midiUtil.sequencer.stop();
		}
	}
	
	public class MeinSchnellerListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = midiUtil.sequencer.getTempoFactor();
			midiUtil.sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}
	
	public class MeinLangsamerListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = midiUtil.sequencer.getTempoFactor();
			midiUtil.sequencer.setTempoFactor((float)(tempoFactor * 0.97));
		}
	}
	
	public class MeinSendenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			boolean[] checkboxZustand = new boolean[256];
			
			for (int i = 0; i < checkboxZustand.length; i++) {
				JCheckBox check = (JCheckBox)checkboxListe.get(i);
				if (check.isSelected()) {
					checkboxZustand[i] = true;
				}
			}
			try{
				JFileChooser dateiWahl = new JFileChooser();
				dateiWahl.showSaveDialog(derFrame);
				FileOutputStream fileStream = new FileOutputStream(dateiWahl.getSelectedFile());
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
				os.writeObject(checkboxZustand);
				os.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
	
	public class MeinEinlesenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			boolean[] checkboxZustand = null;
			try{
				JFileChooser dateiÖffnen = new JFileChooser();
				dateiÖffnen.showOpenDialog(derFrame);
				FileInputStream fileIn = new FileInputStream(dateiÖffnen.getSelectedFile());
				ObjectInputStream is = new ObjectInputStream(fileIn);
				checkboxZustand = (boolean[]) is.readObject();
				is.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			for (int i = 0; i < checkboxZustand.length; i++) {
				JCheckBox check = (JCheckBox) checkboxListe.get(i);
				if (checkboxZustand[i]) {
					check.setSelected(true);
				}
				else{
					check.setSelected(false);
				}
			}
			
			midiUtil.sequencer.stop();
			player.trackErstellenUndStarten(checkBoxes());
		}
		
	}
	
	public class MeinNeuListener implements ActionListener{

		
		public void actionPerformed(ActionEvent a) {
			trackLists.clear();
			for(JCheckBox checkBox : checkboxListe){
				checkBox.setSelected(false);
			}
			midiUtil.sequencer.stop();
			
		}
		
	}
	


}
