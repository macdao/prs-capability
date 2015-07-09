package training;

import java.io.File;

public class FizzGameMainPerformanceTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100 * 1000; i++) {
            final File tempFile = File.createTempFile("fizz-game-test-", ".txt");
            FizzGameMain.main(new String[]{"3", "5", "7", tempFile.getAbsolutePath()});
            tempFile.delete();
        }
    }
}
