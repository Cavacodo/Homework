package com.example.rbac;

import com.example.rbac.entity.*;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUpdate {
    JFrame frame = new JFrame("Update Your Content");
    TUsr tUsr;
    TResource tResource;
    TResHistory tResHistory;
    TUsrOpHis tUsrOpHis;
    TErr tErr;
    public SwingUpdate(int status){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tUsr = context.getBean(TUsr.class);
        this.tResource = context.getBean(TResource.class);
        this.tResHistory = context.getBean(TResHistory.class);
        this.tUsrOpHis = context.getBean(TUsrOpHis.class);
        this.tErr = context.getBean(TErr.class);

        frame.setSize(700,70);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        if(status == 0){
            update4Res(panel);
        }
        else if(status == 1){
            update4Usr(panel);
        }
        frame.add(panel);
        frame.setVisible(true);

    }
    private void update4Res(JPanel panel){
        JLabel userLabel = new JLabel("ID:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10,50,20,25);
        panel.add(userText);

        JLabel label = new JLabel("Address:");
        label.setBounds(10,90,80,25);
        panel.add(label);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(10,110,165,25);
        panel.add(userText2);

        JButton button2Res = new JButton("Confirm");
        button2Res.setBounds(150,140,80,25);
        button2Res.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(userText.getText());
                String address = userText2.getText();
                if(check(id)){
                    String account = tUsr.getAccById(id);
                    tResHistory.addHis(account,"Search");
                    tResource.updateInfo(id,address);
                }
                else{
                    tErr.addRecord(4);
                    new SwingFeedback(0,4);
                }
            }
        });
        panel.add(button2Res);
    }
    private void update4Usr(JPanel panel){
        JLabel userLabel = new JLabel("ID:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10,50,20,25);
        panel.add(userText);

        JLabel label = new JLabel("Passwd:");
        label.setBounds(10,90,80,25);
        panel.add(label);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(10,110,165,25);
        panel.add(userText2);

        JButton button2Res = new JButton("Confirm");
        button2Res.setBounds(150,140,80,25);
        button2Res.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(userText.getText());
                String passwd = userText2.getText();
                if(check4Usr(id)){
                    tUsr.updateById(id,passwd);
                    String account = tUsr.getAccById(id);
                    tUsrOpHis.addHis(account,"update");
                }
                else{
                    tErr.addRecord(17);
                    new SwingFeedback(1,17);
                }
                frame.setVisible(false);
            }
        });
        panel.add(button2Res);
    }
    private boolean check(int id){
        //有的话true
        return tResource.check(id);
    }
    private boolean check4Usr(int id){return tUsr.check(id);}

}
