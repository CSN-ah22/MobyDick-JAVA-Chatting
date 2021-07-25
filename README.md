# 자바 스터디 멘토 활동 자료
모비딕 동아리에서 멘토 활동을 하게 되었습니다</br>
수업시간에 이미 한번 만들었던 채팅프로그램을 가르쳐 볼겁니다</br>
다른사람에게 어떻게 하면 쉽게 코드를 이해전달 시킬지</br>
그리고 완전히 제 자신의 것으로 만들기 위해 부족한 부분이 어디인지</br>
고민해 보면서 완성시키는 것이 목표입니다!</br>

#1주차

## 완성본

- 시작전에 오늘 완성할 화면을 보여드리겠습니다

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/91971375-f49c-4810-8846-5bed03d14dfa/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/91971375-f49c-4810-8846-5bed03d14dfa/Untitled.png)

## JAVA의 GUI 클래스 : Swing

**GUI란?** 

- 그래픽 사용자 인터페이스(graphical user interface, GUI)
- 입출력 등의 기능을 알기 쉬운 아이콘 같은 그래픽으로 나타낸 것
- HTML과 같은 화면 구현을 해놓은것

**GUI를 구현하기 위한 도구 Swing**

- Java Swing은 운영체제에 영향을 받지 않고 플랫폼이 독립적이며 가벼운 구성 요소를 제공

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40047eb8-984e-4974-80c4-31d08acdaf1f/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40047eb8-984e-4974-80c4-31d08acdaf1f/Untitled.png)

클래스 : 변수와 메서드를 정의해놓은 틀 

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06881efa-66ad-4afe-8200-39500f2bfd85/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06881efa-66ad-4afe-8200-39500f2bfd85/Untitled.png)

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

