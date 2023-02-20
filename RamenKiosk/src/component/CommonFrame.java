package component;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CommonFrame extends JFrame {
	
	//프레임 사이즈
	final int WIDTH = 450;
	final int HEIGHT = 800;
	
	//sql
	static Connection con;
	static Statement stmt;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ramenkiosk",
					"root", "1234");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 생성자 */
	public CommonFrame() {
		setSize(450, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
	}

	/* 메소드 */
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
			var pstmt = con.prepareStatement(sql);
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
	
	public static JComponent setBounds(JComponent comp, int x, int y, int width, int height) {
		comp.setBounds(x, y, width, height);
		return comp;
	}
}
