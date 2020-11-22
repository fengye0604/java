package cn.sh.ideal.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import cn.sh.ideal.validation.MyValidatorOfCannotHaveBlank;

public class FocusClickVO {
	
	@NotEmpty(message="pageId不能为空！;")
	private String pageId;		//专题id
	private String sortId;		//分类id
	private String sortType;	//分类类型
	
	@MyValidatorOfCannotHaveBlank(message="infoId不能包含空格;")
	private String infoId;		//信息id
	
	@Pattern(regexp="[1-3]{1}",message="clickType不能为空，并且只能是1到3的单个数字;") 
	private String infoType;	//信息类型
	
	@Pattern(regexp="[0-2]{1}",message="clickType不能为空，并且只能是0到2的单个数字;")  
	private String clickType;	//点击类型
	
	@Pattern(regexp="[0-9]{1,2}",message="clickLevel不能为空,并且只能是数字;")  
	private String clickLevel;	//点击层级
	
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
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
	
	
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
}