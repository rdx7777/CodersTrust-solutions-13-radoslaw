package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ScenarioE {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.submit(new Producer(queue, Duration.ofMillis(100), 25));
        executor.submit(new Producer(queue, Duration.ofMillis(200), 25));
        executor.submit(new Producer(queue, Duration.ofMillis(300), 25));
        executor.submit(new Consumer(queue, Duration.ofMillis(50), 25));
        executor.submit(new Consumer(queue, Duration.ofMillis(150), 25));
        executor.submit(new Consumer(queue, Duration.ofMillis(500), 25));
        executor.shutdownNow();
    }
}
