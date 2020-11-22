package cn.sh.ideal.pojo;

import java.util.Date;

public class SearchEvaluateVO {
	private String klId;	//主键
	private String infoId;	//关联信息的id
	private String infoType;	//关联信息的类型(1:知识库 2、业务资料 3、新闻摘要)
	private String qsInfoId;	//问答类信息ID
	private String evaluateType;	//评价信息类型(1:知识信息  2:集锦信息)
	private String evaluateCreater;	//评价人
	private Date evaluateCreateTime;	//评价时间
	private String platform;	//平台类型(1:微信 0、app)
	private String evaluate;	//评价值(1:好评 0、差评)

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

	public String getQsInfoId() {
		return qsInfoId;
	}

	public void setQsInfoId(String qsInfoId) {
		this.qsInfoId = qsInfoId;
	}

	public String getEvaluateType() {
		return evaluateType;
	}

	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType;
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
