package cn.sh.ideal.service;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.sh.ideal.bean.ContentInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.QuestionAnswerInfo;
import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.common.CommProperties;
import cn.sh.ideal.dao.ClickLoggerDao;
import cn.sh.ideal.dao.ContentDao;
import cn.sh.ideal.entity.KeywordRecord;


import cn.sh.ideal.pojo.SearchVO;
import cn.sh.ideal.util.DateUtil;


import com.trs.client.TRSConnection;
import com.trs.client.TRSConstant;
import com.trs.client.TRSResultSet;

@Service(value="searchService")
public class SearchService {
	public static Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	@Resource
	public ContentDao contentDao;
	@Resource
	public ClickLoggerDao clickLoggerDao;
	
	@MyAnnotation(flag = true, 
			value = "SearchService的searchInfos【trs查询信息】")
	public ResultBean searchInfos(SearchVO searchVO) {
		ResultBean resultBean = new ResultBean();
		
		String sPort = "8888";
		String sUserName = "system";
		String sPassWord = "manager";
		String sHost = "172.16.1.89";
		
		sHost = CommProperties.getProp("sHost");
		sPort = CommProperties.getProp("sPort");
		sUserName = CommProperties.getProp("sUserName");
		sPassWord = CommProperties.getProp("sPassWord");
		/**/
		try {
			searchVO.setKeyword(new String(searchVO.getKeyword().getBytes("iso8859-1"), "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> resultData = new HashMap<String, Object>();
		resultData.put("trsConnectArguments", "系统获取主机：["+sHost+"]  端口：["+sPort+"]  用户名：["+sUserName+"]  密码："+sPassWord);
		TRSConnection trsCon = null;
		TRSResultSet trsRs = null;
		try {
			//设置查询条件
			StringBuffer queryWhere = new StringBuffer(100);
			queryWhere = setQueryWhere(searchVO);
			logger.info("检索条件【{}】",queryWhere.toString());
			
			String queryWhereSearch = "";
//			queryWhereSearch = "KL_CONTENT_STATUS=(1 or 0) AND KL_CONTENT_VALIDITYTIME>2020.06.19 20:06:01 AND KL_CONTENT_PUBLISHTIME<2020.06.19 20:06:01 AND (KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=LIKE(驾驶证) OR KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=LIKE(驾照) OR KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=LIKE(驾驶执照) OR KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=(驾驶证) OR KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=(驾照) OR KL_CONTENT_TITLE/1000,KL_CONTENT/100,KL_CONTENT_KEYWORD/500,KL_CONTENT_ADDEDKEYWORD/500+=(驾驶执照) OR ( (KL_CONTENT_TITLE/1000 LIKE[驾驶证] OR KL_CONTENT/100 LIKE[驾驶证] OR KL_CONTENT_KEYWORD/500 LIKE[驾驶证] OR KL_CONTENT_ADDEDKEYWORD/500 LIKE[驾驶证]) ) OR ( (KL_CONTENT_TITLE/1000 =LIKE(驾驶证) OR KL_CONTENT/100 =LIKE(驾驶证) OR KL_CONTENT_KEYWORD/500 =LIKE(驾驶证) OR KL_CONTENT_ADDEDKEYWORD/500 =LIKE(驾驶证)) ))";
			queryWhereSearch = queryWhere.toString();
			resultData.put("searchKeyword", queryWhereSearch);
			
			
			//设置排序，可以不要；
			String sortColumn = "-KL_CONTENT_CREATETIME,-COUNTS";
			
			
			trsCon = new TRSConnection();
			boolean connect = trsCon.connect(sHost, sPort, sUserName, sPassWord, "T10");
			logger.info("是否连接成功={}",connect);
			
			logger.info("trs检索信息");
			//现网环境
			trsRs = trsCon.executeSelect("KL_CONTENT_INFO2", queryWhereSearch, sortColumn,"", "KL_CONTENT", 0, TRSConstant.TCE_OFFSET, false);
			//测试环境
//			trsRs = trsCon.executeSelect("KL_CONTENT_INFO3", queryWhereSearch, sortColumn,"", "KL_CONTENT", 0, TRSConstant.TCE_OFFSET, false);
			
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();

			//将结果封装返还给前台
			int totalSize = (int) trsRs.getRecordCount();
			resultData.put("totalSize", totalSize);
			
			int pageSize = searchVO.getPageSize() == 0 ? 5: searchVO.getPageSize();
			int pageCount = (totalSize + pageSize - 1) / pageSize;
			int currentPage =  searchVO.getCurrentPage();
				currentPage = currentPage == 0 ? 1:currentPage;
			trsRs.setPageSize(pageSize);
			trsRs.setPage(currentPage);
			
			logger.info("共检索到信息{}条，每页显示{}条，共计{}页，当前显示第{}页",totalSize,pageSize,pageCount,currentPage);
			resultData.put("pageSize", pageSize);
			resultData.put("pageCount", pageCount);
			resultData.put("currentPage", currentPage);
			
			if (totalSize > 0) {
				Map<String, String> content;
				for (int i = 0; i < pageSize; i++) {
					content = new HashMap<String, String>();
					// 设置具体字段, 提高效率
					trsRs.setReadOptions("KL_ID;KL_CONTENT_KEYWORD;KL_CONTENT_TITLE;KL_CONTENT;COUNTS;KL_CONTENT_CREATETIME;KL_CONTENT_DEPTNAME;KL_CONTENT_ISHOT",
							 "KL_CONTENT_KEYWORD;KL_CONTENT_TITLE;KL_CONTENT;COUNTS;KL_CONTENT_CREATETIME;KL_CONTENT_UPDATETIME;KL_CONTENT_DEPTNAME;KL_CONTENT_ISHOT", ";", TRSConstant.TCE_OFFSET, 0);
					
					content.put("klId", trsRs.getString("KL_ID"));													/** 主键      */
					content.put("klContentTitle", trsRs.getString("KL_CONTENT_TITLE"));								/** 标题      */
					content.put("dept", trsRs.getString("KL_CONTENT_DEPTNAME"));									/** 上传部门  */
					content.put("createTime", trsRs.getString("KL_CONTENT_CREATETIME"));
					content.put("updateTime", trsRs.getString("KL_CONTENT_UPDATETIME"));
//					content.put("KlContentKeyword", trsRs.getString("KL_CONTENT_KEYWORD"));
					
//					content.put("KlContentKeyword", trsRs.getString("KL_CONTENT_KEYWORD", "red"));
//					content.put("KlContentTitleNoHighlight", trsRs.getString("KL_CONTENT_TITLE"));					/** 标题      */
//					content.put("KlContentKeyword", trsRs.getString("KL_CONTENT_KEYWORD", "red"));					/** 关键词 */
					
//					content.put("klContentAddedKeyword", trsRs.getString("KL_CONTENT_ADDEDKEYWORD", "red"));		/** 附加关键词 */
//					content.put("KlContentTitle", trsRs.getStringWithCutsize("KL_CONTENT_TITLE", 150, "red"));		/** 标题      */
//					content.put("KlContentTitleNoHighlight", trsRs.getString("KL_CONTENT_TITLE"));					/** 标题      */
//					content.put("KlContent",trsRs.getStringWithCutsize("KL_CONTENT", 80, "red"));					/** 内容      */
//					content.put("count", trsRs.getString("COUNTS"));												/** 点击量  */
//					content.put("dept", trsRs.getString("KL_CONTENT_DEPTNAME"));									/** 上传部门  */
//					content.put("uploadTime", trsRs.getStringWithCutsize("KL_CONTENT_CREATETIME", 10, "black"));	/** 上传时间 */
//					content.put("updateTime", trsRs.getStringWithCutsize("KL_CONTENT_UPDATETIME", 10, "black"));
//					content.put("isHot", trsRs.getString("KL_CONTENT_ISHOT"));										/** 是否热点 */
//					String createTime = trsRs.getString("KL_CONTENT_CREATETIME");
					
					resultList.add(content);
					if (trsRs.moveNext() == false)
						break;
				}
			}
			resultData.put("contents", resultList);
			
			//插入点击量
			insertKeywordRecord(searchVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			resultData.put("message", e.getMessage());
		}finally{
			if (trsRs != null)
				trsRs.close();
			trsRs = null;
			if (trsCon != null)
				trsCon.close();
			trsCon = null;
		}
		resultBean.setData(resultData);
		return resultBean;
	}
	
	/**
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2020-9-28 上午10:10:37
	 * @Title: insertKeywordRecord 
	 * @Description 记录检索关键字入库
	 * @param searchVO
	 */
	public void insertKeywordRecord(SearchVO searchVO) {
		try {
			if(StringUtils.isNotBlank(searchVO.getKeyword())){
				logger.info("插入检索关键字数据，检索关键字【{}】，平台类型【{}】",searchVO.getKeyword(),searchVO.getPlatform());
				KeywordRecord keywordRecordParam = new KeywordRecord();
				keywordRecordParam.setClickCreater("-1");
				BeanUtils.copyProperties(searchVO, keywordRecordParam);
				clickLoggerDao.addSearchKeywordRecord(keywordRecordParam);
			}
		} catch (Exception e) {
			logger.info("插入检索关键字数据失败，检索关键字【{}】，平台类型【{}】",searchVO.getKeyword(),searchVO.getPlatform());
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2020-9-28 上午10:13:24
	 * @Title: setQueryWhere 
	 * @Description 拼装检索表达式 
	 * @param searchVO
	 * @return
	 */
	public StringBuffer setQueryWhere (SearchVO searchVO){
		StringBuffer queryWhere = new StringBuffer(100);
		String infoType = searchVO.getInfoType();		//信息的类型
		String keyword = searchVO.getKeyword();			//检索关键字
		
		/*固定逻辑字段*/
		logger.info("检索关键字【{}】，信息的类型【{}】",keyword,infoType);
		queryWhere.append("KL_CONTENT_STATUS=1 ")			//信息的状态
//					.append("AND KL_CONTENT_ISPUBLIC = 0")			//信息的状态
					.append(" AND (KL_CONTENT_CREATETIME > 2020.01.01 00:00:00 OR KL_CONTENT_UPDATETIME > 2020.01.01 00:00:00) ")			//
					.append(" AND KL_CONTENT_PUBLISHTIME<").append(DateUtil.dateToCnStr(new GregorianCalendar()))
					.append(" AND KL_CONTENT_VALIDITYTIME>").append(DateUtil.dateToCnStr(new GregorianCalendar()))
					.append(" AND KL_CONTENT_ISPUBLIC = 1 ")
					;
		
		
		
		/*根据参数拼装字段*/
		queryWhere = getTitleSearchWhere(queryWhere, keyword,true);
//		queryWhere = getTitleAndContentSearchWhere(queryWhere, keyword);
		
		//0：政策、1：问答、2：其他
		//当前台传过来的类型为null时，将默认值是改为2
		if(StringUtils.isBlank(infoType)){
			infoType = "2";
		}
		
		if("1".equals(infoType) || "0".equals(infoType)){
			queryWhere.append(" AND KL_CONTENT_TYPE=").append(infoType);
		}else if("2".equals(infoType)){
			//5.19版本要求2时查询不到信息，故将 KL_CONTENT_TYPE = 100
//			queryWhere.append(" AND KL_CONTENT_TYPE = (2 or 3 or 4 or 5)");
			queryWhere.append(" AND KL_CONTENT_TYPE = 100");
		}
		return queryWhere;
	}
	
	//仅标题检索,flag为true时表示多字段检索
	public StringBuffer getTitleSearchWhere(StringBuffer queryWhere, String keyword,boolean flag ) {
		if(StringUtils.isBlank(keyword))
			return queryWhere;
		
		if(flag){
			/*
			keyword = keyword.replaceAll("\\s+", " ").trim();//.replaceAll(" ", "*");
			String[] queryKeywords = keyword.split(" ");
			for (String queryKeyword : queryKeywords) {
				queryWhere.append(" AND KL_CONTENT_TITLE/1000=INCLUDE(").append(queryKeyword).append(")");
			}
			*/
			keyword = keyword.replaceAll("\\s+", " ").trim().replaceAll(" ", "*");
			queryWhere.append(" AND KL_CONTENT_TITLE/1000=(").append(keyword).append(")");
		}else{
			queryWhere.append(" AND KL_CONTENT_TITLE/1000=INCLUDE(").append(keyword).append(")");
		}
		return queryWhere;
	}	
	
	//多个字段精确匹配检索
	public StringBuffer getTitleAndContentSearchWhere(StringBuffer queryWhere, String keyword) {
		if(StringUtils.isNotBlank(keyword)){
			queryWhere.append(" AND KL_CONTENT_TITLE/1000,KL_CONTENT/100+=INCLUDE(").append(keyword).append(")");
		}
		return queryWhere;
	}
	
	
	
	@MyAnnotation(flag = true, 
			value = "SearchService的getInfoTemplateTypeById【查询知识信息的模板类型】")
	public ResultBean getInfoTemplateTypeById(String infoId) {
		logger.info("参数：知识信息id",infoId);
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("isExist", "0");
		data.put("klId", infoId);
		Map<String,Object> result = contentDao.getContentInfoTemplateType(infoId);
		if(result!=null){
			data.put("isExist", "1");
			data.put("templateType",result.get("TEMPLATE_TYPE"));
		}
		return ResultBean.build("0", data);
	}
	
	@MyAnnotation(flag = true, 
			value = "SearchService的getQuestionAnswerInfos【根据知识信息id查询问答类集锦信息】")
	public ResultBean getQuestionAnswerInfos(Map<String,String> paramMap) {
		logger.info("参数：信息的类型【{}】,检索关键字【{}】",paramMap.get("contentId"),paramMap.get("keyword"));
		List<QuestionAnswerInfo> questionAnswerInfos = contentDao.getQuestionAnswerInfos(paramMap);
		return ResultBean.build("0", questionAnswerInfos);
	}
	
	@MyAnnotation(flag = true,
			value = "SearchService的getQuestionAnswerInfoById【根据id查询具体的问答类信息】")
	public ResultBean getQuestionAnswerInfoById(String questionAnswerInfoId) {
		logger.info("参数：问答类信息id【{}】",questionAnswerInfoId);
		QuestionAnswerInfo questionAnswerInfo = contentDao.getQuestionAnswerInfoById(questionAnswerInfoId);
		return ResultBean.build("0", questionAnswerInfo);
	}

	@MyAnnotation(flag = true,
			value = "SearchService的hotRankTop10【查询热搜的前十条信息】")
	public ResultBean hotRankTop10() {
		List<ContentInfo> infos = contentDao.hotRankTop10();
		return ResultBean.build("0", infos);
	}

	
}
