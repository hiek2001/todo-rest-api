package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum TodoStatus {
	
	TODO("할 일"),
	IN_PROGRESS("진행 중"),
	DONE("완료"),
	PENDING("대기");
	
	private final String statusCode;

	TodoStatus(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public TodoStatus changeStatus(TodoStatus newStatus) {
		if(this == IN_PROGRESS && newStatus == PENDING) {
			return PENDING;
		} 
		if(this == PENDING) {
			return newStatus;
		}
		throw new IllegalStateException("잘못된 상태 전환: " + this + " -> " + newStatus);
	}
}
