package cn.sh.ideal.pojo;

import cn.sh.ideal.bean.Signature;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SignatureVO extends Signature{
	
	@JsonIgnore
	private String appId;
	@JsonIgnore
	private String noncestr;		//随机字符串
	@JsonIgnore
	private long timestamp;			//时间戳
	@JsonIgnore
	private String url;				//当前网页的URL
	@JsonIgnore		//响应前台数据时，屏蔽该字段
	private String jsapi_ticket;	//临时票据
	
	private String signatureStr;	//返还给前台的加密串
	
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getSignatureStr() {
		return signatureStr;
	}

	public void setSignatureStr(String signatureStr) {
		this.signatureStr = signatureStr;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJsapi_ticket() {
		return jsapi_ticket;
	}

	public void setJsapi_ticket(String jsapi_ticket) {
		this.jsapi_ticket = jsapi_ticket;
	}

	@Override
	public String toString() {
		return "SignatureVO [noncestr=" + noncestr + ", signatureStr="
				+ signatureStr + ", timestamp=" + timestamp + ", url=" + url
				+ ", jsapi_ticket=" + jsapi_ticket + "]";
	}
	
	
	
	
	
	
}
