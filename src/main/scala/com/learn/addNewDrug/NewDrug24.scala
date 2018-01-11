package com.learn.addNewDrug

import com.learn.excel.MongoOperator
import com.learn.excel.utils.ExcelUtils
import com.mongodb.casbah.Imports._
import info.folone.scala.poi.{FormulaCell, NumericCell, Row, Sheet, StringCell}

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/11
  */
object NewDrug24 {
	var finalList: List[NewDrug] = List()
	def readExcel(): List[NewDrug] = {
		ExcelUtils.apply[NewDrug].readExcel("/Users/zcx/scalaExcelTest/药品信息清理-补充信息.xlsx")(printSheet)
		finalList
	}
	def printSheet(sheet: Sheet): Unit = {
		if(sheet.name.equals("工作表1")){
			println(s"------------ ${sheet.name} ------------\n")
			val list:List[Row]  = sheet.rows.toList.filter( row => row.index != 0)
			list.foreach { row =>
				row match {
					case Row(index, _) => {
						if (index > 0) {
							val  drug = new NewDrug()
							row.cells.toList.sortBy(_.index) .foreach { ss =>
								ss match {
									case StringCell(index, data) => addToList(index, data,drug)
									case NumericCell(index, data) => addToList(index, data.toString,drug)
									case FormulaCell(index, data) => addToList(index, data,drug)
									case _ => Some(None)
								}
							}
							finalList = drug :: finalList
						}
					}
				}
			}
		}
	}

	def addToList(index: Int, data: String,drug:NewDrug) ={

		index match {
			case 0 => if(!data.isEmpty) drug.name = data.trim
			case 1 => if(!data.isEmpty) drug.orderNum = BigDecimal(data.trim).intValue()
			case 2 => if(!data.isEmpty) drug.isCompare = data.trim
			case 3 => if(!data.isEmpty) drug.lv1 = data.trim
			case 4 => if(!data.isEmpty) drug.lv2 =  data.trim
			case 5 => if(!data.isEmpty) drug.lv3 = data.trim
			case 6 => if(!data.isEmpty) drug.lv4 = (data.trim)
			case 7 => if(!data.isEmpty) drug.lv5 = (data.trim)
			case 8 => if(!data.isEmpty) drug.lv6 = (data.trim)
			case 9 => if(!data.isEmpty) drug.lv7 = (data.trim)
			case 10 => if(!data.isEmpty) drug.dosage1 = (data.trim)
			case 11 => if(!data.isEmpty) drug.dosage2 = (data.trim)
			case 12 => if(!data.isEmpty) drug.indication = (data.trim)
			case 13 => if(!data.isEmpty) drug.commonName = (data.trim)
			case 14 => if(!data.isEmpty) drug.drugName = (data.trim)
			case _ =>

		}
	}

	def main(args: Array[String]): Unit = {
		val db = MongoOperator.apply.mongoClient("audit_test")
		val tb = db("drug_info")
		val thisList = tb.find().toList
		println(tb.size)
		readExcel().foreach(ds => {
			thisList.filter(d_ => d_.get("commonName") == ds.commonName).filter(da => da.get("categorys") == null ||
				(if(da.get("categorys").isInstanceOf[BasicDBList]) {
					da.get("categorys").asInstanceOf[BasicDBList].size == 0
				}else if(da.get("categorys").isInstanceOf[MongoDBList]){
					da.get("categorys").asInstanceOf[MongoDBList].size == 0
				}else{
					false
				}
					)).foreach(dd =>{
				val categorys = MongoDBList.empty
				val lv1 = MongoDBObject.empty
				if(ds.lv1 != null){
					lv1 += ("categoryName" -> ds.lv1)
					lv1 += ("layer" -> "1")
					categorys += lv1
				}
				val lv2 = MongoDBObject.empty
				if(ds.lv2!= null){
					lv2 += ("categoryName" -> ds.lv2)
					lv2 += ("layer" -> "2")
					categorys += lv2
				}
				val lv3 =  MongoDBObject.empty
				if(ds.lv3 != null){
					lv3 += ("categoryName" -> ds.lv3)
					lv3 += ("layer" -> "3")
					categorys += lv3
				}
				val lv4 =  MongoDBObject.empty
				if(ds.lv4 != null){
					lv4 += ("categoryName" -> ds.lv4)
					lv4 += ("layer" -> "4")
					categorys += lv4
				}
				val lv5 =  MongoDBObject.empty
				if(ds.lv5 != null){
					lv5 += ("categoryName" -> ds.lv5)
					lv5 += ("layer" -> "5")
					categorys += lv5
				}
				val lv6 =  MongoDBObject.empty
				if(ds.lv6 != null){
					lv6 += ("categoryName" -> ds.lv6)
					lv6 += ("layer" -> "6")
					categorys += lv6
				}
				dd += ("categorys" -> categorys)
				if(ds.lv7 != null){
					val mainIngredients = MongoDBList.empty
					ds.lv7.replaceAll(" ", ",").replaceAll("、",",").replaceAll("，",",").replaceAll(";",",").split(",").foreach(d7 =>{
						val mongoDBObject = MongoDBObject.empty
						mongoDBObject += ("ingredientName" -> d7)
						mainIngredients += mongoDBObject
					})
					dd += ("mainIngredients" -> mainIngredients)
				}
				if(ds.indication != null){
					val applyDiagnoses = MongoDBList.empty
					ds.indication.replaceAll(" ", ",").replaceAll("、",",").replaceAll("，",",").replaceAll(";",",").split(",").foreach(din =>{
						val applyDiagnose = MongoDBObject.empty
						applyDiagnose += ("diseaseName" -> din)
						applyDiagnoses += applyDiagnose
					})
					dd += ("applyDiagnose" -> applyDiagnoses)
				}
				tb.save(dd)
				println(dd)
			})

		})
	}
}

 class NewDrug{
	var name: String = null
	var orderNum:Int = 0
	var isCompare: String = null
	var lv1: String = null
	var lv2:String = null
	var lv3:String = null
	var lv4:String = null
	var lv5:String = null
	var lv6:String = null
	var lv7:String = null
	var dosage1:String = null
	var dosage2:String = null
	var indication:String = null
	var commonName:String = null
	var drugName:String = null
        override def toString = s"NewDrug(name=$name, orderNum=$orderNum, isCompare=$isCompare, lv1=$lv1, lv2=$lv2, lv3=$lv3, lv4=$lv4, lv5=$lv5, lv6=$lv6, lv7=$lv7, dosage1=$dosage1, dosage2=$dosage2, indication=$indication, commonName=$commonName, drugName=$drugName)"
 }