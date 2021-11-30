import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {

	JTextField t1, t2;
	private JTextField tf;
	private TextField pwf, t3;

	private JButton login;
	private JButton newname;
	JLabel loginText = new JLabel();
	private boolean isLogin = false;
	BufferedWriter data;
	File file = new File("회원명단.txt");
	String[] arr;

	public Login() {

		JPanel idPanel = new JPanel();
		JPanel passPanel = new JPanel();
		tf = new JTextField(15);
		pwf = new TextField(15);
		pwf.setEchoChar('*');

		loginText.setForeground(Color.RED);

		JLabel label = new JLabel("    ");
		JLabel idLabel = new JLabel("    ID   : ");
		idLabel.setBounds(60, 30, 100, 30);
		JLabel passLabel = new JLabel("PassWord : ");
		passLabel.setBounds(60, 70, 100, 30);

		login = new JButton("로그인");
		login.setBounds(225, 220, 100, 80);
		newname = new JButton("회원가입");

		add(label);
		add(idLabel);
		add(idPanel);
		add(passLabel);
		add(passPanel);

		idPanel.add(idLabel);
		idPanel.add(tf);

		passPanel.add(passLabel);
		passPanel.add(pwf);

		this.add(loginText);
		add(login);
		add(newname);

		setTitle("LOGIN");
		setLayout(new FlowLayout());
		setBounds(500, 300, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);

		// 배경색 바꾸기
		login.setBackground(new Color(255, 247, 242));
		newname.setBackground(new Color(255, 247, 242));

		// 글꼴
		idLabel.setFont(new Font("굴림체", Font.BOLD, 15));
		passLabel.setFont(new Font("굴림체", Font.BOLD, 15));
		login.setFont(new Font("굴림체", Font.BOLD, 15));
		newname.setFont(new Font("굴림체", Font.BOLD, 15));

		// 글자색 변경
		idLabel.setForeground(new Color(247, 99, 12));
		passLabel.setForeground(new Color(247, 99, 12));
		login.setForeground(new Color(247, 99, 12));
		newname.setForeground(new Color(247, 99, 12));

		// 버튼 테두리 없애기
		login.setBorderPainted(false);
		newname.setBorderPainted(false);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					FileReader filereader = new FileReader(file);
					BufferedReader bufReader = new BufferedReader(filereader);
					String line;

					while ((line = bufReader.readLine()) != null) {
						arr = line.split("/");
						try {
							for (int i = 1; (i < arr.length) && (i % 3 != 0); i++) {

								if (tf.getText().equals(arr[i]) && pwf.getText().equals(arr[i + 1])) {

									dispose();
									new Test();
									isLogin = true;

								}
							}
						} catch (ArrayIndexOutOfBoundsException ex) {
							System.out.print("");
						}

					}

					if (!isLogin) {

						if ((!tf.getText().equals("") && !pwf.getText().equals("")))

							JOptionPane.showMessageDialog(null, "아이디나 패스워드가 일치하지 않습니다!");
						else {

							JOptionPane.showMessageDialog(null, "아이디 및 패스워드를 모두 입력해주세요!");

						}
					}

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

		});

		newname.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MeberInfo();

			}

		});

	}

	public void MeberInfo() {
		JFrame frame = new JFrame("회원 가입");
		frame.setBounds(0, 0, 500, 500);
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 500, 500);
		Label l1 = new Label("이름");
		Label l2 = new Label("아이디");
		Label l3 = new Label("패스워드");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new TextField();

		p.add(l1);
		p.add(l2);
		p.add(l3);

		p.add(t1);
		p.add(t2);
		p.add(t3);

		t3.setEchoChar('*');
		RoundedButton j1 = new RoundedButton("저장");
		j1.setFont(new Font("고딕", Font.BOLD, 18));

		RoundedButton j2 = new RoundedButton("취소");
		j2.setFont(new Font("고딕", Font.BOLD, 18));

		p.add(j1);
		p.add(j2);
		l1.setBounds(40, 30, 40, 40);
		l2.setBounds(40, 70, 40, 40);
		l3.setBounds(40, 110, 60, 40);

		t1.setBounds(120, 30, 200, 30);
		t2.setBounds(120, 70, 200, 30);
		t3.setBounds(120, 110, 200, 30);

		j1.setBounds(80, 250, 150, 70);
		j2.setBounds(250, 250, 150, 70);

		frame.add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {

				// 회원가입 데이터 저장
				if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 입력해주세요!");

				}

				else {

					try {
						data = new BufferedWriter(new FileWriter("회원명단.txt", true));

						data.write(t1.getText() + "/");
						data.write(t2.getText() + "/");
						data.write(t3.getText() + "/" + "\n");

						data.close();
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
						frame.dispose();
						setVisible(true);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					}
				}
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				setVisible(true);

			}

		});

	}

	public static void main(String[] args) {
		new Login();
	}

}
