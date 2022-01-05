package com.platziMarket.core.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.platziMarket.core.domain.service.PlatziUserDetailsService;
import com.platziMarket.core.web.security.JwtUtil;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtFilterRequest extends OncePerRequestFilter {
	
	private JwtUtil jwtUtil;
	private PlatziUserDetailsService platziUserDetailsService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String authotizationHeader = request.getHeader("Authorization");
		
		if(authotizationHeader != null && authotizationHeader.startsWith("Bearer")) {
			String jwt = authotizationHeader.substring(7);
			String username = jwtUtil.extractUsername(jwt);
			
			if(username != null && SecurityContextHolder
					.getContext().getAuthentication() == null) {
				UserDetails userDetails = platziUserDetailsService
						.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken = 
							new UsernamePasswordAuthenticationToken(
									userDetails, null, userDetails.getAuthorities());
					
					//obtener todo los detalles de la autenticacion como l enavegador y hora
					authenticationToken.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request));
					
					//settear la autenticacion para que solo se authentique una vez
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
