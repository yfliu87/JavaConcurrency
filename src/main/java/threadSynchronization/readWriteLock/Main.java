package threadSynchronization.readWriteLock;

public class Main {
    public static void main(String[] args) {

        PriceInfo priceInfo = new PriceInfo();
        Reader[] readers = new Reader[5];
        Thread[] threqdsReader = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            threqdsReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            threqdsReader[i].start();
        }

        threadWriter.start();
    }
}
