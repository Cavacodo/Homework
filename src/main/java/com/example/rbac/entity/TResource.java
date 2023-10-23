package com.example.rbac.entity;

import com.example.rbac.dao.TResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (TResource)实体类
 *
 * @author makejava
 * @since 2023-10-17 17:23:26
 */
@Component
public class TResource implements Serializable {
    @Autowired
    TResourceDao tResourceDao;

    private static final long serialVersionUID = -67602475560294796L;
    
    private Integer rId;
    
    private String rAddress;
    
    private Date rDate;
    
    private String rUploader;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRAddress() {
        return rAddress;
    }

    public void setRAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getRUploader() {
        return rUploader;
    }

    public void setRUploader(String rUploader) {
        this.rUploader = rUploader;
    }

    public String[][] toStringArr(){
        List<TResource> t = tResourceDao.getAllRes();
        String[][] str = new String[t.size()][4];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getRId()+"");
            str[i][1] = new String(t.get(i).getRAddress()+"");
            str[i][2] = new String(t.get(i).getRDate()+"");
            str[i][3] = new String(t.get(i).getRUploader());

        }
        return str;
    }
    public String[][] findResByUp(String account){
        List<TResource> t = tResourceDao.findRes(account);
        String[][] str = new String[t.size()][4];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getRId()+"");
            str[i][1] = new String(t.get(i).getRAddress()+"");
            str[i][2] = new String(t.get(i).getRDate()+"");
            str[i][3] = new String(t.get(i).getRUploader());

        }
        return str;
    }

    public Integer addRes(String address,String account){
        return tResourceDao.addResource(address,account);
    }
    public boolean check(int id){
        return tResourceDao.queryById(id) != null;
    }
    public Integer updateInfo(int id,String address){
        return tResourceDao.updateInfoById(id,address);
    }
}

