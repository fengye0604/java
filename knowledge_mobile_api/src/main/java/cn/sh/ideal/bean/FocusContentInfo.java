package cn.sh.ideal.bean;

import java.io.Serializable;

/**
 * 热点专题关联信息
 * @author yanggaoli
 */
public class FocusContentInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	private String autoId;//主键
	private String columnId;//所属栏目或分类的id
	*/
	private String infoId;//信息id
	private String infoTitle;//信息标题
	private String infoType;//信息类别:1知识信息,2业务资料,3新闻摘要
	/*
	private String showIndex;//排序值
	private String infoTitleNew;//信息新标题
	private String infoTitleOld;//信息原标题
	private String status;//信息在栏目或分类下的状态
	private String infoStatus;//信息本身的状态(1:在线、0:过期)
	private String isDel;//信息本身是否删除:0否，1是
	private String focusTitle;//所属专题名称
	private String sortName;//所属栏目或分类的名称
	private String labelName;//所属标签分类的名称
	private String focusId;//热点专题id
	private String fileCounts;//附件个数
	private String syncState;//是否同步到外网:0否1是
	
	public String getAutoId() {
		return autoId;
	}
	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	*/
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	/*
	public String getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(String showIndex) {
		this.showIndex = showIndex;
	}
	public String getInfoTitleNew() {
		return infoTitleNew;
	}
	public void setInfoTitleNew(String infoTitleNew) {
		this.infoTitleNew = infoTitleNew;
	}
	public String getInfoTitleOld() {
		return infoTitleOld;
	}
	public void setInfoTitleOld(String infoTitleOld) {
		this.infoTitleOld = infoTitleOld;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getFocusTitle() {
		return focusTitle;
	}
	public void setFocusTitle(String focusTitle) {
		this.focusTitle = focusTitle;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getFocusId() {
		return focusId;
	}
	public void setFocusId(String focusId) {
		this.focusId = focusId;
	}
	public String getFileCounts() {
		return fileCounts;
	}
	public void setFileCounts(String fileCounts) {
		this.fileCounts = fileCounts;
	}
	public String getSyncState() {
		return syncState;
	}
	public void setSyncState(String syncState) {
		this.syncState = syncState;
	}
	*/
	
}