package com.dadapro.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.dadapro.bean.User;
import com.dadapro.responBean.ErpMessage;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dadapro.responBean.ResponMessage;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @date 2019-10-18
 */
public class MessageUtil {

    private static final Logger LOG = LoggerFactory.getLogger(MessageUtil.class);

    /**
     * 发送消息给具体的用户
     * @param accessToken
     * @return
     * @throws ApiException
     */

    static String MESSAGE_TEMPLATE = "{}\n【申请人】{} \n【当前审批人】{} \n  请及时到ERP系统进行查阅并审批，谢谢\n";


    public static ResponMessage sendDingTalkMessage(ErpMessage erpMessage) throws ApiException {

//        String msgContent = "【结算单号】：JS201906200016" +
//                "【属  主】：厦门大亮贸易有限公司-业务一部-黄文锻" +
//                "【进口合同号】";

        String userid = AccessTokenUtil.getInstance().getDingsUserId(erpMessage.getApprover());
        String msgContent = (String) erpMessage.getTaskexpl();
//        msgContent = msgContent.replace("【","\n【");
        String formatMeesage = StrUtil.format(MESSAGE_TEMPLATE, msgContent, erpMessage.getSubmitter(), erpMessage.getApprover());


        String accessToken = AccessTokenUtil.getInstance().getToken();


        LOG.info("J1=====> Message is Approver:{}, content:{},{}",erpMessage.getApprover(),formatMeesage);

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setUseridList(userid);
//        request.setUseridList("manager4278");
        request.setAgentId(279917024L);
        request.setToAllUser(false);

        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();

        msg.setMsgtype("text");
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());


        msg.getText().setContent(formatMeesage);
        request.setMsg(msg);

        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request,accessToken);
        ResponMessage responMessage = JSONUtil.toBean(response.getBody(), ResponMessage.class);



        return responMessage;
    }

}
