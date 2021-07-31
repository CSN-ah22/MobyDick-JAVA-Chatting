# 자바 스터디 멘토 활동 자료
모비딕 동아리에서 멘토 활동을 하게 되었습니다</br>
수업시간에 이미 한번 만들었던 채팅프로그램을 멘토링 할겁니다</br>
다른사람에게 어떻게 하면 쉽게 코드를 이해전달 시킬지</br>
그리고 완전히 제 자신의 것으로 만들기 위해 부족한 부분이 어디인지</br>
이번 멘토링을 통해 고민해 보면서 채팅프로그램을 완성시키는 것이 목표입니다!</br>
# 2주차

- 숙제 코드

    ```java
    				JButton bt_join = new JButton("회원가입");
            bt_join.setBounds(120,300,260,30);
            bt_join.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("회원가입을 요청했습니다");
                }
            });
            f.add(bt_join);

            JButton bt_setting = new JButton("환경설정");
            bt_setting.setBounds(120,350,260,30);
            bt_setting.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("환경설정 편집을 요청했습니다");
                }
            });
            f.add(bt_setting);
    ```

- 숙제 결과 화면

    <img src="https://user-images.githubusercontent.com/70833455/127742009-d11efdcf-8ffd-46bb-b445-3f7ee065a22c.png" width="300px" height="300px">

- 오늘의 완성본

    <img src="https://user-images.githubusercontent.com/70833455/127742032-5d6677b8-6084-4180-aa51-743a16341bcd.png" width="300px" height="300px">

## 중복된 코드를 줄이기 위해 정리하기

✨LoginPanel

> 저번 시간에는 비밀번호 입력 칸을 JTextField를 이용하였습니다. 하지만 비밀번호를 입력할 시에는 아래 사진과 같이 입력하고 있는 글자가 안 보이게 하기 위해 JPasswordField를 사용합니다.

<img src="https://user-images.githubusercontent.com/70833455/127742060-87d2e532-fbff-4cb2-9720-263afb1214a5.png" width="344px" height="44px">

- 전역변수 선언

```java
private JPasswordField pwField;
private JTextField idField;
```

- 전역변수? 지역변수?

    전체에서 **어디서든 호출**하면 사용할수 있는 변수는 **전역변수**

    **특정한 구역({ })안**에 생성되어 그 지역에만 사용할수 있는 변수는 **지역변수**

```java
idField = new JTextField();
pwField = new JPasswordField();
```

- ✨Main

    ```java
    	public class Main {
        public static JFrame f;
        private static LoginPanel loginPage;

        public static void main(String[] args) {

            f = new JFrame();

            loginPage = new LoginPanel();
            f.add(loginPage);

            f.setSize(500, 500);
            f.setLayout(null);
            f.setVisible(true);

        }
    }
    ```

💥여기서 잠깐!

JFrame으로 창을 띄웠다가 우측 상단에 X표를 누르면 우리 눈에는 창이 닫히는 것처럼 보이지만 실제로는 작업관리자 프로세스를 보면 아직 가동 중인 프로세스를 발견할 수 있습니다.

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 을 하면 윈도우창 종료 시 프로세스까지 깔끔하게 닫을 수 있습니다. (이제는 ⏹버튼을 따로 눌러주지 않아도 됩니다.)

- 생성자

    ```java
    public LoginPanel() {
        setView();

        setBackground(Color.ORANGE);
        setSize(500,500);
        setLayout(null);
    }
    ```

- setView 메소드

    f.을 없이 바로 add해줘도 됩니다.

## 회원가입 화면 만들기

- ✔ JoinPanel 클래스 만들기
    1. Panel 패키지를 우클릭하고 New > Java Class 를 클릭합니다.
    2. JoinPanel 이라고 입력하고 엔터를 누릅니다.
    3. extends 키워드를 사용하여 JPanel을 상속 받습니다. 

- ✔ JoinPanel 기본 생성자 만들기

    ```java
    public JoinPanel(){
            setBackground(Color.LIGHT_GRAY);
            setSize(500,500);
            setLayout(null);
        }
    ```

    - 1주차 시간에 배웠던 JFrame 메서드 참고!

- ✔ main 클래스에 JoinPanel 클래스 호출하기
    - 전역변수 joinPage 선언

        ```java
        private static JoinPanel joinPage;
        ```

    - JoinPanel 객체 생성 후 JFrame에 추가

        ```java
        joinPage= new JoinPanel();
        f.add(joinPage);

        f.setVisible(true); //가장 아래로 옮겨주세요
        ```

- ✔ JoinPanel 클래스에 전역변수 선언

    ```jsx
    private JTextField nameField;
    private JTextField emailField;
    ```

