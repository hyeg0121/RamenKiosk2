package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class SingUp extends KioskFrame {

	public SingUp() {
		KioskPanel pnl = new KioskPanel(getImage("signUpBg"));
		add(setBounds(pnl, -5, -5, this.getWidth(), this.getHeight()));
		
		KioskBtn btn = new KioskBtn("signUpBtn");
		pnl.add(setBounds(btn, 125, 540, 200, 60));
	}

	public static void main(String[] args) {
		new SingUp().setVisible(true);
	}

}
