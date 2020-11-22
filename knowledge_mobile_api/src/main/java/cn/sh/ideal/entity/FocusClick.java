package cn.sh.ideal.entity;

import java.util.Date;

public class FocusClick {
	private String klId;		//主键
	private String focusId;		//专题id
	private String sortId;		//分类id
	private String sortType;	//分类类型
	private String infoId;		//信息id
	private String infoType;	//信息类型
	private String clickType;	//点击类型
	private String clickLevel;	//点击层级
	private String clickCreater;	//点击人
	private Date clickCreateTime;	//点击时间
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getFocusId() {
		return focusId;
	}
	public void setFocusId(String focusId) {
		this.focusId = focusId;
	}
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
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
	public String getClickLevel() {
		return clickLevel;
	}
	public void setClickLevel(String clickLevel) {
		this.clickLevel = clickLevel;
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