package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
sealed abstract class Trade()
case class Sell(stockSymbol: String, quantity: Int) extends Trade
case class Buy(stockSymbol: String, quantity: Int) extends Trade
case class Hedge(stockSymbol: String, quantity: Int) extends Trade

class TradeProcessor{
	def processTransaction(trade: Trade): Unit ={
		trade match {
			case Sell(stock, 1000) => println(s"Selling 1000-quantity $stock")
			case Sell(stock, quantity) => println(s"Selling 1000-$quantity $stock")
			case Buy(stock, quantity) if(quantity > 10000)  => println(s"Buying ${quantity}(Large) $stock")
			case Buy(stock, quantity)  => println(s"Buying ${quantity} $stock")
			case Hedge(stock, quantity) => println(s"$stock")
		}
	}
}

object TradeProcessor extends App{
	val tradeProcessor = new TradeProcessor
	/*tradeProcessor.processTransaction(Sell("GOOGLE", 10100))
	tradeProcessor.processTransaction(Buy("GOOGLE", 1000))
	tradeProcessor.processTransaction(Buy("GOOGLE", 1000000))
	tradeProcessor.processTransaction(Hedge("GOOGLE", 1000000))*/
}
