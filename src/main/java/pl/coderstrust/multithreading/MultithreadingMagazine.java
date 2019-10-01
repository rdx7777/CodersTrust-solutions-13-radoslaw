package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultithreadingMagazine {

    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) throws InterruptedException {
        magazine();
    }

    public static void magazine() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Produced: " + i);
                try {
                    sleep1();
                    queue.put("Result " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    sleep2();
                    String result = queue.take();
                    System.out.println("Consumed: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void sleep1() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep2() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
