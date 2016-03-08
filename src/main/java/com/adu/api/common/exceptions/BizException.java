package com.adu.api.common.exceptions;

import java.io.Serializable;

import com.adu.api.common.bean.ErrorCode;

public class BizException extends Exception implements Serializable {
	private static final long serialVersionUID = -511441181426301067L;
	private ErrorCode errorCode;

	public BizException() {
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public BizException(ErrorCode code) {
		super(code.getMessage());
		this.errorCode = code;
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(Throwable cause, ErrorCode code) {
		super(code.getMessage(), cause);
		this.errorCode = code;
	}

	public Throwable fillInStackTrace() {
		return super.fillInStackTrace();
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
