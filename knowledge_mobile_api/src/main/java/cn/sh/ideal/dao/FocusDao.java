package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.sh.ideal.bean.FocusContentInfo;
import cn.sh.ideal.bean.FocusInfo;

@Repository
public interface FocusDao {
	public List<FocusInfo> queryAll();
	public List<FocusContentInfo> getInfos(Map map);
	public List<FocusContentInfo> getColumnInfos(Map map);
}
