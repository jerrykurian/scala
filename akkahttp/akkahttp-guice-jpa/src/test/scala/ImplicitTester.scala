import com.app.implicittest.{B, ImplicitUser}
import org.specs2.mutable._

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class ImplicitTester extends Specification{
  "ImplicitUser " should {
    "return B " in {
      val user = new ImplicitUser
      val retVal:B = user.bReturner
      retVal.id mustEqual(10)
    }
  }
}
