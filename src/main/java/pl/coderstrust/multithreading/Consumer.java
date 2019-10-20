package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final Duration duration;
    private final int amount;

    Consumer(BlockingQueue<String> queue, Duration duration, int amount) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        if (duration == null) {
            throw new IllegalArgumentException("Duration cannot be null.");
        }
        if (duration.isNegative() || duration.isZero()) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.queue = queue;
        this.duration = duration;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < amount; i++) {
                Thread.sleep(duration.toMillis());
                String result = queue.take();
                System.out.println("Consumed by " + Thread.currentThread().getName() + ": " + result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
