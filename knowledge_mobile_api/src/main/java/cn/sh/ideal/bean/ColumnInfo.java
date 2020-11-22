package cn.sh.ideal.bean;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 热点专题栏目信息
 * @author yanggaoli
 */
public class ColumnInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String columnId;
	private String columnTitle;
	private String columnType;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Object subColumn;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Object columnInfos;
	
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public Object getSubColumn() {
		return subColumn;
	}
	public void setSubColumn(Object subColumn) {
		this.subColumn = subColumn;
	}
	public Object getColumnInfos() {
		return columnInfos;
	}
	public void setColumnInfos(Object columnInfos) {
		this.columnInfos = columnInfos;
	}
	
	
}
