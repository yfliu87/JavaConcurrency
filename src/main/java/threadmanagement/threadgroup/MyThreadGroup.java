package threadmanagement.threadgroup;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n", t.getId());
        e.printStackTrace();
        System.out.printf("Terminating rest threads\n");
        interrupt();
    }
}
