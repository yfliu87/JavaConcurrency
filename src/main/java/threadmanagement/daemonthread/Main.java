package threadmanagement.daemonthread;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {
        Deque<Event> queue = new ConcurrentLinkedDeque<>();
        Writer writer = new Writer(queue);
        Consumer consumer = new Consumer(queue);

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Thread t = new Thread(writer);
            t.start();
        }

        consumer.start();
    }
}
