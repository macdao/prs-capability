package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContainGameRuleTest {

    private ContainGameRule containGameRule;

    @Before
    public void setUp() throws Exception {
        containGameRule = new ContainGameRule(3);
    }

    @Test
    public void should_return_fizz_when_say_13() throws Exception {
        assertThat(containGameRule.say(13).get(), is("Fizz"));
    }

    @Test
    public void should_return_fizz_when_say_31() throws Exception {
        assertThat(containGameRule.say(31).get(), is("Fizz"));
    }

    @Test
    public void should_return_nothing_when_say_1() throws Exception {
        assertThat(containGameRule.say(1).isPresent(), is(false));
    }
}