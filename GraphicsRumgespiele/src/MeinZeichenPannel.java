import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Zeichnet einen Kreis mit dem Mittelpunkt mx/my und dem Radius r
 * 
 */
public class MeinZeichenPannel extends JFrame {
    
    JPanel panel;
    
    public MeinZeichenPannel(){
        panel = new KreisPanel();
        add(panel);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MeinZeichenPannel();
    }
}

class KreisPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLUE);
        Rectangle rec = new Rectangle();
        rec.height = 20;
        rec.width = 20;
        GradientPaint gradient = new GradientPaint(70, 70, Color.BLACK, 150, 150, Color.magenta);
        g2d.setPaint(gradient);
        g2d.fillRect(20, 20, 100, 100);
        g2d.draw(rec);
    }
} 