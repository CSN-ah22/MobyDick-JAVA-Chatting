package com.daelim.five1.Panel;

import com.daelim.five1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {
    static JTextArea textArea;

    public MainPanel(){
        setView();

        setBackground(Color.pink);
        setSize(500, 500);
        setLayout(null);
    }

    private void setView() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); //스크롤 기능
        scrollPane.setBounds(3, 10, 480, 300);
        add(scrollPane);

        JTextField text = new JTextField();
        text.setBounds(120, 350, 190, 30);
        add(text);

        JButton submit = new JButton("전송");
        submit.setBounds(320, 350, 60, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.getText().equals("")) {
                    return;
                } else {
                    Main.sendMessage(text.getText());
                    textArea.append(text.getText()+"\n");
                    text.setText(""); //이전에 입력했던 값을 지워줍니다
                    System.out.println("전송됨");
                }

            }
        });
        add(submit);

        JButton bt_back = new JButton("로그인 화면으로 이동");
            bt_back.setBounds(120,400,260,30);
            bt_back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.movePage(1);
                }
            });
            add(bt_back);

        Action ok = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.sendMessage(text.getText());
                textArea.append(text.getText()+"\n");
                text.setText("");
                textArea.setCaretPosition(textArea.getDocument().getLength());

                text.setText("");
            }
        };
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false);
        text.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter,"ENTER");
        text.getActionMap().put("ENTER",ok);
    }
    public static void recvMsg(String s) {

        String[] strs = s.split("\\|");
        textArea.setFont(new Font("굴림체", Font.BOLD, 15));
        textArea.setForeground(Color.BLUE);
        textArea.append("메세지 보낸 사람:" + strs[0] + "\n");
        textArea.append("보낸 시간: " + strs[1] + "\n");
        textArea.append("보낸 메시지: " + strs[2] + "\n");
        textArea.append("----------------------------" + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());

    }
}
