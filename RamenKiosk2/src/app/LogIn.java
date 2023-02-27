package app;

import component.KioskFrame;
import component.KioskPanel;

public class LogIn extends KioskFrame{

	public LogIn() {
		KioskPanel pnl = new KioskPanel(getImage("logInBg"));
	}

	public static void main(String[] args) {
		new LogIn().setVisible(true);

	}

}
