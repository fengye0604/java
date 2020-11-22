package cn.sh.ideal.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sh.ideal.common.CommProperties;
import cn.sh.ideal.dao.ContentDao;
import cn.sh.ideal.dao.HotWordDao;
import cn.sh.ideal.dao.HotWordLinkInfoDao;
import cn.sh.ideal.dao.HotWordSubOptionDao;
import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ContentFile;
import cn.sh.ideal.bean.ContentInfo;
import cn.sh.ideal.bean.HotWord;
import cn.sh.ideal.bean.HotWordLinkInfo;
import cn.sh.ideal.bean.HotWordSubOption;
import cn.sh.ideal.bean.QuestionAnswerInfo;
import cn.sh.ideal.bean.ResultBean;



@Service(value="hotWordService")
public class HotWordService{
	public static Logger logger = LoggerFactory.getLogger(HotWordService.class);
	@Resource
	public HotWordDao hotWordDao;
	@Resource
	public HotWordLinkInfoDao hotWordLinkInfoDao;
	@Resource
	public HotWordSubOptionDao hotWordSubOptionDao;
	@Resource
	public ContentDao contentDao;
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getZxcxHotWordList【查询所有选项式查询的热词】")
	public ResultBean getZxcxHotWordList() throws Exception{
		//设置参数
		ResultBean resultBean = new ResultBean();
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typeLevel1", "zxcx");
		//查询数据
//		PageHelper.startPage(1, 5);
		List<HotWord> hotWords = hotWordDao.queryHotWordListByMap(paramMap);
//		分页
//		PageInfo<HotWord> pageInfo = new PageInfo<HotWord>(hotWords);
//		hotWords = pageInfo.getList();
		
		//封装数据
		resultBean.setData(hotWords);
		return resultBean;
	}
	@MyAnnotation(flag = true, 
			value = "HotWordService的getMszlHotWordList【查询所有民生专栏的热词】")
	public ResultBean getMszlHotWordList() throws Exception{
		//设置参数
		ResultBean resultBean = new ResultBean();
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typeLevel1", "mszl");
		//查询数据
		List<HotWord> hotWords = hotWordDao.queryHotWordListByMap(paramMap);
		//封装数据
		resultBean.setData(hotWords);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getSingleQuryInfosList【单点式查询，查询热次及热词分类关联的知识信息】")
	public ResultBean getSingleQuryInfosList(Map<String, String> map) throws Exception{
		ResultBean resultBean = new ResultBean();
		//设置参数
		
//		参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
		String hotWordId = map.get("hotWordId");
		String type = map.get("type");
		String typeLevel2 = map.get("typeLevel2");
		logger.info("执行的方法{},参数列表，hotWordId=【{}】、type=【{}】、typeLevel2=【{}】",
				"getSingleQuryContentInfoList",hotWordId,type,typeLevel2);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hotWordId", hotWordId);
		paramMap.put("hotWordSortId", "0");
		//查询数据
		List<HotWordLinkInfo> hotWordLinkInfos = hotWordLinkInfoDao.queryHotWordLinkInfoListByMap(paramMap);
		//封装数据
		resultBean.setData(hotWordLinkInfos);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getOptionalQeuryLinksOrSorts【选项式查询，根据热词的类型查询关联热词或热词分类】")
	public ResultBean getOptionalQeuryLinksOrSorts(Map<String, String> map) throws Exception{
		ResultBean resultBean = new ResultBean();
		//设置参数
		
//		参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
		String hotWordId = map.get("hotWordId");	//热词Id
		String type = map.get("type");				//查询类型（4：热词分类，5：关联热词）
		String typeLevel2 = map.get("typeLevel2");
		logger.info("执行的方法{},参数列表，hotWordId=【{}】、type=【{}】、typeLevel2=【{}】",
				"getSingleQuryContentInfoList",hotWordId,type,typeLevel2);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hotWordId", hotWordId);
		//设置返回值
		List<HotWordSubOption> hotWordSubOptions = null;
		//查询数据
		if("4".equals(type)){
			//查询分类
			hotWordSubOptions = hotWordSubOptionDao.queryHotWordSortsByMap(paramMap);
		}else if("5".equals(type)){
			//查询关联热词
			hotWordSubOptions = hotWordSubOptionDao.queryLinkHotWordByMap(paramMap);
		}
		//封装数据
		resultBean.setData(hotWordSubOptions);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getLinkHotWordList【根据热词的id查询热词关联的热词列表】")
	public ResultBean getLinkHotWordList(Map<String, Object> paramMap) throws Exception{
		ResultBean resultBean = new ResultBean();
		//查询数据
		List<HotWord> hotWords = hotWordDao.queryLinkHotWordByMap(paramMap);
		//封装数据
		resultBean.setData(hotWords);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getOptionalQeuryInfosList【选项式查询，查询关联热词或热词分类下关联的知识信息】")
	public ResultBean getOptionalQeuryInfosList(Map<String, String> map) throws Exception{
		ResultBean resultBean = new ResultBean();
		//设置参数
//		String hotWordId = map.get("hotWordId");	//热词id
		String hotWordId = map.get("hotWordId");	//关联热词或热词分类Id
		String type = map.get("type");				//查询类型（4：热词分类，5：关联热词）
		String optionId = map.get("optionId");
		String keyword = map.get("keyword");		//检索关键字
		logger.info("执行的方法{},参数列表，hotWordId=【{}】、type=【{}】、keyword=【{}】",
				"getOptionalQeuryInfosList",hotWordId,type,keyword);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(keyword)){
			paramMap.put("keyword", keyword);
		}
		
		//设置返回值
		List<HotWordLinkInfo> hotWordLinkInfos = null;
		//查询数据
		if("4".equals(type)){
			//查询分类
			paramMap.put("hotWordId", hotWordId);
			if(StringUtils.isBlank(optionId)){
				optionId = "0";
			}
			paramMap.put("hotWordSortId", optionId);
		}else{
			//查询关联热词
			if(StringUtils.isBlank(optionId)){
				optionId = hotWordId;
			}
			paramMap.put("hotWordId", optionId);
			paramMap.put("hotWordSortId", "0");
		}
		hotWordLinkInfos = hotWordLinkInfoDao.queryHotWordLinkInfoListByMap(paramMap);
		//封装数据
		resultBean.setData(hotWordLinkInfos);
		return resultBean;
	}

	@MyAnnotation(flag = true, 
			value = "HotWordService的getInfoById【查询指定的信息】")
	public ResultBean getInfoById(String contentId)  throws Exception{
		
		//1、查询知识信息
		ResultBean resultBean = new ResultBean();
		ContentInfo contentInfo = contentDao.getContentInfo(contentId);
		contentInfo.setKlContent(contentInfo.getKlContent().replaceAll("src=\"/knowledge/ftpReader.do", "src=\""+CommProperties.getProp("image_url")+"/knowledge/ftpReader.do"));

		//2、查询知识信息关联的附件列表
		List<ContentFile> contentFiles = contentDao.getContentFileByContentId(contentId);
		for (ContentFile contentFile : contentFiles) {
			contentFile.setFileUrl(CommProperties.getProp("file_url")+contentFile.getFileUrl());
		}
		contentInfo.setContentFile(contentFiles);
		resultBean.setData(contentInfo);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getHotWordLinksOrSorts【选项式查询，根据热词的类型查询关联热词或热词分类】")
	public ResultBean getHotWordLinksOrSorts(Map<String, String> map) throws Exception{
		ResultBean resultBean = new ResultBean();
		//设置参数
//		参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
		String hotWordId = map.get("hotWordId");	//热词Id
		String type = map.get("type");				//查询类型（4：热词分类，5：关联热词）
		String typeLevel2 = map.get("typeLevel2");
		logger.info("执行的方法{},参数列表，hotWordId=【{}】、type=【{}】、typeLevel2=【{}】",
				"getSingleQuryContentInfoList",hotWordId,type,typeLevel2);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hotWordId", hotWordId);
		//设置返回值
		List<HotWordSubOption> hotWordSubOptions = null;
		//查询数据
		if("4".equals(type)){
			//查询分类
			hotWordSubOptions = hotWordSubOptionDao.queryHotWordSortsByMap(paramMap);
		}else if("5".equals(type)){
			//查询关联热词
			hotWordSubOptions = hotWordSubOptionDao.queryLinkHotWordByMap(paramMap);
		}
		//封装数据
		resultBean.setData(hotWordSubOptions);
		return resultBean;
	}
	
	
	@MyAnnotation(flag = true, 
			value = "HotWordService的getHotWordLinksOrSorts【查询问答类信息，根据热词的类型查询关联热词或热词分类】")
	public ResultBean getQuestionAnswerInfos(Map<String, String> map) throws Exception{
		ResultBean resultBean = new ResultBean();
		//设置参数
//		参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目optionId：optionId=3
		String hotWordId = map.get("hotWordId");	//热词Id
		String type = map.get("type");				//查询类型（4：热词分类，5：关联热词）
		String optionId = map.get("optionId");
		String keyword = map.get("keyword");
		logger.info("执行的方法{},参数列表，hotWordId=【{}】、type=【{}】、keyword=【{}】,optionId=【{}】",
				"getSingleQuryContentInfoList",hotWordId,type,keyword, optionId);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hotWordId", hotWordId);
		paramMap.put("type", type);
		paramMap.put("keyword", keyword);
		paramMap.put("optionId", optionId);
		//设置返回值
		
		//查询数据
		List<QuestionAnswerInfo> questionAnswerInfos =  contentDao.getQuestionAnswerInfo(paramMap);
		for (QuestionAnswerInfo questionAnswerInfo : questionAnswerInfos) {
			questionAnswerInfo.setAnswerInfo(questionAnswerInfo.getAnswerInfo().replaceAll("src=\"/knowledge/ftpReader.do", "src=\""+CommProperties.getProp("image_url")+"/knowledge/ftpReader.do"));
		}
		//封装数据
		resultBean.setData(questionAnswerInfos);
		return resultBean;
	}
}
