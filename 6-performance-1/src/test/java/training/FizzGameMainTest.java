package training;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzGameMainTest {
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog().mute();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog().mute();
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void should_print_err_invalid_input_and_exit_1_when_input_3_5() throws Exception {
        exit.expectSystemExitWithStatus(1);

        try {
            FizzGameMain.main(new String[]{"3", "5"});
        } finally {
            assertThat(systemErrRule.getLog(), is("invalid input" + System.lineSeparator()));
        }
    }

    @Test
    public void should_print_invalid_input_when_input_3_5_10() throws Exception {
        exit.expectSystemExitWithStatus(1);

        try {
            FizzGameMain.main(new String[]{"3", "5", "10"});
        } finally {
            assertThat(systemErrRule.getLog(), is("invalid input" + System.lineSeparator()));
        }
    }

    @Test
    public void should_write_to_file_when_input_3_5_7_file() throws Exception {
        String file = Files.createTempFile("fizz-game-test", ".txt").toString();

        FizzGameMain.main(new String[]{"3", "5", "7", file});

        assertThat(systemOutRule.getLog(), is(""));
    }
}