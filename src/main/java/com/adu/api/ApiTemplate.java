package com.adu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.api.common.constants.CommonRetCode;
import com.adu.api.common.exceptions.BizException;

public abstract class ApiTemplate<T> {
	protected String monitorKey;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected ApiTemplate(String monitorKey) {
		this.monitorKey = monitorKey;
	}

	protected void checkParams() {
	}

	protected abstract T process() throws BizException;

	protected void afterProcess() {
	}

	protected void onSuccess() {
	}

	protected void onError(Throwable e) {
	}

	public APIResponse<T> execute() {
		try {
			checkParams();
		} catch (IllegalArgumentException e) {
			logger.error("[ERRPR-PARAM-{}]", monitorKey, e);
			return APIResponse.returnFail(CommonRetCode.ILLEGAL_PARAM);
		}

		long start = System.currentTimeMillis();
		try {
			T result = process();
			onSuccess();
			return APIResponse.returnSuccess(result);
		} catch (BizException biz) {
			logger.error("[ERROR-BizException-{}]", monitorKey, biz);
			onError(biz);
			return APIResponse.returnFail(biz.getErrorCode());
		} catch (Throwable e) {
			logger.warn("[ERROR-UnknownException-{}]", monitorKey, e);
			onError(e);
			return APIResponse.returnFail(CommonRetCode.UNKOWN_ERROR);
		} finally {
			afterProcess();
			logger.info("[elapsed-time-{}]time={}ms", monitorKey, System.currentTimeMillis() - start);
		}
	}
}
