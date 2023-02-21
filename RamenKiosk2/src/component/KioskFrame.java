package component;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class KioskFrame extends JFrame{
	
	
	final int WIDTH = 450;
	final int HEIGHT = 800;
	
	// TODO : 프레임이 화면 중앙에 나타나지 않는 오류 해결하기
	public KioskFrame() {
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("뽀글뽀글 키오스크");
		setSize(WIDTH, HEIGHT);
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
	
	
}	
