package com.example.rbac;

import com.example.rbac.entity.TResource;
import com.example.rbac.entity.TUsr;
import com.example.rbac.entity.TUsrOpHis;
import com.example.rbac.entity.TUsrPermit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingSearch {
    JFrame frame = new JFrame("Search Result");
    String[][] content;
    TUsr tUsr;
    TResource tResource;
    TUsrPermit tUsrPermit;
    public SwingSearch(int status,String account){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tUsr = context.getBean(TUsr.class);
        this.tResource = context.getBean(TResource.class);
        this.tUsrPermit = context.getBean(TUsrPermit.class);

        frame.setSize(500,150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        if(status == 0){
            search2Res(panel,account);
        }
        else if(status == 1){
            search2Usr(panel,account);
        }
        frame.add(panel);
        frame.setVisible(true);

    }
    private void search2Res(JPanel panel,String account){
        String[] header = new String[]{"ID","Address","Date","Uploader"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = sdf.format(new Date());
        content = tResource.findResByUp(account);
        DefaultTableModel model = new DefaultTableModel(content,header);
        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(40,40,200,200);
        panel.add(jScrollPane);
    }
    private void search2Usr(JPanel panel,String account){
        String[] header = new String[]{"ID","Account","passwd"};
        String[][] tmp = tUsr.findUsr(account);
        System.out.println(tmp[0][0]);
        DefaultTableModel model = new DefaultTableModel(tmp,header);
        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(40,40,200,200);
        panel.add(jScrollPane);
    }

    private boolean addResContent(String address,String account){
        return tResource.addRes(address,account) != null;
    }
    private boolean checkUsrAcc(String account){
        return !tUsr.checkAccount(account) && tUsrPermit.rootCheck(account)<2;
    }


}