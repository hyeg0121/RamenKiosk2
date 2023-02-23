package component;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class KioskFrame extends JFrame{
	
	static Connection con;
	static Statement stmt;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramenkiosk", "root", "1234");
			stmt = con.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public final int WIDTH = 450;
	public final int HEIGHT = 800;
	
	// TODO : 프레임이 화면 중앙에 나타나지 않는 오류 해결하기
	public KioskFrame() {
		setLayout(null);
		setTitle("뽀글뽀글 키오스크");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	//setBounds를 편리하게 사용할 수 있도록 함
	public static JComponent setBounds(JComponent comp, int x, int y, int width, int height) {
		comp.setBounds(x, y, width, height);
		return comp;
	}
	
	//이미지 이름을 입력받아 이미지 아이콘으로 돌려줌
	public static Image getImage(String imgName) {
		Image img = new ImageIcon(KioskFrame.class.getResource("../images/"+imgName+".png")).getImage();
		return img;
	}
	
	//prepare statement를 편리하게 쓰기 위한 메소드
	public static ResultSet getResultSet(String sql, Object...parameter) {
		try {
			var pstmt = con.prepareStatement(sql);
			for (int i = 0; i < parameter.length; i++) {
				pstmt.setObject(i+1, parameter[i]);
			}
			
			return pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet updateSQL(String sql, Object...parameter) {
		try {
			var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			for (int i = 0; i < parameter.length; i++) {
				pstmt.setObject(i+1, parameter[i]);
			}
			
			pstmt.executeUpdate();
			
			return pstmt.getGeneratedKeys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}	
