package threadmanagement.daemonthread;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {

    private Deque<Event> queue;

    public Writer(Deque<Event> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("Thread %s generates event", Thread.currentThread().getId()));
            queue.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
