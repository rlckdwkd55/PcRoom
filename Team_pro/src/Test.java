import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Test {
	// 변수 및 배열 설정
	int sum;                  
	int total_sum;
	int index = 1;
	int last_money;
public static JLabel money_la;
	Charge ch;
	

	public JFrame frame;
	String RiceMenu[] = { "참치마요덮밥　", "오삼불고기덮밥", "치킨커리볶음밥", "　김치볶음밥　", "　제육덮밥　　", "　낙지덮밥　　", "　새우볶음밥　", "대패삼겹비빔밥" };
	String NoodleMenu[] = {"　　너구리　", "　오징어짬뽕　", "　　간짬뽕　　", "　안성탕면　　", "　짜파게티　　", "　삼양라면　　", "　　진라면　　", "　불닭볶음면　"};
	String DrinkMenu[] = { "　게토레이　　", "　　사이다　　", "　　레쓰비　　", "　　핫식스　　",  "　카페라떼　　", "　　포카리　　", "　코카콜라　　",  "　　코코팜　　" };
	
    int Rice_price[] = { 5000, 5500, 4500, 4500, 6500, 5000, 4500, 6500 };
    int Noodle_price[] = { 3000, 3000, 3500, 3000, 3500, 3000, 3000, 3500 };
    int Drink_price[] = { 1000, 1000, 1000, 1200, 2500 , 1000, 1500, 1000 }; 
    int[] count = new int [RiceMenu.length];
   
    JButton bt[] = new JButton[RiceMenu.length];
    TextField num[] = new TextField[RiceMenu.length];
    RoundedButton minus[] = new RoundedButton[RiceMenu.length];
    RoundedButton plus[] = new RoundedButton[RiceMenu.length];
    RoundedButton ok[] = new RoundedButton[RiceMenu.length];
    
    Label product_la[] = new Label[RiceMenu.length];
    Label price_la[] = new Label[RiceMenu.length];
    
    Label product_la2[] = new Label[RiceMenu.length];
    Label price_la2[] = new Label[RiceMenu.length];
    
   
   
    // 아이콘 이름 배열 설정
    String Rice_iconName[] = { "참치마요덮밥.PNG" , "오삼불고기덮밥.PNG" , "치킨커리볶음밥.PNG" , "김치볶음밥.PNG" , "제육덮밥.PNG" , "낙지덮밥.PNG", "새우볶음밥.PNG" , "대패삼겹비빔밥.PNG"};
    String Noodle_iconName[] = { "너구리.PNG" , "오징어짬뽕.PNG" , "간짬뽕.PNG" , "안성탕면.PNG" , "짜파게티.PNG" , "삼양라면.PNG","진라면.PNG" , "불닭볶음면.PNG"};
    String Drink_iconName[] = { "게토레이.PNG" , "사이다.PNG" , "레쓰비.PNG" , "핫식스.PNG" , "카페라떼.PNG" , "포카리.PNG","코카콜라.PNG" , "코코팜.PNG"};
    ImageIcon icon[] = new ImageIcon[8];	
    ImageIcon icon1 = new ImageIcon();
    
    Font font = new Font(Font.DIALOG, Font.PLAIN, 12);
    Font font1 = new Font(Font.DIALOG, Font.BOLD, 18);
      
		String show = "";
    Panel pNorth = new Panel();
    
	public Test() {
		frame = new JFrame("1조의 먹거리 자판기 ver1.0 ");
		frame.setBounds(0, 0, 625,1000);
		
	 
	        pNorth.setBackground(Color.white);
	        pNorth.setLayout(null);
	        pNorth.setSize(0, 650);
	        pNorth.setFont(font);
	        
	     
	        Menu(); // 메뉴 함수 호출
	     
	        frame.add(pNorth, BorderLayout.NORTH);
	        frame.setVisible(true);
	 
	
	
	  // 중앙 출력
	        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	     	ta.setText("            상품명                가격        수량        합계\n\n");
	        ta.setBackground(Color.white);
	        ta.setEditable(false);
	        ta.setFont(font1);

    // 아래쪽 출력
	        Panel pSouth = new Panel();
	        pSouth.setPreferredSize(new Dimension(250,70));
	        pSouth.setFont(font);
	        pSouth.setBackground(Color.gray);
	        
	        RoundedButton btn1 = new RoundedButton("충전하기");
	        btn1.setPreferredSize(new Dimension(110,70));
	        btn1.setFont(new Font("고딕", Font.BOLD , 22));
	        
	        RoundedButton bt1 = new RoundedButton("구매하기");
	        bt1.setPreferredSize(new Dimension(110,70));
	        bt1.setFont(new Font("고딕", Font.BOLD , 22));
	        
	        RoundedButton bt2 = new RoundedButton("전체 삭제");
	        bt2.setPreferredSize(new Dimension(110,70));
	        bt2.setFont(new Font("고딕", Font.BOLD , 22));
	           
	        RoundedButton bt3 = new RoundedButton("창 닫기");
	        bt3.setPreferredSize(new Dimension(110,70));
	        bt3.setFont(new Font("고딕", Font.BOLD , 22));
	        pSouth.add(btn1);
	        pSouth.add(bt1);
	        pSouth.add(bt2);
	        pSouth.add(bt3);
	       

	 // 충전하기 버튼
	 
     btn1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
					
					new Charge();
			
			
		
			 
			
		}	 
    	 
    	 
     });

	       

	        
     // 주문버튼
     bt1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
             if(ch.total_money > total_sum) {  
             last_money = ch.total_money - total_sum;
             money_la.setText("잔액: " + last_money + "원");
             ch.total_money = last_money;
             JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다.                총 합계 :   " + total_sum + "원" + "\n이용해주셔서 감사합니다.");
             for (int i = 0; i < RiceMenu.length; i++) {
                 bt[i].setEnabled(true);
                 minus[i].setEnabled(false);
                 plus[i].setEnabled(false);
                 num[i].setText("   0");
                 ta.setText("            상품명                가격        수량        합계\n\n");
               
                total_sum = 0;
                index = 1;
             }
             }
            
            else {
            	 JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
            }
        }
    });

    // 전체 삭제 버튼
    bt2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	total_sum = 0;
            for (int i = 0; i < RiceMenu.length; i++) {
                bt[i].setEnabled(true);
                minus[i].setEnabled(false);
                plus[i].setEnabled(false);
                num[i].setText("    0");
                ta.setText("            상품명                가격        수량        합계\n\n");

            }
        }
    });


    //bt3 닫기버튼
    
    bt3.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });


    // 컴포넌트
    frame.add(pNorth, BorderLayout.NORTH);
    frame.add(ta, BorderLayout.CENTER);
    frame.add(pSouth, BorderLayout.SOUTH);
    frame.setVisible(true);

    // 이벤트단
    for (int i = 0; i < RiceMenu.length; i++) {
        int j = i;

        // 상품 버튼 이벤트
        bt[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minus[j].setEnabled(true);
                plus[j].setEnabled(true);
                ok[j].setEnabled(true);

                count[j] = 0;
            }
        });

        // "-" 버튼 이벤트
        minus[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count[j] > 0) {
                    count[j] = count[j] - 1;
                    num[j].setText("   "+ count[j] + "");
                    ok[j].setEnabled(true);
                } else {
                    minus[j].setEnabled(false);
                }
            }
        });
        
        // "+" 버튼 이벤트
        plus[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               count[j]++;
                num[j].setText("   "+ count[j] + "");
                ok[j].setEnabled(true);
                
                if (count[j] > 0) {
                    minus[j].setEnabled(true);
                }
                
                if (count[j] > 9) {
                	plus[j].setEnabled(false);
                }
                
                
              
            }
        });
         
        //확인 버튼 이벤트
        ok[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	 if(count[j] > 9) {
                     icon[j] = new ImageIcon("rice/Soldout.png");
                     bt[j].setIcon(icon[j]);
                    
                           }
            	 
            	if(index == 1 ) {
            	sum = Rice_price[j] * count[j];
            	
                show = bt[j].getActionCommand();
                ta.append("         " + RiceMenu[j] + "        " + Rice_price[j] + "        " + count[j] + "         " + sum
                        + "원" + "\n");
              
                ok[j].setEnabled(false);
                plus[j].setEnabled(false);
                minus[j].setEnabled(false);
               
                
               
                	
                count[j] = 0;
                
               
                num[j].setText("   0");
                total_sum += sum;
                
                
            	}
            
            else if(index == 2) {
            	sum = Noodle_price[j] * count[j];

                show = bt[j].getActionCommand();
                ta.append("         " + NoodleMenu[j] + "        " + Noodle_price[j] + "        " + count[j] + "         " + sum
                        + "원" + "\n");
                ok[j].setEnabled(false);
                plus[j].setEnabled(false);
                minus[j].setEnabled(false);
                count[j] = 0;

                num[j].setText("   0");
                total_sum += sum;
            }
            else if(index == 3) {
            	sum = Drink_price[j] * count[j];

                show = bt[j].getActionCommand();
                ta.append("         " + DrinkMenu[j] + "        " + Drink_price[j] + "        " + count[j] + "         " + sum
                        + "원" + "\n");
                ok[j].setEnabled(false);
                plus[j].setEnabled(false);
                minus[j].setEnabled(false);
                count[j] = 0;

                num[j].setText("   0");
                total_sum += sum;
            }
            
            }  
            
        });

    }

    // 끄기
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
}
	
	public void Menu() {
		
		RoundedButton btn = new RoundedButton("Rice");
        btn.setBounds(0, 0, 200, 50);
        
        
        RoundedButton btn2 = new RoundedButton("Noodle");
        btn2.setBounds(200, 0, 200, 50);
        
        RoundedButton btn3 = new RoundedButton("Drink");
        btn3.setBounds(400, 0, 200, 50);
        
        
        
        btn.setFont(font1);
        btn2.setFont(font1);
        btn3.setFont(font1);
        
       pNorth.add(btn);
       pNorth.add(btn2);
       pNorth.add(btn3);
	      
  
    
         
        for (int i = 0; i < RiceMenu.length; i++) {
        	 
            // 밥 버튼
            bt[i] = new JButton(RiceMenu[i]);
            
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 100, 100, 100);                     
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 350, 100, 100);
            }
            
    
            icon[i] = new ImageIcon("rice/" + Rice_iconName[i]);
            bt[i].setIcon(icon[i]);
         
          
            
           
            // 숫자 txt 버튼
            num[i] = new TextField("   0");
            num[i].setBackground(Color.white);
            num[i].setEditable(false);
      
            num[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 160, 40, 20);
 
            // "-" 버튼
            minus[i] = new RoundedButton("-");
      
            minus[i].setBounds(bt[i].getX(), num[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new RoundedButton("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), num[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 상품명
            product_la[i] = new Label(RiceMenu[i]);
            product_la[i].setBounds(bt[i].getX() + 10, num[i].getY()- 55 , 100, 20);
           
            
            // 가격
            price_la[i] = new Label("　" + Rice_price[i] + "원");
            price_la[i].setBounds(bt[i].getX() + 20, num[i].getY()- 30 , 100, 20);
 
            // 확인 버튼
            ok[i] = new RoundedButton("확인");
            ok[i].setBounds(bt[i].getX(), num[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
           
           // 현재 잔액
         
            money_la = new JLabel();
            money_la.setFont(new Font("고딕", Font.ITALIC, 16));
            money_la.setBounds(480 , 600 ,130, 20);
        
        	
        	
            
          
            pNorth.add(bt[i]);
            pNorth.add(num[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(product_la[i]);
            pNorth.add(price_la[i]);
            pNorth.add(ok[i]);
            pNorth.add(money_la);
        }
        
        // btn(밥류) 
        btn.addActionListener(new ActionListener() {
        	
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		
    			index = 1;
    	    String temp = btn.getText();
    	    if(temp.equals("Rice")) {
    	    	
    	for(int i = 0; i < RiceMenu.length; i++) {
    		 icon[i] = new ImageIcon("Rice/" + Rice_iconName[i]);
             bt[i].setIcon(icon[i]);
             
          // 상품명
             product_la[i].setText(RiceMenu[i]);
             product_la[i].setBounds(bt[i].getX() + 10, num[i].getY()- 55 , 100, 20);
          
             
             // 가격
             price_la[i].setText(Rice_price[i] + "원");
             price_la[i].setBounds(bt[i].getX() + 20, num[i].getY()- 30 , 100, 20);
             
             pNorth.add(product_la[i]);
             pNorth.add(price_la[i]);
    		
    	}
    	    
    		
    					}
    		}
    	});
        
    	// btn2(누들류)
    	btn2.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			index = 2;
    			 String temp2 = btn2.getText();
    			 
    		    if(temp2.equals("Noodle")) {
    		             
    	    	for(int i = 0; i < NoodleMenu.length; i++) {
    		    		 icon[i] = new ImageIcon("noodle/" + Noodle_iconName[i]);
    		             bt[i].setIcon(icon[i]);
    		             
    		             // 상품명
    		             product_la[i].setText(NoodleMenu[i]);
    		             product_la[i].setBounds(bt[i].getX() + 10, num[i].getY()- 55 , 100, 20);
    		          
    		             
    		             // 가격
    		             price_la[i].setText(Noodle_price[i] + "원");
    		             price_la[i].setBounds(bt[i].getX() + 20, num[i].getY()- 30 , 100, 20);
    		             
    		             pNorth.add(product_la[i]);
    		             pNorth.add(price_la[i]);
    		    		
    		    	}
    					}
    		}
    		
    	});
    	
    	// btn3(음료류)
    	btn3.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			index = 3;
    			 String temp3 = btn3.getText();
    			 
    		    if(temp3.equals("Drink")) {
    		             
    	    	for(int i = 0; i < DrinkMenu.length; i++) {
    		    		 icon[i] = new ImageIcon("Drink/" + Drink_iconName[i]);
    		             bt[i].setIcon(icon[i]);
    		             
    		             // 상품명
    		             product_la[i].setText(DrinkMenu[i]);
    		             product_la[i].setBounds(bt[i].getX() + 10, num[i].getY()- 55 , 100, 20);
    		          
    		             
    		             // 가격
    		             price_la[i].setText(Drink_price[i] + "원");
    		             price_la[i].setBounds(bt[i].getX() + 20, num[i].getY()- 30 , 100, 20);
    		             
    		             pNorth.add(product_la[i]);
    		             pNorth.add(price_la[i]);
    		    		
    		    	}
    					}
    		}
    		
    	});
    	
        
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	
	
	
	

}

class RoundedButton extends JButton {
    public RoundedButton() { super(); decorate(); } 
    public RoundedButton(String text) { super(text); decorate(); } 
    public RoundedButton(Action action) { super(); decorate(); } 
    public RoundedButton(Icon icon) { super(icon); decorate(); } 
    public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
    protected void decorate() { setBorderPainted(false); setOpaque(false); }
    @Override 
    protected void paintComponent(Graphics g) {
       Color c=new Color(255,247,242); //배경색 결정
       Color o=new Color(247,99,12); //글자색 결정
       int width = getWidth(); 
       int height = getHeight(); 
       Graphics2D graphics = (Graphics2D) g; 
       graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
       if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
       else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
       else { graphics.setColor(c); } 
       graphics.fillRoundRect(0, 0, width, height, 10, 10); 
       FontMetrics fontMetrics = graphics.getFontMetrics(); 
       Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
       int textX = (width - stringBounds.width) / 2; 
       int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
       graphics.setColor(o); 
       graphics.setFont(getFont()); 
       graphics.drawString(getText(), textX, textY); 
       graphics.dispose(); 
       super.paintComponent(g); 
       }
    }


