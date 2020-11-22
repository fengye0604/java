package cn.sh.ideal.bean;

import com.fasterxml.jackson.annotation.JsonInclude;


public class ResultBean {
	private String result = "0";
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mesage;
	private Object data;
	
	
	public ResultBean(){	
	}
	public ResultBean(String result,Object data){
		this.result = result;
		this.data = data;
	}
	public ResultBean(Object data){
		this.data = data;
	}
	public static ResultBean ok(Object data) {
        return new ResultBean(data);
    }
	public static ResultBean build(String result,Object data) {
        return new ResultBean(result,data);
    }
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
