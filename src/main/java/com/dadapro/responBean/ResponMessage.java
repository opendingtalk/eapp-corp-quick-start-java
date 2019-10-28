package com.dadapro.responBean;

/**
 * @author Administrator
 * @date 2019-10-18
 */
public class ResponMessage {


    /**
     * errcode : 0
     * errmsg : ok
     * task_id : 123
     */

    private int errcode;
    private String errmsg;
    private int task_id;

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

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
}
