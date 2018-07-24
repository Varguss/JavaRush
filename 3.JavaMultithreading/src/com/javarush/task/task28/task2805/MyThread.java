package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger integer = new AtomicInteger(1);

    public MyThread() {

    }

    {
        setUpPriority();
    }

    private void setUpPriority() {
        if (integer.get() > 10)
            integer.set(1);

        if (this.getThreadGroup() != null && integer.get() > this.getThreadGroup().getMaxPriority()) {
            this.setPriority(this.getThreadGroup().getMaxPriority());
            integer.incrementAndGet();
        } else {
            this.setPriority(integer.getAndIncrement());
        }
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
