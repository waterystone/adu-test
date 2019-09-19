package com.adu.model;

/**
 * Http客户端的配置选项
 *
 * @author duyunjie
 * @date 2019-09-19 14:52
 */
public class HttpOptions {
    private Integer retryCount;//重试次数，默认null表示不重试。
    private Integer timeoutMs;//每次请求的超时时间，毫秒。

    public Integer getRetryCount() {
        return retryCount;
    }

    public HttpOptions setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public Integer getTimeoutMs() {
        return timeoutMs;
    }

    public HttpOptions setTimeoutMs(Integer timeoutMs) {
        this.timeoutMs = timeoutMs;
        return this;
    }

    @Override
    public String toString() {
        return "HttpOptions{" +
                "retryCount=" + retryCount +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}
