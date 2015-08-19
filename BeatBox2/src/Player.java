import javax.sound.midi.Sequencer;

public class Player {
	MidiUtil midi;
	GuiCreator gui;
	public Player(MidiUtil midi){
		this.midi = midi;
	}
	
	public void trackErstellenUndStarten(int[] trackListe){
		
		midi.sequence.deleteTrack(midi.track);
		midi.track = midi.sequence.createTrack();
		
		for (int i = 0; i < 16; i++) {
			midi.tracksErzeugen(trackListe);
		}
		
		midi.track.add(midi.eventErzeugen(192, 9, 1, 0, 16));
		try{
			midi.sequencer.setSequence(midi.sequence);
			midi.sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			midi.sequencer.start();
			midi.sequencer.setTempoInBPM(120);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
