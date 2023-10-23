package com.example.rbac;

import com.example.rbac.entity.TErr;
import com.example.rbac.entity.TUsr;
import com.example.rbac.entity.TUsrPermit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingSignUp extends JFrame {

    String SAccount;
    String FirstPasswd;
    String SecondPasswd;
    JFrame frame = new JFrame("SignUp");

    TUsrPermit tUsrPermit;
    TUsr tUsr;
    TErr tErr;

    public SwingSignUp(){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        tUsr = context.getBean(TUsr.class);
        tUsrPermit = context.getBean(TUsrPermit.class);
        tErr = context.getBean(TErr.class);

        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

     public void placeComponents(JPanel panel){
         panel.setLayout(null);

         JLabel userLabel = new JLabel("UserName:");

         userLabel.setBounds(10,20,80,25);
         panel.add(userLabel);

         JTextField userText = new JTextField(20);
         userText.setBounds(130,20,165,25);
         panel.add(userText);



         JLabel passwordLabel = new JLabel("Password:");
         passwordLabel.setBounds(10,50,80,25);
         panel.add(passwordLabel);


         JPasswordField passwordText = new JPasswordField(20);
         passwordText.setBounds(130,50,165,25);
         panel.add(passwordText);




         JLabel passwordLabel2 = new JLabel("Confirm Password:");
         passwordLabel2.setBounds(5,80,120,25);
         panel.add(passwordLabel2);


         JPasswordField passwordText2 = new JPasswordField(20);
         passwordText2.setBounds(130,80,165,25);
         panel.add(passwordText2);



         JButton loginButton = new JButton("login");
         loginButton.setBounds(50, 120, 80, 25);
         panel.add(loginButton);
         loginButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
//                 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 frame.setVisible(false);
                 new SwingLogin();
             }
         });

         JButton SubmitButton = new JButton("Submit");
         SubmitButton.setBounds(200, 120, 80, 25);
         panel.add(SubmitButton);
         SubmitButton.addActionListener(new ActionListener() {
             @SneakyThrows
             @Override
             public void actionPerformed(ActionEvent e) {
                 SAccount = userText.getText();
                 FirstPasswd = passwordText.getText();
                 SecondPasswd = passwordText2.getText();

                 if(!FirstPasswd.equals(SecondPasswd)){
                     new SwingFeedback(1,11);
                     tErr.addRecord(11);
                 }
                 else if(!checkDuplicate(SAccount)){
                     new SwingFeedback(1,12);
                     tErr.addRecord(12);
                 }
                 else{
                     tUsr.addAccount(SAccount,FirstPasswd);
                     tUsrPermit.addUsrPermit(SAccount);
                     new SwingLogin();
                     frame.setVisible(false);
                 }
//                 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             }
         });
     }

     public  boolean checkDuplicate(String account){
        return tUsr.checkAccount(account);
     }

}
