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
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramenkiosk", "root", "1234");
	Statement stmt = con.createStatement();
	
	public ManagerLogIn() throws SQLException {
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
			// TODO : 로그인 기능 만들기
			new ManagerMain().setVisible(true);
		});
		
	}
	public static void main(String[] args) throws SQLException {
		try {
			new ManagerLogIn().setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
