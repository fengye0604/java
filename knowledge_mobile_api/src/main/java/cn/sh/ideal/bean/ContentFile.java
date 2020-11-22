package cn.sh.ideal.bean;
/**
 * 知识信息关联附件
 * @author yanggaoli
 */
public class ContentFile {
	private String fileName;	//文件名称
	private String fileUrl;		//文件的ftp访问路径
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
}
