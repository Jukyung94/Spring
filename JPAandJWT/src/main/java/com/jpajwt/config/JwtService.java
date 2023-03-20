package com.jpajwt.config;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "VmYq3t6v9y$B&E)H@McQfTjWnZr4u7x!"; //encryption Key Generator를 통해 생성한 키

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts
			.parserBuilder() //token builder
			.setSigningKey(getSignInKey()) //to create to generate or to decode a token
			.build()
			.parseClaimsJws(token) //parse token
			.getBody(); //get all the claims that we have within the token
			
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
