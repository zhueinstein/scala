package com.learn.entity;

import java.math.BigDecimal;

public class DeductionResult {
	private String drugCode;
	private BigDecimal amount = BigDecimal.ZERO;//扣费后剩余数量        
	private BigDecimal grade = BigDecimal.ZERO;//评分
	private String ruleId;
	

	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
}
