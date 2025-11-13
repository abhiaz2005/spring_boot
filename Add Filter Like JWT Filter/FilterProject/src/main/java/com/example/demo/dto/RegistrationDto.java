package com.example.demo.dto;

import java.util.List;

import com.example.demo.enums.Role;

public class RegistrationDto {
	private String name;
    private String email;
    private String logoUrl ;
    private Long stateId;
    private Role role ;
    private Long cityId;
    private String phoneNumber;
    private Long companyId;
    private Long departmentId;
    private Long subDepartmentId;
    private Boolean isActive;
    private String presentAddress;
    private String permanentAddress;
    private List<Long> departmentIds; 
    private List<Long> subDepartmentIds; 
	public RegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RegistrationDto(String name, String email, String logoUrl, Role role, Long stateId, Long cityId,
			String phoneNumber, Long companyId, Long departmentId, Long subDepartmentId, Boolean isActive,
			String presentAddress, String permanentAddress, List<Long> departmentIds) {
		super();
		this.name = name;
		this.email = email;
		this.logoUrl = logoUrl;
		this.role = role;
		this.stateId = stateId;
		this.cityId = cityId;
		this.phoneNumber = phoneNumber;
		this.companyId = companyId;
		this.departmentId = departmentId;
		this.subDepartmentId = subDepartmentId;
		this.isActive = isActive;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.departmentIds = departmentIds;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogoUrl() {
		return logoUrl;
	}


	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Long getStateId() {
		return stateId;
	}


	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}


	public Long getCityId() {
		return cityId;
	}


	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public Long getSubDepartmentId() {
		return subDepartmentId;
	}


	public void setSubDepartmentId(Long subDepartmentId) {
		this.subDepartmentId = subDepartmentId;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public String getPresentAddress() {
		return presentAddress;
	}


	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}



	public List<Long> getDepartmentIds() {
		return departmentIds;
	}



	public void setDepartmentIds(List<Long> departmentIds) {
		this.departmentIds = departmentIds;
	}



	public List<Long> getSubDepartmentIds() {
		return subDepartmentIds;
	}



	public void setSubDepartmentIds(List<Long> subDepartmentIds) {
		this.subDepartmentIds = subDepartmentIds;
	}


	

    
}
