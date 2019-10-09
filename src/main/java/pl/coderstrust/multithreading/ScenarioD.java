package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ScenarioD {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new Producer(queue, Duration.ofMillis(500), 25));
        executor.submit(new Producer(queue, Duration.ofMillis(500), 25));
        executor.submit(new Producer(queue, Duration.ofMillis(500), 25));
        executor.submit(new Consumer(queue, Duration.ofMillis(1), 75));
        executor.shutdownNow();
    }
}
