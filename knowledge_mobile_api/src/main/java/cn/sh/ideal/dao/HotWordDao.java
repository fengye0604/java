package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sh.ideal.bean.HotWord;
@Repository
public interface HotWordDao {
	public List<HotWord> queryHotWordListByMap(Map map);
	public List<HotWord> queryLinkHotWordByMap(Map<String, Object> paramMap);
	
	
}
