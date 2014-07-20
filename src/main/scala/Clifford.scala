import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.Stack

class Clifford {

  def add(m: Stack[Int]) {
    m.push(m.pop() + m.pop())
  }

  def subtract(m: Stack[Int]) {
    m.push(- m.pop() + m.pop())
  }

  def multiply(m: Stack[Int]) {
    m.push(m.pop() * m.pop())
  }

  def divide(m: Stack[Int]) {
    val a = m.pop()
    val b = m.pop()
    m.push(b / a)
  }

  @tailrec
  private final def engine(x: Stack[Int], y: Stack[Int]): Int = {

    if (x.isEmpty && y.length == 1) y.pop()
    else {

      x.pop() match {

        case 0 => y.push(x.pop())
        case 1 => y.pop()
        case 2 => add(y)
        case 3 => subtract(y)
        case 4 => multiply(y)
        case 5 => divide(y)

      }

      engine(x, y)

    }

  }

  def start(x: Stack[Int]): Int = {

    engine(x, new mutable.Stack[Int])

  }

}

object Clifford {

  def main(args: Array[String]) {

    val clifford = new Clifford

    val result = clifford.start(new mutable.Stack[Int].pushAll(args.map(_.toInt).toList.reverse))

    println("Result: " + result)

  }

}
