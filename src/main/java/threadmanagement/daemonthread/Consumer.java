package threadmanagement.daemonthread;


import java.util.Date;
import java.util.Deque;

public class Consumer extends Thread {

    private Deque<Event> queue;
    public Consumer(Deque<Event> queue) {
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run() {
        while(true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (queue.size() == 0) {
            return;
        }

        delete = false;
        do {
            Event e = queue.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.printf("consumer: %s\n", e.getEvent());
                queue.removeLast();
                delete = true;
            }
        } while(difference > 10000);

        if (delete) {
            System.out.printf("consumer: size of queue: %d\n", queue.size());
        }
    }
}
