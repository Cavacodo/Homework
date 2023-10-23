package com.example.rbac;

import com.example.rbac.entity.*;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingInsert {
    JFrame frame = new JFrame("Insert Your Content");
    String content;
    String account;
    TUsr tUsr;
    TUsrPermit tUsrPermit;
    TUsrOpHis tUsrOpHis;
    TResHistory tResHistory;
    TResource tResource;
    TErr tErr;
    public SwingInsert(int status){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tUsr = context.getBean(TUsr.class);
        this.tUsrPermit = context.getBean(TUsrPermit.class);
        this.tResource = context.getBean(TResource.class);
        this.tResHistory = context.getBean(TResHistory.class);
        this.tUsrOpHis = context.getBean(TUsrOpHis.class);
        this.tErr = context.getBean(TErr.class);

        frame.setSize(350,150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        if(status == 0){
            add2Res(panel);
        }
        else if(status == 1){
            add2Usr(panel);
        }
        frame.add(panel);
        frame.setVisible(true);

    }
    private void add2Res(JPanel panel){
        JLabel userLabel = new JLabel("Content:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10,50,165,25);
        panel.add(userText);

        JLabel userLabel2 = new JLabel("Account:");
        userLabel2.setBounds(10,80,80,25);
        panel.add(userLabel2);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(10,110,165,25);
        panel.add(userText2);

        JButton button2Res = new JButton("Confirm");
        button2Res.setBounds(150,140,80,25);
        button2Res.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                content = userText.getText();
                account = userText2.getText();
                if(checkUsrAcc(account)){
                    tResHistory.addHis(account,"Insert");
                    addResContent(content,account);
                }
                else{
                    tErr.addRecord(2);
                    new SwingFeedback(0,2);
                }
                frame.setVisible(false);
            }
        });
        panel.add(button2Res);
    }

    private void add2Usr(JPanel panel){
        JLabel userLabel = new JLabel("Account:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10,50,165,25);
        panel.add(userText);

        JLabel userLabel2 = new JLabel("Passwd:");
        userLabel2.setBounds(10,80,80,25);
        panel.add(userLabel2);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(10,110,165,25);
        panel.add(userText2);

        JButton button2Res = new JButton("Confirm");
        button2Res.setBounds(150,140,80,25);
        button2Res.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String acc = userText.getText();
                String passwd = userText2.getText();
                if(!checkUsrAcc(acc)){
                    addUsrInfo(acc,passwd);
                    addUsrPermit(acc);
                    tUsrOpHis.addHis(acc,"Insert");
                }
                else{
                    tErr.addRecord(15);
                    new SwingFeedback(1,15);
                }
                frame.setVisible(false);
            }
        });
        panel.add(button2Res);
    }
    private boolean addResContent(String address,String account){
        return tResource.addRes(address,account) != null;
    }
    private boolean addUsrInfo(String account,String passwd){
        return tUsr.addAccount(account,passwd)!=null;
    }
    private boolean addUsrPermit(String account){return tUsrPermit.addUsrPermit(account)!=null;}
    private boolean checkUsrAcc(String account){
        return !tUsr.checkAccount(account) && tUsrPermit.rootCheck(account)<2;
    }

}
