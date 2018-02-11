package com.learn.entity;


import com.learn.enums.FlagsEnum;
import com.learn.enums.StatusEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document(collection = "audit_order")
public class AuditOrder implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@Id
	private String orderId;
	private String caseId;
	private String orderNo;
	private Patient patient;
	private List<Disease> diseases;
	private String chiefComplaint;//主诉*
	private String mainDiagnosis;//主要诊断
	private String otherDiagnosis;//次要诊断
	private String deputyDiagnosis;//副诊断
	private List<Drug> drugs;
	private Date orderDate;//开具日期
	private Integer cycle;//用药周期
	private String doctor;//医生姓名
	private String department;//科室
	private Hospital hospital;//机构信息
	private Integer status = StatusEnum.AUDITORDER_STATUS_NOAUDIT.getCode(); //单据状态 0=未审核 5=审核中 10=待扣费 15=扣费中 20=待人工初审 25=人工初审中 30=待公示 35=待反馈 40=待人工复审 45=人工复审中 99=审核完成
	private Integer resultType;
	private BigDecimal totalMoney; //总金额，以分为单位的整数
	private Date createDate; //创建时间
	private Date updateDate; //更新时间
	private String manualAuditUser; //审核人
	private String auditOpinion;//人工审核意见
	private List<AuditOrder> sameDayAuditOrder;
	private long flags = 0;
	/** 医保类型 1市医保 2省医保*/
	private Integer medicareType;
	// 手动自动审核
	private Integer isManuallyReview; // 0 否 1 是

	public Integer getIsManuallyReview() {
		return isManuallyReview;
	}

	public void setIsManuallyReview(Integer isManuallyReview) {
		this.isManuallyReview = isManuallyReview;
	}

	public Integer getMedicareType() {
		return medicareType;
	}

	public void setMedicareType(Integer medicareType) {
		this.medicareType = medicareType;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	public long getFlags() {
		return flags;
	}
	public void setFlags(long flags) {
		this.flags = flags;
	}
	public Boolean testFlag(FlagsEnum flag) {
		return ((this.flags & flag.getCode()) > 0);
	}
	public void setFlag(FlagsEnum flag) {
		this.flags |= flag.getCode();
	}
	public void clrFlag(FlagsEnum flag) {
		this.flags &= ~flag.getCode();
	}
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public String getMainDiagnosis() {
		return mainDiagnosis;
	}
	public void setMainDiagnosis(String mainDiagnosis) {
		this.mainDiagnosis = mainDiagnosis;
	}
	public String getOtherDiagnosis() {
		return otherDiagnosis;
	}
	public void setOtherDiagnosis(String otherDiagnosis) {
		this.otherDiagnosis = otherDiagnosis;
	}
	public String getDeputyDiagnosis() {
		return deputyDiagnosis;
	}
	public void setDeputyDiagnosis(String deputyDiagnosis) {
		this.deputyDiagnosis = deputyDiagnosis;
	}
	public List<Drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
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
	public String getManualAuditUser() {
		return manualAuditUser;
	}
	public void setManualAuditUser(String manualAuditUser) {
		this.manualAuditUser = manualAuditUser;
	}
	public List<AuditOrder> getSameDayAuditOrder() {
		return sameDayAuditOrder;
	}
	public void setSameDayAuditOrder(List<AuditOrder> sameDayAuditOrder) {
		this.sameDayAuditOrder = sameDayAuditOrder;
	}
	public Integer getResultType() {
		return resultType;
	}
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	
	
	
}
