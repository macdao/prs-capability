package training;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class StudentTest {
    @Test
    public void say_fizz_when_first_rule_return_fizz() throws Exception {
        final GameRule rule1 = when(mock(GameRule.class).say(anyInt())).thenReturn(Optional.of("Fizz")).getMock();
        final GameRule rule2 = when(mock(GameRule.class).say(anyInt())).thenReturn(Optional.<String>absent()).getMock();
        final Student student = new Student(Lists.newArrayList(rule1, rule2), 1);

        assertThat(student.say(), is("Fizz"));
    }

    @Test
    public void say_buzz_when_first_rule_return_nothing_and_second_rule_return_buzz() throws Exception {
        final GameRule rule1 = when(mock(GameRule.class).say(anyInt())).thenReturn(Optional.<String>absent()).getMock();
        final GameRule rule2 = when(mock(GameRule.class).say(anyInt())).thenReturn(Optional.of("Buzz")).getMock();
        final Student student = new Student(Lists.newArrayList(rule1, rule2), 1);

        assertThat(student.say(), is("Buzz"));
    }
}