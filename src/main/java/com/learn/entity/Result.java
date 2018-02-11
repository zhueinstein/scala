package com.learn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * 审核结果
 */
@Document(collection="audit_result")
public class Result implements Serializable{

	private static final long serialVersionUID = -4671052724624438758L;
	@Id
	private String resultId;
	private String caseId; // 任务id
	private String orderId; // 订单id
	private int resultType = 1;//审核结果 1=正常，2=可疑，3=违规
	private BigDecimal totalSave = BigDecimal.ZERO;//结余金额
	private String auditOpinion;//人工审核意见
	private BigDecimal grade = BigDecimal.ZERO; //评分
	private Date automaticAuditTime;  //自动审核时间
	private Date manualAuditTime;  //人工审核时间
	private List<AuditResult> automaticAuditResults;//自动审核结果
	private List<AuditResult> manualAuditResults;//人工审核结果
	private List<DeductionResult> automaticDeductionResults;//自动审核扣费结果
	private List<DeductionResult> manualDeductionResults;//人工审核扣费结果
	private Hashtable<String, Integer> drugScores;
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getResultType() {
		return resultType;
	}
	public void setResultType(int resultType) {
		this.resultType = resultType;
	}
	public BigDecimal getTotalSave() {
		return totalSave;
	}
	public void setTotalSave(BigDecimal totalSave) {
		this.totalSave = totalSave;
	}
	public String getAuditOpinion() {
		return auditOpinion;
	}
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public List<AuditResult> getAutomaticAuditResults() {
		return automaticAuditResults;
	}
	public void setAutomaticAuditResults(List<AuditResult> automaticAuditResults) {
		this.automaticAuditResults = automaticAuditResults;
	}
	public List<AuditResult> getManualAuditResults() {
		return manualAuditResults;
	}
	public void setManualAuditResults(List<AuditResult> manualAuditResults) {
		this.manualAuditResults = manualAuditResults;
	}
	public List<DeductionResult> getAutomaticDeductionResults() {
		return automaticDeductionResults;
	}
	public void setAutomaticDeductionResults(List<DeductionResult> automaticDeductionResults) {
		this.automaticDeductionResults = automaticDeductionResults;
	}
	public List<DeductionResult> getManualDeductionResults() {
		return manualDeductionResults;
	}
	public void setManualDeductionResults(List<DeductionResult> manualDeductionResults) {
		this.manualDeductionResults = manualDeductionResults;
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public Date getAutomaticAuditTime() {
		return automaticAuditTime;
	}

	public void setAutomaticAuditTime(Date automaticAuditTime) {
		this.automaticAuditTime = automaticAuditTime;
	}

	public Date getManualAuditTime() {
		return manualAuditTime;
	}

	public void setManualAuditTime(Date manualAuditTime) {
		this.manualAuditTime = manualAuditTime;
	}

	public Hashtable<String, Integer> getDrugScores() {
		return drugScores;
	}

	public void setDrugScores(Hashtable<String, Integer> drugScores) {
		this.drugScores = drugScores;
	}

	@Override
	public String toString() {
		return "Result{" +
				"resultId='" + resultId + '\'' +
				", caseId='" + caseId + '\'' +
				", orderId='" + orderId + '\'' +
				", resultType=" + resultType +
				", totalSave=" + totalSave +
				", auditOpinion='" + auditOpinion + '\'' +
				", grade=" + grade +
				", automaticAuditTime=" + automaticAuditTime +
				", manualAuditTime=" + manualAuditTime +
				", automaticAuditResults=" + automaticAuditResults +
				", manualAuditResults=" + manualAuditResults +
				", automaticDeductionResults=" + automaticDeductionResults +
				", manualDeductionResults=" + manualDeductionResults +
				'}';
	}
}
