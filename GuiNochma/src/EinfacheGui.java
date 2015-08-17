import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EinfacheGui {
	JFrame frame;
	JLabel label;
	
	int x = 320;
	int y = 70;
	
	public static void main(String[] args) {
		EinfacheGui gui = new EinfacheGui();
		gui.los();
		

	}

	public void los() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Farbe wechseln");
		JButton labelButton = new JButton("Label ändern");
		button.addActionListener(new ColorListener());
		labelButton.addActionListener(new LabelListener());
		label = new JLabel("Ich bin ein Label");
		
		
		MeinZeichenPanel zeichenPanel = new MeinZeichenPanel();
		
		//frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, zeichenPanel);
		//frame.getContentPane().add(BorderLayout.WEST, label);
		//frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.setSize(600, 600);
		frame.setVisible(true);	
		
		for (int i = 0; i < 130; i++) {
			x--;
			y++;
			
			zeichenPanel.repaint();
			
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if (i == 129) {
				for (int j = 0; j < 130; j++) {
					x++;
					y--;
					
					zeichenPanel.repaint();
					try{
						Thread.sleep(50);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			label.setText("Jojo");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.repaint();	
		}
	}
	
	class MeinZeichenPanel extends JPanel {
		
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			Graphics2D g2d = (Graphics2D) g;
			int rot = (int)(Math.random() * 255);
			int grün = (int)(Math.random() * 255);
			int blau = (int)(Math.random() * 255);
			
			Color startColor = new Color(rot, grün, blau); 
			
			rot = (int)(Math.random() * 255);
			grün = (int)(Math.random() * 255);
			blau = (int)(Math.random() * 255);
			
			Color endColor = new Color(rot, grün, blau);
			
			GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
			g2d.setPaint(gradient);
			g2d.fillOval(x, y, 250, 250);
		}

	}

}
