package cn.sh.ideal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

/***
 * java鎶撳彇缃戠粶鍥剧墖
 * 
 * @author swinglife
 * 
 */
public class CatchImageUtil {
	public static Logger log = Logger.getLogger(CatchImageUtil.class);
	// 网站抓取图片
	private static final String URL = "http://www.shanghai.gov.cn";
	// http://www.shanghai.gov.cn/uploads/month_1612/201612090817493641.jpg
	// 设置编码
	private static final String ECODING = "UTF-8";
	// 匹配图片标签
	private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
	// 匹配src的内容
	private static final String IMGSRC_REG = "src=['\"]?(.*?)['\"]";
	// private static final String IMGSRC_REG =
	// "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";//"http:\"?(.*?)(\"|>|\\s+)";
	// String reg = "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";
	private static final String SRC = ".*?";

	/***
	 * 鑾峰彇ImageUrl鍦板潃
	 * 
	 * @param HTML
	 * @return
	 */
	public static List<String> getImageUrl(String HTML) {
		Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(HTML);
		List<String> listImgUrl = new ArrayList<String>();
		while (matcher.find()) {
			listImgUrl.add(matcher.group());
		}
		return listImgUrl;
	}

	public static List<String> getImage(String text) {
		List<String> images = new ArrayList<String>();
		List<String> imgURLList = getImageUrl(text);
		for (String srcUrl : imgURLList) {
			System.out.println(srcUrl);
			String[] attr = srcUrl.split("ftpPath=");
			if (attr[1].length() > 0) {
				images.add(attr[1].substring(0, attr[1].lastIndexOf("\"")));
			}
		}
		return images;
	}
}
