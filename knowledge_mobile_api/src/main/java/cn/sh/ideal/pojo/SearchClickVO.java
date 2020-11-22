package cn.sh.ideal.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchClickVO {
	
	private String pageId;
	private String hotWordId;   //热词id
	private String infoId;
	@Pattern(regexp="[0-2]{1}",message="infoType不能为空，并且只能是0到2的单个数字!;") 
	private String infoType;	//信息类型(0、政策；1、问答；2、其他)
	private String qsInfoId;
	private String clickType;
	private String platform;
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
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
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
