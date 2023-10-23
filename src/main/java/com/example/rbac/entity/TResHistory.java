package com.example.rbac.entity;

import com.example.rbac.dao.TLogHisDao;
import com.example.rbac.dao.TResHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (TResHistory)实体类
 *
 * @author makejava
 * @since 2023-10-17 17:06:03
 */
@Component
public class TResHistory implements Serializable {
    @Autowired
    TResHistoryDao tResHistoryDao;
    private static final long serialVersionUID = -96298318946630984L;
    
    private Integer reshId;
    
    private String reshUsrAcc;
    
    private Date reshDate;
    
    private String reshOp;


    public Integer getReshId() {
        return reshId;
    }

    public void setReshId(Integer reshId) {
        this.reshId = reshId;
    }

    public String getReshUsrAcc() {
        return reshUsrAcc;
    }

    public void setReshUsrAcc(String reshUsrAcc) {
        this.reshUsrAcc = reshUsrAcc;
    }

    public Date getReshDate() {
        return reshDate;
    }

    public void setReshDate(Date reshDate) {
        this.reshDate = reshDate;
    }

    public String getReshOp() {
        return reshOp;
    }

    public void setReshOp(String reshOp) {
        this.reshOp = reshOp;
    }
    public String[][] toStringArr(){
        List<TResHistory> t = tResHistoryDao.getAllHis();
        String[][] str = new String[t.size()][4];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getReshId()+"");
            str[i][1] = new String(t.get(i).getReshUsrAcc()+"");
            str[i][2] = new String(t.get(i).getReshDate()+"");
            str[i][3] = new String(""+t.get(i).getReshOp());
        }
        return str;
    }
    public void addHis(String account,String operation){
        tResHistoryDao.addHis(account,operation);
    }

}

