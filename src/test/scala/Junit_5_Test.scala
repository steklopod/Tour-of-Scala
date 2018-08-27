import org.junit.jupiter.api.{DisplayName, Test}
import org.junit.runner.RunWith
import org.scalatest.Matchers
import org.scalatest.junit.{JUnitRunner, JUnitSuite}

@RunWith(classOf[JUnitRunner])
class Junit_5_Test extends JUnitSuite with Matchers{

  object ExceptionTest {
    @throws(classOf[RuntimeException])
    def throwRunEx = throw new RuntimeException
  }

  @Test
  @DisplayName("Example with JUnitSuite and ShouldMatchersForJUnit")
  def throwsExceptionWhenCalled_With_JUnitSuite() {
    import ExceptionTest._
    assertThrows[RuntimeException]{ throwRunEx}
  }

}
