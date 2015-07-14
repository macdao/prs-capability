package training.mbean;

public class Training implements TrainingMBean {

    private int throughput;
    private int running;

    @Override
    public int getThroughput() {
        return throughput;
    }

    public void setThroughput(int throughput) {
        this.throughput = throughput;
    }

    public int getRunning() {
        return running;
    }

    public void setRunning(int running) {
        this.running = running;
    }
}
