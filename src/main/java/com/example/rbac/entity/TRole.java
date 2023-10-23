package com.example.rbac.entity;

import java.io.Serializable;

/**
 * (TRole)实体类
 *
 * @author makejava
 * @since 2023-10-17 17:25:36
 */
public class TRole implements Serializable {
    private static final long serialVersionUID = 399428155878820291L;
    
    private Integer rPermission;
    
    private String rRole;


    public Integer getRPermission() {
        return rPermission;
    }

    public void setRPermission(Integer rPermission) {
        this.rPermission = rPermission;
    }

    public String getRRole() {
        return rRole;
    }

    public void setRRole(String rRole) {
        this.rRole = rRole;
    }

}

