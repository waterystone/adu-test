package com.adu.lmax.disruptor;

import com.adu.api.common.Stringfy;

/**
 * @author duyunjie
 * @date 2019-07-11 20:55
 */
public class LogEvent extends Stringfy {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
