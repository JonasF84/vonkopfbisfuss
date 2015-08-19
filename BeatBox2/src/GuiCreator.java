import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class GuiCreator {
	JPanel hauptPanel;
	ArrayList<JCheckBox> checkboxListe;
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
		
		derFrame.setBounds(50, 50, 300, 300);
		derFrame.pack();
		derFrame.setVisible(true);		
	}
	
	private void createButton(String name, ActionListener listener) {
		JButton button = new JButton(name);
		button.addActionListener(listener);
		buttonBox.add(button);
		
	}

	public class MeinStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			
		    player.trackErstellenUndStarten(checkBoxes());
		}

		private int[] checkBoxes() {
			int[] trackListe = null;
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
		}
			return trackListe;
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
	


}
