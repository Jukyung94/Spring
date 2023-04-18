package com.jpajwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpajwt.dto.AuthenticationRequest;
import com.jpajwt.dto.RegisterRequest;
import com.jpajwt.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vi/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationService service;
	
	public AuthController(AuthenticationService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		//
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		//
		return ResponseEntity.ok(service.authenticate(request));
	}
}
