package com.app;

/*
 * this is a dto class which represents all the customer data
 */
public class CustomerDetails {
	private String customerId;
	private String contractId;
	private String geoZone;
	private String teamCode;
	private String projectCode;
	private Integer buildDuration;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getGeoZone() {
		return geoZone;
	}
	public void setGeoZone(String geoZone) {
		this.geoZone = geoZone;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public Integer getBuildDuration() {
		return buildDuration;
	}
	public void setBuildDuration(Integer buildDuration) {
		this.buildDuration = buildDuration;
	}
	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", contractId=" + contractId + ", geoZone=" + geoZone
				+ ", teamCode=" + teamCode + ", projectCode=" + projectCode + ", buildDuration=" + buildDuration + "]";
	}
	
}
