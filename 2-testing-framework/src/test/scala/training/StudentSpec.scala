package training

import org.scalatest.path

class StudentSpec extends path.FunSpec {
  describe("Student") {
    describe("in 3 5 7 game") {
      val fizzGame: FizzGame = new FizzGame(3, 5, 7)
      it("should say 1 for student 1") {
        assert(new Student(fizzGame, 1).say() == "1")
      }

      it("should say Fizz for student 3") {
        assert(new Student(fizzGame, 3).say() == "Fizz")
      }
    }

    describe("in 4 5 6 game") {
      val fizzGame: FizzGame = new FizzGame(4, 5, 6)
      it("should say 1 for student 1") {
        assert(new Student(fizzGame, 1).say() == "1")
      }
      it("should say 3 for student 3") {
        assert(new Student(fizzGame, 3).say() == "3")
      }
      it("should say Fizz for student 4") {
        assert(new Student(fizzGame, 4).say() == "Fizz")
      }
    }
  }
}
