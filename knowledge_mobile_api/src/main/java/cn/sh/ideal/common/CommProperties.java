package cn.sh.ideal.common;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommProperties {
	private static Logger logger = Logger.getLogger(CommProperties.class );
	
	private static Properties prop = new Properties();
	//读取配置文件的路径：/comm.properties	表示在classpath目录下
	private static String fileName = "/comm.properties";
	
	//读取配置文件的路径：comm.properties		不带“/”表示在和当前文件同级目下
//	private static String fileName = "comm.properties";
	/*
	public static String getProp(String key){
		String source = "";
		FileInputStream fis = null;
		
		try {
				fis = new FileInputStream(fileName);
				prop.load(fis);
				source = prop.getProperty(key);
			} catch (Exception e) {
				logger.error("读取参数异常", e);
				if(fis != null){
					try {
						fis.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}finally{
				if(fis != null){
					try {
						fis.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		return source;
	}
	*/
	public static String getProp(String key) {
		String source = "";
		try {
			prop.load(CommProperties.class.getResourceAsStream(fileName));
			source = prop.getProperty(key);
		} catch (Exception e) {
			logger.error("读取参数异常", e);
		}
		return source;
	}
	
}
