package com.backend.source.security;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.backend.source.security.service.CustomUserDetails;

public class SecurityUtil {
	
	public static Optional<CustomUserDetails> getCurrentAdminLogin(){
		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		return Optional.ofNullable(securityContext.getAuthentication())
				.map(authentication -> {
					if(authentication.getPrincipal() instanceof CustomUserDetails) {
						return (CustomUserDetails) authentication.getPrincipal();
					}
					return null;
				});
	}
}
