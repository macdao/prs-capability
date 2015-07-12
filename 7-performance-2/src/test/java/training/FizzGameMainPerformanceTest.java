package training;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzGameMainPerformanceTest {

    private static final int count = 500 * 1000;
    private static final int threads = 8;

    public static void main(String[] args) throws Exception {
        warmUp();

        for (int i = 0; i < 3; i++) {
            final long start = System.currentTimeMillis();
            runMain(count, threads);
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    private static void warmUp() throws InterruptedException {
        runMain(20 * 1000, threads);
    }

    private static void runMain(final int count, int threads) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(threads);

        final AtomicInteger finished = new AtomicInteger();
        for (int i = 0; i < count; i++) {
            if (i - finished.get() > 10 * 1000) {
                Thread.sleep(1000);
            }
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        final File tempFile = File.createTempFile("fizz-game-test-", ".txt");
                        FizzGameMain.main(new String[]{"3", "5", "7", tempFile.getAbsolutePath()});
                        tempFile.delete();
                        if ((finished.incrementAndGet()) * 100 % count == 0) {
                            System.out.print("\r" + finished.get() * 100 / count + "%");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println();
    }
}
