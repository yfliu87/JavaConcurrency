package threadmanagement.exceptionhandler;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("StackTrace:\n");
        e.printStackTrace();
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
