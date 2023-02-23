package app;

import javax.swing.JButton;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class ChoiceRamen extends KioskFrame{
	
	public ChoiceRamen() {
		KioskPanel pnl = new KioskPanel(getImage("ramenBg"));
		add(pnl);
		
		for(int i = 0; i < 6; i++ ) {
			KioskBtn btn = new KioskBtn("ramen" +(i+1));
			
			if ( i % 2 == 0 ) {
				pnl.add(setBounds(btn, 50, 115+200*(i/2), 150, 185));
			}else {
				pnl.add(setBounds(btn, 240, 115+200*(i/2), 150, 185));
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ChoiceRamen().setVisible(true);
	}
	
}
