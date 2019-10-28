package com.dadapro.mq.Receiver;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.dadapro.config.Constant;
import com.dadapro.responBean.ErpMessage;
import com.dadapro.util.AccessTokenUtil;
import com.dadapro.util.MessageUtil;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2019-10-21
 */

@Component
//监听队列ding_erp_message
@RabbitListener(queues = {Constant.MQ_QQ_NAME})
public class DingErpReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(DingErpReceiver.class);

    @RabbitHandler
    public void receiver(String erpApproveMessage) throws ApiException {


        ErpMessage erpMessage = JSONUtil.toBean(erpApproveMessage, ErpMessage.class);
        if (ObjectUtil.isNotNull(erpMessage)){

            MessageUtil.sendDingTalkMessage(erpMessage);
        }else {
            LOG.debug("J1--> erpMessage is null ！ erpApproveMessage:{}", erpApproveMessage);
        }


//        String userId = AccessTokenUtil.getInstance().getDingsUserId(username);
//        if (StrUtil.isNotBlank(userId)){
//            MessageUtil.sendDingTalkMessage(AccessTokenUtil.getInstance().getToken(),userId);
//        }


    }
}
