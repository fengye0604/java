package cn.sh.ideal.service;


import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.dao.EvaluateDao;
import cn.sh.ideal.entity.FocusEvaluate;
import cn.sh.ideal.entity.HotWordEvaluate;
import cn.sh.ideal.entity.PolicyEvaluate;
import cn.sh.ideal.entity.SearchEvaluate;
import cn.sh.ideal.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value="evaluateService")
public class EvaluateService {
	public static Logger logger = LoggerFactory.getLogger(EvaluateService.class);
	@Resource
	public EvaluateDao evaluateDao;
	
	
	@MyAnnotation(flag = true, 
			value = "EvaluateService的addHotWordEvaluate【添加热词评价】")
	public ResultBean addHotWordEvaluate(HotWordEvaluateVO hotWordEvaluateVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		HotWordEvaluate hotWordEvaluateParm = new HotWordEvaluate();
		
		//数据转换
		BeanUtils.copyProperties(hotWordEvaluateVO, hotWordEvaluateParm);
		hotWordEvaluateParm.setEvaluateCreater("-1");
		
		int count  = evaluateDao.addHotWordEvaluate(hotWordEvaluateParm);
		resultBean.setData(hotWordEvaluateParm);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "EvaluateService的addPolicyEvaluate【添加热词评价】")
	public ResultBean addPolicyEvaluate(PolicyEvaluateVO policyEvaluateVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		PolicyEvaluate policyEvaluate = new PolicyEvaluate();
		
		//数据转换
		BeanUtils.copyProperties(policyEvaluateVO, policyEvaluate);
		policyEvaluate.setEvaluateCreater("-1");
		
		int klId  = evaluateDao.addPolicyEvaluate(policyEvaluate);
		resultBean.setData(policyEvaluate);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "EvaluateService的addFocusEvaluate【添加热词评价】")
	public ResultBean addFocusEvaluate(FocusEvaluateVO focusEvaluateVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		FocusEvaluate focusEvaluate = new FocusEvaluate();
		
		//数据转换
		BeanUtils.copyProperties(focusEvaluateVO, focusEvaluate);
		focusEvaluate.setEvaluateCreater("-1");
		
		int klId  = evaluateDao.addFocusEvaluate(focusEvaluate);
		resultBean.setData(focusEvaluate);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "EvaluateService的addSearchEvaluate【添加搜索评价】")
	public ResultBean addSearchEvaluate(SearchEvaluateVO searchEvaluateVO) {
		
		ResultBean resultBean = new ResultBean();
		SearchEvaluate searchEvaluate = new SearchEvaluate();
		
		//数据转换
		BeanUtils.copyProperties(searchEvaluateVO, searchEvaluate);
		searchEvaluate.setEvaluateCreater("-1");
		
		int klId  = evaluateDao.addSearchEvaluate(searchEvaluate);
		resultBean.setData(searchEvaluate);
		return resultBean;
	}
	
}
