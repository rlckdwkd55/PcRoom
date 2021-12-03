
## KH정보교육원 MINI PROJECT
### 작성자 : 임기창
### 교육기간 2021년 07월 26일 ~ 2021년 07월 30일


#

# JAVA GUI를 활용한 "피시방 주문 프로그램" 

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
### 2. 결제/충전금액 차감,
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

