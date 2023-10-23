package com.example.rbac;

import com.example.rbac.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingHistoryPanel{
    JFrame frame = new JFrame("History");
    TLogHis tLogHis;
    TUsrOpHis tUsrOpHis;
    TResHistory tResHistory;
    public SwingHistoryPanel(){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tLogHis = context.getBean(TLogHis.class);
        this.tUsrOpHis = context.getBean(TUsrOpHis.class);
        this.tResHistory = context.getBean(TResHistory.class);

        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton usrButton = new JButton("UsrHis");
        usrButton.setBounds(10,10,90,25);
        usrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] header = {"ID","Account","Date","Op"};
                String[][] data = tUsrOpHis.toStringArr();

                DefaultTableModel model = new DefaultTableModel(data,header);
                JTable table = new JTable(model);
                table.setGridColor(Color.BLACK);
                table.setEnabled(false);

                JScrollPane jScrollPane = new JScrollPane();
                jScrollPane.setViewportView(table);
                jScrollPane.setBounds(20,40,350,200);
                panel.add(jScrollPane);
            }
        });
        panel.add(usrButton);

        JButton ResButton = new JButton("ResButton");
        ResButton.setBounds(40,10,90,25);
        ResButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] header = {"ID","Account","Date","Op"};
                String[][] data = tResHistory.toStringArr();

                DefaultTableModel model = new DefaultTableModel(data,header);
                JTable table = new JTable(model);
                table.setGridColor(Color.BLACK);
                table.setEnabled(false);

                JScrollPane jScrollPane = new JScrollPane();
                jScrollPane.setViewportView(table);
                jScrollPane.setBounds(20,40,350,200);
                panel.add(jScrollPane);
            }
        });
        panel.add(ResButton);

        JButton LogHis = new JButton("LogHis");
        LogHis.setBounds(70,10,90,25);
        LogHis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] header = {"ID","Account","Date"};
                String[][] data = tLogHis.toStringArr();

                DefaultTableModel model = new DefaultTableModel(data,header);
                JTable table = new JTable(model);
                table.setGridColor(Color.BLACK);
                table.setEnabled(false);

                JScrollPane jScrollPane = new JScrollPane();
                jScrollPane.setViewportView(table);
                jScrollPane.setBounds(20,40,350,200);
                panel.add(jScrollPane);
            }
        });
        panel.add(LogHis);

        frame.add(panel);
        frame.setVisible(true);
    }


}
