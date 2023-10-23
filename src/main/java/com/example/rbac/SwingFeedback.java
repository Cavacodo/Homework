package com.example.rbac;

import com.example.rbac.entity.TResMsgbox;
import com.example.rbac.entity.TUsrMsgbox;
import com.example.rbac.entity.TUsrOpHis;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class SwingFeedback {
    JFrame frame = new JFrame("Notice");
    TResMsgbox tResMsgbox;
    TUsrMsgbox tUsrMsgbox;

    public SwingFeedback(int status,int i) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tResMsgbox = context.getBean(TResMsgbox.class);
        this.tUsrMsgbox = context.getBean(TUsrMsgbox.class);

        frame.setSize(250,150);
        JPanel panel = new JPanel();
        String a= new String();
        if(status == 1){
            a = tUsrMsgbox.getDetailById(i);
        }
        else if(status==0){
            a = tResMsgbox.getDetailById(i);
        }
        JLabel label = new JLabel(a);
        JButton button = new JButton("Confirm");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(button);
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }




}
