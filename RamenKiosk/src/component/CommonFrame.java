package component;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CommonFrame extends JFrame {
	
	final int WIDTH = 450;
	final int HEIGHT = 800;
	
	public CommonFrame() {}
	
	public CommonFrame(String title) {
		setSize(450, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(CommonFrame.class.getResource("../image/frameIcon.png")).getImage());
		setResizable(true);
	}

}
