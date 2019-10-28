package com.dadapro.responBean;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-10-18
 */
public class ResponUser {


    /**
     * errcode : 0
     * errmsg : ok
     * userlist : [{"name":"钟信高","userid":"015537650537236726"},{"name":"苏锡峰","userid":"025467003233388286"},{"name":"黄亚娥","userid":"062642282639705743"},{"name":"郭艺泉","userid":"4831495736717372"},{"name":"肖良强","userid":"023236006932693697"},{"name":"黄文锻","userid":"062642271839902808"}]
     */

    private int errcode;
    private String errmsg;
    private List<UserlistBean> userlist;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<UserlistBean> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserlistBean> userlist) {
        this.userlist = userlist;
    }

    public static class UserlistBean {
        /**
         * name : 钟信高
         * userid : 015537650537236726
         */

        private String name;
        private String userid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }
}
