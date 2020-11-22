package cn.sh.ideal.entity;

import java.util.Date;

public class PolicyClick {
	private String klId;		//主键
	private String pageId;		//页面id
	private String infoId;		//信息id
	private String infoType;	//信息类型
	private String clickType;	//点击类型
	private String clickCreater;	//点击人
	private Date clickCreateTime;	//点击时间
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getClickType() {
		return clickType;
	}
	public void setClickType(String clickType) {
		this.clickType = clickType;
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
	
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
}