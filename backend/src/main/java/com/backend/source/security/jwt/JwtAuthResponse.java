package com.backend.source.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JwtAuthResponse {
	private static final long serialVersionUID = 1250166508152483573L;
	
	@Getter
	private final String token;
}
