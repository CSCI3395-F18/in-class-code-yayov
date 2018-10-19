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


object BeersLaw extends App {
  
  def calcAbsorbance(extinctionCoeff: Double, pathLength: Double, substrateConc:Double):Double = {
    
    val absorbance = extinctionCoeff * pathLength * substrateConc
    absorbance
    
  }
  
  def calcsubstrateConc(extinctionCoeff:Double, pathLength:Double, absorbance:Double):Double = {
      
    val substrateConc = (absorbance / (extinctionCoeff * pathLength))
    substrateConc
    
  }
  
  def calcextinctionCoeff(absorbance:Double, pathLength:Double, substrateConc:Double):Double = {
  
    val extinctionCoeff = (absorbance / (pathLength * substrateConc))
    extinctionCoeff
    
  }
  
  def BeersLawPlot(x: Array[Double], y:Array[Double], title:String, xLabel:String, yLabel:String):Unit = {
    
    val beerPlot = Plot.scatterPlotWithLines(x, y, title, xLabel, yLabel, 5, BlackARGB, 0, Renderer.StrokeData(1,Nil))
    SwingRenderer(beerPlot)
    
  }
}