- ✔ JoinPanel 클래스에 setView() 메소드 생성하기

    ```java
    private void setView() {

    JLabel label_name = new JLabel("이름");
        label_name.setBounds(120, 50, 60, 30);
        add(label_name);
        nameField = new JTextField();
        nameField.setBounds(180, 50, 200, 30);
        add(nameField);

    JLabel label_email = new JLabel("이메일");
        label_email.setBounds(120, 100, 60, 30);
        add(label_email);
        emailField = new JTextField();
        emailField.setBounds(180, 100, 200, 30);
        add(emailField);

    JButton bt_join = new JButton("가입하기");
        bt_join.setBounds(120, 350, 260, 30);
        bt_join.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvente e) {
    		System.out.println("회원가입을 요청했습니다");
    		        }
    		    });
        add(bt_join);

    JButton bt_back = new JButton("<"); //로그인 화면으로 이동
        bt_back.setBounds(10,10,50,30);
        add(bt_back);
    }
    ```

✔ 생성자에 setView() 메소드 호출

## 화면 이동

- 실행시 로그인 화면과 회원가입 화면이 동시에 나오는 문제를 해결하려 합니다
- 로그인 창에서 회원 가입 버튼을 누를 시에만 회원가입 창이 열리도록하는 기능 구현이 목표입니다

## 화면 이동 실습

- ✔ main 클래스에 movePage 메소드 만들기
    - ✨조건문 - swith문

    ```java
    public static void movePage(int index) {
    loginPage.setVisible(false);//화면을 끕니다
    joinPage.setVisible(false);//화면을 끕니다

        switch (index) {
            case 1:
    						f.setTitle("Chat - 로그인 화면");
    						loginPage.setVisible(true);
                break;
            case 2:
    						f.setTitle("Chat - 회원가입 화면");
    						joinPage.setVisible(true);
                break;
        }
    }
    ```

✔ main 메소드에 movePage(1); 설정하고 회원가입 버튼 클릭 시 movePage(2); 설정

- ✔ JoinPanel 클래스에 < 버튼 클릭 시 로그인 페이지로 넘어가도록 하기

    ```java
    bt_back.addActionListener(newActionListener() {
    @Override
    public void actionPerformed(ActionEvente) {
    Main.movePage(1);
    //Main 클래스를 참조하여 movePage 메서드를 호출합니다 
        }
    });
    ```

## 숙제

아래 그림과 같이 나머지 부분을 완성시켜주세요!

<img src="https://user-images.githubusercontent.com/70833455/127742076-ef1d9369-7e43-47c0-8e5c-e3b8de123b8d.png" width="507px" height="265px">

🍀 **아이디 라벨** 위치/크기 : x :120  y :150  / w:60  h:30

🍀 **아이디 필드** 위치/크기 : x :180  y :150  / w:200  h:30 

🍀 **비밀번호 라벨** 위치/크기 : x :120  y :200  / w:60  h: 30

🍀 **비밀번호 필드** 위치/크기 : x :180  y :200  / w:200  h: 30

- JPasswordField 를 이용해주세요

🍀 **비밀번호 확인 라벨** 위치/크기 : x :120  y : 250 / w:80  h: 30

🍀 **비밀번호 확인 필드** 위치/크기 : x :200  y : 250 / w:180  h: 30

- JPasswordField 를 이용해주세요

# 1주차

## 완성본

- 시작전에 오늘 완성할 화면을 보여드리겠습니다
<img src="https://user-images.githubusercontent.com/70833455/126898341-527443d1-33ff-44c9-b701-bb3fb8e3f761.png" width="300px" height="300px">


## JAVA의 GUI 클래스 : Swing

**GUI란?** 

- 그래픽 사용자 인터페이스(graphical user interface, GUI)
- 입출력 등의 기능을 알기 쉬운 아이콘 같은 그래픽으로 나타낸 것
- HTML과 같은 화면 구현을 해놓은것

**GUI를 구현하기 위한 도구 Swing**

- Java Swing은 운영체제에 영향을 받지 않고 플랫폼이 독립적이며 가벼운 구성 요소를 제공
<img src="https://user-images.githubusercontent.com/70833455/126898562-2c5fddf8-ff14-41c0-b094-9754174285e3.png" width="350px" height="250px">


클래스 : 변수와 메서드를 정의해놓은 틀 

<img src="https://user-images.githubusercontent.com/70833455/126898601-1edc1a81-e1f2-45be-96c0-33a9fefa9686.png" width="400px" height="200px">

✨**JFrame이란?**

- 모든 요소를 화면에 띄우는 컨테이너
- 밑바탕 , 틀

✨**JPanel 이란?**

- 조각난 프레임으로 생각하면 됨
- 레이아웃 적용과 UI 배치들을 모두 할 수 있음
- 쉽게말해 HTML의 div 태그 같은 역할

✨**JLabel 이란?**

- 실습을 통해 알아보겠습니다!

