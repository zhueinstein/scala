package com.learn.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AuditResult {

	private String ruleId;
	private Integer resultType;//审核结果 1=正常，2=可疑，3=违规
	private String description;//描述
	private BigDecimal saveCount; // 规则节省药品数量，在人工审核时使用
	private String uniqueMark; // 扣费使用
	private List<String> drugs = new ArrayList<>();
	private String ruleName;
	private String ruleCaption; // 规则说明

	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getResultType() {
		return resultType;
	}
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<String> drugs) {
		this.drugs = drugs;
	}

	public BigDecimal getSaveCount() {
		return saveCount;
	}

	public void setSaveCount(BigDecimal saveCount) {
		this.saveCount = saveCount;
	}

	public String getUniqueMark() {
		return uniqueMark;
	}

	public void setUniqueMark(String uniqueMark) {
		this.uniqueMark = uniqueMark;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleCaption() {
		return ruleCaption;
	}

	public void setRuleCaption(String ruleCaption) {
		this.ruleCaption = ruleCaption;
	}
}
