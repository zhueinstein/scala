package com.learn.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Document(collection="drug_info")
public class Drug implements Serializable{

	private static final long serialVersionUID = 1L;
	private String drugCode;
	private String drugName;
	private String usage;
	private BigDecimal number;
	private BigDecimal price;
	private BigDecimal dosage;
	private String standard;
	private String producer;
	private List<Category> categorys;
	private List<Disease> applyDiagnose;
	private List<Ingredient> mainIngredients;
	private BigDecimal pillContent; // 药丸含量 以mg为单位
	private Integer packageSize; // 药品规格
	private BigDecimal maximumDose;		//单次最大用量
	private BigDecimal maximumDoseDaily;	//日最大用量
	private String commonName;		// 通用名
	private Category pharmacology;	//药理学分类 ----关联字典表（type= pharmacology）
	
	//2017年09月15日
	private Integer masSolo;    //是否马鞍山独有
	private String  containsOriginatorProductProportion; //目录内是否有原研参比
	private Integer conversionRatio; //转换比
	private String dosageForms; // 剂型
	private String approvalNumber; //批准文号
	private String state; //状态
	private BigDecimal whScale; // 折扣
	private String supplement;// 分类(正式 补充)
	private String recommendDosage; //指南推荐剂量
	private BigDecimal monthUsage; //每月常规用量
	private BigDecimal monthTreatmentExpense; //每月治疗费用
	private BigDecimal  originatorProductGenericDrugCostGap;  //仿制药与原研药治疗费用差异
	private String containsOriginatorProductProportionReagent;//是否有原研参比试剂
	private Integer clinicalGuideline; //是否临床指南推荐
	private String medicalInsuranceCategory; //医保目录品类
	private String originatorProduct; //是否原研
	private String effectType; //effect剂型
	private String medicineConvenience; //服药便利性
	private String marketShare; //市场占有率
	private String quotedCompany;// 上市公司
	//    private Integer approvalStandards; //持有的认证标准
	private BigDecimal scoreSummary; //分数合计
	private BigDecimal scoreRecommendGuide; //评分-指南推荐
	private BigDecimal scoreMedicalInsurance;//评分-医保等级
	private BigDecimal scoreOriginatorProduct; //评分-原研
	private BigDecimal scoreEffectType; //评分-剂型
	private BigDecimal scoreMedicineConvenience;//评分-用药便利
	private BigDecimal scoreMarketRate; //评级-市场排名
	private BigDecimal scoreMarketShare; //评级-市场份额
	private BigDecimal scoreQuotedCompany; //评级-上市公司
	private BigDecimal scoreTreatmentExpense; //治疗费用评分
	private BigDecimal scoreExpertOpinion; //  专家意见调分
	private BigDecimal scorePoisonousDrug; // 毒副作用
//    private BigDecimal scoreApprovalStandards; //评分-持有的认证标准

	private String baseUnit; // 药品基本使用单位 mg g ml
	private BigDecimal baseDosage; // 药品剂量 跟baseUnit是一组合


	public BigDecimal getBaseDosage() {
		return baseDosage;
	}

	public void setBaseDosage(BigDecimal baseDosage) {
		this.baseDosage = baseDosage;
	}

