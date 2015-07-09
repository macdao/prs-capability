package training;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzGameMainPerformanceTest {

    public static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(1);

        final int count = 200 * 1000;
        for (int i = 0; i < count; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        final File tempFile = File.createTempFile("fizz-game-test-", ".txt");
                        FizzGameMain.main(new String[]{"3", "5", "7", tempFile.getAbsolutePath()});
                        tempFile.delete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
