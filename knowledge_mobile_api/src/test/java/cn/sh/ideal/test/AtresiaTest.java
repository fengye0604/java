package cn.sh.ideal.test;

import java.util.HashMap;
import java.util.Map;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;


import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.controller.FocusController;
import cn.sh.ideal.controller.HotWordController;
import cn.sh.ideal.controller.PolicyAction;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class AtresiaTest {
	public static Logger logger = LoggerFactory.getLogger(AtresiaTest.class);
	@Autowired
	FocusController  focusController;
	
	@Autowired
	PolicyAction policyAction;
	
	@Autowired
	HotWordController hotWordController;
	
/***********************************热词相关查询****************************************************/
	
	
	
    @Test	//专项查询获取热词列表
    public void testHotWordZxcx() {
    	try {
    		System.out.println();
        	ResultBean getInfoList = hotWordController.getZxcxHotWordList();
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			
		}
    	
    }
    @Test	//专项查询获取热词列表
    public void testHotWordMszl() {
    	try {
    		System.out.println();
        	ResultBean getInfoList = hotWordController.getMszlHotWordList();
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			   
		}
    	
    }
    
    
    @Test	//单点式查询获取信息列表
    public void getSingleQuryContentInfoList() {
    	try {
    		System.out.println();
    		//参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
    		Map<String,String> map = new HashMap<String,String>();
        	map.put("hotWordId", "100000252");
        	map.put("type", "3");
        	map.put("typeLevel2", "3");
        	
        	ResultBean getInfoList = hotWordController.getSingleQueryInfosList(map);
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @Test	//专项查询获取热词列表
    public void getOptionQuryContentInfoList() {
    	try {
    		System.out.println();
    		//参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
    		Map<String,String> map = new HashMap<String,String>();
//        	map.put("hotWordId", "100000252");	//差热词分类
//        	map.put("type", "4");
        	map.put("hotWordId", "100000247");	//查关联热词
        	map.put("type", "5");
        	map.put("typeLevel2", "3");
        	
        	ResultBean getInfoList = hotWordController.getOptionalQeuryLinksOrSorts(map);
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @Test	//专项查询获取热词列表
    public void getOptionalQeuryInfosList() {
    	try {
    		System.out.println();
    		//参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("hotWordId", "100000264");	//查关联热词
        	map.put("type", "5");
//        	map.put("hotWordId", "1000000160");	//查关联热词
//        	map.put("type", "4");
        	map.put("typeLevel2", "3");
//        	map.put("keyword", "闵行");
        	
        	
        	ResultBean getInfoList = hotWordController.getOptionalQeuryInfosList(map);
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    
    @Test	//专项查询获取热词列表
    public void getInfoById() {
    	try {
    		System.out.println();
    		//参数：热词id(hotWordId = 100000252) 、 热词类型type：type=3   、 热词所属栏目typeLevel2：typeLevel2=3
    		
//        	map.put("keyword", "闵行");
    		String infoId = "szfbz_info_120914143135841";
        	
        	ResultBean getInfoList = hotWordController.getInfoById(infoId);
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
   
    
	
	/***********************************热点专题相关查询********************************************/
	
    @Test
    public void testGetInfoList() {
    	ResultBean getInfoList;
		try {
			logger.info("**********222******方法调用开始*****************");
			getInfoList = focusController.getInfoList();
			String result = JSON.toJSONString(getInfoList);
	    	System.out.println(result);
	    	logger.info("方法执行的结果是【{}】",result);
	    	logger.info("****************方法调用结束*****************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @Test
    public void testGetContentInfoById() {
    	
//    	ResultBean getInfoList = focusController.getContentInfoById("11513671");
    	try {
    		//11508651	有附件
        	ResultBean getInfoList = focusController.getContentInfoById("sswj_info_137");
        	System.out.println();
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
        	System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @Test
    public void testGetInfos() {
    	try {
    		Map<String,String> map = new HashMap<String,String>();
        	map.put("focusId", "1010094");
        	map.put("keyword", "测试");
//        	ResultBean getInfoList = focusController.getContentInfoById("11513671");
//        	ResultBean getInfoList = focusController.getFocusInfos(map);
//        	System.out.println();
        	System.out.println();
//        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
        	System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    
    /**************************新政速递测试*****************************************/
    
    /**
     * 
     * @Description	
     * @author yanggaoli
     * @date 2020年3月12日下午4:09:07void
     * @version
     */
    @Test
    public void testGetLatestInfos() {
    	try {
    		ResultBean getInfoList = policyAction.getLatestPolicyInfos();
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	

    }
    
    
    /**
     * 
     * @Description	
     * @author yanggaoli
     * @date 2020年3月12日下午4:09:19void
     * @version
     */
    @Test
    public void testGetPolicyInfo() {
    	try {
    		Map<String,String> map = new HashMap<String,String>();
        	map.put("focusId", "1010094");
        	map.put("keyword", "测试");
//        	ResultBean getInfoList = focusController.getContentInfoById("11513671");
        	ResultBean getInfoList = policyAction.getPolicyInfo("11513671");
//        	System.out.println();
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
        	System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @Test
    public void testGetPolicyInfoByWh() {
    	try {
        	ResultBean getInfoList = focusController.getContentInfoById("11513671");
        	System.out.println();
        	System.out.println(JSON.toJSONString(getInfoList));
        	System.out.println();
		} catch (Exception e) {
			
		}
    	
    }
    
    
   
    
}