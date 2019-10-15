package threadSynchronization.conditionSynchronization;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {

    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notify();
    }

    public synchronized void get() {
        while(storage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notifyAll();
    }
}
