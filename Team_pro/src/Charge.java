import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Charge {
	
	
	
	public JLabel label1, label2, label3;
	public JTextField total, input, change;
	public RoundedButton bt[] = new RoundedButton[4];
	RoundedButton cbtn = new RoundedButton();
	int sum = 0;
	public static int money;
	public static int total_money;
	Font font = new Font("맑은고딕", Font.BOLD, 15);
	Font ffont = new Font("맑은고딕", Font.BOLD, 10);
    Font font1 = new Font("맑은고딕", Font.PLAIN, 9);
    Test te;
   
	
	public Charge() {	
		
		JFrame charge_frame = new JFrame("충전 하기");
		charge_frame.setBounds(0, 0, 625,850);
		
	Label label = new Label("충전 하실 금액을 눌러주세요!");
	label.setFont(new Font("바탕", Font.BOLD, 30));
	label.setBounds(100,100,625,100);
	
	
		
   	Panel Npan = new Panel();
		   	Npan.setLayout(null);    // 충전 금액 선택
		    Npan.setSize(0, 450);
		    Npan.add(label);
		    
	    RoundedButton[] btns = new RoundedButton[4];
		String[] price = { "1000원", "5000원", "10000원", "50000원" };
		int sum = 0;
		
		 for (int i = 0; i < btns.length; i++) {
        	 
	           
	            btns[i] = new RoundedButton(price[i]);
	            btns[i].setBounds(i * 160, 250, 138, 138);       
	            btns[i].setFont(new Font("고딕", Font.BOLD, 20));
	            Npan.add(btns[i]);
	            
	            btns[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String text = e.getActionCommand();  // 1000원
						int charge = Integer.parseInt(text.replace("원", ""));
						
					total.setText(String.valueOf(Integer.parseInt(total.getText()) + charge));
					money = Integer.parseInt(total.getText());
				
		  
				
					}
				});
	            
		 }   
		 
		
	charge_frame.add(Npan,BorderLayout.NORTH);
	
	
	// 남쪽 패널
	Panel Span = new Panel();
	Span.setLayout(null);
	
	JPanel pan2 = new JPanel(); // 충전 및 결과 표시
	pan2.setBounds(0, 300, 625, 300);
	pan2.setBackground(Color.white);
	pan2.setLayout(null);
	
	label1 = new JLabel("충전 합계 : ");
	label1.setFont(font);
	label1.setBounds(60, 30, 100, 30);
	
	total = new JTextField(10);
	total.setText("0");
	total.setEditable(false);
	total.setBounds(160, 30, 325, 30);
	
	label2 = new JLabel("투입 금액 : ");
	label2.setFont(font);
	label2.setBounds(60, 70, 100, 30);
	input = new JTextField(10);
	input.setBounds(160, 70, 325, 30);
	
	cbtn = new RoundedButton("충전"); // 충전 버튼
	cbtn.setFont(new Font("고딕",Font.BOLD, 20));
	
	cbtn.setBounds(490, 70, 80,30);
	cbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			try {
			int totalm = Integer.parseInt(total.getText());
			int inputm = Integer.parseInt(input.getText());
			if(inputm >= totalm) {
				
			
			change.setText(String.valueOf(inputm - totalm));
			JOptionPane.showMessageDialog(pan2, "충전 완료");
			total_money += money;
			total.setText("0");
			input.setText("0");
		
			te.money_la.setText("잔액 : " + total_money + "원");
			
			
			} else {
				JOptionPane.showMessageDialog(null,"투입 금액이 충전 금액보다 부족합니다.");
				
			}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"숫자를 입력해주세요!");
			}
			
			
			
		}
	}); 
	
	label3 = new JLabel("거스름돈 : ");
	label3.setFont(font);
	label3.setBounds(60,130, 100, 30);
	
	change = new JTextField(20);
	change.setBounds(160, 110, 325, 30);
	change.setEditable(false);
	
	Span.add(label1);
	Span.add(total);
	Span.add(label2);
	Span.add(input);
	Span.add(cbtn);
	Span.add(label3);
	Span.add(change);

	
	
	

	charge_frame.add(Span,BorderLayout.CENTER);
	charge_frame.setVisible(true);
	
	RoundedButton home = new RoundedButton("홈으로");
	home.setFont(new Font("고딕", Font.BOLD, 22));
	home.setBounds(225,220,150,100);
	home.setFont(font);
	Span.add(home);
	
	home.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			charge_frame.setVisible(false);
			
						
			
			
		}
	});
	
	}
	


}

