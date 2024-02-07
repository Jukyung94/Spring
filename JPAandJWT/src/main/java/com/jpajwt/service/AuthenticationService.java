package com.jpajwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpajwt.config.JwtService;
import com.jpajwt.controller.AuthenticationResponse;
import com.jpajwt.dto.AuthenticationRequest;
import com.jpajwt.dto.RegisterRequest;
import com.jpajwt.repository.UserRepository;
import com.jpajwt.user.Member;
import com.jpajwt.user.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService() {
	}


	public AuthenticationResponse register(RegisterRequest request) {
		// create user data and save in Database
		var user = Member.builder()
				.name(request.getFirstname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();
//		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// 
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);
		var user = repository.findByEmail(request.getEmail())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
}
