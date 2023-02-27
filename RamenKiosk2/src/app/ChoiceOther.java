package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class ChoiceOther extends KioskFrame {

	JTextArea area = new JTextArea();
	boolean isChoice[] = { false, false, false, false };
	
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
		
		//TextArea
		area.setBorder(new LineBorder(Color.black));
		area.setEditable(false);
		area.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pnl.add(setBounds(area, 50, 450, 350, 200));
		
		try(var rs = getResultSet("select r_price from ramen where r_name = ?", rName)){
			rs.next();
			area.setText(rName+"\t\t" + rs.getString(1) + " 원\n");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO : 효율적인 코드로 수정하기

		btn[0].addActionListener(e ->{
			if(isChoice[0] ) {
				var answer = JOptionPane.showConfirmDialog(null, "취소하시겠습니까?");
			}
			try (var rs = getResultSet("select o_price from other where o_name = ?", btn[0].getText())){
				rs.next();
				area.setText(area.getText()+btn[0].getText()+"\t\t"+rs.getInt(1)+"원\n");
				isChoice[0] = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btn[1].addActionListener(e ->{
			try (var rs = getResultSet("select o_price from other where o_name = ?", btn[0].getText())){
				rs.next();
				area.setText(area.getText()+btn[1].getText()+"\t\t"+rs.getInt(1)+"원\n");
				isChoice[1] = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btn[2].addActionListener(e ->{
			try (var rs = getResultSet("select o_price from other where o_name = ?", btn[0].getText())){
				rs.next();
				area.setText(area.getText()+btn[2].getText()+"\t\t"+rs.getInt(1)+"원\n");
				isChoice[2] = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btn[3].addActionListener(e ->{
			try (var rs = getResultSet("select o_price from other where o_name = ?", btn[0].getText())){
				rs.next();
				area.setText(area.getText()+btn[3].getText()+"\t\t"+rs.getInt(1)+"원\n");
				isChoice[3] = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		KioskBtn backBtn = new KioskBtn("backBtn");
		pnl.add(setBounds(backBtn, 20, 670, 200, 60));
		backBtn.addActionListener(e ->{
			new ChoiceRamen().setVisible(true);
			dispose();
		});
		KioskBtn chargeBtn = new KioskBtn("chargeBtn");
		pnl.add(setBounds(chargeBtn, 225, 670, 200, 60));

	}

	public static void main(String[] args) {
		new ChoiceOther("진라면").setVisible(true);
	}

}
