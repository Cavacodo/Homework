package com.example.rbac;

import com.example.rbac.entity.TErr;
import com.example.rbac.entity.TLogHis;
import com.example.rbac.entity.TUsr;
import com.example.rbac.entity.TUsrPermit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownServiceException;
import java.util.Stack;

import static java.lang.Thread.sleep;

public class SwingLogin extends JFrame{

    JFrame frame = new JFrame("Login");
    String tAccount;
    String tPasswd;

    TUsr tUsr;
    TLogHis tLogHis;
    TUsrPermit tUsrPermit;
    TErr tErr;


    public SwingLogin(){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tUsr = (TUsr) context.getBean(TUsr.class);
        this.tUsrPermit = (TUsrPermit)context.getBean(TUsrPermit.class);
        this.tLogHis = (TLogHis)context.getBean(TLogHis.class);
        this.tErr = context.getBean(TErr.class);



        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");

        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);


        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(50, 100, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                tAccount = userText.getText();
                tPasswd = passwordText.getText();
                if(check(tAccount,tPasswd)){
                    new SwingPanel(getPrivilege(tAccount));
                    tLogHis.insertRecord(tAccount);
                    frame.setVisible(false);
                }
                else{
                    tErr.addRecord(13);
                    new SwingFeedback(1,13);
                }
            }
        });

        JButton SignUpButton = new JButton("Sign Up");
        SignUpButton.setBounds(200, 100, 80, 25);
        panel.add(SignUpButton);

        SignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(false);
                new SwingSignUp();
            }
        });
    }
    public boolean check(String account,String passwd){
        Integer a = tUsr.LogCheck(account, passwd);
        return a!=null;
    }
    public Integer getPrivilege(String account){
        return tUsrPermit.rootCheck(account);
    }

    public static void main(String[] args) throws InterruptedException {
        new SwingLogin();
    }


}
