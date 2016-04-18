package scalaImpatient

/**
  * Created by huangzhibo on 4/14/16.
  */
class Cource02 {

}
object Cource02 {
  def sum(args: Int*) ={
    var result = 0
    for (arg <- args) result += arg
    result
  }
  def box(s: String){
    var border = "-" * s.length + "--\n"
    print(border + "|" + s + "|\n" + border)
  }

  def signNum(x: Int) ={
    if (x > 0) 1
    else if (x < 0) -1
    else 0

    //if (x > 0) 1 else if (x < 0) -1 else 0
  }

  def unicodeSum(args: String):Long = {
//    var result: Long = 1
//    for (str <- args) result *= str
//    result

    var result: Long = 1
//    args.foreach(ch => result *= ch)
    args.foreach(result *= _)
    result
  }

  def getPower(x:Double, n:Int):Double = {
    if (n == 0 ) 1
    else if ( n>0 && n % 2 != 0 ) x * getPower(x, n-1)
    else if (n >0 && n % 2 == 0 ) getPower (x, n/2) * getPower (x, n/2)
    else 1/getPower( x, -n)
  }

  def main(args: Array[String]) {
    //for (i <- 1 to 3; j <- 1 to 3) print(10 * i + j + "\n")

    for (i <- 1 to 3; j <- 1 to 3 if i != j) print(10 * i + j + "\n")

    val is = for (i <- 1 to 10) yield i % 3
    println(is)

    val res = sum(1, 4, 9, 16 ,25)
    println(res)
//    val res1 = sum(1 to 5)  //wrong
    val res2 = sum(1 to 5: _*)  //转换成参数序列

    box("hello")

    println(signNum(10))

    for (i <- 0 to 10 reverse) println(i)

    println(unicodeSum("Hello"))
  }
}
