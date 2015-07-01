package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MultipleGameRuleTest {

    private MultipleGameRule multipleGameRule;

    @Before
    public void setUp() throws Exception {
        multipleGameRule = new MultipleGameRule(new FizzGame(3, 5, 7));
    }

    @Test
    public void student_3_should_say_Fizz() throws Exception {
        assertThat(multipleGameRule.say(3).get(), is("Fizz"));
    }

    @Test
    public void student_5_should_say_Buzz() throws Exception {
        assertThat(multipleGameRule.say(5).get(), is("Buzz"));
    }

    @Test
    public void student_7_should_say_Whizz() throws Exception {
        assertThat(multipleGameRule.say(7).get(), is("Whizz"));
    }

    @Test
    public void student_15_should_say_FizzBuzz() throws Exception {
        assertThat(multipleGameRule.say(15).get(), is("FizzBuzz"));
    }

    @Test
    public void student_105_should_say_FizzBuzzWhizz() throws Exception {
        assertThat(multipleGameRule.say(105).get(), is("FizzBuzzWhizz"));
    }

    @Test
    public void student_1_should_say_nothing() throws Exception {
        assertThat(multipleGameRule.say(1).isPresent(), is(false));
    }

}