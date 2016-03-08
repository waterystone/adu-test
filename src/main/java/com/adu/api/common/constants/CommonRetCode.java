package com.adu.api.common.constants;

import com.adu.api.common.bean.ErrorCode;

public interface CommonRetCode {
	ErrorCode SUCCESS = new ErrorCode(0, "success");
	ErrorCode NO_PERMISSION = new ErrorCode(1, "无权限");
	ErrorCode API_TIMEOUT = new ErrorCode(2, "超时");
	ErrorCode DATA_EXPIRED = new ErrorCode(3, "数据异常");
	ErrorCode ILLEGAL_PARAM = new ErrorCode(4, "参数有误");
	ErrorCode NO_LOGIN = new ErrorCode(5, "用户未登陆");
	ErrorCode UNKOWN_ERROR = new ErrorCode(9999, "未知异常");
}
