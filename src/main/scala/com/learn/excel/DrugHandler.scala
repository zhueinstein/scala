package com.learn.excel

import com.mongodb.casbah.Imports._

import scala.math.BigDecimal.RoundingMode
/**
  * Created by zcx on 2017/9/14.
  *
  */
object DrugHandler extends App{
	val excelList = ReadExcel.apply.readExcel()
	val mongoList = MongoOperator.apply.drugInfo()

	val db = MongoOperator.apply.mongoClient("audit_test")
	val coll = db("drug_info")
	coll.drop()
	for (drugInfo <- mongoList) {
		val mb = drugInfo

		if(excelList.find(excel => excel.getDrugCode.equals(drugInfo.get("drugCode"))).isDefined) {
			val elem = excelList.find(mongo => mongo.getDrugCode().equals(drugInfo.get("drugCode"))).get
			val full = excelList.filter(dd => dd.getMarketShare != null).filter(execl => execl.getCommonName().equals(elem.getCommonName)).sortBy(drug => drug.getMarketShare)
			val top5 =  full.take(if(full.size > 5) 5 else full.size)
			if(elem.getMasSolo != null) mb += ("masSolo" -> elem.getMasSolo)
			if(elem.getContainsOriginatorProductProportion != null) mb += ("containsOriginatorProductProportion" -> elem.getContainsOriginatorProductProportion)
			if(elem.getConversionRatio != null) mb += ("conversionRatio" -> elem.getConversionRatio)
			if(elem.getDosageForms != null) mb += ("dosageForms" -> elem.getDosageForms)
			if(elem.getApprovalNumber != null) mb += ("approvalNumber" -> elem.getApprovalNumber)
			if(elem.getState != null) mb += ("state" -> elem.getState)
			if(elem.getWhScale != null) mb += ("whScale" -> elem.getWhScale.toString())
			if(elem.getSupplement != null) mb += ("supplement" -> elem.getSupplement)
			if(elem.getRecommendDosage != null) mb += ("recommendDosage" -> elem.getRecommendDosage)
			if(elem.getMonthUsage != null) mb += ("monthUsage" -> elem.getMonthUsage.toString())
			if(elem.getMonthTreatmentExpense != null) mb += ("monthTreatmentExpense" -> elem.getMonthTreatmentExpense.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getOriginatorProductGenericDrugCostGap != null) mb += ("originatorProductGenericDrugCostGap" -> elem.getOriginatorProductGenericDrugCostGap.setScale(4, RoundingMode.HALF_UP).toString())
			if(elem.getContainsOriginatorProductProportionReagent != null) mb += ("containsOriginatorProductProportionReagent" -> elem.getContainsOriginatorProductProportionReagent)
			if(elem.getClinicalGuideline != null) mb += ("clinicalGuideline" -> elem.getClinicalGuideline.toString)
			if(elem.getMedicalInsuranceCategory != null) mb += ("medicalInsuranceCategory" -> elem.getMedicalInsuranceCategory)
			if(elem.getOriginatorProduct != null) mb += ("originatorProduct" -> elem.getOriginatorProduct)
			if(elem.getEffectType != null) mb += ("effectType" -> elem.getEffectType)
			if(elem.getMedicineConvenience != null) mb += ("medicineConvenience" -> elem.getMedicineConvenience)
			if(elem.getMarketShare != null) {println(elem.getMarketShare); mb += ("marketShare" -> BigDecimal(elem.getMarketShare.replaceAll("%","")).setScale(2, RoundingMode.HALF_UP).toString())}
			if(elem.getQuotedCompany != null) mb += ("quotedCompany" -> elem.getQuotedCompany)
			if(elem.getScoreSummary != null) mb += ("scoreSummary" -> elem.getScoreSummary.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreRecommendGuide != null) mb += ("scoreRecommendGuide" -> elem.getScoreRecommendGuide.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreMedicalInsurance != null) mb += ("scoreMedicalInsurance" -> elem.getScoreMedicalInsurance.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreOriginatorProduct != null) mb += ("scoreOriginatorProduct" -> elem.getScoreOriginatorProduct.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreEffectType != null) mb += ("scoreEffectType" -> elem.getScoreEffectType.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreMedicineConvenience != null) mb += ("scoreMedicineConvenience" -> elem.getScoreMedicineConvenience.setScale(2, RoundingMode.HALF_UP).toString())
			if(top5 != null && top5.size > 0){
				if(elem.getMarketShare != null && top5.find(drug => drug.getDrugCode().equals(elem.getDrugCode())).isDefined) mb += ("scoreMarketRate" -> "1")
				else mb += ("scoreMarketRate" -> "0")

			}else{
				mb += ("scoreMarketRate" -> "0")
			}
			if(elem.getScoreMarketShare != null) mb += ("scoreMarketShare" -> elem.getScoreMarketShare.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreQuotedCompany != null) mb += ("scoreQuotedCompany" -> elem.getScoreQuotedCompany.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreTreatmentExpense != null) mb += ("scoreTreatmentExpense" -> elem.getScoreTreatmentExpense.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScoreExpertOpinion != null) mb += ("scoreExpertOpinion" -> elem.getScoreExpertOpinion.setScale(2, RoundingMode.HALF_UP).toString())
			if(elem.getScorePoisonousDrug != null) mb += ("scorePoisonousDrug" -> elem.getScorePoisonousDrug.setScale(2, RoundingMode.HALF_UP).toString())
//			if(elem.getScoreFinal != null) mb += ("scoreFinal" -> elem.getScoreFinal)
//			if(elem.getScoreFinalTransform != null) mb += ("scoreFinalTransform" -> elem.getScoreFinal)
		}
		coll.insert(mb)
	}
}
case class DrugInfoObject(drugCode: String, drugName: String ,usage: String, number: BigDecimal, price: BigDecimal,dosage: BigDecimal, standard: String,
						  producer:String, categorys: List[Category], applyDiagnose: List[Disease], mainIngredients: List[Ingredient],
						  packageSize: Int, maximumDose: BigDecimal, maximumDoseDaily: BigDecimal, commonName: String, pharmacology: Category,
						  masSolo: Int, containsOriginatorProductProportion: String, conversionRatio: Int, dosageForms: String,
						  approvalNumber: String, state: String, whScale: BigDecimal, supplement: String, recommendDosage: String, monthUsage: BigDecimal,
						  monthTreatmentExpense: BigDecimal, originatorProductGenericDrugCostGap: String, containsOriginatorProductProportionReagent: String,
						  clinicalGuideline: String, medicalInsuranceCategory: String, originatorProduct: String, effectType: String,
						  medicineConvenience: String,marketShare: String, quotedCompany: String, scoreSummary: BigDecimal, scoreRecommendGuide: BigDecimal,
						  scoreMedicalInsurance: BigDecimal, scoreOriginatorProduct: BigDecimal, scoreEffectType: BigDecimal, scoreMedicineConvenience: BigDecimal,
						  scoreMarketRate: BigDecimal, scoreMarketShare: BigDecimal, scoreQuotedCompany:BigDecimal, scoreTreatmentExpense:BigDecimal,
						  scoreExpertOpinion: BigDecimal, scorePoisonousDrug:BigDecimal/*,scoreFinal:BigDecimal, scoreFinalTransform:BigDecimal*/
						 )
