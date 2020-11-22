package cn.sh.ideal.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchVO {
	@NotEmpty(message="keyword不能为空！;")
	private String keyword; 	//检索关键字
	@Pattern(regexp="[0-2]{1}",message="clickType不能为空，并且只能是0到2的单个数字!;") 
	private String infoType; 	//信息类型(0、政策；1、问答；2、其他)
	
	private int pageSize;		//每页多少条
	private int pageCount;		//总页数
	private int currentPage;	//当前页
	
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", infoType=" + infoType
				+ ", pageSize=" + pageSize + ", pageCount=" + pageCount
				+ ", currentPage=" + currentPage  + ", platform=" + platform
				+ "]";
	}
	
	
	
}
