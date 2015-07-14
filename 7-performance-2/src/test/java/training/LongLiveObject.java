package training;

public class LongLiveObject {
    public final int COUNT = 1000 * 1000;
    private final int liveSeconds = 15;
    private boolean running;
    private Object[] objects = new Object[COUNT];

    public void start() {
        running = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(LongLiveObject.class.getSimpleName() + " started");
                int index = 0;
                while (running) {
                    for (int i = 0; i < COUNT / liveSeconds; i++) {
                        objects[(index % COUNT)] = new Object();
                        index++;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(LongLiveObject.class.getSimpleName() + " stopped " + objects.length);
            }
        }).start();
    }


    public void stop() {
        running = false;
    }
}
