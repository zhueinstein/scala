package com.learn.common.mongo.dto
import java.util.{List => JavaList, Map => JavaHashMap}

import org.bson.types.ObjectId
/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/6
  */
class CommonCaseClass {


}

case class OBJECT($oid: String)
case class DATE($date: String)
case class AuditCase(_id: OBJECT, _class: String, name:String, hospitalNum: Int, orderNum: Int, completionNum: Int,
                     isManuallyReview: Int, manuallyReviewNum: Int, status: Int, auditTime: DATE, createDate: DATE, updateDate: DATE,
                     error:String)


case class AuditOrderDrugPharmacology(categoryName: String)
case class AuditOrderDrugMainIngredient(ingredientId: String, ingredientName: String)
case class AuditOrderDrugApplyDiagnose(diseaseName: String)
case class AuditOrderDrugCategory(categoryCode: String, categoryName: String, layer: String)
case class AuditOrderDrug(drugCode: String, drugName: String, usage: String, number:String, price:String,
                            dosage: String, standard:String, producer: String, packageSize: String, maximumDose: String,
                            maximumDoseDaily: String, commonName: String,  conversionRatio: String, dosageForms: String, approvalNumber: String,
                            state: String, whScale: String, supplement: String, recommendDosage: String, monthUsage: String,
                                monthTreatmentExpense: String, clinicalGuideline: String, medicalInsuranceCategory: String, originatorProduct: String, effectType: String,
                          medicineConvenience: String, quotedCompany: String, scoreSummary: String, scoreRecommendGuide: String, scoreMedicalInsurance: String,
                          scoreOriginatorProduct: String,scoreEffectType: String,  scoreMedicineConvenience:String, scoreMarketRate: String, scoreMarketShare: String,
                          scoreQuotedCompany: String, categorys: JavaList[AuditOrderDrugCategory], applyDiagnose: JavaList[AuditOrderDrugApplyDiagnose], mainIngredients: JavaList[AuditOrderDrugMainIngredient], pharmacology: AuditOrderDrugPharmacology
                         )

case class AuditOrderHospital(hospialId: String, hospitalName: String)
case class AuditOrderDisease(diseaseCode: String, diseaseName: String)
case class AuditOrderPatientInsurance(name: String)
case class AuditOrderPatient(name: String, age:Int, sex: Int, idCard: String, isChronicDiseaseCard: Int, insurances: JavaList[AuditOrderPatientInsurance])
case class AuditOrder(_id: OBJECT, _class: String, caseId: String, orderNo: String,mainDiagnosis: String,
                      orderDate: java.util.Date,  cycle: Int, doctor:String, department:String,
                      status: Int, resultType: Int, totalMoney:String, updateDate: DATE, flags:Int,
                     patient:AuditOrderPatient, diseases: JavaList[AuditOrderDisease], hospital: AuditOrderHospital,
                      drugs: JavaList[AuditOrderDrug])

case class DeductionResult(drugCode: String, amount: String, grade: String, ruleId: String)
case class AuditResult(ruleId: String, resultType: Int, description: String, saveCount: String,uniqueMark: String,
	                                ruleName: String, ruleCaption: String, drugs: JavaList[String])
case class DrugScore(drugCode: String, score: Int)
case class Result(_id: OBJECT, _class: String, caseId: String, orderId: String, resultType: Int,
                       totalSave: String, grade: String, automaticAuditTime:DATE, manualAuditTime:DATE, drugScores: JavaHashMap[String, Int],
			automaticAuditResults: JavaList[AuditResult], automaticDeductionResults: JavaList[DeductionResult],manualDeductionResults:JavaList[DeductionResult]
                      )
case class DrugInfo(_id: ObjectId, var drugCode: String, var drugName: String, var standard:String,  var producer: String,
                    var packageSize: String, var maximumDose: String, var maximumDoseDaily: String, var commonName: String, var conversionRatio: String,
                    var dosageForms: String, var approvalNumber: String, var state: String, var whScale: String, var supplement: String,
                    var recommendDosage: String, var monthUsage: String, var monthTreatmentExpense: String, var clinicalGuideline: String, var medicalInsuranceCategory: String,
                    var originatorProduct: String, var effectType: String,  var medicineConvenience: String, var quotedCompany: String,  var scoreSummary: String,
                    var scoreRecommendGuide: String, var scoreMedicalInsurance: String, var scoreOriginatorProduct: String, var scoreEffectType: String,  var scoreMedicineConvenience:String,
                    var scoreMarketRate: String, var scoreMarketShare: String, var scoreQuotedCompany: String, var categorys: JavaList[AuditOrderDrugCategory], var applyDiagnose: JavaList[AuditOrderDrugApplyDiagnose],
                    var mainIngredients: JavaList[AuditOrderDrugMainIngredient], var pharmacology: AuditOrderDrugPharmacology, var scoreTreatmentExpense: String, var baseUnit: String, var baseDosage: String,
                    containsOriginatorProductProportion: String, originatorProductGenericDrugCostGap: String, containsOriginatorProductProportionReagent: String, masSolo: String)