package cn.sh.ideal.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.service.FocusService;
import cn.sh.ideal.service.PolicyService;

/**
 * 
 * @Description	新政新规查询
 * @author yanggaoli
 * @date 2020年3月11日下午5:55:05
 */

@CrossOrigin(origins = "*", maxAge = 3600)
/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */
@RestController
@RequestMapping(value = "/policy")
public class PolicyAction {
	@Resource
	PolicyService policyService;
	
	@Resource
	FocusService focusService;
	   
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/latestInfos
	 * 		参数：无
	 * @Description	查询最近的三条新政新规
	 * @author yanggaoli
	 * @date 2020年3月11日下午5:55:59
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/latestInfos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getLatestPolicyInfos() throws Exception{
		return policyService.getLatestInfos();
	}
	
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/infos
	 * 		参数：map
	 * @Description	
	 * @author yanggaoli
	 * @date 2020年3月11日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getPolicyInfosByWh(@RequestParam Map<String,String> map)  throws Exception{
		return policyService.getInfosByWhere(map);
	}
	
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/infos/{11526569}
	 * 		参数：contentId（知识信息ID）
	 * @Description	查询信息详情
	 * @author yanggaoli
	 * @date 2020年3月11日下午5:56:58
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/infos/{contentId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getPolicyInfo(@PathVariable String contentId)  throws Exception{
		return focusService.getContentInfoById(contentId);
	}
}
