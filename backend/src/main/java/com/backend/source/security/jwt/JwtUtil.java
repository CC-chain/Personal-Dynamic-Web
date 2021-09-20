package com.backend.source.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.backend.source.config.ApplicationProperties;
import com.backend.source.security.service.CustomUserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private String secretKey;
	
	private long tokenValidityInMilliseconds;
	
	private long tokenValidityInMillisecondsForRememberMe;
	
	private ApplicationProperties applicationProperties;
	
	public JwtUtil(ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
		this.secretKey = 
					applicationProperties.getSecurity().getJwt().getSecret();
		
		this.tokenValidityInMilliseconds=
					1000 * applicationProperties.getSecurity().getJwt().getTokenValidityInSeconds();
		
		this.tokenValidityInMillisecondsForRememberMe=
					1000 * applicationProperties.getSecurity().getJwt().getTokenValidityInSeconds();
	}
	
	public String createToken(Authentication authentication ) {
		return createToken(authentication, false);
	}
	
	public String createToken(Authentication authentication , Boolean rememberMe) {
		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		
		long now = (new Date()).getTime();
		Date validity;
		if(rememberMe) {
			validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
		}else {
			validity = new Date(now + this.tokenValidityInMilliseconds);
		}
		
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		
		return Jwts.builder()
				.setId(Long.toString(customUserDetails.getId()))
				.setSubject(customUserDetails.getUsername())
				.setIssuedAt(new Date())
				.claim("authoritites", authorities)
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.setExpiration(validity)
				.compact();
	}
	
	
}
