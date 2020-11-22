package cn.sh.ideal.controller;


import javax.annotation.Resource;
import javax.validation.Valid;



import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.pojo.AccessTokenVO;
import cn.sh.ideal.pojo.JsapiTicketVO;
import cn.sh.ideal.pojo.SignatureVO;
import cn.sh.ideal.service.WeChatService;

/**
 * 
 * @Description	微信相关接口
 * @author yanggaoli
 * @date 2020年8月11日下午5:55:05
 */

@CrossOrigin(origins = "*", maxAge = 3600)
/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */

@RestController
@RequestMapping(value = "/wechat")
public class WechatController {
	
	@Resource
	WeChatService weChatService;
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/wechat/signature
	 * 		参数：SignatureVO
	 * @Description	获取签名
	 * @author yanggaoli
	 * @date 2020年8月5日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/signature", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getSignature(@Valid SignatureVO signatureVO)  throws Exception{
		return weChatService.getSignature(signatureVO);
	}
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/wechat/accessToken
	 * 		参数：SignatureVO
	 * @Description	获取签名
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/accessToken", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getSignature(@Valid AccessTokenVO accessTokenVO)  throws Exception{
		return weChatService.getAccessTokenVO(accessTokenVO);
	}
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/wechat/jsapiTicket
	 * 		参数：SignatureVO
	 * @Description	获取签名
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/jsapiTicket", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getJsapiTicket(@Valid JsapiTicketVO jsapiTicketVO)  throws Exception{
		return weChatService.getJsapiTicketVO(jsapiTicketVO);
	}
	
	
	
	
}
