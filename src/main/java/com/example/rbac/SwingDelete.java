package com.example.rbac;

import com.example.rbac.entity.*;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDelete {
    JFrame frame = new JFrame("Delete Usr");
    TUsr tUsr;
    TUsrPermit tUsrPermit;
    TUsrOpHis tUsrOpHis;
    TErr tErr;
    public SwingDelete(){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        tUsr = context.getBean(TUsr.class);
        tUsrPermit = context.getBean(TUsrPermit.class);
        tUsrOpHis = context.getBean(TUsrOpHis.class);
        tErr = context.getBean(TErr.class);
        frame.setSize(400,70);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        delete4Usr(panel);
        frame.add(panel);
        frame.setVisible(true);

    }
    private void delete4Usr(JPanel panel){
        JLabel userLabel = new JLabel("ID:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10,50,20,25);
        panel.add(userText);

        JButton button2Res = new JButton("Confirm");
        button2Res.setBounds(150,140,80,25);
        button2Res.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(userText.getText());
                if(check(id)){
                    String account =  SpringApplication.run(RbacApplication.class).getBean(TUsr.class).getAccById(id);
                    tUsrPermit.deleteByAcc(account);
                    tUsrOpHis.addHis(account,"delete");
                    tUsr.deleteById(id);
                }
                else{
                    tErr.addRecord(14);
                    new SwingFeedback(1,14);
                }
                frame.setVisible(false);
            }
        });
        panel.add(button2Res);
    }
    private boolean check(int id){
        //有的话true
        return tUsr.check(id);
    }
}
