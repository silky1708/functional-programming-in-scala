package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(s"${pascal(col, row)} ")
//      println()
//    }
//
//
//    println(balance("(if (zero? x) max (/ 1 x))".toList))
//    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
//    println(balance("())(".toList))
//
//    println(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c==0 || r==0) 1
    else if(c==r) 1
    else pascal(c-1, r-1)+pascal(c, r-1)
  }

  /**
   * Exercise 2
   */

    private def balance_helper(chars: List[Char], count: Int): Boolean = chars match {
      case Nil=> if(count==0) true else false
      case x::xs =>
        if(x=='(') balance_helper(xs, count+1)
        else if(x==')') {
          count match {
            case 0 => false
            case _ => balance_helper(xs, count - 1)
          }

        }
        else balance_helper(xs, count)

    }

  def balance(chars: List[Char]): Boolean = balance_helper(chars, 0)

//    var cnt = 0
//    for (ch <- chars){
//      ch match {
//        case "(" => cnt = cnt+1;
//        case ")" => cnt = cnt-1; if(cnt < 0) return false
//        case _ =>
//      }
//    }
//
//    if(cnt == 0) true else false
//
//  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = if(money ==0) 1 else coins match {
    case Nil => 0
    case List(y) => {
      if(money % y ==0) 1
      else 0
    }
    case x::xs => {
      if(x <= money) countChange(money, xs) + countChange(money-x, coins)
      else countChange(money, xs)
    }
  }
}
