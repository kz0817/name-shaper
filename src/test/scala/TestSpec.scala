import org.scalatest._

class TestSpec extends FlatSpec with Matchers {

  "Multi-byte A " should "be converted to a single-byte A (ASCII)" in {
    Main.getConvertedLine("Ａ") should be ("A")
  }
}
