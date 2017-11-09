package com.learn.excel

import java.io.File

import com.learn.pickData.PickData
import info.folone.scala.poi.{Row, Sheet, Workbook}

import scala.io.Source
import info.folone.scala.poi.{NumericCell, Row, Sheet, StringCell, Workbook}

/**
  * Created by zcx on 2017/11/3.
  */
class ReadDrugScoreJson {
	var list: List[DrugExcelInfo] = List()
	import play.api.libs.json._
	implicit val drugFormat = Json.format[Drug]
	def readJSON() = {
		val file = new File("/Users/zcx/Downloads/drugScore.json")
		val source = Source.fromFile(file, "UTF-8")
		val lineIterator = source.getLines()
		val drugLists = lineIterator.map(l => Json.fromJson[Drug](Json.parse(l)).get).toSet
		val highest = drugLists.map(ds => ds.scoreSummary).reduce((b1,b2) => if(b1.doubleValue() > b2.doubleValue()) b1 else b2);
		var index = 0
		Workbook {
			Set(Sheet("正常处方") {
				drugLists.map(drug => {

					Row(index) {
						index match {
							case 0 => Set( {index += 1; StringCell(0, "产品编码")}, StringCell(1, "通用名"), StringCell(2, "商品名"), StringCell(3, "仿制药与原研药治疗费用差异"),
												StringCell(4, "是否临床指南推荐"),StringCell(5, "医保目录品类"),StringCell(6, "是否原研"), StringCell(7, "effect剂型"),
												StringCell(8,"服药便利性	"), StringCell(9, "市场占有率"), StringCell(10, "上市公司"),StringCell(11, "分数合计"),
												StringCell(12, "评分-指南推荐"), StringCell(13, "评分-医保等级"), StringCell(14, "评分-原研"),StringCell(15, "评分-剂型"),
												StringCell(16, "评分-用药便利"),  StringCell(17, "评级-市场份额"), StringCell(18, "评级-上市公司"),StringCell(19, "治疗费用评分"),
												StringCell(20, "专家意见调分"), StringCell(21, "毒副作用"),StringCell(22, "转换为100分"))
							case _ => Set({index += 1; StringCell(0, drug.drugCode)},
												StringCell(1, drug.commonName),
												StringCell(2, if(drug.drugName.isDefined) drug.drugName.get else " "),
												StringCell(3, if(drug.originatorProductGenericDrugCostGap.isDefined) drug.originatorProductGenericDrugCostGap.get.toString() else " "),
												StringCell(4, if(drug.clinicalGuideline.isDefined) drug.clinicalGuideline.get.toString else " "),
												StringCell(5, if(drug.medicalInsuranceCategory.isDefined) drug.medicalInsuranceCategory.get else " "),
												StringCell(6, if(drug.originatorProduct.isDefined) drug.originatorProduct.get else " "),
												StringCell(7, if(drug.effectType.isDefined) drug.effectType.get else " "),
												StringCell(8, if(drug.medicineConvenience.isDefined) drug.medicineConvenience.get else " "),
												StringCell(9, if(drug.marketShare.isDefined) drug.marketShare.get.toString() else " "),
												StringCell(10, if(drug.quotedCompany.isDefined) drug.quotedCompany.get else " "),
												NumericCell(11, drug.scoreSummary.toDouble),
												NumericCell(12, drug.scoreRecommendGuide.toDouble),
												NumericCell(13, drug.scoreMedicalInsurance.toDouble),
												NumericCell(14, drug.scoreOriginatorProduct.toDouble),
												NumericCell(15, drug.scoreEffectType.toDouble),
												NumericCell(16, drug.scoreMedicineConvenience.toDouble),
												NumericCell(17, drug.scoreMarketRate.toDouble),
												NumericCell(18, drug.scoreQuotedCompany.toDouble),
												NumericCell(19, drug.scoreTreatmentExpense.toDouble),
												if(drug.scoreExpertOpinion.isDefined)  NumericCell(20, drug.scoreExpertOpinion.get.toDouble ) else StringCell(20, " "),
												if(drug.scorePoisonousDrug.isDefined)  NumericCell(21, drug.scorePoisonousDrug.get.doubleValue() ) else StringCell(21, " "),
												NumericCell(22, (((BigDecimal(100) / highest) * drug.scoreSummary).setScale(0, BigDecimal.RoundingMode.HALF_UP) +
													(if(drug.scoreExpertOpinion.isDefined) drug.scoreExpertOpinion.get else BigDecimal(0)) +
													(if(drug.scorePoisonousDrug.isDefined) drug.scorePoisonousDrug.get else BigDecimal(0))).doubleValue())
							)
						}
					}
				})

			})


		}
	}

}

object ReadDrugScoreJson extends App{
	def apply: ReadDrugScoreJson = new ReadDrugScoreJson()
	val path = "/Users/zcx/scalaExcelTest/ttest.xls"
	ReadDrugScoreJson.apply.readJSON().safeToFile(path).fold(ex => throw ex, identity).unsafePerformIO()
}

case class Drug(drugCode: String, commonName:String , drugName: Option[String], originatorProductGenericDrugCostGap:Option[BigDecimal],
				clinicalGuideline:Option[Int], medicalInsuranceCategory: Option[String], originatorProduct: Option[String],effectType: Option[String],
				medicineConvenience:Option[String], marketShare: Option[BigDecimal], quotedCompany: Option[String],scoreSummary: BigDecimal,
				scoreRecommendGuide: BigDecimal, scoreMedicalInsurance:BigDecimal,scoreOriginatorProduct:BigDecimal, scoreEffectType:BigDecimal,
				scoreMedicineConvenience:BigDecimal,scoreMarketRate:BigDecimal,scoreQuotedCompany:BigDecimal, scoreTreatmentExpense:BigDecimal,
				scoreExpertOpinion:Option[BigDecimal], scorePoisonousDrug:Option[BigDecimal])
case class EDrug(index: Int, drug: Drug)