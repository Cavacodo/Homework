package com.example.rbac;

import com.example.rbac.dao.TResHistoryDao;
import com.example.rbac.dao.TUsrDao;
import com.example.rbac.entity.TResHistory;
import com.example.rbac.entity.TResource;
import com.example.rbac.entity.TUsr;
import com.example.rbac.entity.TUsrOpHis;
import com.mysql.cj.util.DnsSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SwingPanel {
    static JFrame frame = new JFrame("Control Panel");

    static String[][] data;

    static TResource tResource;
    static TResHistory tResHistory;
    static TUsrOpHis tUsrOpHis;

    static TUsr tUsr;

    public SwingPanel(){
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
    public SwingPanel(int status){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        attache(context.getBean(TResource.class),context.getBean(TResHistory.class),context.getBean(TUsr.class),context.getBean(TUsrOpHis.class));


        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        switch(status){
            case 0 : adminComponent(panel); break;
            case 1 : seniorOfficerComponents(panel); break;
            case 2 : juniorOfficerComponents(panel); break;
        }
        frame.add(panel);
        frame.setVisible(true);
    }

    public void attache(TResource tResource,TResHistory tResHistory,TUsr tUsr,TUsrOpHis tUsrOpHis){
        this.tResource = tResource;
        this.tResHistory = tResHistory;
        this.tUsr = tUsr;
        this.tUsrOpHis = tUsrOpHis;
    }
    public static void addSearch(JPanel panel,int status){
        panel.setLayout(null);
        JTextField searchText = new JTextField(20);
        searchText.setBounds(20,10,220,25);
        panel.add(searchText);

        JButton search = new JButton("Search");
        search.setBounds(270,10,80,25);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp = searchText.getText();
                if(status == 0){
                    tResHistory.addHis(tmp,"Search");
                }
                else{
                    tUsrOpHis.addHis(tmp,"Search");
                }
                new SwingSearch(status,tmp);
            }
        });
        panel.add(search);
    }
    private static void addResources(JPanel panel){
        String[] header = new String[]{"ID","Address","Date","Uploader"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = sdf.format(new Date());
        data = tResource.toStringArr();
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(20,40,350,200);
        panel.add(jScrollPane);
    }
    public static void addUsrTable(JPanel panel){
        String[] header = new String[]{"UID","Account","Password","Permission"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = sdf.format(new Date());

        String[][] data = tUsr.toStringArr();

        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(20,40,500,200);
        panel.add(jScrollPane);
    }
    public static void insertButton(JPanel panel,int status){
        JButton insertData = new JButton("DataInsert");
        insertData.setBounds(110,245,90,25);
        insertData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingInsert(status);
            }
        });
        panel.add(insertData);
    }
    public static void refreshButton(JPanel panel,int status){
        JButton refresh = new JButton("Refresh");
        refresh.setBounds(10,245,90,25);
        if(status==0){
            refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    data = tResource.toStringArr();
                    addResources(panel);
                }
            });
        }
        else if(status==1){
            refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addUsrTable(panel);
                }
            });
        }
        panel.add(refresh);
    }
    public static void UpdateDataButton(JPanel panel,int status){
        JButton updateData = new JButton("Update");
        updateData.setBounds(210,245,90,25);
        updateData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingUpdate(status);
            }
        });
        panel.add(updateData);
    }
    private static void UserMangmt(JPanel panel){
        JButton userManagement = new JButton("usrMangmt");
        userManagement.setBounds(300,245,100,25);
        userManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingUsrManage();
            }
        });
        panel.add(userManagement);
    }
    private static void adminComponent(JPanel panel){
        addSearch(panel,0);
        addResources(panel);
        insertButton(panel,0);
        refreshButton(panel,0);
        UpdateDataButton(panel,0);
        UserMangmt(panel);
    }
    private static void seniorOfficerComponents(JPanel panel){
        addSearch(panel,0);
        addResources(panel);
        insertButton(panel,0);
        refreshButton(panel,0);
    }
    private static void juniorOfficerComponents(JPanel panel){
        addSearch(panel,0);
        addResources(panel);
        refreshButton(panel,0);
    }

    public static void addHisButton(JPanel panel){
        JButton button = new JButton("His_Mgt");
        button.setBounds(300,245,100,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingHistoryPanel();
            }
        });
        panel.add(button);
    }
    public static void addDeleteButton(JPanel panel){
        JButton button = new JButton("Delete");
        button.setBounds(400,245,100,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingDelete();
            }
        });
        panel.add(button);
    }

    public static void addErrButton(JPanel panel){
        JButton button = new JButton("Err Log");
        button.setBounds(500,245,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingErr();
            }
        });
        panel.add(button);
    }

}
