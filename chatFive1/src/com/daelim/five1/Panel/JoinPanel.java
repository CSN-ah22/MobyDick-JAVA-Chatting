package com.daelim.five1.Panel;

import com.daelim.five1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinPanel extends JPanel {
    private  JTextField nameField;
    private JTextField emailField;
    private JTextField id_field;
    private JPasswordField pw_field;
    private JPasswordField check_pw_field;

    public JoinPanel(){
        setView();

        setBackground(Color.LIGHT_GRAY);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    private void setView(){
        JLabel label_name = new JLabel("이름:");
        label_name.setBounds(120,50,60,30);
        add(label_name);
        nameField = new JTextField();
        nameField.setBounds(180,50,200,30);
        add(nameField);

        JLabel label_email = new JLabel("이메일:");
        label_email.setBounds(120,100,60,30);
        add(label_email);
        emailField = new JTextField();
        emailField.setBounds(180,100,200,30);
        add(emailField);

        /*아이디*/
        JLabel join_id = new JLabel("아이디:");
        join_id.setBounds(120,150,60,30);
        add(join_id);

        id_field = new JTextField();
        id_field.setBounds(180,150,200,30);
        add(id_field);
        /*아이디 END*/

        /*비밀번호*/
        JLabel join_pw = new JLabel("비밀번호:");
        join_pw.setBounds(120,200,60,30);
        add(join_pw);

        pw_field = new JPasswordField();
        pw_field.setBounds(180,200,200,30);
        add(pw_field);
        /*비밀번호 END*/

        /*비밀번호 확인*/
        JLabel check_pw = new JLabel("비밀번호 확인");
        check_pw.setBounds(120,250,80,30);
        add(check_pw);

        check_pw_field = new JPasswordField();
        check_pw_field.setBounds(200,250,180,30);
        add(check_pw_field);
        /*비밀번호 확인 END*/

        /*비교 문구 FAIL*/
        JLabel check_pw_FAIL = new JLabel("비밀번호를 다시 확인해주세요");
        check_pw_FAIL.setBounds(200,290,200,30);
        check_pw_FAIL.setForeground(new Color(102,0,153));
        add(check_pw_FAIL);
        check_pw_FAIL.setVisible(false);
        /*비교 문구 END*/

        /*비교 문구 OK*/
        JLabel check_pw_OK = new JLabel("등록되었습니다 로그인 창으로 돌아가주십시오");
        check_pw_OK.setBounds(130, 330, 600, 30);
        check_pw_OK.setForeground(new Color(0,128,0));
        add(check_pw_OK);
        check_pw_OK.setVisible(false);
        /*비교 문구 END*/


        JButton bt_join = new JButton("가입하기");
        bt_join.setBounds(120,350,260,30);
        bt_join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myPass=String.valueOf(pw_field.getPassword());
                String myPass2=String.valueOf(check_pw_field.getPassword());
                if (myPass.equals("")||myPass2.equals("")){
                    check_pw_OK.setVisible(false);
                    check_pw_FAIL.setVisible(true);//

                }else if (myPass.equals(myPass2)){
                    check_pw_FAIL.setVisible(false);
                    check_pw_OK.setVisible(true);//
                    bt_join.setVisible(false);//

                }
                else{
                    check_pw_OK.setVisible(false);
                    check_pw_FAIL.setVisible(true);//
                }
                /*System.out.println("회원가입을 요청했습니다");*/
            }
        });
        add(bt_join);

        /*로그인 화면으로 이동 버튼*/
        JButton bt_back = new JButton("로그인 화면으로 이동");
        bt_back.setBounds(120, 400, 260, 30);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });
        add(bt_back);

    }
}
