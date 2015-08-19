public class BeatBox {

	
	
	public static void main(String[] args) {
		new BeatBox().go();

	}

	private void go() {
		MidiUtil midi = new MidiUtil();
		Player player = new Player(midi);
		GuiCreator gui = new GuiCreator(midi, player);
		gui.guiErstellen();
		midi.midiEinrichten();
		
		
		
	}	

}
