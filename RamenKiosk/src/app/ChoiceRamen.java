package app;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import component.CommonFrame;

public class ChoiceRamen extends CommonFrame {

	public ChoiceRamen() {

		JLabel menuLb[] = new JLabel[6];
		
		int i = 0;
		try(var rs = getResultSet("SELECT * FROM ramen ORDER BY r_order desc, r_name asc")){


			while (rs.next()) {
				// TODO : 마지막 라벨에서 크기가 전체가 되는 오류 수정
				
				JButton btn = new JButton(rs.getString("r_name"));
				
				menuLb[i] = new JLabel();
				menuLb[i].setBorder(new TitledBorder(new LineBorder(Color.black), rs.getString("r_name")));
				if ( i % 2 == 0 ) {
					add(setBounds(menuLb[i], 250, 150 + (i/2) * 200, 150, 150));
					add(setBounds(btn, 250, 170 + (i/2) * 200, 150, 25));
				}else {
					add(setBounds(menuLb[i], 50, 150 + (i/2) * 200, 150, 150));
					add(setBounds(btn, 50, 170 + (i/2) * 200, 150, 25));
				}

				i++;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
