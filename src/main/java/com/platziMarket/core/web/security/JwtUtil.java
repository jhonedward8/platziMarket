package com.platziMarket.core.web.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private static final String KEY = "pl4tz1";

	public String generateToken(UserDetails details) {
		return Jwts.builder()
				.setSubject(details.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, KEY)
				.compact();
	}
	
	public boolean validateToken(String token, UserDetails details){
		return details.getUsername()
				.equals(extractUsername(token)) && !isTokenExpired(token);
	}
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}
	
	//claims objetos dentro del jwt
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(KEY)
				.parseClaimsJws(token).getBody();
	}
	
}
