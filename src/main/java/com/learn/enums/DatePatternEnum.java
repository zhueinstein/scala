package com.learn.enums;

public enum DatePatternEnum {
    YMD(1,"yyyy-MM-dd"),
    YMDHMS(2,"yyyy-MM-dd HH:mm:ss");

    private int dateCode;
    private String pattern;

    DatePatternEnum(int dateCode, String pattern) {
        this.dateCode = dateCode;
        this.pattern = pattern;
    }

    public int getDateCode() {
        return dateCode;
    }

    public String getPattern() {
        return pattern;
    }
}
