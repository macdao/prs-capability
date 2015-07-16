package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContainGameRuleTest {

    private ContainGameRule containGameRule;

    @Before
    public void setUp() throws Exception {
        containGameRule = new ContainGameRule(new GameInput(3, 5, 7));
    }

    @Test
    public void student_13_should_say_Fizz_when_input_3_5_7() throws Exception {
        assertThat(containGameRule.say(13).get(), is("Fizz"));
    }

    @Test
    public void student_1_should_mute() throws Exception {
        assertThat(containGameRule.say(1).isPresent(), is(false));
    }

    @Test
    public void student_33_should_say_FizzFizz() throws Exception {
        assertThat(containGameRule.say(33).get(), is("FizzFizz"));
    }
}
