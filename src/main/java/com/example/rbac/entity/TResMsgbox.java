package com.example.rbac.entity;

import com.example.rbac.dao.TResMsgboxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TResMsgbox)实体类
 *
 * @author makejava
 * @since 2023-10-18 10:27:01
 */
@Component
public class TResMsgbox implements Serializable {
    @Autowired
    TResMsgboxDao tResMsgboxDao;
    private static final long serialVersionUID = 281131642453831860L;
    
    private Integer rmbId;
    
    private Integer rmbErr;
    
    private String rmbDetail;


    public Integer getRmbId() {
        return rmbId;
    }

    public void setRmbId(Integer rmbId) {
        this.rmbId = rmbId;
    }

    public Integer getRmbErr() {
        return rmbErr;
    }

    public void setRmbErr(Integer rmbErr) {
        this.rmbErr = rmbErr;
    }

    public String getRmbDetail() {
        return rmbDetail;
    }

    public void setRmbDetail(String rmbDetail) {
        this.rmbDetail = rmbDetail;
    }
    public String getDetailById(Integer id){return tResMsgboxDao.getDetailById(id);}

}

