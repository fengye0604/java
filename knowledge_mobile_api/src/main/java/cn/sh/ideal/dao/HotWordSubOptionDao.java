package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.sh.ideal.bean.FocusContentInfo;
import cn.sh.ideal.bean.FocusInfo;
import cn.sh.ideal.bean.HotWord;
import cn.sh.ideal.bean.HotWordLinkInfo;
import cn.sh.ideal.bean.HotWordSubOption;

@Repository
public interface HotWordSubOptionDao {
	public List<HotWordSubOption> queryLinkHotWordByMap(Map<String, Object> paramMap);
	public List<HotWordSubOption> queryHotWordSortsByMap(Map<String, Object> paramMap);
	
	
}
