package scalatest

import java.util.Date

object ScalaFunction {

  def main(args : Array[String]) : Unit = {

    ifElse(20)

    println("---------------")
    println(funn.addInt(y = 3, x = 4))

    println("---------------")
    funn.delayed(funn.time())
    println("---------------")
    funn.delayed2(funn.time())

    println("---------------")
    funn.putStrings("scala", "haskell", "python")

    println("---------------")
    for (i <- 1 to 10)
      printf("%d的阶乘是:%d, %d\r\n", i, funn.factorial(i), funn.factorial2(i))

    println("---------------")
    println(funn.hfun(funn.lay, 3))

    println("---------------")
    println(funn.gfun(3, 4)(6, 7))

    println("---------------")
    println(funn.applyTwice(funn.add3, 10))
    println(funn.applyTwice(funn.addl, "aa"))

    println("---------------")
    println(funn.max(2, funn.maxWith3(1)))
    println(funn.curryAdd(4)(5), funn.addTo4(3))

    println("---------------")
    println("lambda:" + funn.inc(3) + ", " + funn.dir())

    println("---------------")
    // 偏应用函数调用
    var date = new Date
    var logWithDateBounded = funn.log(date, _ : String) //用下划线(_)替换缺失的参数列表
    logWithDateBounded("message1")
    Thread.sleep(1000)
    logWithDateBounded("message2")
  }

  def ifElse(x : Int) : Unit = {
    if (x < 20) {
      println(x)
    } else {
      println(x + 4)
    }
  }
}

//  Scala 函数名可以由以下特殊字符：+, ++, ~, &,-, -- , \, /, : 等。
/*
     def functionName ([参数列表]) : [return type] = {
     function body
     return [expr]
     }
  */
object funn {

  // 函数定义时可设置默认值
  // 调用时可指定函数参数名x,y;如addInt(y=3,x=4)
  def addInt(x : Int, y : Int, z : Int = 9) : Int = {
    var s : Int = x + y + z;
    printf("x is %d, y is %d, z is %d.\r\n", x, y, z)
    return s;
  }

  /* 传名调用是在函数内部进行参数表达式的值计算的
   * 这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值
   * => 符号来设置传名调用
   */
  def delayed(t : => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
    println("参数2： " + t)
  }

  // 在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕
  def delayed2(t : Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  // 函数体前必须要等号
  def time() = {
    println("获取系统时间: ")
    System.nanoTime
  }

  // 可变参数
  def putStrings(args : String*) {
    var i : Int = 0 // 必须初始化
    for (arg <- args) {
      printf("Arg value[%d] = %s\r\n", i, arg)
      i = i + 1
    }
  }

  // 递归函数
  def factorial(n : BigInt) : BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

  // 可以在 Scala 函数内定义函数，定义在函数内的函数称之为局部函数
  def factorial2(i : Int) : Int = {
    def fact(i : Int, accumulator : Int) : Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  // 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果
  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def hfun(f : Int => String, v : Int) = f(v)
  def lay[A](x : A) = "[" + x.toString() + "]"

  def gfun(x : Int, y : Int) : (Int, Int) => Int = {
    def localfun(a : Int, b : Int) : Int =
      if (a > b) 0
      else
        x + y + localfun(a + 1, b)
    return localfun // 可不要return
  }

  /*
   * haskell
   * applyTwice :: (a -> a) -> a -> a
   * applyTwice f x = f (f x)
   */
  def applyTwice[A](f : A => A, a : A) : A = f(f(a))
  def add3(x : Int) : Int = x + 3
  def addl(x : String) : String = x + "ll"

  def max(x : Int, y : Int) : Int = {
    if (x > y)
      x
    else
      y
  }
  def maxWith3(x : Int) : Int = max(3, x)
  // 函数柯里化
  // 实质上：def add(x:Int)=(y:Int)=>x+y
  def curryAdd(x : Int)(y : Int) = x + y
  def add(x : Int) = (y : Int) => x + y
  val addTo4 = curryAdd(4)_

  // FunctionN：是trait；带N-1个参数的函数,最后一个参数是返回值；必须实现apply方法
  def add2 = new Function1[Int, Int] {
    def apply(x : Int) : Int = x + 1
  }
  // 匿名函数
  var inc = (x : Int) => x + 1
  // 无参匿名函数
  var dir = () => System.getProperty("user.dir")

  // 偏应用函数是一种表达式，你不需要提供函数需要的所有参数，只需要提供部分，或不提供所需参数
  // 函数体前不需要等号
  def log(date : Date, message : String) {
    println(date + "-----" + message)
  }
}