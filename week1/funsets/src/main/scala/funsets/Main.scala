package funsets

object Main extends App {
  import FunSets._
  val s = singletonSet(1)
  val q = singletonSet(2)


  println(exists(s, (x=> x==2)))
  println(forall(s, (x=> x==2)))
  println(contains(singletonSet(1), 1))
}
