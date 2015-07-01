package training;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    private List<GameRule> rules;

    @Before
    public void setUp() {
        rules = Lists.newArrayList(new MultipleGameRule(new FizzGame(3, 5, 7)), new DefaultGameRule());
    }

    @Test
    public void test_student1_say_1() throws Exception {
        assertThat(new Student(rules, 1).say(), is("1"));
    }

    @Test
    public void test_student3_say_Fizz() throws Exception {
        assertThat(new Student(rules, 3).say(), is("Fizz"));
    }

    @Test
    public void test_student5_say_Buzz() throws Exception {
        assertThat(new Student(rules, 5).say(), is("Buzz"));
    }

    @Test
    public void test_student7_say_Whizz() throws Exception {
        assertThat(new Student(rules, 7).say(), is("Whizz"));
    }

    @Test
    public void test_student15_say_FizzBuzz() throws Exception {
        assertThat(new Student(rules, 15).say(), is("FizzBuzz"));
    }

    @Test
    public void test_student21_say_FizzWhizz() throws Exception {
        assertThat(new Student(rules, 21).say(), is("FizzWhizz"));
    }

    @Test
    public void test_student105_say_FizzBuzzWhizz() throws Exception {
        assertThat(new Student(rules, 105).say(), is("FizzBuzzWhizz"));
    }
}