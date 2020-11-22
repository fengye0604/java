package cn.sh.ideal.entity;

import java.util.Date;

public class HotWordClick {
	private String klId;		//主键
	private String hotWordId;	//热词id
	private String typeLevel1;	//一级所属类型(对应热词主表中一级栏目类型)
	private String typeLevel2;	//二级所属类型(对应热词主表中二级栏目类型)
	private String hotSortId;	//热词分类id或关联热词id	
	private String hotSortType;	//关联的类型：热词，分类
	private String infoId;		//关联信息的id
	private String infoType;	//关联信息所属模块(1:知识库 2、业务资料 3、新闻摘要)
	private String questionAnswerId;	//关联信息所属模块(1:知识库 2、业务资料 3、新闻摘要)
	private String clickType;	//点击类型(0:页面 1:分类 2:信息)
	private String clickLevel;	//点击层级
	private String clickCreater;	//点击人
	private Date clickCreateTime;	//点击时间
	
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getHotWordId() {
		return hotWordId;
	}
	public void setHotWordId(String hotWordId) {
		this.hotWordId = hotWordId;
	}
	public String getTypeLevel1() {
		return typeLevel1;
	}
	public void setTypeLevel1(String typeLevel1) {
		this.typeLevel1 = typeLevel1;
	}
	public String getTypeLevel2() {
		return typeLevel2;
	}
	public void setTypeLevel2(String typeLevel2) {
		this.typeLevel2 = typeLevel2;
	}
	public String getHotSortId() {
		return hotSortId;
	}
	public void setHotSortId(String hotSortId) {
		this.hotSortId = hotSortId;
	}
	public String getHotSortType() {
		return hotSortType;
	}
	public void setHotSortType(String hotSortType) {
		this.hotSortType = hotSortType;
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
	public String getQuestionAnswerId() {
		return questionAnswerId;
	}
	public void setQuestionAnswerId(String questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
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
