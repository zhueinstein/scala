package com.learn.enums;


public enum APICodeEnum {

    // 根据业务逻辑往下排
    OK(0, "OK"),
    UNLOGIN(401,"用户名或密码错误"),
    ERROR(500,"系统内部错误"),

    // 统一参数异常
    PARAM_IS_EMPTY(101,"参数不允许为空"),
    JSON_FORMATTER_ERROR(102, "不是对应的JSON数据格式"),

    // AuditCases 参数
    CASESPARAM_IS_EMPTY(201,"审核任务参数不允许为空"),
    CASESPARAM_MANUALLYREVIEW(202,"审核任务:人工审核参数必须是0或1"),
    CASESPARAM_NAME_TOO_LONG(203,"分析任务名称过长，限制50字符"),
    CASESPARAM_FILE_JSONERROR(204,"上传文本必须是.json文件"),
    CASESPARAM_FILE_EMPTY(205,"上传文件不能为空"),

	RESULT_NOT_FOUND(1206,"数据不存在"),

    /** Result 相关 */
    RESULT_NO_EXIST(1001,"该审核结果不存在"),

    /** AuditCase 相关*/
    AUDITCASE_NOT_EXIST(2001,"该审核任务不存在"),
    AUDITCASE_STATUS_NOTERR(2002,"该审核任务状态不是错误状态，不允许删除"),

    /** AuditOrder 相关*/
    AUDITORDER_NO_EXIST(3001,"该结果不存在"),
    AUDITORDER_STATUS_FINISHED(3002,"该审核任务已完成，不允许修改");

    private int code;
    private String reason;

    APICodeEnum(final int statusCode, final String reasonPhrase) {
        this.code = statusCode;
        this.reason = reasonPhrase;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
