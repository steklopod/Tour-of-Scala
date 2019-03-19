import org.junit.jupiter.api.{DisplayName, Test}
import org.scalatest.Matchers

class Junit_5_Test  extends Matchers {

  object ExceptionTest {
    @throws(classOf[RuntimeException])
    def throwRunEx = throw new RuntimeException
  }

  @Test
  @DisplayName("Example with JUnitSuite")
  def throwsExceptionWhenCalled_With_JUnitSuite() {
    import ExceptionTest._
    assertThrows[RuntimeException]{ throwRunEx}
  }

}
