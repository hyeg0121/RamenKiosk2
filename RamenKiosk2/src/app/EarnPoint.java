package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class EarnPoint extends KioskFrame {
	
	public EarnPoint() {
		KioskPanel pnl = new KioskPanel(getImage("pointBg"));
		add(pnl);
		
		KioskBtn btn[] = new KioskBtn[3];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new KioskBtn("point"+(i+1));
			pnl.add(setBounds(btn[i], 125, 360 + i*110 , 200, 60));
			
		}
		
		btn[0].addActionListener(e -> {
			new LogIn().setVisible(true);
			dispose();
		});
		
		btn[1].addActionListener(e -> {
			new Success().setVisible(true);
			dispose();
		});
		
		btn[2].addActionListener(e -> {
			new SignUp().setVisible(true);
			dispose();
		});
	}
	public static void main(String[] args) {
		new EarnPoint().setVisible(true);
	}

}
