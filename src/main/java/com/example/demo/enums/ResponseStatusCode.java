package com.example.demo.enums;
import lombok.Getter;


@Getter
public enum ResponseStatusCode {
	
	C200(200, "요청 성공"),
	C404(404, "해당 URL이 존재하지 않습니다");
	
	private int code;
	private String msg;

	ResponseStatusCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
