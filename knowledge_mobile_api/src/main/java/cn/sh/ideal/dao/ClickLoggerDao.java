package cn.sh.ideal.dao;



import org.springframework.stereotype.Repository;

import cn.sh.ideal.entity.FocusClick;
import cn.sh.ideal.entity.HotWordClick;
import cn.sh.ideal.entity.KeywordRecord;
import cn.sh.ideal.entity.PolicyClick;
import cn.sh.ideal.entity.SearchClick;




@Repository
public interface ClickLoggerDao {
	public int addHotWordClick(HotWordClick hotWordClick);
	public int addPolicyClick(PolicyClick policyClick);
	public int addFocusClick(FocusClick focusClick);
	public int addSearchClick(SearchClick searchClick);
	public int addSearchKeywordRecord(KeywordRecord keywordRecord);
}
