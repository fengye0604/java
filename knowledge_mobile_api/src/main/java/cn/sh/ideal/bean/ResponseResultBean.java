package cn.sh.ideal.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseResultBean {
	private String message;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String code;
	private Token  data;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Token getData() {
		return data;
	}
	public void setData(Token data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResultBean [message=" + message + ", code=" + code
				+ ", data=" + data + "]";
	}
	
	
	
	
}
