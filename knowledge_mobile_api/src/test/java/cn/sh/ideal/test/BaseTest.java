package cn.sh.ideal.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BaseTest {
	public static ApplicationContext ctx ;
	
    @Before
    public void init(){
    	ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
    }
	
    
}