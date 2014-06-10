package SortingAlgorithms

import scala.collection.mutable.ArraySeq
import SortingAlgorithms._
import java.util.Random
import scala.language.postfixOps
import spire.implicits._
import spire.random.immutable.Generator
import spire.algebra.Group
import spire.algebra.Order

import Helpers._

object SortingDoubleTest {
	def main(args: Array[String]): Unit = {
			
			implicit object myGroup extends Group[Double]{
			  def id = 0
			  def inverse(a:Double):Double = -a
			  def op(x:Double,y:Double):Double = x+y
			}
			implicit object myOrder extends Order[Double]{
			  def compare(x:Double,y:Double):Int = 
    	  	  if(x<y) -1 
    	  	  else if (x > y) 1
    	  	  else 0
			}
			//val r = new Random()
			val arrayGenerator = ArrayGenerator
			//val doubleArray = generateArray(1000,ArraySeq[Double](1000),r)
			val doubleArray = arrayGenerator.generateArray(1000,ArraySeq[Double](1000))
			val heapSortArray = doubleArray
			val quickSortArray = doubleArray
			val insertionSortArray = doubleArray
			val mergeSortArray = doubleArray
			val shellSortArray = doubleArray
			println("Unsorted array:")
			println(doubleArray)
			println("----------------------------------------")
			println("Sorted array with HeapSort")
			TimeProfiler.time{HeapSort.sort(heapSortArray)(myOrder,myGroup)}
			println("----------------------------------------")
			println("Sorted array with QuickSort")
			TimeProfiler.time{QuickSort.sort(quickSortArray)(myOrder,myGroup)}
			println("----------------------------------------")
			println("Sorted array with InsertionSort")
			TimeProfiler.time{InsertionSort.sort(insertionSortArray)(myOrder,myGroup)}
			println("----------------------------------------")
			println("Sorted array with MergeSort")
			TimeProfiler.time{MergeSort.sort(mergeSortArray)(myOrder,myGroup)}
			println("----------------------------------------")
			println("Sorted array with ShellSort")
			TimeProfiler.time{ShellSort.sort(shellSortArray)(myOrder,myGroup)}
			println("----------------------------------------")
			println("Sorted array:")
			println(shellSortArray) 

	}


}