package cn.sh.ideal.dao;


import cn.sh.ideal.entity.*;
import org.springframework.stereotype.Repository;


@Repository
public interface EvaluateDao {
	public int addHotWordEvaluate(HotWordEvaluate hotWordEvaluate);
	public int addPolicyEvaluate(PolicyEvaluate policyEvaluate);
	public int addFocusEvaluate(FocusEvaluate focusEvaluate);
	public int addSearchEvaluate(SearchEvaluate searchEvaluate);
}
