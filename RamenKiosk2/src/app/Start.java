package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class Start extends KioskFrame {
	
	public Start() {
		KioskPanel pnl = new KioskPanel(getImage("mainBg"));
		add(pnl);
		
		KioskBtn startBtn = new KioskBtn("startBtn");
		pnl.add(setBounds(startBtn, 100, 400, 225, 60));
		
		KioskBtn managerBtn = new KioskBtn("managerBtn");
		pnl.add(setBounds(managerBtn, 140, 600, 150, 40));
	}
	
	public static void main(String[] args) {
		new Start().setVisible(true);
	}

}
