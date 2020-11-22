package cn.sh.ideal.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;



public class DateUtil {
	public static Logger log = Logger.getLogger(DateUtil.class);
	private static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	/**
	 * 
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2019-8-9 下午4:50:06
	 * @Title: getMinuteDate 
	 * @Description 对当前的时间的分钟做加减
	 * @param date  传入的时间
	 * @param minuteValue  
	 * @return
	 */
	public static Date getMinuteDate(Date date,int minuteValue) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minuteValue);//-1今天的时间加一天
        date = calendar.getTime();
        return date;
    }
	/**
	 * 
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2019-8-12 上午10:20:23
	 * @Title: getNextDay 
	 * @Description 获取前一天的
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);//-1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	
	public static Date dateAddDays(Date date,int minuteValue) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, minuteValue);//-1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	
	public static Date dateAddMonths(Date date,int minuteValue) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, minuteValue);//-1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	
	public static Date dateAddMinute(Date date,int secondValue) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, secondValue);//-1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	
	public static Date dateAddSecond(Date date,int secondValue) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, secondValue);//-1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	
	public static String dateToCnStr(Date date) {
		
		return DATE_TIME.format(date);
	}
	
	
	public static String dateToCnStr(Calendar currentDate) {
		
		return dateFormat.format(currentDate.getTime());
	}
	Calendar currentDate = new GregorianCalendar();
	public static void main(String[] args) {
		/*
		Date date = dateAddMinute(new Date(),7200);
		System.out.println(dateToCnStr(date));
		System.out.println(dateToCnStr(new GregorianCalendar()));
		*/
		
		
		
		
		Date date = dateAddMinute(new Date(),7200);
		System.out.println(date);
		
		
		
	}
	
	
}
