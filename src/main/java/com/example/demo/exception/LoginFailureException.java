package com.example.demo.exception;

public class LoginFailureException extends IllegalStateException{

	private static final String MESSAGE = "아이디 혹은 비밀번호를 확인해주세요.";
	
	public LoginFailureException() {
		super(MESSAGE);
	}
	
	
}
