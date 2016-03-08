package com.adu.api;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.adu.api.common.Stringfy;
import com.adu.api.common.bean.ErrorCode;

public class APIResponse<T> extends Stringfy {
	private static final long serialVersionUID = -7335040230774064085L;

	private final String ver = "1.0";
	private boolean ret;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String errmsg;
	private int errcode;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private T data;

	public APIResponse() {
	}

	private APIResponse(T t) {
		this.ret = true;
		this.data = t;
		this.errcode = 0;
	}

	private APIResponse(String errmsg, T t) {
		this.ret = false;
		this.errmsg = errmsg;
		this.data = t;
		this.errcode = -1;
	}

	private APIResponse(int errcode, String errmsg, T t) {
		this.ret = false;
		this.errmsg = errmsg;
		this.errcode = errcode;
		this.data = t;
	}

	public static <T> APIResponse<T> returnSuccess() {
		return new APIResponse<T>(null);
	}

	public static <T> APIResponse<T> returnSuccess(T t) {
		return new APIResponse<T>(t);
	}

	public static <T> APIResponse<T> returnFail(String errmsg) {
		return new APIResponse<T>(errmsg, null);
	}

	public static <T> APIResponse<T> returnFail(String errmsg, T t) {
		return new APIResponse<T>(errmsg, t);
	}

	public static <T> APIResponse<T> returnFail(int errcode, String errmsg) {
		return new APIResponse<T>(errcode, errmsg, null);
	}

	public static <T> APIResponse<T> returnFail(ErrorCode code) {
		return new APIResponse<T>(code.getCode(), code.getMessage(), null);
	}

	public static <T> APIResponse<T> returnFail(int errcode, String errmsg, T t) {
		return new APIResponse<T>(errcode, errmsg, t);
	}

	public static <T> APIResponse<T> returnFail(ErrorCode code, T t) {
		return new APIResponse<T>(code.getCode(), code.getMessage(), t);
	}

	public String getVer() {
		return ver;
	}

	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((errmsg == null) ? 0 : errmsg.hashCode());
		result = prime * result + (ret ? 1231 : 1237);
		result = prime * result + errcode;
		result = prime * result + ((ver == null) ? 0 : ver.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		APIResponse that = (APIResponse) o;

		if (errcode != that.errcode)
			return false;
		if (ret != that.ret)
			return false;
		if (data != null ? !data.equals(that.data) : that.data != null)
			return false;
		if (errmsg != null ? !errmsg.equals(that.errmsg) : that.errmsg != null)
			return false;
		if (ver != null ? !ver.equals(that.ver) : that.ver != null)
			return false;

		return true;
	}

}
