package threadmanagement.threadlocal;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        ThreadLocalTask threadLocalTask = new ThreadLocalTask();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(unsafeTask);
            //Thread t = new Thread(threadLocalTask);
            t.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
