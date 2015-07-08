package training

import java.io.{ByteArrayOutputStream, PrintStream}

import org.scalatest.{Matchers, path}

class FizzGameMainSpec extends path.FunSpec with Matchers {
  describe("FizzGameMain") {
    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()
    val originalOut: PrintStream = System.out
    System.setOut(new PrintStream(outputStream))

    lazy val result: Array[String] = outputStream.toString.split(System.lineSeparator())

    def student(index: Int) = {
      result(index - 1)
    }

    describe("when input 3 5 7") {
      FizzGameMain.main(Array("3", "5", "7"))

      it("students should say 100 lines") {
        result.length shouldBe 100
      }

      it("student 1 should say 1") {
        student(1) shouldBe "1"
      }

      it("student 3 should say Fizz") {
        student(3) shouldBe "Fizz"
      }

      it("student 5 should say Buzz") {
        student(5) shouldBe "Buzz"
      }

      it("student 7 should say Whizz") {
        student(7) shouldBe "Whizz"
      }

      it("student 15 should say FizzBuzz") {
        student(15) shouldBe "FizzBuzz"
      }

      it("student 21 should say FizzWhizz") {
        student(21) shouldBe "FizzWhizz"
      }

      it("student 13 should say Fizz") {
        student(13) shouldBe "Fizz"
      }
    }

    System.setOut(originalOut)
  }
}
