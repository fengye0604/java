package cn.sh.ideal.bean;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 政策法规栏目
 * @author yanggaoli
 */
public class PolicyInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String policyId;
	private String policyTitle;
	private String policySource;
	private String policyEnforceTime;
	private String policyYear;
	private String policyMonth;
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPolicyTitle() {
		return policyTitle;
	}
	public void setPolicyTitle(String policyTitle) {
		this.policyTitle = policyTitle;
	}
	public String getPolicySource() {
		return policySource;
	}
	public void setPolicySource(String policySource) {
		this.policySource = policySource;
	}
	public String getPolicyEnforceTime() {
		return policyEnforceTime;
	}
	public void setPolicyEnforceTime(String policyEnforceTime) {
		this.policyEnforceTime = policyEnforceTime;
	}
	public String getPolicyYear() {
		return policyYear;
	}
	public void setPolicyYear(String policyYear) {
		this.policyYear = policyYear;
	}
	public String getPolicyMonth() {
		return policyMonth;
	}
	public void setPolicyMonth(String policyMonth) {
		this.policyMonth = policyMonth;
	}
	
	
	
}
