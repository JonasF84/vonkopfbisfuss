import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Gui {
	JFrame frame;
	JTextField field;
	JTextArea text;
	JScrollPane scroller;

	public static void main(String[] args) {
		
		Gui gui = new Gui();
		gui.los();
			
	}
	
	private void los() {
		frame = new JFrame();
		
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		frame.add(panel, BorderLayout.NORTH);
		
		field = new JTextField("Name");
		field.addActionListener(new FieldListener());
		field.addKeyListener(new TypeListener());
		
		text = new JTextArea(10, 20);
		text.setLineWrap(true);
		
		scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		panel.add(field);
		
		frame.validate();
		
	}

	class FieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			field.setText(text.getText());
		}	
	}
	
	class TypeListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			frame.setTitle(field.getText());
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
			
		}
		
	}

}
