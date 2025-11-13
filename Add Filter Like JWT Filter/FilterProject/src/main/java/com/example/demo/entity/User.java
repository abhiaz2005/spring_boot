package com.example.demo.entity;

import com.example.demo.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_v1")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "email")
	private String email;
	
	
	private String password ;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;


	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	


	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(Long id, String name, String userId, String email, String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
	}




	
	
}
