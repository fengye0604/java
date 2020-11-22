package cn.sh.ideal.service;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.PolicyInfo;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.dao.ContentDao;
import cn.sh.ideal.dao.PolicyDao;


@Service(value="policyService")
public class PolicyService {
	public static Logger logger = Logger.getLogger(PolicyService.class);
	
	@Resource
	public ContentDao contentDao;
	
	@Resource
	public PolicyDao policyDao;
	
	@MyAnnotation(flag = true, 
			value = "PolicyService的getLatestInfos查询最新的三条新政新规信息")
	public ResultBean getLatestInfos() throws Exception{
		
		List<PolicyInfo> policyInfos = policyDao.getLatestInfos();
		return ResultBean.ok(policyInfos);
	}
	
	@MyAnnotation(flag = true, 
			value = "PolicyService的getInfosByWhere根据条件查询新政新规信息")
	public ResultBean getInfosByWhere(Map<String,String> map) throws Exception{
		String year = map.get("year");
		String month = map.get("month");
		String keyword = map.get("keyword");   //关键字
		logger.info("year= "+year); 
		logger.info("month= "+month);
		logger.info("keyword= "+keyword);
		
		List<PolicyInfo> policyInfos = policyDao.getInfosByWhere(map);
		return ResultBean.ok(policyInfos);
	}

	
	
	
}
