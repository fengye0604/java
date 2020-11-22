package cn.sh.ideal.controller;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.exception.MyException;
import cn.sh.ideal.pojo.*;

import cn.sh.ideal.service.EvaluateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 
 * @Description	点点通好差评评价表
 * @author yanggaoli
 * @date 2020年6月14日下午5:55:05
 */

@CrossOrigin(origins = "*", maxAge = 3600)
/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */

@RestController
@RequestMapping(value = "/evaluate")
public class EvaluateAction {
	
	@Resource
	EvaluateService evaluateService;
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/evaluate/hotWord
	 * 		参数：HotWordEvaluateVO
	 * @Description	热词栏目信息评价
	 * @author yanggaoli
	 * @date 2020年6月14日下午5:55:52
	 * @param map
	 * 			year（年份）、month（月份）、keyword（关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/hotWord", method = RequestMethod.POST)
	@ResponseBody
	//public ResultBean hotwordEvaluate(@RequestParam Map<String,String> map)  throws Exception{
	//public ResultBean hotWordEvaluate(@Valid @RequestBody HotWordEvaluateVO hotWordEvaluate)  throws Exception{
	public ResultBean hotWordEvaluate(@Valid HotWordEvaluateVO hotWordEvaluate)  throws Exception{
		return evaluateService.addHotWordEvaluate(hotWordEvaluate);
	}
	
	
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/evaluate/policy
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
	public ResultBean policyEvaluate(@Valid PolicyEvaluateVO policyEvaluateVO)  throws Exception{
		
		return evaluateService.addPolicyEvaluate(policyEvaluateVO);
	}
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/evaluate/focus
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
	public ResultBean focusEvaluate(@Valid FocusEvaluateVO focusEvaluateVO)  throws Exception{
		return evaluateService.addFocusEvaluate(focusEvaluateVO);
	}
	
	/**
	 * http://127.0.0.1:8080/knowledge_mobile_api/evaluate/search
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
	public ResultBean searchEvaluate(@Valid SearchEvaluateVO searchEvaluateVO,BindingResult bindingResult)  throws Exception{
		StringBuffer errorSb = new StringBuffer();
		/*
		if("0".equals(searchEvaluateVO.getEvaluateType())&&StringUtils.isBlank(searchEvaluateVO.getPageId())){
			errorSb.append("当clickType为0是PageId不能为空！;");
		}
		if("1".equals(searchEvaluateVO.getEvaluateType())&&StringUtils.isBlank(searchEvaluateVO.getInfoId())){
				errorSb.append("当clickType为1是infoId不能为空！;");
		}
		*/
		if("2".equals(searchEvaluateVO.getEvaluateType())){
			if(StringUtils.isBlank(searchEvaluateVO.getQsInfoId())){
				errorSb.append("当clickType为2是qsInfoId不能为空！;");
			}
			if(StringUtils.isBlank(searchEvaluateVO.getInfoId())){
				errorSb.append("当clickType为2是infoId不能为空！;");
			}
		}
		if(errorSb.length()>0){
			bindingResult.addError(new FieldError("searchEvaluateVO","clickType",errorSb.toString()));
		}
		if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }
		return evaluateService.addSearchEvaluate(searchEvaluateVO);
	}
	/*
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean testEvaluate(@Valid SearchEvaluateVO searchEvaluateVO)  throws Exception{
//	public ResultBean searchEvaluate(@Valid SearchEvaluateVO searchEvaluateVO)  throws Exception{
		if("0".equals(searchEvaluateVO.getEvaluateType())&&StringUtils.isBlank(searchEvaluateVO.getPageId())){
			throw new MyException("当clickType为0是PageId不能为空！");
		}
		if("1".equals(searchEvaluateVO.getEvaluateType())&&StringUtils.isBlank(searchEvaluateVO.getInfoId())){
			throw new MyException("当clickType为1是infoId不能为空！");
		}
		if("2".equals(searchEvaluateVO.getEvaluateType())&&StringUtils.isBlank(searchEvaluateVO.getQsInfoId())){
			throw new MyException("当clickType为2是qsInfoId不能为空！");
		}
		/*
		Map<String, Object> model = bindingResult.getModel();
		for (String key : model.keySet()) {
			
		}
		FieldError fieldError1 = new FieldError(SearchEvaluateVO.class.getName(), "2222 ", "3333");
		if(fieldError1!= null ){
			//bindingResult.addError(fieldError1);
			
		}


		if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField());
            }
//            throw new BindException(bindingResult);
              throw new MyException("自定义异常");
        }


		return clickLoggerService.addSearchEvaluate(searchEvaluateVO);
	}
	*/
}
