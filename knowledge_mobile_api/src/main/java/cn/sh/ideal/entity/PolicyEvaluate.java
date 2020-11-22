package cn.sh.ideal.entity;

import java.util.Date;

public class PolicyEvaluate {

	private String klId;	//主键
	private String infoId;	//信息id
	private String infoType;	//信息类型(1:知识库 2、业务资料 3、新闻摘要)
	private String pageLevel;	//层级关系(1:首页直接点信息评价 2:更多-进入页面评价)
	private String evaluateCreater;	//评价人人
	private Date evaluateCreateTime;	//评价时间
	private String evaluate;	//评价值(1:好评 0、差评)
	private String platform;	//平台类型(1:微信 0、app)

	public String getKlId() {
		return klId;
	}

	public void setKlId(String klId) {
		this.klId = klId;
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

	public String getPageLevel() {
		return pageLevel;
	}

	public void setPageLevel(String pageLevel) {
		this.pageLevel = pageLevel;
	}

	public String getEvaluateCreater() {
		return evaluateCreater;
	}

	public void setEvaluateCreater(String evaluateCreater) {
		this.evaluateCreater = evaluateCreater;
	}

	public Date getEvaluateCreateTime() {
		return evaluateCreateTime;
	}

	public void setEvaluateCreateTime(Date evaluateCreateTime) {
		this.evaluateCreateTime = evaluateCreateTime;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}