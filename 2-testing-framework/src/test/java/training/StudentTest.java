package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentTest {

    private FizzGame fizzGame;

    @Before
    public void setUp() throws Exception {
        fizzGame = new FizzGame(3, 5, 7);
    }

    @Test
    public void student_1_should_say_1() throws Exception {
        assertThat(new Student(fizzGame, 1).say(), is("1"));
    }

    @Test
    public void student_3_should_say_fizz() throws Exception {
        assertThat(new Student(fizzGame, 3).say(), is("Fizz"));
    }

    @Test
    public void student_5_should_say_buzz() throws Exception {
        assertThat(new Student(fizzGame, 5).say(), is("Buzz"));
    }

    @Test
    public void student_7_should_say_whizz() throws Exception {
        assertThat(new Student(fizzGame, 7).say(), is("Whizz"));
    }
}