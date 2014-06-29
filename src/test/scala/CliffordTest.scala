import org.scalatest.FlatSpec

import scala.collection.mutable
import scala.collection.mutable.Stack

class CliffordTest extends FlatSpec {

  "Clifford Engine" should "calculate correct output " in {

    test(new mutable.Stack[Int].pushAll(List(2, 2, 0 ,2, 0)), 4)
    test(new mutable.Stack[Int].pushAll(List(3, 3, 0 ,5, 0)), 2)
    test(new mutable.Stack[Int].pushAll(List(4, 10, 0 ,10, 0)), 100)
    test(new mutable.Stack[Int].pushAll(List(5, 5, 0 ,10, 0)), 2)
    test(new mutable.Stack[Int].pushAll(List(5, 2, 0, 4, 5, 0, 10, 0)), 25)

  }

  def test(x: Stack[Int], y: Int) {

    val clifford = new Clifford
    val result = clifford.start(x)

    assert(result === y)

  }

}
