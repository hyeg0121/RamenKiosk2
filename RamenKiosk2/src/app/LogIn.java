package app;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class LogIn extends KioskFrame{

	public LogIn() {
		KioskPanel pnl = new KioskPanel(getImage("logInBg"));
		add(pnl);
		
		KioskBtn btn = new KioskBtn("logInBtn");
		pnl.add(setBounds(btn, 125, 540, 200, 60));
		
		JLabel nameLb = new JLabel("이름");
		nameLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pnl.add(setBounds(nameLb, 60, 240, 100, 35));
		
		JLabel pwLb = new JLabel("비밀번호");
		pwLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pnl.add(setBounds(pwLb, 60, 360, 100, 35));
		
		JTextField nameTf = new JTextField();
		pnl.add(setBounds(nameTf, 60, 290, 300, 35));
		
		JPasswordField pwTf = new JPasswordField();
		pnl.add(setBounds(pwTf, 60, 410, 300, 35));
		
		btn.addActionListener(e -> {
			if (nameTf.getText().length() == 0 ||
				pwTf.getText().length() == 0) {
				msg("빈칸이 존재합니다.");
				return ;
			}
			
			try(var rs = getResultSet("select * from member where m_name = ? and m_pw = ?", nameTf.getText(), pwTf.getText())){
				if(rs.next()) {
					int point = (int)((Payment.otherPrice + Payment.ramenPrice) * 0.1);
					updateSQL("update member set m_point = ? where m_name = ? and m_pw = ?", point, nameTf.getText(), pwTf.getText());
					msg(point+"p 가 적립되었습니다. 현재 포인트 "+rs.getInt("m_point")+"p");
					
					new Success().setVisible(true);
				}else {
					msg("이름 또는 비밀번호가 일치하지 않습니다.");
					nameTf.setText("");
					pwTf.setText("");
					nameTf.grabFocus();
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

	public static void main(String[] args) {
		new LogIn().setVisible(true);

	}

}
