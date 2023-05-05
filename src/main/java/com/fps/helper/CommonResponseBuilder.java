package com.fps.helper;

import com.fps.model.CommonResponse;

import lombok.Data;

@Data
public class CommonResponseBuilder {

	private String errorCode;
	private String messgae;
	private int status;
	
public CommonResponseBuilder withErrorCode(String code) {
	this.errorCode=code;
	return this;
}
public CommonResponseBuilder withMessage(String msg) {
	this.messgae=msg;
	return this;
}
public CommonResponseBuilder withStatus(int  status) {
	this.status=status;
	return this;
}
	public CommonResponse build() {
		return new CommonResponse(errorCode,messgae,status);
	}
	
}
