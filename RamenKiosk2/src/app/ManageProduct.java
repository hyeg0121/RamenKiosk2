package app;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import component.KioskFrame;

public class ManageProduct extends KioskFrame {
	public ManageProduct() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 2, 10, 10));
		
		ArrayList<String> products = new ArrayList<>();
		
		var rs = getResultSet("select * from other ");
		try {
			while(rs.next()) {
				products.add(rs.getString("o_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (String product : products) {
			JButton btn = new JButton(product);
			add(btn);
			
			btn.addActionListener(e -> {
				
			});
		}
	}
	
	public static void main(String[] args) {
		new ManageProduct().setVisible(true);
	}

}
