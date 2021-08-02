package com.daelim.five1;

import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.LoginPanel;

import javax.swing.*;

public class Main {
    public static JFrame f;
    private static LoginPanel loginPage;
    private static JoinPanel joinPage;

    public static void main(String[] args) {

	f = new JFrame();
	loginPage = new LoginPanel();
    f.add(loginPage);
    joinPage = new JoinPanel();
    f.add(joinPage);

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         movePage(1);
    }

    public  static  void movePage(int index){
        loginPage.setVisible(false);
        joinPage.setVisible(false);

        switch (index){
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
}
