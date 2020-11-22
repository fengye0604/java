package cn.sh.ideal.entity;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchClick {
	private String klId;		//主键
	private String pageId;		//小沪机器人图片默认6000000000
	private String infoId;		//知识信息Id
	private String hotWordId;   //热词id
	private String infoType;	//信息类型(1、知识信息；2、业务资料；3、新闻摘要)
	private String qsInfoId;	//问答集锦信息id
	private String clickType;	//点击类型
	private String clickCreater;	//点击人
	private Date clickCreateTime;	//点击时间
	private String platform;	//平台类型
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
	public String getHotWordId() {
		return hotWordId;
	}
	public void setHotWordId(String hotWordId) {
		this.hotWordId = hotWordId;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getQsInfoId() {
		return qsInfoId;
	}
	public void setQsInfoId(String qsInfoId) {
		this.qsInfoId = qsInfoId;
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
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}
