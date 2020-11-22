package cn.sh.ideal.service;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.sh.ideal.dao.WeChatDao;
import cn.sh.ideal.pojo.AccessTokenVO;
import cn.sh.ideal.pojo.JsapiTicketVO;
import cn.sh.ideal.pojo.SignatureVO;
import cn.sh.ideal.util.DateUtil;
import cn.sh.ideal.util.WechatUtil;
import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.AccessToken;
import cn.sh.ideal.bean.JsapiTicket;
import cn.sh.ideal.bean.ResultBean;




@Service(value="weChatService")
public class WeChatService{
	public static Logger logger = LoggerFactory.getLogger(WeChatService.class);
	@Resource
	public WeChatDao weChatDao;
	
	@MyAnnotation(flag = true, 
			value = "WeChatService的addHotWordClick【添加token信息】")
	public ResultBean saveAccessToken(AccessToken accessToken) throws Exception{
		ResultBean resultBean = new ResultBean();
		//保存Access_Token
		int count  = weChatDao.saveAccessToken(accessToken);
		resultBean.setData(count);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "WeChatService的saveJsapiTicket【添加临时票根】")
	public ResultBean saveJsapiTicket(JsapiTicket jsapiTicket) throws Exception{
		ResultBean resultBean = new ResultBean();
		//保存Access_Token
		int count  = weChatDao.saveJsapiTicket(jsapiTicket);
		resultBean.setData(count);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "WeChatService的getJsapiTicket【获取临时票根】")
	public JsapiTicket getJsapiTicket(String appId) throws Exception{
		 
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appId", appId);
		return weChatDao.getJsapiTicket(paramMap);
	}
	
	@MyAnnotation(flag = true, 
			value = "WeChatService的getAccessToken【获取token】")
	public AccessToken getAccessToken(String appId) throws Exception{
		 
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appId", appId);
		
		return weChatDao.getAccessToken(paramMap);
	}
	
	
	
	
	public void updateAccessToken(AccessToken queryAccessToken) {
		int coutnt = weChatDao.updateAccessToken(queryAccessToken);
		logger.info("更新结果coutnt={}",coutnt);
	}

	public void updateJsapiTicket(JsapiTicket queryJsapiTicket) {
		int coutnt = weChatDao.updateJsapiTicket(queryJsapiTicket);
		logger.info("更新结果coutnt={}",coutnt);
	}
	
	
	
	@MyAnnotation(flag = true,value = "WeChatService的getSignature【获取签名字符串】")
	public ResultBean getSignature(SignatureVO signatureVO) throws Exception{
		
		ResultBean resultBean = new ResultBean();
		//根据appID查询ticket
		JsapiTicket jsapiTicket = getJsapiTicket(signatureVO.getAppId());
		signatureVO.setJsapi_ticket(jsapiTicket.getTicket());
		
		//获取签名算法
		String signatureStr = signatureVO.createSignature();
		signatureVO.setSignatureStr(signatureStr);
		
		/*
		String data = "jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com";
		//加密数据
		logger.info("返回给前端的xxxshaHex加密字符串【{}】" ,DigestUtils.shaHex(data));
		*/
		
		logger.info("返回给前端的xxxshaHex加密字符串【{}】" ,signatureStr);
		resultBean.setData(signatureVO);
		return resultBean;
	}
	
	@MyAnnotation(flag = true,value = "WeChatService的getAccessTokenVO【获取accessToken并入库】")
	public ResultBean getAccessTokenVO(AccessTokenVO accessTokenVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		
		Map<String, Object> map = WechatUtil.getAccessToken(accessTokenVO.getAppId(),accessTokenVO.getAppsecret());
		accessTokenVO.setAccess_token((String)map.get("access_token"));
//		accessTokenVO.setExpires_in(Integer.parseInt(map.get("expires_in")));
//		accessTokenVO.setExpires_date(DateUtil.dateAddMinute(new Date(),Integer.parseInt(map.get("expires_in"))));
		accessTokenVO.setExpires_in((Integer)map.get("expires_in"));
		accessTokenVO.setExpires_date(DateUtil.dateAddMinute(new Date(),(Integer)map.get("expires_in")));
		
		accessTokenVO.setGrant_type("client_credential");
		
		AccessToken accessToken = new AccessToken();
		BeanUtils.copyProperties(accessTokenVO, accessToken);
		
		AccessToken queryAccessToken = getAccessToken(accessTokenVO.getAppId());
		if(queryAccessToken == null){
			weChatDao.saveAccessToken(accessToken);
		}else{
			accessToken.setKlId(queryAccessToken.getKlId());
			weChatDao.updateAccessToken(accessToken);
		}
		resultBean.setData(accessTokenVO);
		return resultBean;
	}
	
	@MyAnnotation(flag = true,value = "WeChatService的getAccessTokenVO【获取accessToken并入库】")
	public ResultBean getJsapiTicketVO(JsapiTicketVO jsapiTicketVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		
		Map<String, Object> map = WechatUtil.getTicket(jsapiTicketVO.getAccess_token());
		
		jsapiTicketVO.setTicket((String)map.get("ticket"));
		
//		jsapiTicketVO.setExpires_in(Integer.parseInt(map.get("expires_in")));
//		jsapiTicketVO.setExpires_date(DateUtil.dateAddMinute(new Date(),Integer.parseInt(map.get("expires_in"))));
		jsapiTicketVO.setExpires_in((Integer)map.get("expires_in"));
		jsapiTicketVO.setExpires_date(DateUtil.dateAddMinute(new Date(),(Integer)map.get("expires_in")));
		
		jsapiTicketVO.setGrant_type("jsapi");
		
		JsapiTicket jsapiTicket = new JsapiTicket();
		BeanUtils.copyProperties(jsapiTicketVO, jsapiTicket);
		
		JsapiTicket queryJsapiTicket = getJsapiTicket(jsapiTicketVO.getAppId());
		if(queryJsapiTicket == null){
			weChatDao.saveJsapiTicket(jsapiTicket);
		}else{
			jsapiTicket.setKlId(queryJsapiTicket.getKlId());
			weChatDao.updateJsapiTicket(jsapiTicket);
		}
		resultBean.setData(jsapiTicketVO);
		return resultBean;
	}
	
}
