package scalatest

/**
 * 类是对象的抽象，而对象是类的具体实例。类是抽象的，不占用内存，而对象是具体的，占用存储空间。
 * 类是用于创建对象的蓝图，它是一个定义包括在特定类型的对象中的方法和变量的软件模板。
 */
// 类不声明为public，一个Scala源文件中可以有多个类
class Counter {
  var var1 : Int = 3;
  private var value = 0; // 必须初始化字段
  def increment() { value += 1 } // 方法默认公有
  def current = value; // 调用必须是myCounter.current这种风格
}

class Student(ageArg : Int) {
  var age = ageArg; //底层编译器会自动为私有的age添加get和set的公有方法,可以理解为伪public类型  
  private[this] var gender = "male" //private[this] 只有该类的this可以使用  
  private var name = "clow" //声明了private,底层编译器会自动为私有的name添加get和set的私有方法  
  //但是可以自己定义属性方法  
  def getName = this.name
  def setName(value : String) { this.name = value }
}

// 继承，跟Java很相似
/*
 * tips:
 * 1、重写一个非抽象方法必须使用override修饰符;
 *   在子类中重写超类的抽象方法时，你不需要使用override关键字。
 * 2、只有主构造函数才可以往基类的构造函数里写参数。
 */
class Point(val xc : Int, val yc : Int) {
  var x = xc
  var y = yc

  val test = "Point"

  override def toString = "i am a point"

  def move(dx : Int, dy : Int) {
    x = x + dx
    y += dy
    println(x, y)
  }
}
class Location(override val xc : Int, override val yc : Int, val zc : Int)
    extends Point(xc, yc) {

  override val test = "Location" // 父类test必须是val声明
  var z : Int = zc
  override def toString() : String = "i am a Location"

  def move(dx : Int, dy : Int, dz : Int) {
    x += dx
    y += dy
    z += dz
    println(x, y, z)
  }
}

// 私有构造方法
class Maker private (val color : String) {
  println("创建" + this)
  override def toString = "颜色" + color
}
// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object Maker {
  private val makers : Map[String, Maker] =
    Map(
      "red" -> new Maker("red"),
      "blue" -> new Maker("blue"),
      "green" -> new Maker("green")
    )

  def apply(color : String) = {
    if (makers.contains(color))
      makers(color)
    else
      null
  }
  def getMaker(color : String) = {
    if (makers.contains(color)) makers(color) else null
  }

  def main(args : Array[String]) {
    println(Maker("red"))
    println(Maker getMaker ("red"))
  }
}

object Test {
  def main(args : Array[String]) : Unit = {
    println("hello world");

    val counter = new Counter();
    counter.increment();
    println(counter.current);

    val student = new Student(19);
    student.setName("cow")
    println(student.age + ":" + student.getName)

    val p = new Point(2, 2)
    print(p.toString() + " ")
    p.move(2, 2)
    val loc = new Location(1, 2, 3)
    print(loc.toString() + " ")
    loc.move(2, 2, 2)
  }
}
