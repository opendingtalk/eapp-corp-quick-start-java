package com.dadapro.controller;

import com.dadapro.config.Constant;
import com.dadapro.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import com.dadapro.util.AccessTokenUtil;
import com.dadapro.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业内部E应用Quick-Start示例代码 实现了最简单的免密登录（免登）功能
 */
@RestController
public class IndexController {
    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 欢迎页面,通过url访问，判断后端服务是否启动
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    /**
     * 钉钉用户登录，显示当前登录用户的userId和名称
     *
     * @param requestAuthCode 免登临时code
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult login(@RequestParam(value = "authCode") String requestAuthCode) {
        //获取accessToken,注意正是代码要有异常流处理
        String accessToken = AccessTokenUtil.getInstance().getToken();

        //获取用户信息
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_GET_USER_INFO);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(requestAuthCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
        //3.查询得到当前用户的userId
        // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
        String userId = response.getUserid();

        String userName = getUserName(accessToken, userId);
        System.out.println(userName);
        //返回结果
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userName", userName);
        ServiceResult serviceResult = ServiceResult.success(resultMap);
        return serviceResult;
    }

    /**
     * 获取用户姓名
     *
     * @param accessToken
     * @param userId
     * @return
     */
    private String getUserName(String accessToken, String userId) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_USER_GET);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            return response.getName();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 单条消息发送给单个队列，该队列只有一个消费者
     *
     * @return
     */
    @GetMapping(value = "send")
    public String send(@RequestParam String username) throws ApiException {

        String content = "Date:" + System.currentTimeMillis();
        //发送默认交换机对应的的队列kinson
        String userId = AccessTokenUtil.getInstance().getDingsUserId("赵文");

//        amqpTemplate.convertAndSend(Constant.MQ_QQ_NAME, username);
        bizLogger.info("J1-> " + content + "  userId +  " + userId);
        return content;
    }

}


