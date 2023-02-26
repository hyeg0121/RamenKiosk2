package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class ChoiceOther extends KioskFrame {

	JTextArea area = new JTextArea();
	
	public ChoiceOther(String rName) {
		var pnl = new KioskPanel(getImage("otherBg"));
		add(pnl);

		KioskBtn btn[] = new KioskBtn[4];

		for(int i = 0; i < btn.length; i++) {
			try(var rs = getResultSet("select * from other where o_no = ?", i+1)){
				rs.next();

				btn[i] = new KioskBtn("other" + (i+1), rs.getString("o_name"));

				if( i % 2 == 0) {
					pnl.add(setBounds(btn[i], 50, 35+200*(i/2), 150, 190));
				}else {
					pnl.add(setBounds(btn[i], 245, 35+200*(i/2), 150, 190));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}//try
		}//for
		
		area.setBorder(new TitledBorder(new LineBorder(Color.black), "주문 금액"));
		area.setEditable(false);
		area.setFont(new Font("맑은 고딕", 0, 14));
		pnl.add(setBounds(area, 50, 450, 350, 200));
		area.setText("안녕:");
		// TODO : 효율적인 코드로 수정하기

		btn[0].addActionListener(e ->{

		});

		btn[1].addActionListener(e ->{

		});

		btn[2].addActionListener(e ->{

		});

		btn[3].addActionListener(e ->{

		});
		

	}

	public static void main(String[] args) {
		new ChoiceOther("진라면").setVisible(true);
	}

}
