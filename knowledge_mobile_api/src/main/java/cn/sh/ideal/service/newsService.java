package cn.sh.ideal.service;




import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;


import cn.sh.ideal.dao.ClickLoggerDao;
import cn.sh.ideal.pojo.FocusClickVO;
import cn.sh.ideal.pojo.HotWordClickVO;
import cn.sh.ideal.pojo.PolicyClickVO;
import cn.sh.ideal.pojo.SearchClickVO;
import cn.sh.ideal.util.HttpClientUtil;
import cn.sh.ideal.entity.FocusClick;
import cn.sh.ideal.entity.HotWordClick;
import cn.sh.ideal.entity.PolicyClick;
import cn.sh.ideal.entity.SearchClick;
import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ResponseResultBean;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.bean.Token;




public class newsService{
	public static Logger logger = LoggerFactory.getLogger(newsService.class);
	
	
	public static void main(String[] args) {
		//getToken();
		getTree();
//		getInfo();
//		getInfoList();
	}


	
	public static void getToken() {
		String url = "http://10.81.71.161/api/auth/vclient/login";
		 
		Map<String, String> param = new HashMap<String, String>();
		param.put("appKey", "sh_12345");
		param.put("appSecret", "12879228a4294b41b07c1d7dc462dc31");
		String json = JSON.toJSONString(param);
		System.out.println(json);
		
		
		String result = HttpClientUtil.doPostJson(url, json);
		
		ResponseResultBean resultData = (ResponseResultBean) JSON.parseObject(result,ResponseResultBean.class);
		
//		ResponseResultBean [message=success, code=0, data=Token [token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzeXNfdXNlciIsImV4cCI6MTYwMjcyNjM2MSwidXNlcklkIjoiY2U1ZDk0NjhiNjc4NGZmMGFiYmU1NTYxNDIyNDdmNGMifQ.yrlwtBHgmW1FPYpfT7RSl8gVgtNVaI9pDfTGtdmjjkg, refreshToken=71cab902b712488a9d87809d7c523576, expireSeconds=1200]]
//		Token [token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzeXNfdXNlciIsImV4cCI6MTYwMjcyNjM2MSwidXNlcklkIjoiY2U1ZDk0NjhiNjc4NGZmMGFiYmU1NTYxNDIyNDdmNGMifQ.yrlwtBHgmW1FPYpfT7RSl8gVgtNVaI9pDfTGtdmjjkg, refreshToken=71cab902b712488a9d87809d7c523576, expireSeconds=1200]

		System.out.println(resultData.toString());
		if("0".equals(resultData.getCode())){
			Token token = resultData.getData();
			System.out.println(token.toString());
		}
	}
	
	
	
	public static Object getInfoList(){
		String url = "http://10.81.71.161/api/pack/content/page";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("queryParam", new Object());
		
		String json = JSON.toJSONString(param);
		Map<String, String> paramHead = new HashMap<String, String>();
		paramHead.put("accessToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzeXNfdXNlciIsImV4cCI6MTYwMjczMDc1MCwidXNlcklkIjoiY2U1ZDk0NjhiNjc4NGZmMGFiYmU1NTYxNDIyNDdmNGMifQ.Xm8gNoJzJwNkaVsIxXfeA2mSAH3AmZ-XolWiUddl5no");
		paramHead.put("siteId", "0001");
		String result = HttpClientUtil.doPostJson(url,json,paramHead);
		System.out.println(result);
		return null;
	}
	public static Object getInfo(){
		String url = "http://10.81.71.161/api/pack/content/get";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("queryParam", new Object());
		
		String json = JSON.toJSONString(param);
		Map<String, String> paramHead = new HashMap<String, String>();
		paramHead.put("accessToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzeXNfdXNlciIsImV4cCI6MTYwMjczMDc1MCwidXNlcklkIjoiY2U1ZDk0NjhiNjc4NGZmMGFiYmU1NTYxNDIyNDdmNGMifQ.Xm8gNoJzJwNkaVsIxXfeA2mSAH3AmZ-XolWiUddl5no");
		paramHead.put("siteId", "0001");
		String result = HttpClientUtil.doPostJson(url,json,paramHead);
		System.out.println(result);
		return null;
	}
	
	

	public static Object getTree(){
		String url = "http://10.81.71.161/api/pack/content/channel/tree";
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("modelId", "0001-173a8f59416d46ec8b5a49131ae3948b");
		param.put("recursion", "true");
		
		String json = JSON.toJSONString(param);
		
		Map<String, String> paramHead = new HashMap<String, String>();
		paramHead.put("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzeXNfdXNlciIsImV4cCI6MTYwMjc0MTg5NCwidXNlcklkIjoiY2U1ZDk0NjhiNjc4NGZmMGFiYmU1NTYxNDIyNDdmNGMifQ.Vs09u_8biPhF1QvayQoy16s3c7CY6CC5u5HbmlALr5A");
		paramHead.put("siteId", "0001");
		
		String result = HttpClientUtil.doPostJson(url,json,paramHead);
		System.out.println(result);
		return null;
	}

	
}
