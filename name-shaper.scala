import scala.io.Source

object Main {

  private var convMap = collection.mutable.Map[Char,Char]()
  registerConvRules('Ａ' to 'Ｚ', 'A' to 'Z')
  registerConvRules('０' to '９', '0' to '9')
  registerConvRule('　', ' ')
  registerConvRule('！', '!')

  private def registerConvRules(
    keys: collection.immutable.NumericRange.Inclusive[Char],
    values: collection.immutable.NumericRange.Inclusive[Char]) = {
    require(keys.length == values.length)
    for (i <- 0 until keys.length)
      convMap(keys(i)) = values(i)
  }

  private def registerConvRule(key: Char,value: Char) = {
    convMap(key) = value
  }

  def main(args: Array[String]) = {
    for (line <- Source.stdin.getLines) {
      val newLine = for (c <- line) yield convMap.getOrElse(c, c)
      println(newLine)
    }
  }
}
