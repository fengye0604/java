package cn.sh.ideal.bean;
/**
 * 热点专题富文本信息
 * @author yanggaoli
 */
public class FocusColumnContent implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String autoId;
	private String focusColumnId;
	private String content;
	private String contentWeb;
	public String getAutoId() {
		return autoId;
	}
	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}
	public String getFocusColumnId() {
		return focusColumnId;
	}
	public void setFocusColumnId(String focusColumnId) {
		this.focusColumnId = focusColumnId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentWeb() {
		return contentWeb;
	}
	public void setContentWeb(String contentWeb) {
		this.contentWeb = contentWeb;
	}
}