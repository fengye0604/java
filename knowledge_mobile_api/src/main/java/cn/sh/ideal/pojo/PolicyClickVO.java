package cn.sh.ideal.pojo;

import javax.validation.constraints.Pattern;


public class PolicyClickVO {
	private String pageId;		//页面id
	private String infoId;		//信息id
	
	@Pattern(regexp="[1-3]{1}",message="clickType不能为空，并且只能是1到3的单个数字;") 
	private String infoType;	//信息类型
	
	@Pattern(regexp="[0-2]{1}",message="clickType不能为空，并且只能是0到2的单个数字;")  
	private String clickType;	//点击类型
	
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
	
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
}