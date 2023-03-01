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
		});
		
	}

	public static void main(String[] args) {
		new LogIn().setVisible(true);

	}

}
