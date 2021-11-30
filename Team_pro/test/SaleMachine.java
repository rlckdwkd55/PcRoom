import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class SaleMachine extends JFrame {
	static JPanel page1=new JPanel() {
		Image background=new ImageIcon(SaleMachine.class.getResource("123.PNG")).getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌		
		}
	};
	public SaleMachine() {
		
		setTitle("1");//창의 타이틀
		setSize(400,600);//프레임의 크기s
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);
		
		JPanel pan = new JPanel();
		
		JButton btn = new JButton("hi");
		btn.setBackground(Color.black);
		
		setVisible(true);//창이 보이게	
		page1.setLayout(null);
		page1.setBounds(0, 0, 400, 600);
		add(page1);
		
		pan.add(btn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
		
		
		
	}
 
	
	public static void main(String[] args) {
		new SaleMachine();

	}

}

