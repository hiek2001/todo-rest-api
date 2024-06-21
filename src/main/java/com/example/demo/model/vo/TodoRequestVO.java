package com.example.demo.model.vo;



import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class TodoRequestVO {
	
	private Long todoId;
	private String memberId;
	private String content;
	private String statusCode;
}
