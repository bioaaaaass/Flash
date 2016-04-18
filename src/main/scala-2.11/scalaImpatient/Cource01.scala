package scalaImpatient

import scala.util.Random

/**
  * Created by huangzhibo on 4/14/16.
  */
class Cource01 {

}

object Cource01 {
  def main(args: Array[String]) {
    BigInt.apply(100, Random)

    println(BigInt(Random.nextInt).toString(36))

    val str = "Hello"

    /**
      * 获取首字符
      */
    println(str(0))
    println(str.take(1))

    /**
      *  获取尾字符
      */
    println(str.reverse(0))
    println(str.takeRight(1))

  }
}
