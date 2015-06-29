package training

import org.scalatest.{Matchers, path}

class StudentSpec extends path.FunSpec with Matchers {
  describe("Student") {
    describe("当三个特殊数是3、5、7时") {
      val fizzGame = new FizzGame(3, 5, 7)
      it("学生1说1") {
        new Student(fizzGame, 1).say shouldBe "1"
      }
      it("学生3说Fizz") {
        new Student(fizzGame, 3).say shouldBe "Fizz"
      }
      it("学生5说Buzz") {
        new Student(fizzGame, 5).say shouldBe "Buzz"
      }
      it("学生7说Whizz") {
        new Student(fizzGame, 7).say shouldBe "Whizz"
      }
      it("学生15说FizzBuzz") {
        new Student(fizzGame, 15).say shouldBe "FizzBuzz"
      }
      it("学生21说FizzWhizz") {
        new Student(fizzGame, 21).say shouldBe "FizzWhizz"
      }
      it("学生35说BuzzWhizz") {
        new Student(fizzGame, 35).say shouldBe "BuzzWhizz"
      }
      it("学生105说FizzBuzzWhizz") {
        new Student(fizzGame, 105).say shouldBe "FizzBuzzWhizz"
      }
    }

    describe("当三个特殊数是4、5、6时") {
      val fizzGame: FizzGame = new FizzGame(4, 5, 6)
      it("学生1说1") {
        new Student(fizzGame, 1).say shouldBe "1"
      }
      it("学生3说3") {
        new Student(fizzGame, 3).say shouldBe "3"
      }
      it("学生4说Fizz") {
        new Student(fizzGame, 4).say shouldBe "Fizz"
      }
    }

  }
}
