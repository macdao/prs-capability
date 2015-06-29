package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    private FizzGame fizzGame;

    @Before
    public void setUp() {
        fizzGame = new FizzGame(3, 5, 7);
    }

    @Test
    public void test_student1_say_1() throws Exception {
        assertThat(new Student(fizzGame, 1).say(), is("1"));
    }

    @Test
    public void test_student3_say_Fizz() throws Exception {
        assertThat(new Student(fizzGame, 3).say(), is("Fizz"));
    }

    @Test
    public void test_student5_say_Buzz() throws Exception {
        assertThat(new Student(fizzGame, 5).say(), is("Buzz"));
    }

    @Test
    public void test_student7_say_Whizz() throws Exception {
        assertThat(new Student(fizzGame, 7).say(), is("Whizz"));
    }

    @Test
    public void test_student15_say_FizzBuzz() throws Exception {
        assertThat(new Student(fizzGame, 15).say(), is("FizzBuzz"));
    }

    @Test
    public void test_student21_say_FizzWhizz() throws Exception {
        assertThat(new Student(fizzGame, 21).say(), is("FizzWhizz"));
    }

    @Test
    public void test_student105_say_FizzBuzzWhizz() throws Exception {
        assertThat(new Student(fizzGame, 105).say(), is("FizzBuzzWhizz"));
    }
}