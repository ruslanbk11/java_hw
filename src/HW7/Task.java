package HW7;

import java.util.concurrent.Callable;

public class Task<T> {
    private T result;
    private RuntimeException exception;
    private volatile boolean finished = false;
    private Callable<T> callable;

    public Task(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() throws InterruptedException {
        if (!finished) {
            synchronized (this) {
                if (!finished) {
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        exception = new RuntimeException(e);
                    }   finally {
                        finished = true;
                        notify();
                    }
                } else {
                    this.wait();
                }
            }
        }
        if (exception != null) throw exception;
        return result;
    }
}
