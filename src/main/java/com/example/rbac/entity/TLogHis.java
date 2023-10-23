package com.example.rbac.entity;

import com.example.rbac.dao.TLogHisDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (TLogHis)实体类
 *
 * @author makejava
 * @since 2023-10-18 15:09:23
 */
@Component
public class TLogHis implements Serializable {
    @Autowired
    TLogHisDao tLogHisDao;
    private static final long serialVersionUID = -57057744675938881L;
    
    private Integer lhId;
    
    private String ihUsrAcc;
    
    private Date ihDate;


    public Integer getLhId() {
        return lhId;
    }

    public void setLhId(Integer lhId) {
        this.lhId = lhId;
    }

    public String getIhUsrAcc() {
        return ihUsrAcc;
    }

    public void setIhUsrAcc(String ihUsrAcc) {
        this.ihUsrAcc = ihUsrAcc;
    }

    public Date getIhDate() {
        return ihDate;
    }

    public void setIhDate(Date ihDate) {
        this.ihDate = ihDate;
    }
    public String[][] toStringArr(){
        List<TLogHis> t = tLogHisDao.getAllHis();
        String[][] str = new String[t.size()][3];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getLhId()+"");
            str[i][1] = new String(t.get(i).getIhUsrAcc()+"");
            str[i][2] = new String(t.get(i).getIhDate()+"");
        }
        return str;
    }
    public void insertRecord(String account){
        tLogHisDao.insertRecord(account);
    }

}

