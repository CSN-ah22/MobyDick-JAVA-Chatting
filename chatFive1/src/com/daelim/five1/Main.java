package com.daelim.five1;

import com.daelim.five1.Data.SettingData;
import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.LoginPanel;
import com.daelim.five1.Panel.MainPanel;
import com.daelim.five1.Panel.SettingPanel;

import javax.swing.*;

public class Main {
    public static JFrame f;
    private static LoginPanel loginPage;
    private static JoinPanel joinPage;
    private static MainPanel mainPage;
    private static SettingPanel settingPage;

    public static void main(String[] args) {


	f = new JFrame();
	loginPage = new LoginPanel();
    f.add(loginPage);
    joinPage = new JoinPanel();
    f.add(joinPage);
    mainPage = new MainPanel();
    f.add(mainPage);
    settingPage = new SettingPanel();
    f.add(settingPage);

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         movePage(1);
    }

    public  static  void movePage(int index){
        loginPage.setVisible(false);
        joinPage.setVisible(false);
        mainPage.setVisible(false);
        settingPage.setVisible(false);

        switch (index){
            case 1:
                f.setTitle("Chat - 로그인 화면");
                loginPage.setVisible(true);
                break;
            case 2:
                f.setTitle("Chat - 회원가입 화면");
                joinPage.setVisible(true);
                break;
            case 3:
                f.setTitle("Chat - 채팅 화면");
                mainPage.setVisible(true);
                break;
            case 4:
                f.setTitle("Chat - 환경 설정 화면");
                settingPage.setVisible(true);
                break;
        }
    }
}
