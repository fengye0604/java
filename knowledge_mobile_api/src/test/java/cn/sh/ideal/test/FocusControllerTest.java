package cn.sh.ideal.test;

import org.junit.Test;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.controller.FocusController;

public class FocusControllerTest extends BaseTest{
	@Test
    public void test(){
		try {
			FocusController focusController =  ctx.getBean("focusController",FocusController.class);
	        ResultBean rs = focusController.getContentInfoById("11513671");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
	
	@org.junit.Test
    public void testInput(){
		
    	
    }
}
