package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.sh.ideal.bean.FocusContentInfo;
import cn.sh.ideal.bean.FocusInfo;
import cn.sh.ideal.bean.HotWord;
import cn.sh.ideal.bean.HotWordLinkInfo;

@Repository
public interface HotWordLinkInfoDao {
	public List<HotWordLinkInfo> queryHotWordLinkInfoListByMap(Map map);
}
