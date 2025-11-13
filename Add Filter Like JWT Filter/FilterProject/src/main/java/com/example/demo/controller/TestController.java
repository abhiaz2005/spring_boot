package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;

@RestController
public class TestController {

	@PostMapping("/test")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok("Tested");
	}
}