	public String getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getDosage() {
		return dosage;
	}
	public void setDosage(BigDecimal dosage) {
		this.dosage = dosage;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public List<Disease> getApplyDiagnose() {
		return applyDiagnose;
	}
	public void setApplyDiagnose(List<Disease> applyDiagnose) {
		this.applyDiagnose = applyDiagnose;
	}
	public List<Ingredient> getMainIngredients() {
		return mainIngredients;
	}
	public void setMainIngredients(List<Ingredient> mainIngredients) {
		this.mainIngredients = mainIngredients;
	}

	public Integer getPackageSize() {
		return packageSize;
	}

	public void setPackageSize(Integer packageSize) {
		this.packageSize = packageSize;
	}


	public BigDecimal getMaximumDose() {
		return maximumDose;
	}

	public void setMaximumDose(BigDecimal maximumDose) {
		this.maximumDose = maximumDose;
	}

	public BigDecimal getMaximumDoseDaily() {
		return maximumDoseDaily;
	}

	public void setMaximumDoseDaily(BigDecimal maximumDoseDaily) {
		this.maximumDoseDaily = maximumDoseDaily;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public Category getPharmacology() {
		return pharmacology;
	}
	public void setPharmacology(Category pharmacology) {
		this.pharmacology = pharmacology;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getMasSolo() {
		return masSolo;
	}

	public void setMasSolo(Integer masSolo) {
		this.masSolo = masSolo;
	}

	public String getContainsOriginatorProductProportion() {
		return containsOriginatorProductProportion;
	}

	public void setContainsOriginatorProductProportion(String containsOriginatorProductProportion) {
		this.containsOriginatorProductProportion = containsOriginatorProductProportion;
	}

	public Integer getConversionRatio() {
		return conversionRatio;
	}

	public void setConversionRatio(Integer conversionRatio) {
		this.conversionRatio = conversionRatio;
	}

	public String getDosageForms() {
		return dosageForms;
	}

	public void setDosageForms(String dosageForms) {
		this.dosageForms = dosageForms;
	}

	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getWhScale() {
		return whScale;
	}

	public void setWhScale(BigDecimal whScale) {
		this.whScale = whScale;
	}

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public String getRecommendDosage() {
		return recommendDosage;
	}

	public void setRecommendDosage(String recommendDosage) {
		this.recommendDosage = recommendDosage;
	}

	public BigDecimal getMonthUsage() {
		return monthUsage;
	}

	public void setMonthUsage(BigDecimal monthUsage) {
		this.monthUsage = monthUsage;
	}

	public BigDecimal getMonthTreatmentExpense() {
		return monthTreatmentExpense;
	}

	public void setMonthTreatmentExpense(BigDecimal monthTreatmentExpense) {
		this.monthTreatmentExpense = monthTreatmentExpense;
	}

	public BigDecimal getOriginatorProductGenericDrugCostGap() {
		return originatorProductGenericDrugCostGap;
	}

	public void setOriginatorProductGenericDrugCostGap(BigDecimal originatorProductGenericDrugCostGap) {
		this.originatorProductGenericDrugCostGap = originatorProductGenericDrugCostGap;
	}

	public String getContainsOriginatorProductProportionReagent() {
		return containsOriginatorProductProportionReagent;
	}

	public void setContainsOriginatorProductProportionReagent(String containsOriginatorProductProportionReagent) {
		this.containsOriginatorProductProportionReagent = containsOriginatorProductProportionReagent;
	}

	public Integer getClinicalGuideline() {
		return clinicalGuideline;
	}

	public void setClinicalGuideline(Integer clinicalGuideline) {
		this.clinicalGuideline = clinicalGuideline;
	}

	public String getMedicalInsuranceCategory() {
		return medicalInsuranceCategory;
	}

	public void setMedicalInsuranceCategory(String medicalInsuranceCategory) {
		this.medicalInsuranceCategory = medicalInsuranceCategory;
	}

	public String getOriginatorProduct() {
		return originatorProduct;
	}

	public void setOriginatorProduct(String originatorProduct) {
		this.originatorProduct = originatorProduct;
	}

	public String getEffectType() {
		return effectType;
	}

	public void setEffectType(String effectType) {
		this.effectType = effectType;
	}

	public String getMedicineConvenience() {
		return medicineConvenience;
	}

	public void setMedicineConvenience(String medicineConvenience) {
		this.medicineConvenience = medicineConvenience;
	}

	public String getMarketShare() {
		return marketShare;
	}

	public void setMarketShare(String marketShare) {
		this.marketShare = marketShare;
	}

	public String getQuotedCompany() {
		return quotedCompany;
	}

	public void setQuotedCompany(String quotedCompany) {
		this.quotedCompany = quotedCompany;
	}

	public BigDecimal getScoreSummary() {
		return scoreSummary;
	}

	public void setScoreSummary(BigDecimal scoreSummary) {
		this.scoreSummary = scoreSummary;
	}

	public BigDecimal getScoreRecommendGuide() {
		return scoreRecommendGuide;
	}

	public void setScoreRecommendGuide(BigDecimal scoreRecommendGuide) {
		this.scoreRecommendGuide = scoreRecommendGuide;
	}

	public BigDecimal getScoreMedicalInsurance() {
		return scoreMedicalInsurance;
	}

	public void setScoreMedicalInsurance(BigDecimal scoreMedicalInsurance) {
		this.scoreMedicalInsurance = scoreMedicalInsurance;
	}

	public BigDecimal getScoreOriginatorProduct() {
		return scoreOriginatorProduct;
	}

	public void setScoreOriginatorProduct(BigDecimal scoreOriginatorProduct) {
		this.scoreOriginatorProduct = scoreOriginatorProduct;
	}

	public BigDecimal getScoreEffectType() {
		return scoreEffectType;
	}

	public void setScoreEffectType(BigDecimal scoreEffectType) {
		this.scoreEffectType = scoreEffectType;
	}

	public BigDecimal getScoreMedicineConvenience() {
		return scoreMedicineConvenience;
	}

	public void setScoreMedicineConvenience(BigDecimal scoreMedicineConvenience) {
		this.scoreMedicineConvenience = scoreMedicineConvenience;
	}

	public BigDecimal getScoreMarketRate() {
		return scoreMarketRate;
	}

	public void setScoreMarketRate(BigDecimal scoreMarketRate) {
		this.scoreMarketRate = scoreMarketRate;
	}

	public BigDecimal getScoreMarketShare() {
		return scoreMarketShare;
	}

	public void setScoreMarketShare(BigDecimal scoreMarketShare) {
		this.scoreMarketShare = scoreMarketShare;
	}

	public BigDecimal getScoreQuotedCompany() {
		return scoreQuotedCompany;
	}

	public void setScoreQuotedCompany(BigDecimal scoreQuotedCompany) {
		this.scoreQuotedCompany = scoreQuotedCompany;
	}

	public BigDecimal getScoreTreatmentExpense() {
		return scoreTreatmentExpense;
	}

	public void setScoreTreatmentExpense(BigDecimal scoreTreatmentExpense) {
		this.scoreTreatmentExpense = scoreTreatmentExpense;
	}

	public BigDecimal getScoreExpertOpinion() {
		return scoreExpertOpinion;
	}

	public void setScoreExpertOpinion(BigDecimal scoreExpertOpinion) {
		this.scoreExpertOpinion = scoreExpertOpinion;
	}

	public BigDecimal getScorePoisonousDrug() {
		return scorePoisonousDrug;
	}

	public void setScorePoisonousDrug(BigDecimal scorePoisonousDrug) {
		this.scorePoisonousDrug = scorePoisonousDrug;
	}

	public BigDecimal getPillContent() {
		return pillContent;
	}

	public void setPillContent(BigDecimal pillContent) {
		this.pillContent = pillContent;
	}

	@Override
	public String toString() {
		return "Drug{" +
			"drugCode='" + drugCode + '\'' +
			", drugName='" + drugName + '\'' +
			", usage='" + usage + '\'' +
			", number=" + number +
			", price=" + price +
			", dosage=" + dosage +
			", standard='" + standard + '\'' +
			", producer='" + producer + '\'' +
			", categorys=" + categorys +
			", applyDiagnose=" + applyDiagnose +
			", mainIngredients=" + mainIngredients +
			", pillContent=" + pillContent +
			", packageSize=" + packageSize +
			", maximumDose=" + maximumDose +
			", maximumDoseDaily=" + maximumDoseDaily +
			", commonName='" + commonName + '\'' +
			", pharmacology=" + pharmacology +
			", masSolo=" + masSolo +
			", containsOriginatorProductProportion='" + containsOriginatorProductProportion + '\'' +
			", conversionRatio=" + conversionRatio +
			", dosageForms='" + dosageForms + '\'' +
			", approvalNumber='" + approvalNumber + '\'' +
			", state='" + state + '\'' +
			", whScale=" + whScale +
			", supplement='" + supplement + '\'' +
			", recommendDosage='" + recommendDosage + '\'' +
			", monthUsage=" + monthUsage +
			", monthTreatmentExpense=" + monthTreatmentExpense +
			", originatorProductGenericDrugCostGap=" + originatorProductGenericDrugCostGap +
			", containsOriginatorProductProportionReagent='" + containsOriginatorProductProportionReagent + '\'' +
			", clinicalGuideline=" + clinicalGuideline +
			", medicalInsuranceCategory='" + medicalInsuranceCategory + '\'' +
			", originatorProduct='" + originatorProduct + '\'' +
			", effectType='" + effectType + '\'' +
			", medicineConvenience='" + medicineConvenience + '\'' +
			", marketShare='" + marketShare + '\'' +
			", quotedCompany='" + quotedCompany + '\'' +
			", scoreSummary=" + scoreSummary +
			", scoreRecommendGuide=" + scoreRecommendGuide +
			", scoreMedicalInsurance=" + scoreMedicalInsurance +
			", scoreOriginatorProduct=" + scoreOriginatorProduct +
			", scoreEffectType=" + scoreEffectType +
			", scoreMedicineConvenience=" + scoreMedicineConvenience +
			", scoreMarketRate=" + scoreMarketRate +
			", scoreMarketShare=" + scoreMarketShare +
			", scoreQuotedCompany=" + scoreQuotedCompany +
			", scoreTreatmentExpense=" + scoreTreatmentExpense +
			", scoreExpertOpinion=" + scoreExpertOpinion +
			", scorePoisonousDrug=" + scorePoisonousDrug +
			'}';
	}
}
