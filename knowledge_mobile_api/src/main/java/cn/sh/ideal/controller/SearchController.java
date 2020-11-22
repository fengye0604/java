package cn.sh.ideal.controller;

import java.util.Map;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.service.SearchService;
import cn.sh.ideal.pojo.SearchVO;

/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/search")
public class SearchController {
	
	public static Logger logger = LoggerFactory.getLogger(HotWordController.class);
	
	@Autowired
	SearchService searchService;

	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/search/infos
	 * @version 5.19版本新增  
	 * @author yanggaoli 
	 * @date 2020-8-17 下午2:29:17
	 * @Title: searchInfo 
	 * @Description TODO 
	 * @param searchVO
	 * 		参数：	1、检索关键字；2、检索信息的类型(1、问答；3、政策；0、其他)
	 * @return
	 */
	@RequestMapping(value = "/infos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean searchInfo(@Valid SearchVO searchVO){
		
		return searchService.searchInfos(searchVO);
	}
	
	
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/search/info/{infoId}
	 * @version 5.19版本新增  
	 * @author yanggaoli 
	 * @date 2020-8-17 下午2:30:53
	 * @Title: getInfoTemplateTypeById 
	 * @Description TODO 根据知识信息的id查询信息使用的模板类型
	 * @param infoId	知识信息id			
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/info/{infoId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getInfoTemplateTypeById(@PathVariable String infoId)  throws Exception{
		return searchService.getInfoTemplateTypeById(infoId);
	}
	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/search/questionAnswer/infos
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2020-8-17 下午2:32:20
	 * @Title: getInfoTemplateTypeById 
	 * @Description TODO 根据知识信息的主键查找该信息关联的集锦信息列表
	 * @param map
	 * 		
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionAnswer/infos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getQuestionAnswerInfos(@RequestParam Map<String, String> map)  throws Exception{
		return searchService.getQuestionAnswerInfos(map);
	}
	
	/**
	 * 
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2020-8-17 下午2:32:20
	 * @Title: getInfoTemplateTypeById 
	 * @Description TODO 根据知识信息的主键查找该信息关联的集锦信息列表
	 * @param map
	 * 		
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/questionAnswer/info/{questionAnswerInfoId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getQuestionAnswerInfos(@PathVariable String questionAnswerInfoId)  throws Exception{
		return searchService.getQuestionAnswerInfoById(questionAnswerInfoId);
	}

	/**
	 *
	 * @version 1.0
	 * @author yanggaoli
	 * @date 2020-8-17 下午2:32:20
	 * @Title: getInfoTemplateTypeById
	 * @Description TODO 热搜前十点击量排行信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hotRankTop10/infos", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean hotRankTop10()  throws Exception{
		return searchService.hotRankTop10();
	}
}
