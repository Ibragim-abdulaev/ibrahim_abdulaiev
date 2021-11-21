package ua.abdulaiev.hw31.task2;

import java.util.List;

public class ThreadPrimeCounterNumber extends Thread {
    private long count;
    private final List<Integer> list;

    public ThreadPrimeCounterNumber(List<Integer> list) {
        this.list = list;
    }

    public long getCount() {
        return count;
    }

    @Override
    public void run() {
        long result = 0L;
        for (Integer integer : list) {
            if (numberPrime(integer)) {
                result++;
            }
        }
        count = result;
        System.out.println("Thread prime numbers counts" + System.lineSeparator()
                +  Thread.currentThread().getName() + count);
    }

    private static boolean numberPrime(int number) {
        boolean isPrime = number > 1;
        int i = 2;
        while (i <= Math.sqrt(number)) {
            if (number > 1 && number % 2 != 0 && number % 3 != 0 && number % i != 0) {
                i++;
            } else {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
