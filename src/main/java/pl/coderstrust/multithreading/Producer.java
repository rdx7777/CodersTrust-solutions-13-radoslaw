package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String> queue;
    private Duration duration;
    private int amount;

    public Producer(BlockingQueue<String> queue, Duration duration, int amount) {
        this.queue = queue;
        this.duration = duration;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            System.out.println("Produced: " + i);
            try {
                Thread.sleep(duration.toMillis());
                queue.put("Result " + i + " by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
