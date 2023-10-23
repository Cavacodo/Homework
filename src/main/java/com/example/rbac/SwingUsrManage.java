package com.example.rbac;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingUsrManage {
    JFrame frame = new JFrame("User Management");
    public SwingUsrManage(){
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();

        SwingPanel.addUsrTable(panel);
        SwingPanel.addSearch(panel,1);
        SwingPanel.insertButton(panel,1);
        SwingPanel.refreshButton(panel,1);
        SwingPanel.UpdateDataButton(panel,1);
        SwingPanel.addHisButton(panel);
        SwingPanel.addDeleteButton(panel);
        SwingPanel.addErrButton(panel);

        frame.add(panel);
        frame.setVisible(true);
    }


}
