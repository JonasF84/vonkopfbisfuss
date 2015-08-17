import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;

public class MiniMiniMusikProg {
	static JFrame f = new JFrame("Derbe!");
	static MeinZeichenPanel m1;

	public static void main(String[] args) {
		MiniMiniMusikProg mini = new MiniMiniMusikProg();
		mini.spielen();
		
	}
	
	public void createGui(){
		m1 = new MeinZeichenPanel();
		f.setContentPane(m1);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void spielen() {
	createGui();
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] wishedEvents = {127};
			sequencer.addControllerEventListener(m1, wishedEvents);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 5; i < 61; i+=4){
				r = (int)((Math.random() * 50) + 1);
				track.add(createEvent(144, 1, r, 100, i));
				track.add(createEvent(176, 1, 127, 0, i));
				track.add(createEvent(144, 1, r, 100, i +2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			Thread.sleep(5000);
			sequencer.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static MidiEvent createEvent(int comd, int chan, int one, int two, int tick){
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
	
	class MeinZeichenPanel extends JPanel implements ControllerEventListener{
		
		boolean msg = false;

		@Override
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics graphic){
			if(msg){
				Graphics2D graphic2D = (Graphics2D)graphic;
				
				int r = (int)(Math.random() * 250);
				int g = (int)(Math.random() * 250);
				int b = (int)(Math.random() * 250);
				
				graphic.setColor(new Color(r, g, b));
				
				int height = (int)(Math.random() * 120 + 10);
				int width = (int)(Math.random() * 120 + 10);
				int x = (int)(Math.random() * 40 + 10);
				int y = (int)(Math.random() * 40 + 10);
				graphic.fillRect(x, y, width, height);
				msg = false;
			}
		}
		
	}

}
