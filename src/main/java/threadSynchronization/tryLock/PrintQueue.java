package threadSynchronization.tryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Lock queueLock;

    public PrintQueue(boolean fairMode) {
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object doc) {
        queueLock.lock();

        try {
            Long duration = (long) (Math.random() * 5000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue job: " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}
