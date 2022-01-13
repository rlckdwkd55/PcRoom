## KH정보교육원 MINI PROJECT.
### 작성자 : 임기창
### 교육기간 2021년 07월 26일 ~ 2021년 07월 30일


#

# JAVA GUI를 활용한 "피시방 주문 프로그램" 
## [최종보고서 링크](report/1조_미니프로젝트_최종.pdf)

- 회원가입, 로그인을 통하여 회원제 서비스 구현
- 충전하기 기능으로 음식주문 간편화
- 음식 수량을 정해두어 SoldOut 기능 구현

#

![사용 툴](https://user-images.githubusercontent.com/83908822/144542719-538a7fd2-2722-4088-a20a-ce49bf94104d.png)

### - 사용 언어 : JAVA
### - 툴 : Eclipse

# 담당페이지 설명 및 시연자료
## 해당 프로젝트에서 
### 1. 로그인/회원가입,
### 2. 결제/충전/금액 차감,
### 3. 가격의 합 부분을 구현하였습니다.

#

## 1. 로그인/회원가입
### JPanel을 활용하여 로그인, 회원가입 창을 구현하였습니다.
 - 반복문과 조건문을 활용하여 기존 회원이 있는지 대조할 수 있도록 구현하였습니다.
 - BufferedWriter과 FileWriter를 활용하여 회원명단.txt에 신규회원이 자동으로 등록되도록 하였습니다.
###

#

### 흐름
#### 사용자가 회원가입 버튼을 클릭하게 되면 화면이 전환되며 이름과 아이디, 비밀번호를 입력받습니다.
#### 해당 정보를 입력 후 저장버튼을 클릭하면 
#### 회원정보.txt파일에 입력한 정보들이 저장되고 정보를 바탕으로 로그인을 할 수 있습니다.

#

<img width=464 alt="메인화면" src="https://user-images.githubusercontent.com/83908822/144545360-1fa84788-75bb-416f-8b45-c3dbcb631317.png">
<img width=464 alt="메인화면" src="https://user-images.githubusercontent.com/83908822/144545431-2bb30377-ce43-4a0d-89b1-d0794ac48db8.png">

#### 정보 입력 후 아래 사진과 같이 자동적으로 데이터가 저장됩니다.

<img width=464 alt="회원명단" src="https://user-images.githubusercontent.com/83908822/144545567-4dc9778e-33e4-40d5-bca9-3d55ffae8ed1.png">

```java
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
```

#

## 1. 결제/충전/금액 차감
### 더욱 편리한 음식 주문을 위하여 금액을 미리 충전하고, 결제 시 금액이 차감되도록 하였습니다.
 - 버튼들을 이용하여 희망금액을 선택할 수 있도록 하였습니다.
 - 해당 금액만큼 투입금액에 값을 입력하고 만약 값이 작다면 충전되지 않도록, 이상이라면 거스름돈을 주도록 구현하였습니다.
 - 음식의 수량과 종류를 골라 주문버튼을 클릭 시 잔액이 음식의 가격보다 많다면 충전 금액에서 음식가격만큼 차감이 되도록 구현하였습니다.
###

#

### 충전 코드입니다.
```` java
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
````

#

### 메인화면에서 충전하기 버튼을 클릭하면 해당 화면으로 전환됩니다.

![충전](https://user-images.githubusercontent.com/83908822/144545758-56594bec-844d-4553-8b79-b0fbd07c54c6.png)

#

### 이어서 음식을 선택하고 결제하기 버튼을 클릭하면 잔액이 차감되는 모습을 보실 수 있습니다.

![잔액차감](https://user-images.githubusercontent.com/83908822/144545779-de232e0d-79ed-4432-8d55-3fd0e78c2e46.png)

#

![마무리](https://user-images.githubusercontent.com/83908822/144548113-cba184db-773f-4b5c-b1bc-abe5d2e18ca2.png)



