package com.adu.enums;


public enum MyEnum {
    SUCC(0, "成功"),

    FAIL(-1, "失败");

    private final int code;
    private final String desc;

    MyEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MyEnum codeOf(int code) {
        for (MyEnum myEnum : MyEnum.values()) {
            if (myEnum.code == code) {
                return myEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    }
