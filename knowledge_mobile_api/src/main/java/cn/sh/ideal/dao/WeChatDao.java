package cn.sh.ideal.dao;



import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sh.ideal.bean.AccessToken;
import cn.sh.ideal.bean.JsapiTicket;



@Repository
public interface WeChatDao {
	
	public int saveAccessToken(AccessToken accessToken);
	
	
	public int updateAccessToken(AccessToken accessToken);
	
	public AccessToken getAccessToken(Map<String,Object> paramMap);
	
	
	public int saveJsapiTicket(JsapiTicket jsapiTicket);
	public int updateJsapiTicket(JsapiTicket jsapiTicket);
	public JsapiTicket getJsapiTicket(Map<String,Object> paramMap);
	
}
