package cn.sh.ideal.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import cn.sh.ideal.dao.ColumnDao;
import cn.sh.ideal.dao.ContentDao;
import cn.sh.ideal.dao.FocusDao;
import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ColumnInfo;
import cn.sh.ideal.bean.ContentFile;
import cn.sh.ideal.bean.ContentInfo;
import cn.sh.ideal.bean.FocusColumnContent;
import cn.sh.ideal.bean.FocusContentInfo;
import cn.sh.ideal.bean.FocusInfo;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.common.CommProperties;


@Service(value="focusService")
public class FocusService{
	public static Logger logger = LoggerFactory.getLogger(FocusService.class);
	@Resource
	public ContentDao contentDao;
	
	@Resource
	public FocusDao focusDao;
	
	@Resource
	public ColumnDao columnDao;
	
	@MyAnnotation(flag = true, 
			value = "FocusService的getFocusList【查询所有的综合栏目】")
	public ResultBean getFocusList() throws Exception{
		ResultBean resultBean = new ResultBean();
		List<FocusInfo> focusInfo = focusDao.queryAll();
		resultBean.setData(focusInfo);
		return resultBean;
	}
	
	@MyAnnotation(flag = true, 
			value = "FocusService的getAllColumn【查询指定专题栏目下的所有栏目】")
	public ResultBean getAllColumn(String focusId) throws Exception{
		ResultBean resultBean = new ResultBean();
		//查询栏目
		List<ColumnInfo> columnInfos = columnDao.getColumnByFocusId(focusId);
		for (ColumnInfo columnInfo : columnInfos) {
			//查询栏目下的子栏目
			List<ColumnInfo> subColumnInfos = columnDao.getColumnByColumnId(columnInfo.getColumnId());
			if(subColumnInfos != null && subColumnInfos.size()>0){
				//查询子栏目下的分类标签
				/*tail -f catalina.out
				for(ColumnInfo subColumnInfo :subColumnInfos){
					List<ColumnInfo> lableColumnInfos = columnDao.getColumnByColumnId(subColumnInfo.getColumnId());
					if(lableColumnInfos != null && lableColumnInfos.size()>0){
						subColumnInfo.setSubColumn(lableColumnInfos);
					}
				}
				*/
				columnInfo.setSubColumn(subColumnInfos);
			}
		}
		resultBean.setData(columnInfos);
		return resultBean;
	}


	@MyAnnotation(flag = true, 
			value = "FocusService的getInfos【在指定专题下根据关键字检索信息】")
	public ResultBean getInfos(Map<String,String> map)  throws Exception{
		String keyword = map.get("keyword");
		try {
			if(StringUtils.isNotBlank(keyword)){
				//keyword = keyword;//new String(keyword.getBytes("iso8859-1"), "utf-8");
				map.put("keyword", keyword);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<FocusContentInfo> data = focusDao.getInfos(map);
		
		return ResultBean.ok(data);
	}

	@MyAnnotation(flag = true, 
			value = "FocusService的getContentInfoById【查询指定的信息】")
	public ResultBean getContentInfoById(String contentId)  throws Exception{
		
		//1、查询知识信息
		ResultBean resultBean = new ResultBean();
		ContentInfo contentInfo = contentDao.getContentInfo(contentId);
		/*
		List<String> imageUrls = CatchImageUtil.getImage(contentInfo.getKlContent());
		for (String imageUrl : imageUrls) {
			logger.info("附件的路径为："+imageUrl);
		}
		logger.info(contentInfo.getKlContent());
		*/
//		contentInfo.setKlContent(contentInfo.getKlContent().replaceAll("src=\"/knowledge/ftpReader.do", "src=\"http://180.166.127.195:18150/knowledge/ftpReader.do"));
		contentInfo.setKlContent(contentInfo.getKlContent().replaceAll("src=\"/knowledge/ftpReader.do", "src=\""+CommProperties.getProp("image_url")+"/knowledge/ftpReader.do"));
		/*
		List<String> imageUrls1 = CatchImageUtil.getImage(contentInfo.getKlContent());
		for (String imageUrl : imageUrls1) {
			logger.info("附件的路径为："+imageUrl);
		}
		*/
		//2、查询知识信息关联的附件列表
		List<ContentFile> contentFiles = contentDao.getContentFileByContentId(contentId);
		for (ContentFile contentFile : contentFiles) {
			contentFile.setFileUrl(CommProperties.getProp("file_url")+contentFile.getFileUrl());
//			contentFile.setFileUrl("http://10.107.16.232:8082/knowledge/ftpReader.do?ftpPath="+contentFile.getFileUrl());
		}
		contentInfo.setContentFile(contentFiles);
//		int cc = 1/0;
		resultBean.setData(contentInfo);
		return resultBean;
	}


	@MyAnnotation(flag = true, 
			value = "FocusService的getSubColumnContent【栏目id查询栏目的信息及标签分类】")
	public ResultBean getSubColumnContent(Map<String, String> map)  throws Exception{
		ResultBean resultBean = new ResultBean();
		//1、参数处理
		String columnType = map.get("columnType");
		String keyword = map.get("keyword");
		/*
		try {
			//中文乱码处理
			keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
		String columnId = map.get("columnId");
		//2、参数判断
		if("0".equals(columnType)){
			//3：返回富文本信息
			FocusColumnContent focusColumnContent =  columnDao.getColumnRichTextInfo(columnId);
			if (focusColumnContent != null) {
				String richText = "";
	               if (StringUtils.isNotBlank(focusColumnContent.getContentWeb())) {
	            	   richText = focusColumnContent.getContentWeb();
	               } else {
	            	   richText = focusColumnContent.getContent();
	               }
	               resultBean.setData(richText); 
	       }
		}else if("1".equals(columnType)){
			Map<String, Object> data = new HashMap<String, Object>();
			//3：返回标签及信息列表
			//3.1：查询标签集合
			List<ColumnInfo> subColumnInfos = columnDao.getColumnByColumnId(columnId);
			if(subColumnInfos != null && subColumnInfos.size()>0){
				data.put("lableColumn", subColumnInfos);
				columnId = subColumnInfos.get(0).getColumnId();
			}
			//3.2：查询信息列表
			Map<String,String> paramMap = new HashMap<String, String>();
			
			paramMap.put("columnId", columnId);
			
//			paramMap.put("keyword", "");
			List<FocusContentInfo> infoList = focusDao.getColumnInfos(paramMap);
			data.put("infoList", infoList);
			resultBean.setData(data);
		}
		
		return resultBean;
	}


	@MyAnnotation(flag = true, 
			value = "FocusService的getColumnsOrLablesInfos【获取栏目或标签下的信息】")
	public ResultBean getColumnsOrLablesInfos(Map<String, String> map)  throws Exception{
		String columnId = map.get("columnId"); //不为空
		String lableId = map.get("lableId");   //可为空
		String keyword = map.get("keyword");   //可为空
		if(StringUtils.isNotBlank(lableId)){
			map.put("columnId", lableId);
		}
		/*
		if(StringUtils.isNotBlank(keyword)){
			try {
			//中文乱码处理
				keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
				map.put("keyword",keyword);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		*/
		map.put("keyword",keyword);
		List<FocusContentInfo> infoList = focusDao.getColumnInfos(map);
		return ResultBean.ok(infoList);
	}
}
