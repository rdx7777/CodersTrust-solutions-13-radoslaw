package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private Duration duration;
    private int amount;

    public Consumer(BlockingQueue<String> queue, Duration duration, int amount) {
        this.queue = queue;
        this.duration = duration;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            try {
                Thread.sleep(duration.toMillis());
                String result = queue.take();
                System.out.println("Consumed by " + Thread.currentThread().getName() + ": " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
