package com.ust.model;

public class VendorContact {
	private Integer vId;
	private String vName;
	private String vAdd;
	private String vLoc;
	private String vService;
	private Double vPin; 
	private String isActive;
	private Integer cId ;
	private String cName ;
	private String cDep;
	private String email;
	private String phone ;
	@Override
	public String toString() {
		return "VendorContact [vId=" + vId + ", vName=" + vName + ", vAdd=" + vAdd + ", vLoc=" + vLoc + ", vService="
				+ vService + ", vPin=" + vPin + ", isActive=" + isActive + ", cId=" + cId + ", cName=" + cName
				+ ", cDep=" + cDep + ", email=" + email + ", phone=" + phone + "]";
	}
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAdd() {
		return vAdd;
	}
	public void setvAdd(String vAdd) {
		this.vAdd = vAdd;
	}
	public String getvLoc() {
		return vLoc;
	}
	public void setvLoc(String vLoc) {
		this.vLoc = vLoc;
	}
	public String getvService() {
		return vService;
	}
	public void setvService(String vService) {
		this.vService = vService;
	}
	public Double getvPin() {
		return vPin;
	}
	public void setvPin(Double vPin) {
		this.vPin = vPin;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDep() {
		return cDep;
	}
	public void setcDep(String cDep) {
		this.cDep = cDep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public VendorContact(Integer vId, String vName, String vAdd, String vLoc, String vService, Double vPin,
			String isActive, Integer cId, String cName, String cDep, String email, String phone) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAdd = vAdd;
		this.vLoc = vLoc;
		this.vService = vService;
		this.vPin = vPin;
		this.isActive = isActive;
		this.cId = cId;
		this.cName = cName;
		this.cDep = cDep;
		this.email = email;
		this.phone = phone;
	}
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}

}
