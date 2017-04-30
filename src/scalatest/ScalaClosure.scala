package scalatest

import Array._

object ScalaClosure {

  def main(args : Array[String]) : Unit = {
    println("mutiplier(1) = " + multiplier(1))
    println("mutiplier(2) = " + multiplier(2))

    // String是不可变的,可使用StringBuffer、StringBuilder创建可变字符串
    val buf = new StringBuffer
    buf.append('a')
    buf.append("bcdef")
    val sb = new StringBuilder
    sb += 'a'
    sb ++= "bcdef"
    println(buf.toString(), sb.toString())

    // 创建数组
    var arr : Array[String] = new Array[String](3)
    var arr2 = new Array[String](4)
    var arr3 : Array[Int] = Array[Int](1, 2, 3, 4)
    var sum = 0
    for (elem <- arr3)
      sum = sum + elem
    println(sum)
    var sum2 = 0
    var arr4 = Array(1, 2, 3, 4, 5)
    for (i <- 0 to (arr4.length - 1))
      sum2 += arr4(i)
    println(sum2)
    // range
    var rangeArr = range(1, 20, 2)
    var rangeArr2 = range(2, 9)
    for (x <- rangeArr)
      print(x + " ")
    println()
    for (x <- rangeArr2)
      print(x + " ")
    println()

    // 多维数组
    var matrix = ofDim[Int](3, 3)
    for (i <- 0 to 2)
      for (j <- 0 to 2)
        matrix(i)(j) = j
    // 打印
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(matrix(i)(j) + " ")
      }
      println()
    }

    // 合并数组concat() 
    var arr5 = concat(arr3, arr4)
    for (x <- arr5)
      print(x + " ")
    println()
  }

  // 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。
  // 闭包通常来讲可以简单的认为是可以访问一个函数里面局部变量的另外一个函数。
  // factor不是形式参数，而是自由变量
  var factor = 3
  val multiplier = (i : Int) => i * factor

}