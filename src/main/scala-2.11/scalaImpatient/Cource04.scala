package scalaImpatient

import scala.collection.{SortedMap, mutable}
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.io.Source
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import java.util.{Calendar, TreeMap}

/**
  * Created by huangzhibo on 4/18/16.
  */
class Cource04 {

  def hashMapCount(path: String): HashMap[String, Int]={
    val source = Source.fromFile(path).mkString
    val tokens = source.split("\\s+")
    val words = new HashMap[String,Int]
    for (key <- tokens)
      words(key) = words.getOrElse(key,0)+1
    words
  }

  def sortedMapCount(path: String): SortedMap[String, Int]={
    val source = Source.fromFile(path).mkString
    val tokens = source.split("\\s+")
    var words = SortedMap[String,Int]()
    for (key <- tokens) words += (key -> (words.getOrElse(key,0) + 1))
    words
  }

  def treeMapCount(path: String)={
    val source = Source.fromFile(path).mkString
    val tokens = source.split("\\s+")
    val tree:Map[String,Int] = new TreeMap[String,Int]
    for (key <- tokens) tree(key) = tree.getOrElse(key,0)+1
    tree
  }

  def linkedHashMapCount={
    /**
      * 链式哈希表
      */
    val map = new mutable.LinkedHashMap[String,Int]

    map += ("Monday"->Calendar.MONDAY)
    map += ("Tuesday"->Calendar.TUESDAY)
    map += ("Wednesday"->Calendar.WEDNESDAY)
    map += ("Thursday"->Calendar.THURSDAY)
    map += ("Friday"->Calendar.FRIDAY)
    map += ("Saturday"->Calendar.SATURDAY)
    map += ("Sunday"->Calendar.SUNDAY)
  }

  def systemProperty={
    val props: scala.collection.Map[String,String] = System.getProperties()
    val keys = props.keySet
    val keyLengths = for (key <- keys) yield key.length
    val len = keyLengths.max
    for (key <- keys){
      print(key)
      print(" " * (len-key.length))
      print(" | ")
      println(props(key))
    }
  }

  def minmax(valus: Array[Int])={
    (valus.min, valus.min)
  }
  def lteqgt(values: Array[Int], v: Int)={
    var mins = 0
    var eqs = 0
    var maxs = 0
    for (elem <- values){
      if (elem > v) maxs += 1
      else if (elem == v) eqs += 1
      else mins += 1
    }
    (mins,eqs,maxs)

    /**
      * 简洁的写法
      */
    val a = values.toBuffer
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))
  }

}
object Cource04 {
  def main(args: Array[String]) {
    val maps = Map("book"->10,"gun"->18,"ipad"->1360)
    val map = for ((k,v)<-maps) yield (k,v*0.9)
    println(maps)
    println(map)

    val path = "/Users/huangzhibo/temporality/MyFile.txt"
    val c4 = new Cource04
    val res0 = c4.hashMapCount(path)
    println(res0)
    println(c4.sortedMapCount(path))
    println(c4.treeMapCount(path))
    println(c4.linkedHashMapCount)
    println(c4.systemProperty)
  }
}
