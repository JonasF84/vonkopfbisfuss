import javax.sound.midi.*;

public class MidiUtil {
	
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	
	
	public void midiEinrichten() {
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return event;
	}
	
	public void tracksErzeugen(int[] liste){
		for (int i = 0; i < 16; i++) {
			int taste = liste[i];
			if (taste != 0){
				track.add(eventErzeugen(144, 9, taste, 100, i));
				track.add(eventErzeugen(128, 9, taste, 100, i+1));
			}
		}
	}

}
