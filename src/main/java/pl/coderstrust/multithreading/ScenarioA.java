package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ScenarioA {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Producer(queue, Duration.ofMillis(500)));
        executor.submit(new Consumer(queue, Duration.ofMillis(100)));
        executor.shutdownNow();
    }
}
