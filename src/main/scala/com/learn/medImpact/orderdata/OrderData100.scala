package com.learn.medImpact.orderdata

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/27
  */
class OrderData100 {

}
object OrderData100 extends App{
	val orderNos:List[String] = List("101011705030460","101011705080230","101011705110480","101011705160200","101011705200060","101011705220280","101011705220280","101011705240270","101011705250400","101011705250400","101011705290430","101011706090350","101011706120390","101011706130220","101011706180050","101011706220310","101011706250060","101011706250180","101011706290270","101011706300290","101011707040100","101011707040100","101011707150070","101011707180280","101011707190170","101011707190170","101011707260360","101101706190070","101111705230190","101111705230200","101111706060050","101111706210110","101111706210110","101181706130010","101181706130010","101181707010010","101181707170030","101181707180100","101251705090030","101251706110020","101251706110020","101251706110020","101251706250060","101251707090200","101251707100130","101251707100130","101251707100130","101251707100150","101251707100150","101251707180040","101251707180040","101271705310050","101271705310050","101281705170040","101281705260010","101281706160020","101281706160020","101281707140050","102061705050020","102131706040010","102221705100100","102221706280090","102231707170020","102251705190060","102251705230230","102251705240080","102251706020110","102251706260060","102251706260390","102251706280170","102251706290120","102251707030140","102251707060200","102251707120190","102251707130170","102251707130170","102251707240220","102901705020130","102901705220290","102901706020100","102901706050290","102901706050300","102901706070310","102901706190120","102901706210090","102901706230020","102901707060080","102901707060170","102901707240050","102901707260090","102901707270200","102921705090020","102921707120040","102941705020030","102941707090040","102941707120440","102961705030380","102961705150460","102961705190070","102961705310170","102961706050330","102961706060390","102961706060390","102961706080110","102961706080350","102961706080350","102961706130140","102961706190400","102961706280060","102961707110170","102961707170250","102961707270200","102971706190280","102971707030220","102991705220040","102991706070060","103191705020030","103191705020030","103191707030080","103191707120050","103201707240040","103321706050070","103361707250010","103361707250010","103601706120130","103691706230010","103891706050260","103891706140080","103891706140080","103941706070030","103941706070030","103981707250010","103991706260060","104291706070020","104401705120040","104401706080070","104411706190030","104421705040030","104491705170010","104491707060060","104811705250030","104831705190030","104831705190030","104871706210020","104871706210020","104871706210020","104881706220030","104911706050050","104941707150010","105041706160010")
	println(orderNos.size)
	val distinctNos = orderNos.distinct
	println(distinctNos.mkString("','"))

}