package app;

import javax.swing.JButton;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class ChoiceRamen extends KioskFrame{

	public ChoiceRamen() {
		KioskPanel pnl = new KioskPanel(getImage("ramenBg"));
		add(pnl);

		KioskBtn btn[] = new KioskBtn[6];

		for(int i = 0; i < btn.length; i++ ) {

			try(var rs = getResultSet("select * from ramen where r_no = ?", i+1)){
				rs.next();
				
				btn[i] = new KioskBtn("ramen" +(i+1), rs.getString("r_name"));

				if ( i % 2 == 0 ) {
					pnl.add(setBounds(btn[i], 50, 115+200*(i/2), 150, 185));
				}else {
					pnl.add(setBounds(btn[i], 240, 115+200*(i/2), 150, 185));
				}

			}catch(Exception ex) {
				ex.printStackTrace();
			}// try



		}// for

		// TODO : 효율적인 코드로 수정하기

		btn[0].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[0].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[0].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btn[1].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[1].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[1].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btn[2].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[2].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[2].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		btn[3].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[3].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[3].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		btn[4].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[4].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[4].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		btn[5].addActionListener(e -> {

			try (var rs = getResultSet("select * from ramen where r_name = ?", btn[5].getText())){
				rs.next();
				
				//라면 값
				Payment.ramenPrice = rs.getInt("r_price");

				new ChoiceOther(btn[5].getText()).setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}// construct

	public static void main(String[] args) {
		new ChoiceRamen().setVisible(true);
	}

}
