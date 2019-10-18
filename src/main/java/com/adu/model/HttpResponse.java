package com.adu.model;

import java.util.Map;

/**
 * Http请求的返回结果
 *
 * @author duyunjie
 * @date 2019-10-18 14:34
 */
public class HttpResponse {
    private int statusCode; //http状态码
    private String result; //返回结果
    private Map<String, String> headers; //返回的header

    public int getStatusCode() {
        return statusCode;
    }

    public HttpResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getResult() {
        return result;
    }

    public HttpResponse setResult(String result) {
        this.result = result;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpResponse setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "statusCode=" + statusCode +
                ", result='" + result + '\'' +
                ", headers=" + headers +
                '}';
    }
}
