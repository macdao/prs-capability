package training

import java.io.{ByteArrayOutputStream, PrintStream}

import org.scalatest.{Matchers, path}

class FizzGameMainSpec extends path.FunSpec with Matchers {
  describe("FizzGameMain") {
    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()
    val originalOut: PrintStream = System.out
    System.setOut(new PrintStream(outputStream))

    describe("when input 3 5 7") {
      FizzGameMain.main(Array("3", "5", "7"))
      val result: Array[String] = outputStream.toString.split(System.lineSeparator())

      it("students should say 100 lines") {
        result.length shouldBe 100
      }

      it("student 1 should say 1") {
        result(0) shouldBe "1"
      }

      it("student 3 should say Fizz") {
        result(3 - 1) shouldBe "Fizz"
      }

      it("student 5 should say Buzz") {
        result(5 - 1) shouldBe "Buzz"
      }

      it("student 7 should say Whizz") {
        result(7 - 1) shouldBe "Whizz"
      }

      it("student 15 should say FizzBuzz") {
        result(15 - 1) shouldBe "FizzBuzz"
      }

      it("student 21 should say FizzWhizz") {
        result(21 - 1) shouldBe "FizzWhizz"
      }

      it("student 13 should say Fizz") {
        result(13 - 1) shouldBe "Fizz"
      }
    }

    describe("when input 4 5 6") {
      FizzGameMain.main(Array("4", "5", "6"))
      val result: Array[String] = outputStream.toString.split(System.lineSeparator())

      it("student 4 should say Fizz") {
        result(4 - 1) shouldBe "Fizz"
      }
    }

    describe("when input 3 5") {
      it("should throw RuntimeException") {
        intercept[RuntimeException] {
          FizzGameMain.main(Array("3", "5"))
        }
      }
    }

    System.setOut(originalOut)
  }
}
