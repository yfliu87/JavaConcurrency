package threadSynchronization.tryLock;

public class App {
    public static void main(String[] args) {
        System.out.printf("Running example with fair-mode = false\n");
        testPrintQueue(false);
        System.out.printf("Running example with fair-mode = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(Boolean fairMode) {
        PrintQueue queue = new PrintQueue(fairMode);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(queue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
