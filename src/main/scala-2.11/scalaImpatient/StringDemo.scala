package scalaImpatient

/**
  * Created by huangzhibo on 4/14/16.
  */
class StringDemo {
  val str: String = ""
}
object StringDemo {
  def main(args: Array[String]) {
    println("Hello".intersect("World"))

    /**
      * create a appointed places random prime
      */
    println(BigInt.probablePrime(100, scala.util.Random))

    /**
      * remove the
      */
    println("Hello".distinct)

    println("Hello".count(_.isUpper))

    val s = "Harry"
    val s1 = s.patch(1, "ung", 2)
    println(s1)
    println("Harry".patch(1, "ung", 2))
  }
}
