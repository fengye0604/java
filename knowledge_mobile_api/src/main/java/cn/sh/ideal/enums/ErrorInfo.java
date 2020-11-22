package cn.sh.ideal.enums;

public enum ErrorInfo {
	Error001("1","出错了"),
	Error003("-3","参数错误！"),
	Error099("-99","信息有误！");
	private ErrorInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
