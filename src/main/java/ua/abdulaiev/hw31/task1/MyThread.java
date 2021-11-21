package ua.abdulaiev.hw31.task1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyThread extends Thread {
    private int count;
    private int index;

    @Override
    public void run() {
        if (count-- <= 0) {
            return;
        }
        MyThread myThread = new MyThread();
        myThread.setName(String.valueOf(index++));
        run();
        System.out.println("Hello from thread " + myThread.getName());
        if (count-- > 0) {
            do {
                myThread = new MyThread();
                myThread.setName(String.valueOf(index++));
                run();
                System.out.println("Hello from thread " + myThread.getName());
            } while (count-- > 0);
        }
    }

    public MyThread(int count) {
        this.count = count;
    }
}