package com.example.rbac;

import com.example.rbac.entity.TErr;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingErr {
    JFrame frame = new JFrame("Error Report");
    TErr tErr;
    public SwingErr(){
        ApplicationContext context = SpringApplication.run(RbacApplication.class);
        this.tErr = context.getBean(TErr.class);

        frame.setSize(500,300);

        JPanel panel = new JPanel();
        addTable(panel);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void addTable(JPanel panel){
        String[] header = new String[]{"ID","ErrID","Date"};
        String[][] data = tErr.getAllErr();
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(20,40,200,100);
        panel.add(jScrollPane);
    }

}
