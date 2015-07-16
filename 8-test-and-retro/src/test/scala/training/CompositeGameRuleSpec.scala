package training

import com.google.common.base.Optional
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, path}

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class CompositeGameRuleSpec extends path.FunSpec with Matchers with MockitoSugar {
  describe("CompositeGameRule") {
    describe("当有两个规则") {
      it("并且第一个规则返回Fizz，第二个规则返回Fizz，则会返回FizzFizz") {
        val rule1 = mock[GameRule]
        val rule2 = mock[GameRule]
        when(rule1.say(anyInt())).thenReturn(Optional.of("Fizz"))
        when(rule2.say(anyInt())).thenReturn(Optional.of("Fizz"))

        new CompositeGameRule(ListBuffer(rule1, rule2), null).say(1).get shouldBe "FizzFizz"
      }
      it("并且第一个规则没有返回值，而第二个规则返回了Buzz，则会返回Buzz") {
        val rule1 = mock[GameRule]
        when(rule1.say(anyInt())).thenReturn(Optional.absent[String])
        val rule2 = mock[GameRule]
        when(rule2.say(anyInt())).thenReturn(Optional.of("Buzz"))

        new CompositeGameRule(ListBuffer(rule1, rule2), null).say(1).get shouldBe "Buzz"
      }
    }
  }
}
