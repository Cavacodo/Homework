package com.example.rbac.entity;

import com.example.rbac.dao.TUsrOpHisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (TUsrOpHis)实体类
 *
 * @author makejava
 * @since 2023-10-17 17:25:36
 */
@Component
public class TUsrOpHis implements Serializable {
    @Autowired
    TUsrOpHisDao tUsrOpHisDao;
    private static final long serialVersionUID = 377248437882863351L;
    
    private Integer uohId;
    
    private String uohUsrAcc;
    
    private Date uohDate;
    
    private String uohOp;


    public Integer getUohId() {
        return uohId;
    }

    public void setUohId(Integer uohId) {
        this.uohId = uohId;
    }

    public String getUohUsrAcc() {
        return uohUsrAcc;
    }

    public void setUohUsrAcc(String uohUsrAcc) {
        this.uohUsrAcc = uohUsrAcc;
    }

    public Date getUohDate() {
        return uohDate;
    }

    public void setUohDate(Date uohDate) {
        this.uohDate = uohDate;
    }

    public String getUohOp() {
        return uohOp;
    }

    public void setUohOp(String uohOp) {
        this.uohOp = uohOp;
    }
    public String[][] toStringArr(){
        List<TUsrOpHis> t = tUsrOpHisDao.getAllHis();
        String[][] str = new String[t.size()][4];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getUohId()+"");
            str[i][1] = new String(t.get(i).getUohUsrAcc()+"");
            str[i][2] = new String(t.get(i).getUohDate()+"");
            str[i][3] = new String(""+t.get(i).getUohOp());
        }
        return str;
    }

    public Integer addHis(String account,String operation){return tUsrOpHisDao.addHis(account,operation);}


}