### 실습

- 새로운 프로젝트 생성
- Create project from template 체크
- 프로젝트 name : chatFive1
- Base Packeage : com.daelim.five1

- 새로운 패키지 Panel 생성 ( com.daelim.five1.Panel )
- 새로운 클래스 LoginPanel 생성
- extends 키워드 사용 // 다른 클래스 파일을 상속 받음
    - 상속의 주체 = 부모클래스 // 상속받는 클래스 = 자식클래스
    - 자식 클래스는 부모 클래스의 기능을 마음대로 사용할 수 있음
- JPanel 을 상속받음

### 실습2

- 먼저 가벼운 변수 선언으로 시작
    - public String line = "";
    - 접근제어자 : 접근권한, public은 변수를 사용하는 패키지,클래스,메서드 어디에서나 직접 접근할 수 있는 권한을 부여하는것과 같음
    - 변수 타입: 문자열을 담는다
    - 변수명
    - 변수값
- JFrame객체 생성
- public  JFrame f= new JFrame();
    - JFrame은 JPanel의 바탕이 되는 것으로 JPanel이 화면에 표시될 수 있도록 해주는 것
    - 🎉객체를 생성한다는것은 기억장소에 객체의 요소를 저장할 공간이 배정됐다는 뜻 !🎉
    - 이론은 2학년 올라가서 배울테니 지금은 자주 쓰면서 감을 잡아보아요!
    - 객체 생성 기본 형식

    ```jsx
    Class명 참조변수명 = new 생성자 ();
    ```

- 기본 생성자 만들기
    - 생성자란 객체를 생성할 때 항상 실행되는 것으로, 객체를 초기화해주기 위해 맨 처음 실행되는것
- 생성자 채우기

    ```jsx
    public LoginPanel() {
           
            f.getContentPane().setBackground(Color.ORANGE);
            f.setSize(500, 500);
            f.setLayout(null);
            f.setVisible(true);
        }
    ```

    [JFrame](https://www.notion.so/319cfdfb7061416d94768da0ff7fe7dc)

    ### 실습3

    **1.**

    - 메서드 setView() 생성
        - 접근제어자- private / 반환형-void / 매개변수 - 없음

        ---

    - idField라는 이름으로 JTextField 객체 생성

        🍊 JTextField 는 HTML의 form 태그중 input 태그와 같은것

    - idField.setBounds(x,y,w,h)를 사용하여 입력창의 위치와 크기를 조정
    - add() 메서드로 설정된 객체를 화면창에 추가합니다

    ```jsx
    JTextField idField = new JTextField();
            idField.setBounds(150, 100, 200, 30);
            f.add(idField);
    ```

    **2.**

    ---

    - JTextField 위에  JLabel 객체를 생성할겁니다
    - label_id 라는 이름으로 JLabel 객체 생성
        - JLabel은 입력창의 이름을 지정 > 매개변수값 "아이디:"
    - label_id.setBounds() 를 사용하여 위치와 크기를 조정
    - add() 사용

    ```jsx
    JLabel label_id = new JLabel("아이디:");
            label_id.setBounds(100, 100, 50, 30);
            f.add(label_id);
    ```

    ---

    **3.**

    - 생성자에 setView() 호출
    - main클래스에 new LoginPanel() 호출
    - [ ]  실행해서 확인 OK
    - 1. 2.의 실습을 복붙
    - 위치와 Label의 이름만 바꾼다

    ```jsx
    JLabel label_pw = new JLabel("비밀번호:");
            label_pw.setBounds(85, 150, 60, 30);
            f.add(label_pw);
            JTextField pwField = new JTextField();
            pwField.setBounds(150, 150, 200, 30);
            f.add(pwField);
    ```

    - [ ]  실행해서 확인 OK

    ---

    ### 실습4

    - button 만들기
    - bt_login 이름으로 JButton 객체 선언 > 버튼 이름값  "로그인"
    - 마찬가지로 setBounds() 사용 버튼의 크기와 위치를 조정합니다

    ```jsx
    JButton bt_login = new JButton("로그인");
            bt_login.setBounds(120, 250, 260, 30);
    ```

    ---

    - addActionListener 로 버튼을 눌렀을때 이벤트가 일어나도록 할것입니다
    - 어려우니 일단은 무언가 활동이 일어난다는것만 아시고 넘어가셔도 좋습니다
    - 이벤트 내용(활동 내용) - "로그인을 요청했습니다" 라고 출력해보기
    - 이벤트 형식

    ```jsx
    bt_login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
                });
    ```

    - 출력 방법
        - System.out.println("로그인을 요청했습니다");
        - 자주 나오니 외워두시길 바랍니당

        ---

    - 이벤트형식 + 출력

    ```jsx

    bt_login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("로그인 요청");
                }
                });
    ```

