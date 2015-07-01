package training;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzGameMainTest {

    private String[] result;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog().mute();

    @Before
    public void setUp() {
        FizzGameMain.main(new String[0]);
        result = systemOutRule.getLog().split(System.lineSeparator());
    }

    @Test
    public void test_all_students_say_100_lines() throws Exception {
        assertThat(result.length, is(100));
    }

    @Test
    public void test_student1_say_1() throws Exception {
        assertThat(result[0], is("1"));
    }

    @Test
    public void test_student3_say_Fizz() throws Exception {
        assertThat(result[3 - 1], is("Fizz"));
    }

    @Test
    public void test_student5_say_Buzz() throws Exception {
        assertThat(result[5 - 1], is("Buzz"));
    }

    @Test
    public void test_student7_say_Whizz() throws Exception {
        assertThat(result[7 - 1], is("Whizz"));
    }

    @Test
    public void test_student15_say_FizzBuzz() throws Exception {
        assertThat(result[15 - 1], is("FizzBuzz"));
    }

    @Test
    public void test_student21_say_FizzWhizz() throws Exception {
        assertThat(result[21 - 1], is("FizzWhizz"));
    }

    @Test
    public void test_student13_say_Fizz() throws Exception {
        assertThat(result[13 - 1], is("Fizz"));
    }
}
