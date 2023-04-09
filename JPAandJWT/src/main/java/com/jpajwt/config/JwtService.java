package com.jpajwt.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "VmYq3t6v9y$B&E)H@McQfTjWnZr4u7x!"; //encryption Key Generator를 통해 생성한 키

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getSubject); //subject는 email or username
	}
	
	//extract single claim that we pass
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) { //토큰과 Claim type의 function을 사용한다
		final Claims claims = extractAllClaims(token); //extract all claims
		return claimsResolver.apply(claims); //extract from my token
	}
	
	//generate token without extraclaims
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	
	//generate token method
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		//extraClaims는 
		return Jwts
				.builder()
				.setClaims(extraClaims) //클레임 설정
				.setSubject(userDetails.getUsername()) //userDetail에 저장된 username  정보
				.setIssuedAt(new Date(System.currentTimeMillis())) //현재시간
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) //만료시간
				.signWith(getSignInKey(), SignatureAlgorithm.HS256) //보안서명
				.compact(); //빌드
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
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
