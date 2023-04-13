package com.jpajwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jpajwt.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	
	private final UserRepository repository ;
	
	public ApplicationConfig(UserRepository repository) {
		this.repository = repository;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		//fetch user from database
		return username -> repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found")); //유저네임이 없으면 exception 던진다.
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		//data access object responsible to fetch userdetail and encode password
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//encoding password
		return new BCryptPasswordEncoder();
	}

}
