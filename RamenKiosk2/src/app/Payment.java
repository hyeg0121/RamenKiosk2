package app;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class Payment extends KioskFrame {
	static int ramenPrice = 0;
	static int otherPrice = 0;
	
	public Payment() {
		KioskPanel pnl = new KioskPanel(getImage("paymentBg"));
		add(setBounds(pnl, -5, -5, this.getWidth(), this.getHeight()));
		KioskBtn btn[] = new KioskBtn[3];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new KioskBtn("payway"+(i+1));
			pnl.add(setBounds(btn[i], 125, 360 + i*110 , 200, 60));
		}
	}
	public static void main(String[] args) {
		new Payment().setVisible(true);
	}

}
