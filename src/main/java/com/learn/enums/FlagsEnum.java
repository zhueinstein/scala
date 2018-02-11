package com.learn.enums;

/**
 * 标志位类型枚举
 */
public enum FlagsEnum {

	AUDIT_FLAGS_WAIT_ANALYZED(1,"待人工审核"),
    

    ;

    private int code;
    private String result;

    FlagsEnum(int code, String result) {
        this.code = code;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public String getResult() {
        return result;
    }
}
