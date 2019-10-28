package com.dadapro.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.dadapro.bean.Dept;
import com.dadapro.bean.User;
import com.dadapro.config.Constant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserSimplelistRequest;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserSimplelistResponse;
import com.dadapro.responBean.ResponDept;
import com.dadapro.responBean.ResponMessage;
import com.dadapro.responBean.ResponUser;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.dadapro.config.URLConstant.URL_GET_TOKKEN;

/**
 * 获取access_token工具类
 */
@Component
public class AccessTokenUtil {

    private static final Logger bizLogger = LoggerFactory.getLogger(AccessTokenUtil.class);

    private AccessTokenUtil(){

    };

    private static AccessTokenUtil atu;

    public static AccessTokenUtil getInstance(){
        if (atu == null){
            atu = new AccessTokenUtil();
        }
        return atu;
    }


    @Autowired
    private CacheManager cacheManager;



    @PostConstruct
    public void init() {
        getInstance().cacheManager=this.cacheManager;
    }



    public String getToken() throws RuntimeException {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(URL_GET_TOKKEN);
            OapiGettokenRequest request = new OapiGettokenRequest();

            request.setAppkey(Constant.APP_KEY);
            request.setAppsecret(Constant.APP_SECRET);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            String accessToken = response.getAccessToken();
            return accessToken;
        } catch (ApiException e) {
            bizLogger.error("getAccessToken failed", e);
            throw new RuntimeException();
        }

    }

    public static void main(String[] args) throws ApiException {
        String accessToken = AccessTokenUtil.getInstance().getToken();

        String userId = AccessTokenUtil.getInstance().getDingsUserId("赵文");


//        ResponMessage message = MessageUtil.sendDingTalkMessage(accessToken, userId);

        /*[{"createDeptGroup":true,"name":"顺通达集团有限公司","id":1,"autoAddUser":true},{"createDeptGroup":false,"name":"市场部","id":111043605,"autoAddUser":false,"parentid":111260382},{"createDeptGroup":false,"name":"会计二部","id":111045617,"autoAddUser":false,"parentid":111067587},{"createDeptGroup":false,"name":"业务一部","id":111045618,"autoAddUser":false,"parentid":111093697},{"createDeptGroup":false,"name":"行政部","id":111045619,"autoAddUser":false,"parentid":111172443},{"createDeptGroup":false,"name":"总经办","id":111045620,"autoAddUser":false,"parentid":1},{"createDeptGroup":false,"name":"外勤操作部","id":111045621,"autoAddUser":false,"parentid":113411103},{"createDeptGroup":false,"name":"风控部","id":111045622,"autoAddUser":false,"parentid":111189560},{"createDeptGroup":true,"name":"财务中心","id":111067587,"autoAddUser":true,"parentid":1},{"createDeptGroup":true,"name":"综合组","id":111073586,"autoAddUser":true,"parentid":111045617},{"createDeptGroup":true,"name":"物流管理组","id":111083539,"autoAddUser":true,"parentid":111239431},{"createDeptGroup":true,"name":"贸易部二组","id":111084672,"autoAddUser":true,"parentid":111239426},{"createDeptGroup":true,"name":"业务部","id":111093697,"autoAddUser":true,"parentid":1},{"createDeptGroup":true,"name":"贸易部一组","id":111097536,"autoAddUser":true,"parentid":111239426},{"createDeptGroup":true,"name":"结算组\u0028贸易\u0029","id":111105477,"autoAddUser":true,"parentid":111239429},{"createDeptGroup":true,"name":"结算组\u0028物流\u0029","id":111107464,"autoAddUser":true,"parentid":111239429},{"createDeptGroup":false,"name":"总经办","id":111113517,"autoAddUser":false,"parentid":111045620},{"createDeptGroup":true,"name":"理财组","id":111127540,"autoAddUser":true,"parentid":111239434},{"createDeptGroup":true,"name":"授信组","id":111164624,"autoAddUser":true,"parentid":111239434},{"createDeptGroup":true,"name":"人力行政中心","id":111172443,"autoAddUser":true,"parentid":1},{"createDeptGroup":false,"name":"业务二部","id":111177433,"autoAddUser":false,"parentid":111093697},{"createDeptGroup":true,"name":"营运中心","id":111189560,"autoAddUser":true,"parentid":1},{"createDeptGroup":true,"name":"财务组","id":111216467,"autoAddUser":true,"parentid":111239429},{"createDeptGroup":false,"name":"海外部","id":111239425,"autoAddUser":false,"parentid":111189560},{"createDeptGroup":false,"name":"贸易部","id":111239426,"autoAddUser":false,"parentid":111189560},{"createDeptGroup":false,"name":"报关行","id":111239427,"autoAddUser":false,"parentid":1},{"createDeptGroup":false,"name":"报关部","id":111239428,"autoAddUser":false,"parentid":113411103},{"createDeptGroup":false,"name":"会计一部","id":111239429,"autoAddUser":false,"parentid":111067587},{"createDeptGroup":false,"name":"操作部","id":111239430,"autoAddUser":false,"parentid":111172443},{"createDeptGroup":false,"name":"管理部","id":111239431,"autoAddUser":false,"parentid":111067587},{"createDeptGroup":false,"name":"货代OP部","id":111239432,"autoAddUser":false,"parentid":111189560},{"createDeptGroup":false,"name":"信息部","id":111239433,"autoAddUser":false,"parentid":111260382},{"createDeptGroup":false,"name":"资金部","id":111239434,"autoAddUser":false,"parentid":111067587},{"createDeptGroup":true,"name":"市场研发部","id":111260382,"autoAddUser":true,"parentid":1},{"createDeptGroup":true,"name":"物流组","id":111296306,"autoAddUser":true,"parentid":111045617},{"createDeptGroup":true,"name":"数据分析组","id":111313327,"autoAddUser":true,"parentid":111239431},{"createDeptGroup":true,"name":"人力资源部","id":111639708,"autoAddUser":true,"parentid":111172443},{"createDeptGroup":true,"name":"报关行","id":113411103,"autoAddUser":true,"parentid":111239427},{"createDeptGroup":true,"name":"出纳组","id":129712619,"autoAddUser":true,"parentid":111239434},{"createDeptGroup":true,"name":"运输物流部","id":139824111,"autoAddUser":true,"parentid":1}],"errmsg":"ok"}*/

        /**
         * 获取部门下所有人员
         */
        /*DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(111045618L);
        request.setHttpMethod("GET");

        OapiUserSimplelistResponse response = client.execute(request, accessToken);
        System.out.println(response.getBody());*/
        /*{"errcode":0,"errmsg":"ok","userlist":[{"name":"钟信高","userid":"015537650537236726"},{"name":"苏锡峰","userid":"025467003233388286"},{"name":"黄亚娥","userid":"062642282639705743"},{"name":"郭艺泉","userid":"4831495736717372"},{"name":"肖良强","userid":"023236006932693697"},{"name":"黄文锻","userid":"062642271839902808"}]}*/
    }

    /**
     * 根据部门ID获取所有的用户
     *
     * @param DepartmentId
     * @param accessToken
     * @return
     * @throws ApiException
     */
    public ResponUser getDingTalkUsers(Long DepartmentId, String accessToken) throws ApiException {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(DepartmentId);
        request.setHttpMethod("GET");
        OapiUserSimplelistResponse response = client.execute(request, accessToken);
        ResponUser responUser = JSONUtil.toBean(response.getBody(), ResponUser.class);
        return responUser;

    }

    /**
     * 根据token获取所有的部门ID
     *
     * @param accessToken
     * @return
     * @throws ApiException
     */
    public ResponDept getDingTalkDepts(String accessToken) throws ApiException {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setHttpMethod("GET");
        OapiDepartmentListResponse response = client.execute(request, accessToken);
        System.out.println(response.getBody());
        ResponDept responDept = JSONUtil.toBean(response.getBody(), ResponDept.class);
        return responDept;

    }


    /**
     * 获取所有的钉钉用户
     *
     * @return
     */
    public List<User> getDingsUser(String accessToken) throws ApiException {
        List<User> users = new ArrayList<User>();

        ResponDept dingTalkDepts = getDingTalkDepts(accessToken);
        List<Dept> depts = JSONUtil.toList(JSONUtil.parseArray(dingTalkDepts.getDepartment()), Dept.class);
        for (Dept dept : depts) {
            long dId = dept.getId();
            if (ObjectUtil.isNotNull(dId) && dId != 1L) {
                ResponUser responUser = getDingTalkUsers(dept.getId(), accessToken);
                List<User> us = JSONUtil.toList(JSONUtil.parseArray(responUser.getUserlist()), User.class);
                //将新查询出来的用户列表添加到users中
                users = CollUtil.addAllIfNotContains(users, us);
            }
        }
        cacheManager.getCache("dingding").put("dd_user",users);
        return users;
    }

    /**
     * 根据用户名查找用户id
     *
     * @param username
     * @return
     */
    public String getDingsUserId(String username) throws ApiException {
        String userId = "";
        Cache.ValueWrapper valueWrapper = cacheManager.getCache("dingding").get("dd_user");
        if (ObjectUtil.isNotNull(valueWrapper)) {
            List<User> dingUsers = (List<User>) valueWrapper.get();
            userId = getArrayByUserId(dingUsers, username);
            return userId;
        } else {
            List<User> dingsUser = getDingsUser(getToken());
            userId = getArrayByUserId(dingsUser, username);
            return userId;
        }
    }

    /**
     * 根据User集合遍历并确定一致名称则找到对应的userID
     *
     * @param dingdingUsers
     * @param username
     * @return
     */
    public static String getArrayByUserId(List<User> dingdingUsers, String username) {
        String userId = "";
        for (User dingUser : dingdingUsers) {
            if (StrUtil.equalsAny(dingUser.getName(), username)) {
                userId = dingUser.getUserid();
            }
        }
        return userId;
    }
}
