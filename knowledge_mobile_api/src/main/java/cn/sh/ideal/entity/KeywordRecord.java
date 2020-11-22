package cn.sh.ideal.entity;

import java.util.Date;

public class KeywordRecord {
	private String klId;		//主键
	private String keyword;		//检索关键字
	private String clickCreater;	//点击人
	private Date clickCreateTime;	//点击时间
	private String platform;		//平台类型
	
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getClickCreater() {
		return clickCreater;
	}
	public void setClickCreater(String clickCreater) {
		this.clickCreater = clickCreater;
	}
	public Date getClickCreateTime() {
		return clickCreateTime;
	}
	public void setClickCreateTime(Date clickCreateTime) {
		this.clickCreateTime = clickCreateTime;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
}