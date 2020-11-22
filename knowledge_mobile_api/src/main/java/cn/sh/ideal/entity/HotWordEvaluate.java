package cn.sh.ideal.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class HotWordEvaluate {
	private String klId;	//主键
	private String hotWordId;	//热词id
	private String typeLevel1;	//所属类型对应热词主表中一级栏目类型(1:专项查询、2:民生专栏)
	private String typeLevel2;	//所属类型对应热词主表中二级栏目类型(1、选项式查询  2、问答式查询 3、单点式查询 4、选项式查询1)
	private String optionId;	//热词关联的分类或热词id
	private String optionType;	//热词关联的分类或热词的类型(5、热词 4、分类)
	private String infoId;	//关联信息的id
	private String infoType;	//关联信息的类型
	private String qsInfoId;	//问答类信息ID
	private String evaluateType;	//评价信息类型(1:知识信息  2:问答集锦信息)
	private String evaluateLevel;	//评价的层级
	private String evaluateCreater;	//评价人
	private Date evaluateCreateTime;	//点击时间
	private String platform;	//平台类型(1:微信 0、app)
	private String evaluate;	//评价值(1:好评 0、差评)

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

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
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

	public String getEvaluateLevel() {
		return evaluateLevel;
	}

	public void setEvaluateLevel(String evaluateLevel) {
		this.evaluateLevel = evaluateLevel;
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
