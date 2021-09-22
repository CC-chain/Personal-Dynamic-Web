package com.backend.source.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.source.security.Http401ErrorEntryPoint;
import com.backend.source.security.SimpleCorsFilter;
import com.backend.source.security.jwt.JwtAuthFilter;
import com.backend.source.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public CustomUserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder customPasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
			}
		};
	}

	@Bean
	public Http401ErrorEntryPoint http401ErrorEntryPoint() {
		return new Http401ErrorEntryPoint();
	}

	@Bean
	public JwtAuthFilter tokenAuthenticationFilter() {
		return new JwtAuthFilter();
	}

	@Bean
	public SimpleCorsFilter simpleCorsFilter() {
		return new SimpleCorsFilter();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(customPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/app/**/*.{js,html}")
				.antMatchers("/content/**").antMatchers("/swagger-ui.html");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf()
			.disable()
			.formLogin()
			.disable()
			.httpBasic()
			.disable()
			.addFilterBefore((Filter) simpleCorsFilter(), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling()
			.authenticationEntryPoint(new Http401ErrorEntryPoint())
			.and()
			.authorizeRequests()
			.antMatchers("/",
					"/error",
					"/favicon.ico",
					"/**/*.png",
					"/**/*.gif",
					"/**/*.svg",
					"/**/*.jpg",
					"/**/*.html",
					"/**/*.css",
					"/**/*.js"
					)
			.permitAll()
			.antMatchers(HttpMethod.GET, "/api/blogs/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/comments/**").permitAll()
			.antMatchers("/", "/error", "/api/authenticate/**", "/auth/authenticate", "/auth/authenticate").permitAll()
			.anyRequest()
			.authenticated();
			
	}

}
