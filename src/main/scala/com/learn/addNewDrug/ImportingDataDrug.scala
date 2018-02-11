package com.learn.addNewDrug

import com.learn.common.excel.CommonExcelUtil
import com.learn.common.mongo.dao.CommonDao
import com.learn.common.mongo.dto.DrugInfo

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/11
  */

case class DrugInfoFromExcel(drugCode: String

//产品编码

, commonName: String // 通用名

, mainIngredients: String //主要化学成分

, drugCategory: String // 药品类别

, applyDiagnose: String //适应症

, drugName: String //商品名

, standard: String //规格

, packageUnit: String //包装单位

, commProducer: String //通用名+厂家

, price: String //零售价

, producer: String //生产企业

, masSolo: String //是否马鞍山独有

, containsOriginatorProductProportion: String //目录内是否有原研参比

, conversionRatio: String //转换比

, dosageForms: String // 剂型

, approvalNumber: String //批准文号

, state: String //状态

, whScale: String // 折扣

, supplement: String // 分类(正式 补充)

, recommendDosage: String //指南推荐剂量

, monthUsage: String //每月常规用量

, monthTreatmentExpense: String //每月治疗费用

, originatorProductGenericDrugCostGap: String //仿制药与原研药治疗费用差异

, containsOriginatorProductProportionReagent: String //是否有原研参比试剂

, clinicalGuideline: String //是否临床指南推荐

, medicalInsuranceCategory: String //医保目录品类

, originatorProduct: String //是否原研

, effectType: String //effect剂型

, medicineConvenience: String //服药便利性

, marketShare: String //市场占有率

, quotedCompany: String // 上市公司

//    private String approvalStandards; //持有的认证标准
, scoreSummary: String //分数合计

, scoreRecommendGuide: String //评分-指南推荐

, scoreMedicalInsurance: String //评分-医保等级

, scoreOriginatorProduct: String //评分-原研

, scoreEffectType: String //评分-剂型

, scoreMedicineConvenience: String //评分-用药便利

, scoreMarketRate: String //评级-市场排名

, scoreMarketShare: String //评级-市场份额

, scoreQuotedCompany: String //评级-上市公司

, scoreTreatmentExpense: String //治疗费用评分

//    private String scoreApprovalStandards; //评分-持有的认证标准
, scoreExpertOpinion: String //  专家意见调分

, scorePoisonousDrug: String // 毒副作用

/*private String scoreFinal; // 导入Excel等级分数
private String scoreFinalTransform; // 导入excel等级转化为100 的分数*/)
class ImportingDataDrug {
	val list = CommonExcelUtil[DrugInfoFromExcel](classOf[DrugInfoFromExcel])("/Users/zcx/Downloads/药品分级基础数据汇总_20171208.xlsx")
//	list.
}
object ImportingDataDrug extends App{
	val list = CommonExcelUtil[DrugInfoFromExcel](classOf[DrugInfoFromExcel])("/Users/zcx/Downloads/药品分级基础数据汇总_20171208.xlsx").readExcel("TestImporting")
//	list.map(ds => DrugInfo(null, ds.drugCode, ds.drugName, ds.standard, ds.producer,
//					ds.packageUnit))
//	val drugInfo = new DrugInfo()
//	CommonDao.saveDrugInfo()
}