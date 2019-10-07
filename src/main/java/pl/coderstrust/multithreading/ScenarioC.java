package pl.coderstrust.multithreading;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ScenarioC {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new BigProducer(queue, Duration.ofMillis(50)));
        executor.submit(new Consumer(queue, Duration.ofMillis(500)));
        executor.submit(new Consumer(queue, Duration.ofMillis(500)));
        executor.submit(new Consumer(queue, Duration.ofMillis(500)));
        executor.shutdownNow();
    }
}
