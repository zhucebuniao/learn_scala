package scalatest

object iter {

  def main2(args : Array[String]) {
    val ita = Iterator(20, 40, 2, 50, 69, 90)
    val itb = Iterator(20, 40, 2, 50, 69, 90)

    println("最大元素是：" + ita.max)
    println("最小元素是：" + itb.min)

  }

  // Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法
  def main(args : Array[String]) : Unit = {
    val it = Iterator("a", "b", "c")
    while (it.hasNext) {
      print(it.next() + " ")
    }
    println()

    val itC = Iterator("ada", "dsaf", "da2")
    val itInt = Iterator(10, 20, 1, 3, 5)
    println(itC.max, itInt.min)
  }

}