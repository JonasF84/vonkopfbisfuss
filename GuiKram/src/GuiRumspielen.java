import javax.swing.*;
import java.awt.event.*;

public class GuiRumspielen extends JPanel implements ActionListener {
	JButton button;
	int x;

	public static void main(String[] args) {		
		GuiRumspielen gui = new GuiRumspielen();
		gui.los();		
	}

	private void los() {
		JFrame frame = new JFrame();
		button = new JButton("Klick mich");
		x = 0;
		
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setTitle("Test jojo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x++;
		button.setText("Ich wurde " + x + " mal geklickt!");
		
	}
}
