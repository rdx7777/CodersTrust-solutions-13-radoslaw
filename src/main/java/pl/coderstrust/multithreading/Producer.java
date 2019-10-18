package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> queue;
    private final Duration duration;
    private final int amount;

    Producer(BlockingQueue<String> queue, Duration duration, int amount) {
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
                System.out.println("Produced: " + i);
                Thread.sleep(duration.toMillis());
                queue.put("Result " + i + " by " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
