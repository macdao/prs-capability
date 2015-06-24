package training;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzGameTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private String[] results;

    @Before
    public void before() {
        FizzGame.main(new String[0]);

        final String log = systemOutRule.getLog();
        results = log.split(System.getProperty("line.separator"));
    }

    @Test
    public void all_students_should_say_100_words() {
        assertThat(results.length, is(100));
    }

    @Test
    public void student_1_should_say_1() throws Exception {
        assertThat(results[0], is("1"));
    }

    @Test
    public void student_3_should_say_fizz() {
        assertThat(results[3 - 1], is("Fizz"));
    }

    @Test
    public void student_5_should_say_buzz() {
        assertThat(results[5 - 1], is("Buzz"));
    }
}