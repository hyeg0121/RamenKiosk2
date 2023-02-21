package component;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskBtn extends JButton {
	
	public KioskBtn(String imgName) {
		setIcon(new ImageIcon(KioskBtn.class.getResource("../images/startBtn.png")));
		setRolloverIcon(new ImageIcon(KioskBtn.class.getResource("../images/startBtn.png")));
		setRolloverSelectedIcon(new ImageIcon(KioskBtn.class.getResource("../images/startBtn.png")));
		setFocusPainted(false);
		setBackground(Color.WHITE);
		setBorder(null);
	}
}
