package cn.sh.ideal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sh.ideal.bean.ColumnInfo;
import cn.sh.ideal.bean.ContentFile;
import cn.sh.ideal.bean.ContentInfo;
import cn.sh.ideal.bean.QuestionAnswerInfo;

@Repository
public interface ContentDao {
	public ContentInfo getContentInfo(String contentId);
	public List<ContentFile> getContentFileByContentId(String contentId);
	
	public List<QuestionAnswerInfo> getQuestionAnswerInfo(Map map);
	
	public Map<String,Object> getContentInfoTemplateType(String contentId);
	
	public List<QuestionAnswerInfo> getQuestionAnswerInfos(Map map);
	
	public QuestionAnswerInfo getQuestionAnswerInfoById(String questionAnswerInfoId);

	public List<ContentInfo> hotRankTop10();
	
	
}
