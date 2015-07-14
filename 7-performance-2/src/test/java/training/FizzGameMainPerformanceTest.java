package training;

import training.mbean.Training;

import javax.management.*;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class FizzGameMainPerformanceTest {

    private static final int count = 50 * 1000;
    private static final int threads = 4;
    private static final Training training = new Training();
    private static final AtomicInteger throughput = new AtomicInteger();
    private static final AtomicLong throughputBegin = new AtomicLong();

    public static void main(String[] args) throws Exception {
        registerMBean();

        warmUp();

        for (int i = 0; i < 1; i++) {
            final long start = System.currentTimeMillis();
            runMain(count, threads);
            System.out.println(System.currentTimeMillis() - start);
        }

        System.out.println(FizzGameMain.rules.size());
    }

    private static void registerMBean() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        final ObjectName objectName = new ObjectName("training:type=Training");
        if (!ManagementFactory.getPlatformMBeanServer().isRegistered(objectName)) {
            ManagementFactory.getPlatformMBeanServer().registerMBean(training, objectName);
        }
    }

    private static void warmUp() throws InterruptedException {
        runMain(10 * 1000, threads);
    }

    private static void runMain(final int count, int threads) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(threads);

        final AtomicInteger finished = new AtomicInteger();
        throughputBegin.set(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            training.setRunning(i - finished.get());
            while (i - finished.get() > 10 * 1000) {
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
                            System.out.flush();
                        }

                        throughput.incrementAndGet();
                        final long now = System.currentTimeMillis();
                        if (now - throughputBegin.get() > 1000) {
                            throughputBegin.set(now);
                            training.setThroughput(throughput.getAndSet(0));
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
