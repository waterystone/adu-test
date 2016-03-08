package com.adu.api.common.bean;

import com.adu.api.common.Stringfy;

public class ErrorCode extends Stringfy {
	private static final long serialVersionUID = 2125456863556560691L;

	private int code;
	private String message;
	private Object[] param;

	public ErrorCode() {

	}

	public ErrorCode(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorCode(int code, String message, Object... param) {
		super();
		this.code = code;
		this.message = String.format(message, param);
		this.param = param;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getParam() {
		return param;
	}

	public void setParam(Object[] param) {
		this.param = param;
	}

}
