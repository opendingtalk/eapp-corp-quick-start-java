package com.dadapro.bean;

/**
 * @author Administrator
 * @date 2019-10-18
 */
public class Dept {


    /**
     * autoAddUser : false
     * createDeptGroup : false
     * id : 111043605
     * name : 市场部
     * parentid : 111260382
     */

    private boolean autoAddUser;
    private boolean createDeptGroup;
    private long id;
    private String name;
    private long parentid;

    public boolean isAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    public boolean isCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
    }
}
