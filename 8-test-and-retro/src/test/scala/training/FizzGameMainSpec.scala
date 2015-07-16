package training

import java.io._

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

      it("student 3 should say FizzFizz") {
        student(3) shouldBe "FizzFizz"
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

      ignore("all student should say correctly") {
        outputStream.toString.trim shouldBe
          """|1
            |2
            |FizzFizz
            |4
            |Buzz
            |Fizz
            |Whizz
            |8
            |Fizz
            |Buzz
            |11
            |Fizz
            |Fizz
            |Whizz
            |FizzBuzz
            |16
            |17
            |Fizz
            |19
            |Buzz
            |FizzWhizz
            |22
            |Fizz
            |Fizz
            |Buzz
            |26
            |Fizz
            |Whizz
            |29
            |FizzFizzBuzz
            |Fizz
            |Fizz
            |FizzFizzFizz
            |Fizz
            |FizzBuzzWhizz
            |FizzFizz
            |Fizz
            |Fizz
            |FizzFizz
            |Buzz
            |41
            |FizzWhizz
            |Fizz
            |44
            |FizzBuzz
            |46
            |47
            |Fizz
            |Whizz
            |Buzz
            |Fizz
            |52
            |Fizz
            |Fizz
            |Buzz
            |Whizz
            |Fizz
            |58
            |59
            |FizzBuzz
            |61
            |62
            |FizzFizzWhizz
            |64
            |Buzz
            |Fizz
            |67
            |68
            |Fizz
            |BuzzWhizz
            |71
            |Fizz
            |Fizz
            |74
            |FizzBuzz
            |76
            |Whizz
            |Fizz
            |79
            |Buzz
            |Fizz
            |82
            |Fizz
            |FizzWhizz
            |Buzz
            |86
            |Fizz
            |88
            |89
            |FizzBuzz
            |Whizz
            |92
            |FizzFizz
            |94
            |Buzz
            |Fizz
            |97
            |Whizz
            |Fizz
            |Buzz""".stripMargin
      }
    }

    describe("when input 4 5 6") {
      FizzGameMain.main(Array("4", "5", "6"))

      it("student 4 should say FizzFizz") {
        student(4) shouldBe "FizzFizz"
      }
    }

    describe("when input 3 5 7 and a fileName") {
      val tempFile = File.createTempFile("fizz-game-test-", ".txt")
      FizzGameMain.main(Array[String]("3", "5", "7", tempFile.getAbsolutePath))

      it("should not write to System.out") {
        result.length shouldBe 1
        result(0) shouldBe ""
      }

      it("should write to file") {
        val reader = new BufferedReader(new FileReader(tempFile))
        reader.readLine() shouldBe "1"
      }

      tempFile.delete()
    }

    System.setOut(originalOut)
  }
}
