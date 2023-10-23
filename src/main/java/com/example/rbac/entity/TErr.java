package com.example.rbac.entity;

import com.example.rbac.dao.TErrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (TErr)实体类
 *
 * @author makejava
 * @since 2023-10-19 11:40:18
 */
@Component
public class TErr implements Serializable {
    @Autowired
    TErrDao tErrDao;
    private static final long serialVersionUID = 622739638478308250L;
    
    private Integer eId;
    
    private Integer eEid;

    private Date eDate;


    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public Integer getEEid() {
        return eEid;
    }

    public void setEEid(Integer eEid) {
        this.eEid = eEid;
    }

    public Date getEDate() {
        return eDate;
    }

    public void setEDate(Date eDate) {
        this.eDate = eDate;
    }

    public void addRecord(int id){tErrDao.addRecord(id);}

    public String[][] getAllErr(){
        List<TErr> tErrs =  tErrDao.getAllInfo();
        String[][] strs = new String[tErrs.size()][3];
        for(int i=0;i<tErrs.size();i++){
            strs[i][0] = ""+tErrs.get(i).eId;
            strs[i][1] = ""+tErrs.get(i).eEid;
            strs[i][2] = ""+tErrs.get(i).eDate;
        }
        return strs;
    }

}

