import java.util.ArrayList;

import javax.sound.midi.Sequencer;

public class Player {
	MidiUtil midi;
	public Player(MidiUtil midi){
		this.midi = midi;
	}
	
	public void trackErstellenUndStarten(ArrayList<int[]> TrackLists){
		
		midi.sequence.deleteTrack(midi.track);
		midi.track = midi.sequence.createTrack();
		
		for (int i = 0; i < 16; i++) {
			int[] trackList = TrackLists.get(i);
			midi.tracksErzeugen(trackList);
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
