package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class BigConsumer implements Runnable {
    private BlockingQueue<String> queue;
    private Duration duration;

    public BigConsumer(BlockingQueue<String> queue, Duration duration) {
        this.queue = queue;
        this.duration = duration;
    }

    @Override
    public void run() {
        new Thread(() -> {
            for (int i = 0; i < 75; i++) {
                try {
                    Thread.sleep(duration.toMillis());
                    String result = queue.take();
                    System.out.println("Consumed by " + Thread.currentThread().getName() + ": " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
