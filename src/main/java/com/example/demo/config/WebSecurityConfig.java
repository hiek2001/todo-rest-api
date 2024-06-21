package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.addAllowedOriginPattern("*");
//		configuration.addAllowedHeader("*");
//		configuration.addAllowedMethod("*");
//		configuration.addExposedHeader("*");
//		configuration.setAllowCredentials(true);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.cors()
	        .and()
	        .csrf().disable()
	        .httpBasic().disable()
	        .formLogin().disable()
	        .headers().frameOptions().disable()
	        .and()
	        .authorizeRequests()
	        .antMatchers("/api/v1/**")
	        .permitAll();
		
		return http.build();      
	}
	
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception{
//		 return authenticationManagerBean();
//	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
	    return authentication -> {
	        throw new IllegalStateException("No authentication manager");
	    };
	}
}
