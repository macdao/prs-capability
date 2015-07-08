package training;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemErrRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzGameMainTest {
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog().mute();
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void should_print_err_invalid_input_and_exit_1_when_input_3_5() throws Exception {
        exit.expectSystemExitWithStatus(1);

        FizzGameMain.main(new String[]{"3", "5"});

        assertThat(systemErrRule.getLog(), is("invalid input" + System.lineSeparator()));
    }

    @Test
    public void should_print_invalid_input_when_input_3_5_10() throws Exception {
        exit.expectSystemExitWithStatus(1);

        FizzGameMain.main(new String[]{"3", "5", "10"});

        assertThat(systemErrRule.getLog(), is("invalid input" + System.lineSeparator()));
    }
}