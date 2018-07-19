package com.controller;

import com.config.Constant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.DingTalkSignatureUtil;
import com.dingtalk.api.request.OapiServiceGetCorpTokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiServiceGetCorpTokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.config.URLConstant;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ISV E应用Quick-Start示例代码
 * 实现了最简单的免密登录（免登）功能
 */
@RestController
public class IndexController {
	private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * 欢迎页面
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	/**
	 * 钉钉用户登录，显示当前登录的企业和用户
	 * @param requestAuthCode	免登临时code
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ServiceResult login(@RequestParam(value = "authCode") String requestAuthCode) {
		Long start = System.currentTimeMillis();
		//获取accessToken,注意正是代码要有异常流处理
		String accessToken = AccessTokenUtil.getToken();

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


		//返回结果
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("userId",userId);
		ServiceResult serviceResult = ServiceResult.success(resultMap);
		return serviceResult;
	}

}


