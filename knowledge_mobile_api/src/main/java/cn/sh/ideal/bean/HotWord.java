package cn.sh.ideal.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

public class HotWord {
	private String klId;//主键
	private String name;//热词名称
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String keyWord;//关键字
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String type;//热词(关联信息)类型(1、仅有关键字，2、仅关联一个热点专题，3、仅关联知识信息，4、关联分类，5、关联热词)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String title;//V5.5add				xcs			
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String typeLevel1;	//一级栏目类型()
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String typeLevel2;	//二级栏目类型()
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String sort1;
//	private String sort2;
	
	/*
	private Date onlinetime;	//上线时间
	private Date onlinetimeStart;
	private Date onlinetimeEnd;
	
	private Date offlinetime;//下线时间
	private Date offlinetimeStart;
	private Date offlinetimeEnd;
	
	private Date createtime;//创建时间
	private Date createtimeStart;
	private Date createtimeEnd;
	
	private String creater;//创建人
	
	private Date updatetime;//修改时间
	private Date updatetimeStart;
	private Date updatetimeEnd;
	
	private String updater;//修改人
	
	private Date remindertime;//提示时间
	private Date remindertimeStart;
	private Date remindertimeEnd;
	
	private String stick;//提示置顶
	private String state;//状态：1在线  0下线
	
	private String delFlag;//删除标志：1删除  0未删除
	private int order;//排序
	private String linkInfos;//关联信息
	private HotWordLinkFocus hotWordLinkFocus;	//关联热点专题
	
	private String isShow;
	private List<HotWord> hotWordLInks;
	private String hotWordIinkNewsLables;//关联新闻标签的id
	private String hotWordIinkNewsLableNames;//关联新闻标签的id
	private String hotWordLinkIds;
	private List<HotWordSort> hotWordSort;//分类信息
	private List<Map<String ,Object>> linkInfoMap ;//关联信息集合
	private List<HotWordLinkFocus> hotWordLinkFocusList;//热点专题
	*/
	//*以下字段为V5.16版本新增字段
//	private String synState;	//同步标志1、同步，0、不同步
//	private Date onlinetimeWeb;	//点点通上线时间
//	private int sort1;		//专项查询排序
//	private int sort2;		//民生专栏排序
	
//	private String typeLevel2;	//二级栏目类型
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getSort1() {
		return sort1;
	}
	public void setSort1(String sort1) {
		this.sort1 = sort1;
	}
//	public String getSort2() {
//		return sort2;
//	}
//	public void setSort2(String sort2) {
//		this.sort2 = sort2;
//	}

	/**以下字段为V5.21版本新增字段*/
	private String webColumnTitle;//点点通栏目标题

	public String getWebColumnTitle() {
		return webColumnTitle;
	}
	public void setWebColumnTitle(String webColumnTitle) {
		this.webColumnTitle = webColumnTitle;
	}
}
