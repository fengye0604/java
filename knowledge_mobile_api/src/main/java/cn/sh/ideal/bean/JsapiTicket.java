package cn.sh.ideal.bean;

import java.util.Date;

public class JsapiTicket {
	private String klId;
	private String appId;			//小程序的id
	private String appsecret;		//小程序的秘钥
	private String access_token;	//凭证
	private String grant_type;		//获取数据的类型
	
	private String errcode;			//
	private String errmsg;			//
	private String ticket;			//票据
	private int expires_in;		//凭证有效时间，单位：秒
	private Date expires_date;		//凭证有效时间
	
	
	
	public String getKlId() {
		return klId;
	}
	public void setKlId(String klId) {
		this.klId = klId;
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Date getExpires_date() {
		return expires_date;
	}
	public void setExpires_date(Date expires_date) {
		this.expires_date = expires_date;
	}
	@Override
	public String toString() {
		return "JsapiTicket [kl_Id=" + klId + ", appId=" + appId
				+ ", appsecret=" + appsecret + ", access_token=" + access_token
				+ ", grant_type=" + grant_type + ", errcode=" + errcode
				+ ", errmsg=" + errmsg + ", ticket=" + ticket + ", expires_in="
				+ expires_in + ", expires_date=" + expires_date + "]";
	}
	
	
	
}
