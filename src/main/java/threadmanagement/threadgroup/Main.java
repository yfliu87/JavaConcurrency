package threadmanagement.threadgroup;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();

        MyThreadGroup threadGroup = new MyThreadGroup("my thread group");

        Task task = new Task();

        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }

        System.out.printf("NUmber of threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about thread group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (Thread t : threads) {
            System.out.printf("Thread %s: %s\n", t.getName(), t.getState());
        }
    }
}
