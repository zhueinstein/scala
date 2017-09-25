package com.learn.excel;

import java.math.BigDecimal;

/**
 * Created by zcx on 2017/9/14.
 * 产品编码√	通用名√	主要化学成分√	药品类别√	是否马鞍山独有√
 * 商品名√	适应症√	通用名+厂家√	目录内是否有原研参比√
 * 规格√	转换比√	剂型√	包装单位√	生产企业√	批准文号√	状态√	零售价√
 * 折扣√	分类√	指南推荐剂量√	每月常规用量√	月治疗费用√	仿制药与原研药治疗费用差异√
 * 是否有原研参比试剂√	是否临床指南推荐√	医保目录品类√	是否原研√	剂型√	服药便利性√
 * 同种产品市场占有率√	上市公司√	持有的认证标准x		分数合计√	评分-指南推荐√	评分-医保等级√
 * 评分-原研√	评分-剂型√
 * 评分-用药便利√	评级-市场排名√	评级-市场份额√	评级-上市公司√	治疗费用评分√	评分-持有的认证标准x
 */
public class DrugExcelInfo {
    private String drugCode;        //产品编码
    private String commonName;		// 通用名
    private String mainIngredients; //主要化学成分
    private String drugCategory; // 药品类别
    private String applyDiagnose;//适应症
    private String drugName;   //商品名
    private String standard; //规格
    private String packageUnit; //包装单位
    private String commProducer; //通用名+厂家
    private BigDecimal price; //零售价
    private String producer; //生产企业
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
//    private BigDecimal scoreApprovalStandards; //评分-持有的认证标准


    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public void setApplyDiagnose(String applyDiagnose) {
        this.applyDiagnose = applyDiagnose;
    }

    public String getDrugCategory() {
        return drugCategory;
    }

    public void setDrugCategory(String drugCategory) {
        this.drugCategory = drugCategory;
    }

    public Integer getMasSolo() {
        return masSolo;
    }

    public void setMasSolo(Integer masSolo) {
        this.masSolo = masSolo;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCommProducer() {
        return commProducer;
    }

    public void setCommProducer(String commProducer) {
        this.commProducer = commProducer;
    }

    public String getContainsOriginatorProductProportion() {
        return containsOriginatorProductProportion;
    }

    public void setContainsOriginatorProductProportion(String containsOriginatorProductProportion) {
        this.containsOriginatorProductProportion = containsOriginatorProductProportion;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
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

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWhScale() {
        return whScale;
    }

    public void setWhScale(BigDecimal whScale) {
        this.whScale = whScale;
    }

    public String getApplyDiagnose() {
        return applyDiagnose;
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
}
