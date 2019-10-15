package threadmanagement.threadgroup;

import java.util.Random;

public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true) {
            result = 1000/((int) (random.nextDouble() * 1000000000));

            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%s: Interrupted\n", Thread.currentThread().getName());
                return;
            }
        }
    }
}
