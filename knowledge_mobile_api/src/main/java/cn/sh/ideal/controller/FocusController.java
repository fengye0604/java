package cn.sh.ideal.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.ideal.service.FocusService;
import cn.sh.ideal.bean.ResultBean;
/**
 * origins  ： 允许可访问的域列表
 * maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/focus")
public class FocusController {
	public static Logger logger = Logger.getLogger(FocusController.class);
	
	@Resource
	FocusService focusService;
	
	/**
	 * 访问的url http://127.0.0.1:8090/knowledge_mobile_api/focus/focus
	 * @Description	查询热点专题列表（接口001-2）
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:20:09
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/focus", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getInfoList() throws Exception{
		
		return focusService.getFocusList();
	
	}

	/**
	 * 查询该栏目内的信息接口（009）http://127.0.0.1:8090/knowledge_mobile_api/focus/infos
	 * @Description	在专题下检索信息列表
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:20:49
	 * @param map
	 * 			focusId专题id、keyword关键字检索
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getFocusInfos(@RequestParam Map<String, String> map)  throws Exception{
		return focusService.getInfos(map);
	}

	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/focus/columns/1010094
	 * @Description	查询专题下的栏目查询到两级（接口005）
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:21:30
	 * @param focusId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/columns/{focusId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getAllColumn(@PathVariable String focusId)  throws Exception{
		return focusService.getAllColumn(focusId);
	}

	
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/focus/columns/infos/
	 * 	1011256（富文本栏目） 1011254（栏目）
	 * @Description	该接口获取栏目下的所有标签及信息列表或者该栏目下的信息内容。
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:22:06
	 * @param map
	 * 			columnId：栏目id columnType：栏目类型（0：富文本、1、栏目类型）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/columns/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getSubColumnContent(@RequestParam Map<String, String> map)  throws Exception{
		return focusService.getSubColumnContent(map);
	}
 
	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/focus/columnsOrLables/infos
	 * 	columnId=1011254&lableId=1011265&keyword=定公共汽车
	 * @Description	查询专题下的信息列表(007)
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:23:19
	 * @param map
	 * 			columnId（栏目id） lableId（标签id）keyword（检索关键字）
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/columnsOrLables/infos", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean getColumnsOrLablesInfos(@RequestParam Map<String, String> map)  throws Exception{
		return focusService.getColumnsOrLablesInfos(map);
	}

	/**
	 * http://127.0.0.1:8090/knowledge_mobile_api/focus/infos/{contentId}
	 * contentId = 11513671
	 * @Description	根据信息Id获取信息详情接口（008）
	 * @author yanggaoli
	 * @date 2020年3月10日上午9:24:08
	 * @param contentId
	 * @returnResultBean
	 * @version
	 */
	@RequestMapping(value = "/infos/{contentId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean getContentInfoById(@PathVariable String contentId)  throws Exception{
		return focusService.getContentInfoById(contentId);
	}

}
