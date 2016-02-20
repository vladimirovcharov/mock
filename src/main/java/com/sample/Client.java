package com.sample;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author evgeniy.shevchenko
 * @version 1.0 2/19/2016
 */
public class Client extends Thread {
    public enum State {
        ON, OFF
    }

    private final AtomicReference<State> status = new AtomicReference<State>(
            State.OFF);

    /**
     * Causes this thread to begin execution; the Java Virtual Machine
     * calls the <code>run</code> method of this thread.
     * <p/>
     * The result is that two threads are running concurrently: the
     * current thread (which returns from the call to the
     * <code>start</code> method) and the other thread (which executes its
     * <code>run</code> method).
     * <p/>
     * It is never legal to start a thread more than once.
     * In particular, a thread may not be restarted once it has completed
     * execution.
     *
     * @throws IllegalThreadStateException if the thread was already
     *                                     started.
     * @see #run()
     * @see #stop()
     */
    @Override
    public synchronized void start() {
        if (!status.compareAndSet(State.OFF, State.ON))
            throw new IllegalStateException("Already started");
        super.start();
    }

    public State getStatus() {
        return status.get();
    }
}
