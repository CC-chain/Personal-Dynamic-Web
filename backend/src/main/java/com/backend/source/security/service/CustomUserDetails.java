package com.backend.source.security.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.source.model.Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CustomUserDetails implements UserDetails {
	@Getter
	private Long Id;
	private String User_Name;
	private String Password;
	private Collection<? extends GrantedAuthority> authorities;
	@Getter
	@Setter
	private Map<String, Object> attributes;

	public CustomUserDetails(Long id, String user_name, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.Id = id;
		this.User_Name= user_name;
		this.Password = password;
		this.authorities = authorities;
	}

	public static CustomUserDetails create(Admin admin) {
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

		return new CustomUserDetails(admin.getId(), admin.getUserName(), admin.getPassword(), authorities);
	}

	public static CustomUserDetails create(Admin admin, Map<String, Object> attributes) {
		CustomUserDetails customUserDetails = CustomUserDetails.create(admin);
		customUserDetails.setAttributes(attributes);
		return customUserDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return Password;
	}

	@Override
	public String getUsername() {
		return User_Name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
