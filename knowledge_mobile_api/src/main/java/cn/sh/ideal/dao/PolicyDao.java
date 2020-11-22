package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.sh.ideal.bean.FocusContentInfo;
import cn.sh.ideal.bean.FocusInfo;
import cn.sh.ideal.bean.PolicyInfo;

@Repository
public interface PolicyDao {

	List<PolicyInfo> getLatestInfos();
	List<PolicyInfo> getInfosByWhere(Map<String,String> map);
	

	
	
}
