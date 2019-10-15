package threadmanagement.exceptionhandler;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExceptionGenerator generator = new ExceptionGenerator();
        Thread t = new Thread(generator);
        t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
        t.join();
        System.out.printf("Thread %d status: %s\n", t.getId(), t.getState());
        System.out.println("Main thread exit");
    }
}
