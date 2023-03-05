package app;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import component.KioskFrame;

public class EditProduct extends KioskFrame {
	
	public static String otherName = "치즈";
	
	public EditProduct() {
		this.setSize(350, 240);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		
		JLabel title = new JLabel(otherName);
		title.setFont(new Font("맑은 고딕", 1, 20));
		title.setHorizontalAlignment(0);
		add(setBounds(title, 0, 10, this.getWidth(), 50));
		
		JTextField stockTf = new JTextField();
		add(setBounds(new JLabel("재고"), 10, 60, 50, 30));
		add(setBounds(stockTf, 70, 60, 230, 30));
		
		var rs = getResultSet("select * from other where o_name = ?", otherName);
		try {
			while(rs.next()) {
				stockTf.setText(rs.getString("o_stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JButton btn = new JButton("수정");
		add(setBounds(btn, 75, 120, 200, 25));
		btn.addActionListener(e -> {
			
			if(stockTf.getText().length() == 0) {
				msg("빈칸은 존재할 수 없습니다.");
				stockTf.grabFocus();
				return;
			}
			
			updateSQL("update other set o_stock = ? where o_name =?", 
					Integer.parseInt(stockTf.getText()), otherName);
			msg("수정이 완료되었습니다.");
		});
	}
	public static void main(String[] args) {
		new EditProduct().setVisible(true);
	}

}
