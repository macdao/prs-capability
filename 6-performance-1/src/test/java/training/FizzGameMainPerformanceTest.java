package training;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FizzGameMainPerformanceTest {

    private static final int threads = 4;
    private static final int count = 100 * 1000;

    public static void main(String[] args) throws Exception {
        warmUp();

        final long start = System.currentTimeMillis();
        runMain();
        System.out.println("[FizzGameMainPerformanceTest] runs " + (System.currentTimeMillis() - start) / 1000 + "s");
    }

    private static void warmUp() throws InterruptedException {
        run(10 * 1000);
    }

    private static void runMain() throws InterruptedException {
        run(count);
    }

    private static void run(int count) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(threads);

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

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
