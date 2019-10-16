package threadSynchronization.readWriteLock;

import java.util.Date;

public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
            priceInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.printf("%s: Writer: Prices have been modified.\n", new Date());

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
