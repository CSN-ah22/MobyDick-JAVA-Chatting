package com.daelim.five1;

import com.daelim.five1.Data.SettingData;
import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.LoginPanel;
import com.daelim.five1.Panel.MainPanel;
import com.daelim.five1.Panel.SettingPanel;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import javax.swing.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static WebSocketClient ws;
    static String user = "";
    static String s_s;

    public static JFrame f;
    private static LoginPanel loginPage;
    private static JoinPanel joinPage;
    private static MainPanel mainPage;
    private static SettingPanel settingPage;
    private static String URI;

    public static void uri(String uri){
        URI = uri;
    }

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

    public static void connect(String ID){
        user = ID;
        try{
            ws = new WebSocketClient(new URI(URI)) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("open");
                    System.out.println("😀" + user + "|서버 접속!");
                    movePage(3);
                }

                @Override
                public void onMessage(String s) {
                    s_s = s;
                    String[] strs = s.split("\\|");
                    if (strs[0].equals(user)) {
                        System.out.println("나:" + strs[0]);
                    } else {
                        System.out.println("메세지 보낸 사람:" + strs[0]);
                    }
                    System.out.println("보낸 시간:" + strs[1]);
                    System.out.println("보낸 메세지:" + strs[2]);
                    System.out.println("------------------");
                    MainPanel.recvMsg(s);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("onclose");
                }

                @Override
                public void onError(Exception e) {
                    System.out.println("error");
                }

            };
            ws.connect();
            ws.close();
        }catch (Exception e){

        }
    }

    public static void sendMessage(String msg) {
        String timeSpent = "";
        timeSpent = new SimpleDateFormat("HH:mm:ss").format(new Date());
        ws.send(user + "|" + timeSpent + "|" + msg);

    }
}
