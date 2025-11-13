package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class UserDto {

	 	private String name;
	    private String email;
	    private String profilePic ;
	    private String userId;
	    private Role role;
	    private String stateName;
	    private String cityName;
	    private String phoneNumber;

	    private Boolean isActive;
		private Date createdAt;
		private String presentAddress ;
		private String permanentAddress ;
		private String company;
		private String department;
		private String subDepartment;
		private UserDto createdBy;
		
		
		
		public String getProfilePic() {
			return profilePic;
		}
		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
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
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	
		public Boolean getIsActive() {
			return isActive;
		}
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
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
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getSubDepartment() {
			return subDepartment;
		}
		public void setSubDepartment(String subDepartment) {
			this.subDepartment = subDepartment;
		}
		public UserDto getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(UserDto createdBy) {
			this.createdBy = createdBy;
		}
		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDto(String name, String email, String profilePic, String userId, Role role, String stateName,
				String cityName, String phoneNumber, Boolean isActive, Date createdAt, String presentAddress,
				String permanentAddress, String company, String department, String subDepartment, UserDto createdBy) {
			super();
			this.name = name;
			this.email = email;
			this.profilePic = profilePic;
			this.userId = userId;
			this.role = role;
			this.stateName = stateName;
			this.cityName = cityName;
			this.phoneNumber = phoneNumber;
			this.isActive = isActive;
			this.createdAt = createdAt;
			this.presentAddress = presentAddress;
			this.permanentAddress = permanentAddress;
			this.company = company;
			this.department = department;
			this.subDepartment = subDepartment;
			this.createdBy = createdBy;
		}
	
	    
	
}
