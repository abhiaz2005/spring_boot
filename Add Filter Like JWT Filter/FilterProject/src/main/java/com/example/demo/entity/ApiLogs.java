package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "api_logs")
public class ApiLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "end_point")
	private String endPoint;
	
	@Column(name = "ip")
	private String ip ;

	@Column(columnDefinition = "TEXT", name = "payload")
	private String payload;

	@Column(columnDefinition = "TEXT", name = "response")
	private String response;

	@Column(name = "timestamp")
	private Date timestamp;

	

	public ApiLogs(Long id, String email, String endPoint, String ip, String payload, String response, Date timestamp) {
		super();
		this.id = id;
		this.email = email;
		this.endPoint = endPoint;
		this.ip = ip;
		this.payload = payload;
		this.response = response;
		this.timestamp = timestamp;
	}

	public ApiLogs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
