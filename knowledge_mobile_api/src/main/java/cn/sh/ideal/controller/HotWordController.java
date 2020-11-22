package cn.sh.ideal.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.service.HotWordService;
import cn.sh.ideal.bean.ResultBean;

/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/hotWord")
public class HotWordController {
	public static Logger logger = LoggerFactory.getLogger(HotWordController.class);
	
	@Autowired
	Validator globalValidator;
	@Resource
	HotWordService hotWordService;
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/zxcx/infos
	 * 		参数		无
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午2:42:48
	 * @Title: getZxcxHotWordList 
	 * @Description TODO 专项查询、获取热词信息列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxcx/infos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getZxcxHotWordList() throws Exception{
		return hotWordService.getZxcxHotWordList();
	}
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/mszl/infos
	 * 		参数		无
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午2:42:48
	 * @Title: getMszlHotWordList 
	 * @Description TODO 民生专栏查询、获取热词信息列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mszl/infos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getMszlHotWordList() throws Exception{
		return hotWordService.getMszlHotWordList();
	}
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/hotWord/linkHotWords
	 * http://192.168.123.2:18200/knowledge_mobile_api/hotWord/linkHotWords
	 * 		参数		无
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午2:42:48
	 * @Title: getMszlHotWordList 
	 * @Description TODO 根据热词ID查询该热词关联的知识信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/linkHotWords", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getLinkHotWordList(@RequestParam Map<String, Object> map) throws Exception{
		return hotWordService.getLinkHotWordList(map);
	}
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/zxcx/singleQeury/infos
	 * 参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午4:23:45
	 * @Title: getMszlHotWordList 
	 * @Description TODO 单点式获取信息列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxcx/singleQeury/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getSingleQueryInfosList(@RequestParam Map<String, String> map) throws Exception{
		return hotWordService.getSingleQuryInfosList(map);
	}
	
	/**
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午4:23:45
	 * @Title: getMszlHotWordList 
	 * @Description TODO 选项式查询-获取关联热词或分类列表接口（关联热词或热词分类）
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/zxcx/optionalQeury
	 * 参数：热词id(hotWordId = 100000252) 、 热词类型type：type=4   、 热词所属栏目typeLevel2：typeLevel2=3
	 * 参数：热词id(hotWordId = 100000247) 、 热词类型type：type=5   、 热词所属栏目typeLevel2：typeLevel2=3
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxcx/optionalQeury", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getOptionalQeuryLinksOrSorts(@RequestParam Map<String, String> map) throws Exception{
		return hotWordService.getOptionalQeuryLinksOrSorts(map);
	}
	
	
	/**
	 * @version 1.1
	 * @author yanggaoli 
	 * @date 2020-4-18 下午4:23:45
	 * @Title: getMszlHotWordList 
	 * @Description TODO 选项式查询根据热词id获取信息列表
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/zxcx/optionalQeury/infos
	 * 参数：热词id(hotWordId = 1000000160) 、 热词类型type：type=4   、 检索关键字keyword：
	 * 参数：热词id(hotWordId = 100000264) 、 热词类型type：type=5   、 检索关键字keyword：
	 * @return
	 * @throws Exception 1000000160
	 */
	@RequestMapping(value = "/zxcx/optionalQeury/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getOptionalQeuryInfosList(@RequestParam Map<String, String> map) throws Exception{
		return hotWordService.getOptionalQeuryInfosList(map);
	}
	
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/hotWord/zxcx/info/{11526569}
	 * 		参数：contentId（知识信息ID）
	 * @Description	查询信息详情
	 * @author yanggaoli
	 * @date 2020年3月11日下午5:56:58
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/zxcx/info/{infoId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getInfoById(@PathVariable String infoId)  throws Exception{
		return hotWordService.getInfoById(infoId);
	}
	
	
	
	/**
	 * @version 1.2
	 * @author yanggaoli 
	 * @date 2020-6-17 下午4:23:45
	 * @Title: getMszlHotWordList 
	 * @Description TODO 选项式查询-获取信息列表接口（关联热词或热词分类）
	 * http://127.0.0.1:8080/knowledge_mobile_api/hotWord/zxcx/questionAnswerQuery
	 * 参数：热词id(hotWordId = 100000252) 、 热词类型type：type=4   、 热词所属栏目typeLevel2：typeLevel2=3
	 * 参数：热词id(hotWordId = 100000247) 、 热词类型type：type=5   、 热词所属栏目typeLevel2：typeLevel2=3
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxcx/questionAnswerQuery", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getQquestionAnswerQuery(@RequestParam Map<String, String> map) throws Exception{
		
		return hotWordService.getHotWordLinksOrSorts(map);
	}
	
	
	/**
	 * @version 1.2
	 * @author yanggaoli 
	 * @date 2020-6-17 下午21:15:49
	 * @Title: getMszlHotWordList 
	 * @Description TODO 选项式查询-获取信息列表接口（关联热词或热词分类）
	 * http://127.0.0.1:8080/knowledge_mobile_api/hotWord/zxcx/questionAnswerQuery/infos
	 * 参数：热词id(hotWordId = 100000252) 、 热词类型type：type=4   、 热词所属栏目typeLevel2：typeLevel2=3
	 * 参数：热词id(hotWordId = 100000247) 、 热词类型type：type=5   、 热词所属栏目typeLevel2：typeLevel2=3
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxcx/questionAnswerQuery/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getQquestionAnswerInfos(@RequestParam Map<String, String> map ) throws Exception{
		return hotWordService.getQuestionAnswerInfos(map);
	}
}
