package cn.sh.ideal.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.alibaba.fastjson.JSON;

public class WechatUtil {
	public static Logger logger = LoggerFactory.getLogger(WechatUtil.class);
	
	//"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx97bb35a715881328&secret=44bbd9f270d6c4953a5124d856882e60";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	private final static String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	
	public static Map<String,Object> getAccessToken(String appId,String appsecret){
		Map<String,String> param = new HashMap<String, String>(); 
		param.put("appId", appId);
		param.put("secret", appsecret);
		param.put("grant_type", "client_credential");
		String resultStr ="";// HttpClientUtil.doGet(ACCESS_TOKEN_URL, param);
		
//		resultStr = "{\"access_token\":\"36_JpYH9sM6tUzOVwd-vksnfX-U_0Hpds4Rlf9TN9S9prwGIX6FfizwK2m8nGmgossS8nWqwCuP5VPQp08aTfi1Dztr2M3iC2zqyTmkMIEA7toDz48ZZLpN4KCqJ-PDSSEYwBz8yjUjMKOw9_zuWHMiAAAKVA\",\"expires_in\":7200}";
		resultStr = HttpClientUtil.doGet(ACCESS_TOKEN_URL, param);
		logger.info("调用微信服务获取的access_tonken的返回值是{}",resultStr);
		Map<String,Object> resultMap = (Map<String, Object>) JSON.parse(resultStr);
		/*
		//下面是测试代码，上线前删除
		resultMap.put("access_token", "123456"+DateUtil.dateToCnStr(new Date()));
		resultMap.put("expires_in", "7200");
		*/
		return resultMap;
	}
	
	public static Map<String,Object> getTicket(String accessToken){
		Map<String, String> param = new HashMap<String, String>();
		param.put("access_token", accessToken);
		param.put("type", "jsapi");
		String resultStr = HttpClientUtil.doGet(TICKET_URL, param);
		logger.info("调用微信服务获取的ticket的返回值是{}",resultStr);
		Map<String,Object> resultMap = (Map<String, Object>) JSON.parse(resultStr);
		
		/*
		resultMap.put("expires_in", "7200");
		resultMap.put("ticket", "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
		*/
		return resultMap;
	}
	
	
	
}
