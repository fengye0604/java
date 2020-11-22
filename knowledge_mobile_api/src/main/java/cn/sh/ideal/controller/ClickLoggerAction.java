package cn.sh.ideal.controller;

import javax.annotation.Resource;
import javax.validation.Valid;


import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.exception.MyException;
import cn.sh.ideal.pojo.FocusClickVO;
import cn.sh.ideal.pojo.HotWordClickVO;
import cn.sh.ideal.pojo.PolicyClickVO;
import cn.sh.ideal.pojo.SearchClickVO;
import cn.sh.ideal.service.ClickLoggerService;

/**
 * 
 * @Description	点点通日志记录
 * @author yanggaoli
 * @date 2020年6月14日下午5:55:05
 */

@CrossOrigin(origins = "*", maxAge = 3600)
/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */

@RestController
@RequestMapping(value = "/click")
public class ClickLoggerAction {
	
	@Resource
	ClickLoggerService clickLoggerService;
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/click/hotWord
	 * 		参数：HotWordClickVO
	 * @Description	热词点击量
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/hotWord", method = RequestMethod.POST)
	@ResponseBody
	//public ResultBean hotwordClick(@RequestParam Map<String,String> map)  throws Exception{
	//public ResultBean hotWordClick(@Valid @RequestBody HotWordClickVO hotWordClick)  throws Exception{
	public ResultBean hotWordClick(@Valid HotWordClickVO hotWordClick)  throws Exception{
		return clickLoggerService.addHotWordClick(hotWordClick);
	}
	
	
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/infos/{11526569}
	 * 		参数：contentId（知识信息ID）
	 * @Description	新政速递点击量
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:56:58
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/policy", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean policyClick(@Valid PolicyClickVO policyClickVO)  throws Exception{
		
		return clickLoggerService.addPolicyClick(policyClickVO);
	}
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/infos/{11526569}
	 * 		参数：contentId（知识信息ID）
	 * @Description	热点专题点击量
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:56:58
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/focus", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean focusClick(@Valid FocusClickVO focusClickVO)  throws Exception{
		return clickLoggerService.addFocusClick(focusClickVO);
	}
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/policy/infos/{11526569}
	 * 		参数：contentId（知识信息ID）
	 * @Description	热点专题点击量
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:56:58
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean searchClick(@Valid SearchClickVO searchClickVO,BindingResult bindingResult)  throws Exception{
		StringBuffer errorSb = new StringBuffer();
		
		if("0".equals(searchClickVO.getClickType())&&StringUtils.isBlank(searchClickVO.getPageId())){
			errorSb.append("当clickType为0是PageId不能为空！;");
		}
		if("1".equals(searchClickVO.getClickType())&&StringUtils.isBlank(searchClickVO.getInfoId())){
				errorSb.append("当clickType为1是infoId不能为空！;");
		}
		if("2".equals(searchClickVO.getClickType())){
			if(StringUtils.isBlank(searchClickVO.getQsInfoId())){
				errorSb.append("当clickType为2是qsInfoId不能为空！;");
			}
			if(StringUtils.isBlank(searchClickVO.getInfoId())){
				errorSb.append("当clickType为2是infoId不能为空！;");
			}
		}
		if(errorSb.length()>0){
			bindingResult.addError(new FieldError("searchClickVO","clickType",errorSb.toString()));
		}
		if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }
		return clickLoggerService.addSearchClick(searchClickVO);
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean testClick(@Valid SearchClickVO searchClickVO)  throws Exception{
//	public ResultBean searchClick(@Valid SearchClickVO searchClickVO)  throws Exception{
		if("0".equals(searchClickVO.getClickType())&&StringUtils.isBlank(searchClickVO.getPageId())){
			throw new MyException("当clickType为0是PageId不能为空！");
		}
		if("1".equals(searchClickVO.getClickType())&&StringUtils.isBlank(searchClickVO.getInfoId())){
			throw new MyException("当clickType为1是infoId不能为空！");
		}
		if("2".equals(searchClickVO.getClickType())&&StringUtils.isBlank(searchClickVO.getQsInfoId())){
			throw new MyException("当clickType为2是qsInfoId不能为空！");
		}
		/*
		Map<String, Object> model = bindingResult.getModel();
		for (String key : model.keySet()) {
			
		}
		FieldError fieldError1 = new FieldError(SearchClickVO.class.getName(), "2222 ", "3333");
		if(fieldError1!= null ){
			//bindingResult.addError(fieldError1);
			
		}
		*/
		/*
		if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField());
            }
//            throw new BindException(bindingResult);
              throw new MyException("自定义异常");
        }
        */
		/**/
//		return clickLoggerService.addSearchClick(searchClickVO);
		ResultBean resultBean = new ResultBean();
		resultBean.setData("成功！！");
		return resultBean;
	}
}
