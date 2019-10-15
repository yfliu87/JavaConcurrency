package threadmanagement.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTask implements Runnable {

    private static ThreadLocal<Date> date = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting thread: %s: %s\n", Thread.currentThread().getId(), date.get());

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s: %s\n", Thread.currentThread().getId(), date.get());
    }
}
