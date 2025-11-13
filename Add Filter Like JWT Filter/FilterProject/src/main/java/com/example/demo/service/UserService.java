package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;

public interface UserService {

	Response<Object> generateToken(LoginRequest loginRequest);

	Response<Object> register(RegistrationDto loginRequest);

}
