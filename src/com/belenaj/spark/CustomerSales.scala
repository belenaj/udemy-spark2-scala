package com.belenaj.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object CustomerSales {

  def parseLine(line:String)= {
    val fields = line.split(",")
    val customerID = fields(0)
    val productID = fields(1)
    val amount = fields(2).toDouble
    (customerID, productID, amount)
  }

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "CustomerSales")

    val lines = sc.textFile("./src/resources/customer-orders.csv")
    val parsedLines = lines.map(parseLine)


    val keyPair = parsedLines.map(x => (x._1, x._3))



   /* val maxTemps = parsedLines.filter(x => x._2 == "TMAX")
    val stationTemps = maxTemps.map(x => (x._1, x._3.toFloat))
    val maxTempsByStation = stationTemps.reduceByKey( (x,y) => max(x,y))
    val results = maxTempsByStation.collect()


*/
  }

}
