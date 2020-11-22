package cn.sh.ideal.bean;

public class Token {
	private String token;
	private String refreshToken;
	private int expireSeconds;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public int getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	@Override
	public String toString() {
		return "Token [token=" + token + ", refreshToken=" + refreshToken
				+ ", expireSeconds=" + expireSeconds + "]";
	}
	
	
}
