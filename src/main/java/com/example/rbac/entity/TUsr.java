package com.example.rbac.entity;

import com.example.rbac.dao.TRoleDao;
import com.example.rbac.dao.TUsrDao;
import com.example.rbac.dao.TUsrPermitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * (TUsr)实体类
 *
 * @author makejava
 * @since 2023-10-17 17:25:36
 */
@Component
public class TUsr implements Serializable {
    @Autowired
    TUsrDao tUsrDao;
    @Autowired
    TUsrPermitDao tUsrPermitDao;
    @Autowired
    TRoleDao tRoleDao;
    private static final long serialVersionUID = 170962243169678958L;
    
    private Integer usrId;
    
    private String usrAccount;
    
    private String usrPasswd;


    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount;
    }

    public String getUsrPasswd() {
        return usrPasswd;
    }

    public void setUsrPasswd(String usrPasswd) {
        this.usrPasswd = usrPasswd;
    }

    public String[][] toStringArr(){
        List<TUsr> t = tUsrDao.getAllInfo();
        String[][] str = new String[t.size()][4];
        for(int i=0;i<t.size();i++){
            str[i][0] = new String(t.get(i).getUsrId()+"");
            str[i][1] = new String(t.get(i).getUsrAccount()+"");
            str[i][2] = new String(t.get(i).getUsrPasswd()+"");
            int tr = tUsrPermitDao.queryPermission(t.get(i).usrAccount);
            str[i][3] = new String(tRoleDao.queryRole(tr));
        }
        return str;
    }

    public Integer LogCheck(String usrAccount ,String usrPasswd){
        return tUsrDao.checkLoginInfo(usrAccount,usrPasswd);
    }

    public Integer addAccount(String usrAccount,String usrPasswd){
        return tUsrDao.addAccount(usrAccount,usrPasswd);
    }

    public boolean checkAccount(String account){return tUsrDao.checkAccount(account) == null;}

    public int deleteById(Integer id){return tUsrDao.deleteById(id);};

    public boolean check(int id){return tUsrDao.queryById(id)!=null;}

    public String[][] findUsr(String usrAccount){
        String[][] t = new String[1][3];
        t[0][0] = tUsrDao.findUsr(usrAccount).getUsrId()+"";
        t[0][1] = tUsrDao.findUsr(usrAccount).getUsrAccount()+"";
        t[0][2] = tUsrDao.findUsr(usrAccount).getUsrPasswd()+"";
        return t;
    }
    public Integer updateById(Integer id,String passwd){
        return tUsrDao.updateById(id,passwd);
    }

    public String getAccById(Integer id){
        return tUsrDao.getAccById(id);
    }


}

