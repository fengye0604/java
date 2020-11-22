package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sh.ideal.bean.ColumnInfo;
import cn.sh.ideal.bean.ContentInfo;
import cn.sh.ideal.bean.FocusColumnContent;
import cn.sh.ideal.bean.FocusInfo;

@Repository
public interface ColumnDao {
	public List<ColumnInfo> getColumnByFocusId(String focusId);
	public List<ColumnInfo> getColumnByColumnId(String columnId);
	public FocusColumnContent getColumnRichTextInfo(String columnId);
	
}
