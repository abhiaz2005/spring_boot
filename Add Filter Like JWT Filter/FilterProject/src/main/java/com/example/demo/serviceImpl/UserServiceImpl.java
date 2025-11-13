package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.Optional;

import org.apache.catalina.startup.PasswdUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;
import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	public Response<Object> generateToken(LoginRequest loginRequest) {
		try {

			Optional<User> userOptional = userRepository.findByEmail(loginRequest.getUsername());
			if (userOptional.isPresent()) {

				User user = userOptional.get();

				if (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.USER)
						|| user.getRole().equals(Role.USER)) {
					if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

						String token = jwtService.generateToken(loginRequest.getUsername());
						LoginResponseDto response = new LoginResponseDto();
						response.setToken(token);
						response.setUserName(user.getName());
						response.setEmail(user.getEmail());
						response.setRoleType(user.getRole());
						return new Response<>(HttpStatus.OK.value(), "Login Success.", response);
					}
				}
				return new Response<>(HttpStatus.BAD_REQUEST.value(), "Invalid credentials.", null);
			}
			return new Response<>(HttpStatus.BAD_REQUEST.value(), "invalid credential", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "something went wrong", null);
		}
	}

	@Override
	public Response<Object> register(RegistrationDto userDto) {
		try {
			User user = new User();
			user.setName(userDto.getName());
			String tempPassword = "Rst@123";
			user.setPassword(passwordEncoder.encode(tempPassword));
			user.setRole(Role.USER);
			user.setEmail(userDto.getEmail());
			User savedUser = userRepository.save(user);
			return new Response<>(HttpStatus.CREATED.value(), "success", savedUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "something went wrong", null);
		}
	}

}
