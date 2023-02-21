package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class KioskPanel extends JPanel{
	public Image img;
	public Graphics graphic;
	public Image bg;
	
	final int WIDTH = 450;
	final int HEIGHT = 800;
	
	public KioskPanel(Image img) {
		setBounds(0, 0, WIDTH, HEIGHT);
		setLayout(null);
		this.bg = img;
	}
	
	public void paint(Graphics g) {
		img = createImage(this.getWidth(), this.getHeight());
		graphic = img.getGraphics();
		draw(graphic);
		g.drawImage(img, 0, 0, null);
	}//method

	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}//method
}
