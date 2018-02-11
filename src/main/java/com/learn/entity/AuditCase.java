package com.learn.entity;

import com.learn.enums.StatusEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核任务
 * */
@Document(collection = "audit_case")
public class AuditCase implements Serializable {
	private static final long serialVersionUID = -2480732784884191249L;

	@Id
	private String caseId;  //任务id
	private String name;  //任务名称
	private Region region;  //区域
	private Integer hospitalNum = 0;  //机构数量
	private Integer orderNum = 0;  //
	private Integer completionNum = 0;  //完成数量
	private Integer isManuallyReview = 0;  //是否需要人工审核 0=否 1=是
	private Integer manuallyReviewNum = 0;  //待人工审核数量
	private Integer status = StatusEnum.AUDIT_STATUS_UNSTART.getCode();  //状态 0=未开始,10=自动分析中，20=待人工分析，99=分析完成  -1=错误
	private Date auditTime;
	private Date createDate; //创建时间
	private Date updateDate; //更新时间
	private String error;

	public AuditCase(){
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Integer getHospitalNum() {
		return hospitalNum;
	}

	public void setHospitalNum(Integer hospitalNum) {
		this.hospitalNum = hospitalNum;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getCompletionNum() {
		return completionNum;
	}

	public void setCompletionNum(Integer completionNum) {
		this.completionNum = completionNum;
	}

	public Integer getIsManuallyReview() {
		return isManuallyReview;
	}

	public void setIsManuallyReview(Integer isManuallyReview) {
		this.isManuallyReview = isManuallyReview;
	}

	public Integer getManuallyReviewNum() {
		return manuallyReviewNum;
	}

	public void setManuallyReviewNum(Integer manuallyReviewNum) {
		this.manuallyReviewNum = manuallyReviewNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "AuditCase{" +
				"caseId='" + caseId + '\'' +
				", name='" + name + '\'' +
				", region=" + region +
				", hospitalNum=" + hospitalNum +
				", orderNum=" + orderNum +
				", completionNum=" + completionNum +
				", isManuallyReview=" + isManuallyReview +
				", manuallyReviewNum=" + manuallyReviewNum +
				", status=" + status +
				", auditTime=" + auditTime +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				", error='" + error + '\'' +
				'}';
	}
}
