package cn.sh.ideal.pojo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class HotWordClickVO{
	@NotEmpty(message = "hotWordId不能为空;")
	private String hotWordId;
	
	@NotEmpty(message = "typeLevel1不能为空;")
	@Size(min=1,max=2,message="typeLevel1字符长度必须大于0，小于等于2;")
	private String typeLevel1;
	
	@NotEmpty(message = "typeLevel2不能为空;")
	@Size(min=1,max=2,message="typeLevel2字符长度必须大于0，小于等于2;")
	private String typeLevel2;
	
	private String optionId;
	private String optionType;
	private String infoId;
	
	@Pattern(regexp="[0-2]{1}",message="clickType不能为空，并且只能是0到2的单个数字;") 
	private String infoType;
	
	private String qsInfoId;
	
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Size(min=1,max=1,message="clickType不能为空且长度为1;")
	private String clickType;
	@NotEmpty(message = "clickLevel不能为空;")
	private String clickLevel;
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
	
	@Override
	public String toString() {
		return "HotWordClick [hotWordId=" + hotWordId + ", typeLevel1=" + typeLevel1 + ", typeLevel2=" + typeLevel2
				+ ", optionId=" + optionId + ", optionType=" + optionType
				+ ", infoId=" + infoId + ", infoType=" + infoType
				+ ", clickType=" + clickType + ", clickLevel=" + clickLevel
				+ "]";
	}
	
}
