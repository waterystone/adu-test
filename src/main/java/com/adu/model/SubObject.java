package com.adu.model;

import com.adu.api.common.Stringfy;

/**
 * @author yunjie.du
 * @date 2016/12/22 17:37
 */
public class SubObject extends Stringfy {
    private String name;

    public SubObject() {
    }

    public SubObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
