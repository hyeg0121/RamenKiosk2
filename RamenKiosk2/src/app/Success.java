package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class Success extends KioskFrame{

	public Success() {
		KioskPanel pnl = new KioskPanel(getImage("successBg"));
		add(pnl);
		
		KioskBtn btn = new KioskBtn("successBtn");
		pnl.add(setBounds(btn, 125, 500, 200, 60));
		btn.addActionListener(e ->{
			new Cooking().setVisible(true);
			dispose();
		});
	}

	public static void main(String[] args) {
		new Success().setVisible(true);
	}

}
