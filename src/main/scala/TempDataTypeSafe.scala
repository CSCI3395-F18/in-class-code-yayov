

import org.apache.spark.sql.SparkSession

object TempDataTypeSafe extends App {
   val spark = SparkSession.builder().master("local[*]").appName("Temp Data").getOrCreate()
  import spark.implicits._
  
  spark.sparkContext.setLogLevel("WARN")
  
  
  
  spark.sparkContext.stop()
}