package cn.sh.ideal.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class HotWordLinkInfo {
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String klId;/*主键*/
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hotWordId;/*热词id*/
	private String infoId;/*信息ID*/
	private String infoName;/*信息名称*/
	private String infoType;/*信息类型（1.新闻摘要  2.业务资料  3.知识信息）*/
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date updateTime;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String title;//V5.5					xcs				
	
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
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**V5.16版本添加一下字段*/
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hotWordSortId;	//热词分类id
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hotWordSortName;	//热词分类id
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String delFlag;	//删除标志（1：删除，0：未删除）
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String synState;	//同步标志（1：同步，0：未同步）
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String order;	//同步标志（1：同步，0：未同步）

	public String getHotWordSortId() {
		return hotWordSortId;
	}
	public void setHotWordSortId(String hotWordSortId) {
		this.hotWordSortId = hotWordSortId;
	}
	public String getHotWordSortName() {
		return hotWordSortName;
	}
	public void setHotWordSortName(String hotWordSortName) {
		this.hotWordSortName = hotWordSortName;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getSynState() {
		return synState;
	}
	public void setSynState(String synState) {
		this.synState = synState;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
