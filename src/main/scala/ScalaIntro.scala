//package scalaintro

import scala.io.Source

case class TempData(day:Int, doy: Int, month: Int, year: Int, precip: Double, tave: Double, tmax: Double, tmin: Double)

object TempData extends App {
	def parseLine(line: String): TempData = {
		val p = line.split(",")
		TempData(p(0).toInt, p(1).toInt, p(2).toInt, p(4).toInt, p(5).toDouble,
			p(6).toDouble, p(7).toDouble, p(8).toDouble)
	}

	val source = Source.fromFile("data/SanAntonioTemps.csv")
	val lines = source.getLines.drop(2)
	val data = lines.map(parseLine).toArray
	source.close()

	data.foreach(println)
}