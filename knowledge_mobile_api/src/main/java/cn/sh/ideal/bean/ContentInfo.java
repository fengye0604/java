package cn.sh.ideal.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 知识信息
 * @author yanggaoli
 */
public class ContentInfo {
	
	private String klId;//信息id
	private String klContentTitle;//信息标题
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String infoType;//信息类型  1、知识信息 2、业务资料 3、新闻摘要
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String klContentSources;//来源
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String policyNo;    //承办单位设置的政策文号
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String enforceTime;//实施日期
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String klContent;//正文信息
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ContentFile> contentFile;//附件信息
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	public String getKlContentTitle() {
		return klContentTitle;
	}
	public void setKlContentTitle(String klContentTitle) {
		this.klContentTitle = klContentTitle;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getKlContentSources() {
		return klContentSources;
	}
	public void setKlContentSources(String klContentSources) {
		this.klContentSources = klContentSources;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getEnforceTime() {
		return enforceTime;
	}
	public void setEnforceTime(String enforceTime) {
		this.enforceTime = enforceTime;
	}
	public String getKlContent() {
		return klContent;
	}
	public void setKlContent(String klContent) {
		this.klContent = klContent;
	}
	public List<ContentFile> getContentFile() {
		return contentFile;
	}
	public void setContentFile(List<ContentFile> contentFile) {
		this.contentFile = contentFile;
	}
	
}
