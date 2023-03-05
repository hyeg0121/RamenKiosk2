package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class ManagerMain extends KioskFrame {

	public ManagerMain() {
		KioskPanel pnl = new KioskPanel(getImage("managerBg"));
		add(pnl);
		
		KioskBtn btn = new KioskBtn("manageBtn");
		pnl.add(setBounds(btn, 125, 500, 200, 60));
	}
	
	
	public static void main(String[] args) {
		new ManagerMain().setVisible(true);
	}

}
