package com.adu.enums;

import java.util.Map;

import com.google.common.collect.Maps;

public enum MyEnum {
    SUCC(0, "成功"),

    FAIL(-1, "失败");

    private final int code;
    private final String desc;

    MyEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, MyEnum> codeMap = Maps.newHashMapWithExpectedSize(MyEnum.values().length);
    static {
        for (MyEnum myEnum : MyEnum.values()) {
            codeMap.put(myEnum.getCode(), myEnum);
        }
    }

    public static MyEnum codeOf(int code) {
        return codeMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
