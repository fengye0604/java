package cn.sh.ideal.service;




import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import cn.sh.ideal.dao.ClickLoggerDao;
import cn.sh.ideal.pojo.FocusClickVO;
import cn.sh.ideal.pojo.HotWordClickVO;
import cn.sh.ideal.pojo.PolicyClickVO;
import cn.sh.ideal.pojo.SearchClickVO;
import cn.sh.ideal.entity.FocusClick;
import cn.sh.ideal.entity.HotWordClick;
import cn.sh.ideal.entity.PolicyClick;
import cn.sh.ideal.entity.SearchClick;
import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ResultBean;



@Service(value="clickLoggerService")
public class ClickLoggerService{
	public static Logger logger = LoggerFactory.getLogger(ClickLoggerService.class);
	@Resource
	public ClickLoggerDao clickLoggerDao;
	
	
	@MyAnnotation(flag = true, 
			value = "ClickLoggerService的addHotWordClick【添加热词点击量】")
	public ResultBean addHotWordClick(HotWordClickVO hotWordClickVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		HotWordClick hotWordClickParm = new HotWordClick();
		
		//数据转换
		BeanUtils.copyProperties(hotWordClickVO, hotWordClickParm);
		
		hotWordClickParm.setQuestionAnswerId(hotWordClickVO.getQsInfoId());
		hotWordClickParm.setHotSortId(hotWordClickVO.getOptionId());
		hotWordClickParm.setHotSortType(hotWordClickVO.getOptionType());
		hotWordClickParm.setQuestionAnswerId(hotWordClickVO.getQsInfoId());
		hotWordClickParm.setClickCreater("-1");
		
		int count  = clickLoggerDao.addHotWordClick(hotWordClickParm);
		resultBean.setData(hotWordClickParm);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "ClickLoggerService的addPolicyClick【添加热词点击量】")
	public ResultBean addPolicyClick(PolicyClickVO policyClickVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		PolicyClick policyClick = new PolicyClick();
		
		//数据转换
		BeanUtils.copyProperties(policyClickVO, policyClick);
		
		policyClick.setClickCreater("-1");
		
		int klId  = clickLoggerDao.addPolicyClick(policyClick);
		resultBean.setData(policyClick);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "ClickLoggerService的addFocusClick【添加热词点击量】")
	public ResultBean addFocusClick(FocusClickVO focusClickVO) throws Exception{
		ResultBean resultBean = new ResultBean();
		FocusClick focusClick = new FocusClick();
		
		//数据转换
		BeanUtils.copyProperties(focusClickVO, focusClick);
		
		focusClick.setFocusId(focusClickVO.getPageId());
		focusClick.setClickCreater("-1");
		
		int klId  = clickLoggerDao.addFocusClick(focusClick);
		resultBean.setData(focusClick);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "ClickLoggerService的addSearchClick【添加搜索点击量】")
	public ResultBean addSearchClick(SearchClickVO searchClickVO) {
		
		ResultBean resultBean = new ResultBean();
		SearchClick searchClick = new SearchClick();
		
		//数据转换
		BeanUtils.copyProperties(searchClickVO, searchClick);
		searchClick.setClickCreater("-1");
		
		int klId  = clickLoggerDao.addSearchClick(searchClick);
		resultBean.setData(searchClick);
		
		return resultBean;
	}
	
}
