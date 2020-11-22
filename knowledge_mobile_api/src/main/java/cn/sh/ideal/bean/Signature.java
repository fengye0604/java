package cn.sh.ideal.bean;

import org.apache.commons.codec.digest.DigestUtils;

public class Signature{
	
	private String noncestr;		//随机字符串
	private long timestamp;			//时间戳
	private String url;				//当前网页的URL
	private String jsapi_ticket;	//临时票据
	
	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
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
	
	public String createSignature(){
		StringBuffer data = new StringBuffer();
		/**/
		data.append("jsapi_ticket=").append(this.getJsapi_ticket()).append("&");
		data.append("noncestr=").append(this.getNoncestr()).append("&");
		data.append("timestamp=").append(String.valueOf(this.getTimestamp())).append("&");
		data.append("url=").append(this.getUrl());
		/*
		data.append("jsapi_ticket=").append(this.jsapi_ticket);
		data.append("noncestr=").append(this.noncestr);
		data.append("timestamp=").append(String.valueOf(this.timestamp));
		data.append("url=").append(this.url);
		*/
		System.out.println(data.toString());
		return DigestUtils.shaHex(data.toString());
	}
	@Override
	public String toString() {
		return "Signature [noncestr=" + noncestr + ", timestamp=" + timestamp
				+ ", url=" + url + ", jsapi_ticket=" + jsapi_ticket + "]";
	}

	
	
	
	
	
	
	
}
