package threadmanagement.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

    @Override
    public void run() {
        Date date = new Date();
        System.out.printf("Starting thread: %s: %s\n", Thread.currentThread().getId(), date);

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s: %s\n", Thread.currentThread().getId(), date);
    }
}
