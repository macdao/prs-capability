package training

import org.scalatest.{Matchers, path}

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class StudentSpec extends path.FunSpec with Matchers {
  describe("Student") {
    describe("当三个特殊数是3、5、7时") {
      val rules = ListBuffer(new MultipleGameRule(new FizzGame(3, 5, 7)), new DefaultGameRule)
      it("学生1说1") {
        new Student(rules, 1).say shouldBe "1"
      }
      it("学生3说Fizz") {
        new Student(rules, 3).say shouldBe "Fizz"
      }
      it("学生5说Buzz") {
        new Student(rules, 5).say shouldBe "Buzz"
      }
      it("学生7说Whizz") {
        new Student(rules, 7).say shouldBe "Whizz"
      }
      it("学生15说FizzBuzz") {
        new Student(rules, 15).say shouldBe "FizzBuzz"
      }
      it("学生21说FizzWhizz") {
        new Student(rules, 21).say shouldBe "FizzWhizz"
      }
      it("学生35说BuzzWhizz") {
        new Student(rules, 35).say shouldBe "BuzzWhizz"
      }
      it("学生105说FizzBuzzWhizz") {
        new Student(rules, 105).say shouldBe "FizzBuzzWhizz"
      }
    }

    describe("当三个特殊数是4、5、6时") {
      val rules = ListBuffer(new MultipleGameRule(new FizzGame(4, 5, 6)), new DefaultGameRule)
      it("学生1说1") {
        new Student(rules, 1).say shouldBe "1"
      }
      it("学生3说3") {
        new Student(rules, 3).say shouldBe "3"
      }
      it("学生4说Fizz") {
        new Student(rules, 4).say shouldBe "Fizz"
      }
    }

  }
}
