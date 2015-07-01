package training;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DefaultGameRuleTest {

    private DefaultGameRule defaultGameRule;

    @Before
    public void setUp() throws Exception {
        defaultGameRule = new DefaultGameRule();
    }

    @Test
    public void student_1_should_say_1() throws Exception {
        assertThat(defaultGameRule.say(1).get(), is("1"));
    }

    @Test
    public void student_3_should_say_3() throws Exception {
        assertThat(defaultGameRule.say(3).get(), is("3"));
    }
}