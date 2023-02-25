package app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import component.KioskFrame;
import component.KioskPanel;

public class ChoiceOther extends KioskFrame {
	
	
	public ChoiceOther(String rName) {
		var pnl = new KioskPanel(getImage("otherBg"));
		pnl.setLayout(new BorderLayout());
		add(pnl);
		var northPnl = new JPanel(null);
		
		var centerPnl = new JPanel(null);
		
		
	}
	
	public static void main(String[] args) {
		new ChoiceOther("진라면").setVisible(true);
	}

}
