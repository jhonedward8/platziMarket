package com.platziMarket.core.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platziMarket.core.domain.dto.AuthenticationRequest;
import com.platziMarket.core.domain.dto.AuthenticationResponse;
import com.platziMarket.core.domain.service.PlatziUserDetailsService;
import com.platziMarket.core.web.security.JwtUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private PlatziUserDetailsService platziUserDetailsService;
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(
			@RequestBody AuthenticationRequest request){
		
		try {
			//realiza la autenticacin de forma automatica
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getUsername(), 
							request.getPassword()
							));
			
			//se obtienen los UserDetails
			UserDetails details = platziUserDetailsService
					.loadUserByUsername(request.getUsername());
			
			//crear el token
			String jwt = jwtUtil.generateToken(details);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}

}
