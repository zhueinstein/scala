package com.learn.excel

import com.learn.excel.utils.ExcelUtils
import info.folone.scala.poi.{FormulaCell, NumericCell, Row, Sheet, StringCell, Workbook}

import scala.math.BigDecimal.RoundingMode
import scalaz.{-\/, \/-}


/**
  * Created by zcx on 2017/9/13.
  * 用途： 读取excel文档
  */
class ReadExcel {


	var finalList: List[DrugExcelInfo] = List()
	def readExcel(): List[DrugExcelInfo] = {
		ExcelUtils.apply[DrugExcelInfo].readExcel("/Users/zcx/scalaExcelTest/20170915-芜湖市&马鞍山目录 药品打分-v1.0(1).xlsx")(printSheet)
		finalList
	}
	def printSheet(sheet: Sheet): Unit = {
			if(sheet.name.equals("马鞍山销售目录")){
				println(s"------------ ${sheet.name} ------------\n")
				val list:List[Row]  = sheet.rows.toList.filter( row => row.index != 0)
				list.foreach { row =>
					row match {
						case Row(index, _) => {
							if (index > 0 && index <= 160) {
								val  drug = new DrugExcelInfo
								 row.cells.toList.sortBy(_.index) .foreach { ss =>
									ss match {
										case StringCell(index, data) => addToList(index, data,drug)
										case NumericCell(index, data) => addToList(index, data.toString,drug)
										case FormulaCell(index, data) => addToList(index, data,drug)
										case _ => Some(None)
									}
								}
								println(drug.getApplyDiagnose)
								finalList = drug :: finalList
								drug
							}

						}
					}
				}
			}
	}

		def addToList(index: Int, data: String,drug:DrugExcelInfo):DrugExcelInfo ={

			index match {
				case 0 => if(!data.isEmpty) drug.setDrugCode(data.trim)
				case 1 => if(!data.isEmpty) drug.setCommonName(data.trim)
				case 2 => if(!data.isEmpty) drug.setMainIngredients(data.trim)
				case 3 => if(!data.isEmpty) drug.setDrugCategory(data.trim)
				case 4 => if(!data.isEmpty) drug.setMasSolo( BigDecimal(data).setScale(0).intValue())
				case 5 => if(!data.isEmpty) drug.setDrugName(data.trim)
				case 6 => if(!data.isEmpty) drug.setApplyDiagnose(data.trim)
				case 7 => if(!data.isEmpty) drug.setCommProducer(data.trim)
				case 8 => if(!data.isEmpty) drug.setContainsOriginatorProductProportion(data.trim)
				case 9 => if(!data.isEmpty) drug.setStandard(data.trim)
				case 10 => if(!data.isEmpty) drug.setConversionRatio(BigDecimal(data).setScale(0).intValue())
				case 11 => if(!data.isEmpty) drug.setDosageForms(data.trim)
				case 12 => if(!data.isEmpty) drug.setPackageUnit(data.trim)
				case 13 => if(!data.isEmpty) drug.setProducer(data.trim)
				case 14 => if(!data.isEmpty) drug.setApprovalNumber(data.trim)
				case 15 => if(!data.isEmpty) drug.setState(data.trim)
				case 16 => if(!data.isEmpty) drug.setPrice(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 17 => if(!data.isEmpty) drug.setWhScale(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 18 => if(!data.isEmpty) drug.setSupplement(data.trim)
				case 19 => if(!data.isEmpty) drug.setRecommendDosage(data.trim)
				case 20 => if(!data.isEmpty) drug.setMonthUsage(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 21 => if(!data.isEmpty) drug.setMonthTreatmentExpense(BigDecimal(data).setScale(4, RoundingMode.HALF_UP).bigDecimal)

				case 22 => if(!data.isEmpty) {val newData = data.replace("%", ""); println(newData); drug.setOriginatorProductGenericDrugCostGap(BigDecimal(newData).bigDecimal)}
				case 23 => if(!data.isEmpty) if(!data.isInstanceOf[BigDecimal]) drug.setContainsOriginatorProductProportionReagent(data)
				case 24 => if(!data.isEmpty) drug.setClinicalGuideline(BigDecimal(data).intValue())
				case 25 => if(!data.isEmpty) drug.setMedicalInsuranceCategory(data.trim)
				case 26 => if(!data.isEmpty) drug.setOriginatorProduct(data.trim)
				case 27 => if(!data.isEmpty) drug.setEffectType(data.trim)
				case 28 => if(!data.isEmpty) drug.setMedicineConvenience(data.trim)
				case 29 => if(!data.isEmpty) drug.setMarketShare(data.trim)
				case 30 => if(!data.isEmpty) drug.setQuotedCompany(data.trim)

				case 33 => if(!data.isEmpty) drug.setScoreSummary(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 34 => if(!data.isEmpty) drug.setScoreRecommendGuide(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 35 => if(!data.isEmpty) drug.setScoreMedicalInsurance(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 36 => if(!data.isEmpty) drug.setScoreOriginatorProduct(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 37 => if(!data.isEmpty) drug.setScoreEffectType(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 38 => if(!data.isEmpty) drug.setScoreMedicineConvenience(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 39 => if(!data.isEmpty) drug.setScoreMarketRate(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 40 => if(!data.isEmpty) drug.setScoreMarketShare(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 41 => if(!data.isEmpty) drug.setScoreQuotedCompany(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 42 => if(!data.isEmpty) drug.setScoreTreatmentExpense(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 44 => if(!data.isEmpty) drug.setScoreExpertOpinion(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 45 => if(!data.isEmpty) drug.setScorePoisonousDrug(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				/*case 46 => if(!data.isEmpty) drug.setScoreFinalTransform(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)
				case 47 => if(!data.isEmpty) drug.setScoreFinal(BigDecimal(data).setScale(2, RoundingMode.HALF_UP).bigDecimal)*/
				case _ =>

			}
			drug
		}
		//def xlsFile: InputStream = ReadExcelFile.getClass.getResourceAsStream("/test.xls")
		def readFileTest()={
			val readResult = Workbook("/Users/zcx/scalaExcelTest/20170915-芜湖市&马鞍山目录 药品打分-v1.0.xlsx")
				.map(workbook => workbook.sheets)
				.run
				.unsafePerformIO()

			readResult match {
				case -\/(exception) => throw new RuntimeException("Could not read file", exception)
				case \/-(sheets) => sheets.foreach{sheet =>
					sheet match {
						case Sheet(name, _) => name match {
							case "马鞍山销售目录" => {
								println(s"------------ ${sheet.name} ------------\n")
								val list:List[Row]  = sheet.rows.toList.filter( row => row.index != 0)
								list.foreach{row => row match {
									case Row(index) =>  if(index != 0) {
										println(row.cells.toList.sortBy(cell => cell.index).mkString(","))
									}}

								}
							}
							case _ =>
						}
					}

				}
			}
		}
}

object ReadExcel extends App{
	def apply: ReadExcel = new ReadExcel()

	val list= ReadExcel.apply.readExcel()
	println(list.size)

}

