package scalatest

object collection {

  def main(args : Array[String]) : Unit = {

    // 1. List: List的值是不可变的(数组的值可变)，链式结构
    var site : List[String] = List("google", "baidu", "sina")
    var emtpy : List[Nothing] = List()
    var dim : List[List[Int]] =
      List(
        List(1, 2, 3),
        List(0, 1, 3),
        List(3, 2, 1)
      )

    println(site.head, site.tail)
    println(emtpy.isEmpty)
    println(dim.head.head, dim.tail.head.take(1).head)

    // 构造列表的两个基本单位是 Nil 和 ::
    site = "baidu" :: ("google" :: ("csdn" :: Nil))
    emtpy = Nil
    dim =
      (1 :: (2 :: (3 :: Nil))) ::
        (10 :: (1 :: (3 :: Nil))) ::
        (3 :: (2 :: (1 :: Nil))) :: Nil

    println(site.head, site.tail)
    println(emtpy.isEmpty)
    println(dim.head.head, dim.tail.head.take(1).head)

    // 可以使用 ::: 运算符或 List.:::() 方法或 List.concat() 方法来连接两个或多个列表
    var site2 = "1" :: ("2" :: Nil)
    var all = site ::: site2
    println("::: " + all)
    all = site.:::(site2)
    println(".::: " + all)
    all = List.concat(site, site2)
    println("List.concat " + all)

    /* ------------------------- */
    // 2. Set

    
  }
}