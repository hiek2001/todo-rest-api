package com.example.demo.config.jwt;

public interface JwtProperties {

	String SECRET="hiek2001";
	int EXPIRATION_TIME=60000*60*24;
	String TOKEN_PREFIX = "Bearer";
	String HEADER_STRING = "Authorization";
}
