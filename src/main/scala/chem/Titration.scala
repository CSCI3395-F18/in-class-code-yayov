package chem

import scala.io.Source
import swiftvis2.plotting
import swiftvis2.plotting._
import swiftvis2.plotting.renderer.SwingRenderer
import swiftvis2.plotting.ColorGradient
import swiftvis2.plotting.styles.HistogramStyle
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import swiftvis2.spark._
import org.apache.spark.rdd.RDD
import java.time.LocalDate
import swiftvis2.plotting.renderer.Renderer

object Titration extends App {

  def calcpH(hConc: Double): Double = {
    val pH = -math.log(hConc)
    pH
  }

  def calcHConc(pH: Double): Double = {
    val hConc = math.pow(10, -pH)
    hConc
  }

  def pHvsVolTitrant(volTitrant: Array[Double], pH: Array[Double], title: String, xLabel: String, yLabel: String): Unit = {

    val pHvsVolTitrantPlot = Plot.scatterPlotWithLines(volTitrant, pH, title, xLabel, yLabel, 5, BlackARGB, 0, Renderer.StrokeData(1, Nil))
    SwingRenderer(pHvsVolTitrantPlot)

  }

  def GranPlot(volTitrant: Array[Double], volTitrantnegpH: Array[Double], pH: Array[Double], title: String, xLabel: String, yLabel: String): Unit = {
    
    val pHatVolTitrant = (volTitrant, pH).zipped.map((x, y) => x * math.pow(10, -y))
    val granPlot = Plot.scatterPlotWithLines(volTitrant, volTitrantnegpH, title, xLabel, yLabel, 5, BlackARGB, 0, Renderer.StrokeData(1, Nil))
    SwingRenderer(granPlot)
 
  }
  
}