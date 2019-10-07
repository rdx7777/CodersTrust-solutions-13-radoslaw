package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String> queue;
    private Duration duration;

    public Producer(BlockingQueue<String> queue, Duration duration) {
        this.queue = queue;
        this.duration = duration;
    }

    @Override
    public void run() {
        new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Produced: " + i);
                try {
                    Thread.sleep(duration.toMillis());
                    queue.put("Result " + i + " by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
