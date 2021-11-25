package ua.abdulaiev.hw32.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.currentThread;

@Getter
@Setter
class HorseThread extends Thread {
    private volatile int place;
    private final int number;
    private static int horsePlace;

    public HorseThread (int number) {
        this.number = number;
    }

    public static int incrementPlace() {
        return ++horsePlace;
    }

    @Override
    public void run() {
        currentThread().setName("Horse " + number);
        int distance = 1000;
        while (!(distance < 0)) {
            distance = distance - ThreadLocalRandom.current().nextInt(100, 201);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(400, 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        place = incrementPlace();
    }
}
