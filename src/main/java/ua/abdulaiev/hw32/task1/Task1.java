package ua.abdulaiev.hw32.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Task1 {
    private static int var = 50;

    public static void main(String[] args) {
        ExecutorService service = newFixedThreadPool(100);
        Lock lock = new ReentrantLock();

        IntStream.range(0, 100).
                <Runnable>mapToObj(i -> () -> {
                    try {
                        lock.lock();
                        System.out.println(var += 2);
                    } finally {
                        lock.unlock();
                    }
                }).forEach(service::execute);
        service.shutdown();
    }
}
