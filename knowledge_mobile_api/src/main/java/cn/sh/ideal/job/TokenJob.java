package cn.sh.ideal.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import cn.sh.ideal.bean.AccessToken;
import cn.sh.ideal.bean.JsapiTicket;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.common.CommProperties;
import cn.sh.ideal.pojo.AccessTokenVO;
import cn.sh.ideal.pojo.JsapiTicketVO;
import cn.sh.ideal.pojo.PolicyClickVO;
import cn.sh.ideal.service.ClickLoggerService;
import cn.sh.ideal.service.WeChatService;
import cn.sh.ideal.util.DateUtil;
import cn.sh.ideal.util.HttpClientUtil;



public class TokenJob {
	
	public static Logger logger = LoggerFactory.getLogger(TokenJob.class);
	
	@Autowired
	WeChatService weChatService;
	
	public void getAccessToken() {
		logger.info("获取token的方法执行了");
		
		try {
			
			String job_on = CommProperties.getProp("job_on");
			if("1".equals(job_on)){
				
				String appId = CommProperties.getProp("appId");
				String appsecret = CommProperties.getProp("appsecret");
				AccessTokenVO accessTokenVO = new AccessTokenVO();
				
				accessTokenVO.setAppId(appId);
				accessTokenVO.setAppsecret(appsecret);
				ResultBean accessTokenResultBean = weChatService.getAccessTokenVO(accessTokenVO);
				
				JsapiTicketVO jsapiTicketVO = new JsapiTicketVO();
				BeanUtils.copyProperties(accessTokenResultBean.getData(), jsapiTicketVO);
				ResultBean jsapiTicketResultBean = weChatService.getJsapiTicketVO(jsapiTicketVO);
			
			}
		} catch (Exception e) {
			logger.info("获取token的方法执行失败了");
			e.printStackTrace();
		}finally{
			logger.info("获取token的方法执行完成了了");
		}
	}
	
	public void getAccessToken_copy() {
		logger.info("获取token的方法执行了");
		
		try {
			
			//调用微信的获取token的接口
//			String resultStr = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx97bb35a715881329&secret=44bbd9f270d6c4953a5124d856882e60");

			String resultStr = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx97bb35a715881328&secret=44bbd9f270d6c4953a5124d856882e60");
			logger.info(resultStr);
			
			AccessToken accessToken = JSON.parseObject(resultStr, AccessToken.class);
			
			//解析数据并入库
//			AccessToken accessToken = new AccessToken();
			accessToken.setAppId("wx97bb35a715881329");
			accessToken.setAppsecret("44bbd9f270d6c4953a5124d856882e60");
//			accessToken.setAccess_token("123456");
			accessToken.setGrant_type("client_credential");
//			accessToken.setExpires_in(7200);
			accessToken.setExpires_date(DateUtil.dateAddMinute(new Date(),accessToken.getExpires_in()));
			
			AccessToken queryAccessToken = weChatService.getAccessToken("wx97bb35a715881329");
			if(queryAccessToken == null){
				
				weChatService.saveAccessToken(accessToken);
			}else{
				accessToken.setKlId(queryAccessToken.getKlId());
				weChatService.updateAccessToken(accessToken);
			}
			
			
			//获取临时票根
			String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
			Map<String, String> param = new HashMap<String, String>();
			param.put("access_token", accessToken.getAccess_token());
			param.put("type", "jsapi");
			
			String resultStr_ticket = HttpClientUtil.doGet(url,param);
			Map maps = (Map)JSON.parse(resultStr_ticket);
			
			String ticket = (String) maps.get("ticket");
			logger.info("ticket=[{}]",ticket);
			ticket = "bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA";
			
			
			//数据库保存临时票根
			JsapiTicket jsapiTicket = new JsapiTicket();
			BeanUtils.copyProperties(accessToken, jsapiTicket);
			jsapiTicket.setGrant_type("jsapi");
			jsapiTicket.setTicket(ticket);
			
			JsapiTicket queryJsapiTicket = weChatService.getJsapiTicket("wx97bb35a715881329");
			if(queryJsapiTicket == null){
				weChatService.saveJsapiTicket(jsapiTicket);
			}else{
				jsapiTicket.setKlId(queryJsapiTicket.getKlId());
				weChatService.updateJsapiTicket(jsapiTicket);
			}
			
			
			
			
			//获取卡券
			
			logger.info(queryAccessToken.toString());
			queryAccessToken.setAccess_token("access_token12345"+new Date().getTime());
			queryAccessToken.setExpires_date(accessToken.getExpires_date());
			
			weChatService.updateAccessToken(queryAccessToken);
			//获取token
			AccessToken queryAccessToken1 = weChatService.getAccessToken("wx97bb35a715881329");
			logger.info(queryAccessToken1.toString());
			
			
			
			JsapiTicket queryJsapiTicket2 = weChatService.getJsapiTicket("wx97bb35a715881329");
			logger.info(queryJsapiTicket2.toString());
			
			queryJsapiTicket.setTicket("ticket12345"+new Date().getTime());
			queryJsapiTicket.setExpires_date(accessToken.getExpires_date());
			weChatService.updateJsapiTicket(queryJsapiTicket);
			
			JsapiTicket queryJsapiTicket1 = weChatService.getJsapiTicket("wx97bb35a715881329");
			logger.info(queryJsapiTicket1.toString());
			
			
			
			
		} catch (Exception e) {
			logger.info("获取token的方法执行失败了");
			e.printStackTrace();
		}finally{
			logger.info("获取token的方法执行完成了了");
		}
	}
	
	
	public static void main(String[] args) {
		String data = "jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com";
		     	data = "jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com?params=value";	
		//加密数据
		logger.info("返回给前端的xxxshaHex加密字符串【{}】" ,DigestUtils.shaHex(data));
		logger.info("返回给前端的sha256Hex加密字符串【{}】" ,DigestUtils.sha256Hex(data));
		logger.info("返回给前端的sha384Hex加密字符串【{}】" ,DigestUtils.sha384Hex(data));
		logger.info("返回给前端的sha512Hex加密字符串【{}】" ,DigestUtils.sha512Hex(data));
		
	}
}
