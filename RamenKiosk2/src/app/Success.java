package app;

import component.KioskFrame;
import component.KioskPanel;

public class Success extends KioskFrame{

	public Success() {
		KioskPanel pnl = new KioskPanel(getImage("successBg"));
	}

	public static void main(String[] args) {
		new Success().setVisible(true);
	}

}
