package threadSynchronization.conditionSynchronization;

public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread t1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread t2 = new Thread(consumer);

        t2.start();
        t1.start();

    }
}
