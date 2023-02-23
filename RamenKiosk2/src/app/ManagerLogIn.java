package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.KioskFrame;

public class ManagerLogIn extends KioskFrame {
	
	public ManagerLogIn() {
		setSize(300, 150);
		setTitle("관리자 로그인");
		setLocationRelativeTo(null);
		
		add(setBounds(new JLabel("아이디"), 10, 20, 50, 24));
		add(setBounds(new JLabel("비밀번호"), 10, 60, 50, 24));
		
		JTextField idTf = new JTextField();
		JPasswordField pwTf = new JPasswordField();
		
		add(setBounds(idTf, 80, 20, 100, 24));
		add(setBounds(pwTf, 80, 60, 100, 24));
		
		JButton btn = new JButton("로그인");
		add(setBounds(btn, 190, 20, 80, 64));
		btn.addActionListener(e -> {
			try (var rs = getResultSet("select * from member where m_no = 1")){  //1번은 관리자 계정
				rs.next();
				
				if( idTf.getText().equals(rs.getString("m_name")) &&
					pwTf.getText().equals(rs.getString("m_pw"))) {
					msg("관리자로 로그인합니다.");
					new ManagerMain().setVisible(true);
					this.dispose();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
	}
	public static void main(String[] args){
		new ManagerLogIn().setVisible(true);
	}

}
