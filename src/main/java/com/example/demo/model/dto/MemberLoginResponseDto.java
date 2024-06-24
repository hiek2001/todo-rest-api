package com.example.demo.model.dto;

import lombok.Data;
import lombok.Getter;

@Getter 
@Data
public class MemberLoginResponseDto {

	private String id;
	private String token;
	private String issued_time;
	private String expired_time;
	
	public MemberLoginResponseDto(String id, String token) {
		this.id = id;
		this.token = token;
	}
	
}
