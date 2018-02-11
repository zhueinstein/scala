package com.learn.enums;

/**
 * 状态类型枚举
 */
public enum StatusEnum {

    /** 审核任务状态 */
    AUDIT_STATUS_ERROR(-1,"异常"),
    AUDIT_STATUS_UNSTART(0,"未开始"),
    AUDIT_STATUS_DATA_FILTER(2,"数据过滤中"),
    AUDIT_STATUS_PRE_AUTO_ANALYSING(5,"待自动分析"),
    AUDIT_STATUS_AUTO_ANALYSING(10,"自动分析中"),
    AUDIT_STATUS_WAIT_ANALYZED(20,"待人工分析"),
    AUDIT_STATUS_FINISHED(99,"分析完成"),

    AUDIT_STATUS_NOT_MANUALLYREVIEW(0,"不需要人工审核"), // 是否需要人工审核 0=否 1=是
    AUDIT_STATUS_MANUALLYREVIEW(1,"需要人工审核"),

    /** 单据auditOrder状态 0=未审核 5=审核中  40=待人工审核  99=审核完成 */
    AUDITORDER_STATUS_NOAUDIT(0,"未审核"),
    AUDITORDER_STATUS_AUDITING(5,"自动审核中"),
    AUDITORDER_STATUS_PENDINGARTIFICIALREVIEW(40,"待人工审核"),
    AUDITORDER_STATUS_FINISHED(99,"审核完成"),

    ;

    private int code;
    private String result;

    StatusEnum(int code, String result) {
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
