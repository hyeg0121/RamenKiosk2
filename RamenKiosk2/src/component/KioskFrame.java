package component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class KioskFrame extends JFrame{
	
	private Image bg; // 배경 이미지
	
	final int WIDTH = 450;
	final int HEIGHT = 800;
	
	public KioskFrame(String bgName) {
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("뽀글뽀글 키오스크");
		setSize(WIDTH, HEIGHT);
		bg = new ImageIcon(KioskFrame.class.getResource("../images/"+bgName+".png")).getImage();
	}
	
	/* 메소드 */
	
	//배경 이미지를 그림
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);//background를 그려줌
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
