package cn.sh.ideal.pojo;

import java.util.Date;

public class FocusEvaluateVO {
	private String klId;	//主键
	private String focusId;	//热点专题ID
	private String sortId;	//分类ID
	private String sortType;	//分类类型
	private String infoId;	//关联信息的id
	private String infoType;	//关联信息的类型(1:知识库 2、业务资料 3、新闻摘要)
	private String evaluateCreater;	//点击人
	private Date evaluateCreateTime;	//点击时间
	private String platform;	//平台类型(1:微信 0、app)
	private String evaluate;	//评价值(1:好评 0、差评)

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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
}