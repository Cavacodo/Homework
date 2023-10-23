package com.example.rbac.entity;

import com.example.rbac.dao.TUsrMsgboxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TUsrMsgbox)实体类
 *
 * @author makejava
 * @since 2023-10-18 10:27:01
 */
@Component
public class TUsrMsgbox implements Serializable {
    @Autowired
    TUsrMsgboxDao tUsrMsgboxDao;
    private static final long serialVersionUID = -99159812658897020L;
    
    private Integer umId;
    
    private Integer umErr;
    
    private String umDetail;


    public Integer getUmId() {
        return umId;
    }

    public void setUmId(Integer umId) {
        this.umId = umId;
    }

    public Integer getUmErr() {
        return umErr;
    }

    public void setUmErr(Integer umErr) {
        this.umErr = umErr;
    }

    public String getUmDetail() {
        return umDetail;
    }

    public void setUmDetail(String umDetail) {
        this.umDetail = umDetail;
    }
    public String getDetailById(Integer id){return tUsrMsgboxDao.getDetailById(id);}

}

