package com.dadapro.responBean;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-10-18
 */
public class ResponDept {


    /**
     * department : [{"autoAddUser":true,"createDeptGroup":true,"id":1,"name":"顺通达集团有限公司"},{"autoAddUser":false,"createDeptGroup":false,"id":111043605,"name":"市场部","parentid":111260382},{"autoAddUser":false,"createDeptGroup":false,"id":111045617,"name":"会计二部","parentid":111067587},{"autoAddUser":false,"createDeptGroup":false,"id":111045618,"name":"业务一部","parentid":111093697},{"autoAddUser":false,"createDeptGroup":false,"id":111045619,"name":"行政部","parentid":111172443},{"autoAddUser":false,"createDeptGroup":false,"id":111045620,"name":"总经办","parentid":1},{"autoAddUser":false,"createDeptGroup":false,"id":111045621,"name":"外勤操作部","parentid":113411103},{"autoAddUser":false,"createDeptGroup":false,"id":111045622,"name":"风控部","parentid":111189560},{"autoAddUser":true,"createDeptGroup":true,"id":111067587,"name":"财务中心","parentid":1},{"autoAddUser":true,"createDeptGroup":true,"id":111073586,"name":"综合组","parentid":111045617},{"autoAddUser":true,"createDeptGroup":true,"id":111083539,"name":"物流管理组","parentid":111239431},{"autoAddUser":true,"createDeptGroup":true,"id":111084672,"name":"贸易部二组","parentid":111239426},{"autoAddUser":true,"createDeptGroup":true,"id":111093697,"name":"业务部","parentid":1},{"autoAddUser":true,"createDeptGroup":true,"id":111097536,"name":"贸易部一组","parentid":111239426},{"autoAddUser":true,"createDeptGroup":true,"id":111105477,"name":"结算组(贸易)","parentid":111239429},{"autoAddUser":true,"createDeptGroup":true,"id":111107464,"name":"结算组(物流)","parentid":111239429},{"autoAddUser":false,"createDeptGroup":false,"id":111113517,"name":"总经办","parentid":111045620},{"autoAddUser":true,"createDeptGroup":true,"id":111127540,"name":"理财组","parentid":111239434},{"autoAddUser":true,"createDeptGroup":true,"id":111164624,"name":"授信组","parentid":111239434},{"autoAddUser":true,"createDeptGroup":true,"id":111172443,"name":"人力行政中心","parentid":1},{"autoAddUser":false,"createDeptGroup":false,"id":111177433,"name":"业务二部","parentid":111093697},{"autoAddUser":true,"createDeptGroup":true,"id":111189560,"name":"营运中心","parentid":1},{"autoAddUser":true,"createDeptGroup":true,"id":111216467,"name":"财务组","parentid":111239429},{"autoAddUser":false,"createDeptGroup":false,"id":111239425,"name":"海外部","parentid":111189560},{"autoAddUser":false,"createDeptGroup":false,"id":111239426,"name":"贸易部","parentid":111189560},{"autoAddUser":false,"createDeptGroup":false,"id":111239427,"name":"报关行","parentid":1},{"autoAddUser":false,"createDeptGroup":false,"id":111239428,"name":"报关部","parentid":113411103},{"autoAddUser":false,"createDeptGroup":false,"id":111239429,"name":"会计一部","parentid":111067587},{"autoAddUser":false,"createDeptGroup":false,"id":111239430,"name":"操作部","parentid":111172443},{"autoAddUser":false,"createDeptGroup":false,"id":111239431,"name":"管理部","parentid":111067587},{"autoAddUser":false,"createDeptGroup":false,"id":111239432,"name":"货代OP部","parentid":111189560},{"autoAddUser":false,"createDeptGroup":false,"id":111239433,"name":"信息部","parentid":111260382},{"autoAddUser":false,"createDeptGroup":false,"id":111239434,"name":"资金部","parentid":111067587},{"autoAddUser":true,"createDeptGroup":true,"id":111260382,"name":"市场研发部","parentid":1},{"autoAddUser":true,"createDeptGroup":true,"id":111296306,"name":"物流组","parentid":111045617},{"autoAddUser":true,"createDeptGroup":true,"id":111313327,"name":"数据分析组","parentid":111239431},{"autoAddUser":true,"createDeptGroup":true,"id":111639708,"name":"人力资源部","parentid":111172443},{"autoAddUser":true,"createDeptGroup":true,"id":113411103,"name":"报关行","parentid":111239427},{"autoAddUser":true,"createDeptGroup":true,"id":129712619,"name":"出纳组","parentid":111239434},{"autoAddUser":true,"createDeptGroup":true,"id":139824111,"name":"运输物流部","parentid":1}]
     * errcode : 0
     * errmsg : ok
     */

    private int errcode;
    private String errmsg;
    private List<DepartmentBean> department;

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

    public List<DepartmentBean> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentBean> department) {
        this.department = department;
    }

    public static class DepartmentBean {
        /**
         * autoAddUser : true
         * createDeptGroup : true
         * id : 1
         * name : 顺通达集团有限公司
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
}
