package com.example.demo.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_DEFAULT)
public class ResponseVO {

	private boolean result;
	private int statusCode;
	private String message;
	private Object data;

	public ResponseVO(boolean result, int code, String message) {
		this.result = result;
		this.statusCode = code;
		this.message = message;
		this.data = null;
	}

	public void setResponseVO(boolean result, int code, String message) {
		this.result = result;
		this.statusCode = code;
		this.message = message;
		this.data = null;
	}
	
	public void setResponseVO(boolean result, int code, String message, Object data) {
		this.result = result;
		this.statusCode = code;
		this.message = message;
		this.data = data;
	}
}
