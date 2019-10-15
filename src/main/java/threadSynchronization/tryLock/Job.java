package threadSynchronization.tryLock;

public class Job implements Runnable {

    private PrintQueue queue;

    public Job(PrintQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        queue.printJob(new Object());

        System.out.printf("%s: Document has been printed\n", Thread.currentThread().getName());
    }
}
