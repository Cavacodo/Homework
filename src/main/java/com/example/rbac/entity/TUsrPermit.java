package com.example.rbac.entity;

import com.example.rbac.dao.TUsrPermitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TUsrPermit)实体类
 *
 * @author makejava
 * @since 2023-10-17 23:21:39
 */
@Component
public class TUsrPermit implements Serializable {
    @Autowired
    TUsrPermitDao tUsrPermitDao;
    private static final long serialVersionUID = -29019543824615380L;
    
    private Integer pId;
    
    private String pUsrAcc;
    
    private Integer permission;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPUsrAcc() {
        return pUsrAcc;
    }

    public void setPUsrAcc(String pUsrAcc) {
        this.pUsrAcc = pUsrAcc;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer rootCheck(String account){
        return tUsrPermitDao.queryPermission(account);
    }
    public Integer addUsrPermit(String account){
        return tUsrPermitDao.addNewUsr(account);
    }
    public Integer deleteByAcc(String  account){
        return tUsrPermitDao.deleteByAcc(account);
    }
    public Integer updateByAcc(String account,String newAcc){
        return tUsrPermitDao.updateByAcc(account,newAcc);
    }

}

