package scalaImpatient
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone.getAvailableIDs
import java.util.TimeZone.getTimeZone
import scala.math.random
/**
  * Created by huangzhibo on 4/14/16.
  */
class Cource03 {
  def randomArray(n: Int): Array[Int]={
    val a = for (i <- 0 until n) yield (random * n).toInt
    a.toArray
  }

  def reorderArray(arr: Array[Int]): Array[Int]={
    val t = arr.toBuffer
    for (i <- 0 until(t.length, 2) if (i+1) < t.length){
//      val a = t(i)
//      val b = t(i+1)
//      t.remove(i,2)
//      t.insert(i, b)
//      t.insert(i+1, a)
      val temp = t(i)
      t(i) = t(i+1)
      t(i+1) = temp
    }
    t.toArray
  }

  def reorderArr(arr: Array[Int]): Array[Int]={
    val t = arr.toBuffer
    val result = for (i <- 0 until t.length)
      yield if (i % 2 == 0 && i+1 < t.length)t(i+1)
      else if (i % 2 == 0 && i+1 >= t.length)t(i)
      else t(i-1)
    result.toArray
  }

  def reorderArray1(arr: Array[Int]): Array[AnyVal]={
    /**
      * wrong
      */
    //    val t = arr.toBuffer
//    var result = for (i <- 0 until(t.length))
//      yield if (t(i) > 0) t(i)
//    val res1 = for (i <- 0 until(t.length))
//      yield if (t(i) <= 0)t(i)
//    result ++= res1
//    result.toArray
    /**
      * right
      */
//    val a = ArrayBuffer[Int]()
//    val b = ArrayBuffer[Int]()
//    arr.foreach(arg => if (arg > 0) a+=arg else b+=arg)
//    a++=b
//    a.toArray
    /**
      *
      */
    val a = arr.filter(_ > 0).map(1 * _)
    val b = arr.filter(_ <= 0).map(1 * _)
    val c = a.toBuffer
    c ++= b
    c.toArray
  }

  def calculateAve(arr: Array[Double]): Double={
    arr.sum / arr.length
  }
  def reverseArr(arr: Array[Int]): Array[Int]={
    arr.reverse
  }
  def distictArr(arr: Array[Int]): Array[Int]={
    val a = arr.toBuffer
    a.distinct.toArray
  }

}
object Cource03{
  def main(args: Array[String]) {
    /**
      * mutable or immutable? why? how?
      */
    val s = Array("Hello", "World")
    val s1 = s
    println(s == s1)
    s(0) = "GoodBye"
    println(s == s1)
    println(s.mkString)
    println(s1.mkString)

//    for (i <- 0 until 10) println(i)
//    for (i <- 0 until(10 ,2)) println(i)
//    for (i <- (0 until 10).reverse) println(i)
    val a = Array(2,3,-1,5,0,7,-13,11,-23)
    val result = for (elem <- a) yield 2 * elem
    println(result.mkString(","))
    val res1 = for (elem <- a if elem % 2 == 0) yield elem * 2
    println(res1.mkString(","))
    val res2 = a.filter(_ % 2 == 0).map(2 * _)
    val res3 = a.filter(_ % 2 == 0) map (2 * _)
    println(res2.mkString(","))

    /**
      * 移除第一个负数外所有负数
      */
//    var first = true
//    var b = a.toBuffer
//    var n = b.length
//    var i = 0
//    while (i < n){
//      if (b(i) >= 0) i+=1
//      else {
//        if (first) {first = false; i+=1}
//        else {b.remove(i); i-=1}
//      }
//    }
//    println(b.mkString(","))

    val c3 = new Cource03
    val randArr = c3.randomArray(10)
    println(randArr.mkString(","))
    println(c3.reorderArray(randArr).mkString(","))
    println(c3.reorderArr(randArr).mkString(","))
    println(c3.reorderArray1(a).mkString(","))
    val timeZone = for (i <- getAvailableIDs) yield getTimeZone(i).getDisplayName()
    println(timeZone.mkString(","))
  }
}
