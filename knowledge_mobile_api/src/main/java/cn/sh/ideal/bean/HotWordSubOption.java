package cn.sh.ideal.bean;

public class HotWordSubOption {
	private String hotWordId;
	private String optionId;			//选项Id
	private String optionName;			//选项名称
	private String optionType;			//选项类型 4：关联热词  5、热词分类

	
	public String getHotWordId() {
		return hotWordId;
	}
	public void setHotWordId(String hotWordId) {
		this.hotWordId = hotWordId;
	}
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	/**以下字段为V5.21版本新增字段*/
	private String webColumnTitle;//点点通栏目标题
	public String getWebColumnTitle() {
		return webColumnTitle;
	}
	public void setWebColumnTitle(String webColumnTitle) {
		this.webColumnTitle = webColumnTitle;
	}
}
