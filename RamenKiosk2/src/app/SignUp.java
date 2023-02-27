package app;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.KioskBtn;
import component.KioskFrame;
import component.KioskPanel;

public class SignUp extends KioskFrame {

	public SignUp() {
		KioskPanel pnl = new KioskPanel(getImage("signUpBg"));
		add(pnl);
		
		KioskBtn btn = new KioskBtn("signUpBtn");
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
		pwTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg("비밀번호로 사용될 숫자 4자리를 입력하세요.");
			}
		});
		
		btn.addActionListener(e -> {
			
			if (nameTf.getText().length() == 0 ||
				pwTf.getText().length() == 0) {
				msg("빈칸이 존재합니다.");
				return ;
			}
			
			if (nameTf.getText().length() > 10) {
				msg("이름은 최대 10글자 입니다.");
				return;
			}
			
			if (pwTf.getText().length() > 4) {
				msg("비밀번호는 숫자 4자리 입니다.");
			}
			
			try {
				int pw = Integer.parseInt(pwTf.getText());
			}catch (Exception ex) {
				msg("비밀번호는 숫자로만 이루어져야 합니다.");
				return;
			}
		});
		
		
	}

	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}

}
