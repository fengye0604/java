package cn.sh.ideal.bean;

import java.util.List;
import java.util.Map;

public class HotWordSort {
	private Integer hotWordSortId;//分类id
	private String hotWordId;//分类id
	private String hotWordSortName;//分类名称
	private String infoLinks;//分类关联信息集合（前台）
	private String newsSortIds;//新闻标签id集合（前台）
	private String newsSortNames;//新闻标签id集合（前台）
	private String sortOrder;//排序
	private List<Map<String ,Object>> linkInfoMap ;
	
	
	
	
	public Integer getHotWordSortId() {
		return hotWordSortId;
	}
	public void setHotWordSortId(Integer hotWordSortId) {
		this.hotWordSortId = hotWordSortId;
	}
	public String getHotWordId() {
		return hotWordId;
	}
	public void setHotWordId(String hotWordId) {
		this.hotWordId = hotWordId;
	}
	public String getHotWordSortName() {
		return hotWordSortName;
	}
	public void setHotWordSortName(String hotWordSortName) {
		this.hotWordSortName = hotWordSortName;
	}
	public String getInfoLinks() {
		return infoLinks;
	}
	public void setInfoLinks(String infoLinks) {
		this.infoLinks = infoLinks;
	}
	public String getNewsSortIds() {
		return newsSortIds;
	}
	public void setNewsSortIds(String newsSortIds) {
		this.newsSortIds = newsSortIds;
	}
	
	public String getNewsSortNames() {
		return newsSortNames;
	}
	public void setNewsSortNames(String newsSortNames) {
		this.newsSortNames = newsSortNames;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public List<Map<String, Object>> getLinkInfoMap() {
		return linkInfoMap;
	}
	public void setLinkInfoMap(List<Map<String, Object>> linkInfoMap) {
		this.linkInfoMap = linkInfoMap;
	}
	
	/**V5.16版本添加一下字段*/
	private String delFlag;	//删除标志（1：删除，0：未删除）
	private String synState;	//同步标志（1：同步，0：未同步）
	private String updateTime;	//更新时间
	private String updater;	//更新人
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	
	
	
	
	
	
}
