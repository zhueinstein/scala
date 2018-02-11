package com.learn.entity;

import java.math.BigDecimal;
import java.util.List;

public class Patient {

	private String name;
	private Integer age;
	private Integer sex;
	private String idCard;
	private String weight;// "80", //体重 kg
	private String animalHeat; //"37.5", //体温 °c
	private Integer sphygmus;// 95, //脉搏
	private Integer heartRate;// 95, //心率
	private Integer systolicPressure;// 120, //收缩压（高压）
	private Integer diastolicPressure;// 90, //舒张压（低压）
	private String bloodGlucose;// "3.9", //血糖 毫摩尔/升
	private String auxiliaryExamination;// "辅助检查"
	private Integer isChronicDiseaseCard;  //是否门慢卡 0=否 1=是
	private List<Insurance> insurances;//保险

	private List<Disease> diseases;
	private String presentIllness;//现病史
	private String familyHistory; //家族病史
	private String pastHistory;//既往病史
	private String allergyHistory;//过敏病史

	@SuppressWarnings("rawtypes")
	private List medicalRecords;//就诊记录

	private BigDecimal Scr; // //血肌酐 以μmol/L 为单位
	private BigDecimal ALT; //
	private BigDecimal AST; //
	private BigDecimal TCHO; // 总胆固醇
	private List<String> historicSurgery; // 手术史
	private List<String> customHobbies; // 习惯 吸烟 喝酒等


	public List<String> getCustomHobbies() {
		return customHobbies;
	}

	public void setCustomHobbies(List<String> customHobbies) {
		this.customHobbies = customHobbies;
	}

	public BigDecimal getScr() {
		return Scr;
	}

	public void setScr(BigDecimal scr) {
		Scr = scr;
	}

	public BigDecimal getALT() {
		return ALT;
	}

	public void setALT(BigDecimal ALT) {
		this.ALT = ALT;
	}

	public BigDecimal getAST() {
		return AST;
	}

	public void setAST(BigDecimal AST) {
		this.AST = AST;
	}

	public BigDecimal getTCHO() {
		return TCHO;
	}

	public void setTCHO(BigDecimal TCHO) {
		this.TCHO = TCHO;
	}

	public List<String> getHistoricSurgery() {
		return historicSurgery;
	}

	public void setHistoricSurgery(List<String> historicSurgery) {
		this.historicSurgery = historicSurgery;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAnimalHeat() {
		return animalHeat;
	}

	public void setAnimalHeat(String animalHeat) {
		this.animalHeat = animalHeat;
	}

	public Integer getSphygmus() {
		return sphygmus;
	}

	public void setSphygmus(Integer sphygmus) {
		this.sphygmus = sphygmus;
	}

	public Integer getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	public Integer getSystolicPressure() {
		return systolicPressure;
	}

	public void setSystolicPressure(Integer systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public Integer getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(Integer diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public String getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(String bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public String getAuxiliaryExamination() {
		return auxiliaryExamination;
	}

	public void setAuxiliaryExamination(String auxiliaryExamination) {
		this.auxiliaryExamination = auxiliaryExamination;
	}

	public Integer getIsChronicDiseaseCard() {
		return isChronicDiseaseCard;
	}

	public void setIsChronicDiseaseCard(Integer isChronicDiseaseCard) {
		this.isChronicDiseaseCard = isChronicDiseaseCard;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPresentIllness() {
		return presentIllness;
	}

	public void setPresentIllness(String presentIllness) {
		this.presentIllness = presentIllness;
	}

	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getPastHistory() {
		return pastHistory;
	}

	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	public String getAllergyHistory() {
		return allergyHistory;
	}

	public void setAllergyHistory(String allergyHistory) {
		this.allergyHistory = allergyHistory;
	}

	@SuppressWarnings("rawtypes")
	public List getMedicalRecords() {
		return medicalRecords;
	}

	@SuppressWarnings("rawtypes")
	public void setMedicalRecords(List medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
