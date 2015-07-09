package training;

import java.nio.file.Files;

public class FizzGameMainPerformanceTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100 * 1000; i++) {
            final String fileName = Files.createTempFile("fizz-game-test-", ".txt").toString();
            FizzGameMain.main(new String[]{"3", "5", "7", fileName});
        }
    }
}
