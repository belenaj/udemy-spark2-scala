package com.belenaj.spark

import org.apache.log4j._
import org.apache.spark._

import scala.math.min

/** Find the day with more precipitationsby weather station */
object DayMaxPrecipitations {
  
  def parseLine(line:String)= {
    val fields = line.split(",")
    val stationID = fields(0)
    val day = fields(1)
    val entryType = fields(2)
    val number_prcp = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (stationID, day, entryType, number_prcp)
  }
    /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "DayMaxPrecipitations")
    
    // Read each line of input data
    val lines = sc.textFile("./src/resources/1800.csv")
    
    // Convert to (stationID, day, entryType, number_prcp) tuples
    val parsedLines = lines.map(parseLine)
    
    // Filter out all but PRCP entries
    val prcp = parsedLines.filter(x => x._3 == "PRCP")

    for (result <- prcp.collect().sorted) {
      val station = result._1
      val day = result._2
      val num = result._4
      println(s"$station $day $num")
    }
    
    // Convert to (stationID, day, number_prcp)
    val stationDayPrcp = prcp.map(x => ((x._1 , x._2), x._4.toFloat))
    
    // Reduce by stationID retaining the minimum temperature found
    val minTempsByStation = stationDayPrcp.reduceByKey( (x,y) => min(x,y))
    // Collect, format, and print the results
    val results = minTempsByStation.collect()
    
    for (result <- results.sorted) {
       val station = result._1
       val temp = result._2
       val formattedTemp = f"$temp%.2f F"
     //  println(s"$station minimum temperature: $formattedTemp")
    }
      
  }
}