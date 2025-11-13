package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Response<Object>> login(@RequestBody LoginRequest loginRequest) {
		Response<Object> response = userService.generateToken(loginRequest);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	}

	@PostMapping("/signUp")
	public ResponseEntity<Response<Object>> register(@RequestBody RegistrationDto loginRequest) {
		Response<Object> response = userService.register(loginRequest);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	}
}
