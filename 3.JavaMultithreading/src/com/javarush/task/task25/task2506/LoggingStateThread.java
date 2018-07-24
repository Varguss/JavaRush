package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread toObserve) {
        this.thread = toObserve;
    }

    public void run() {
        Thread.State lastState = thread.getState();

        System.out.println(lastState);

        while(true) {
            Thread.State state = thread.getState();
            if(state != lastState) {
                System.out.println(state);
                lastState = state;
            }

            if(lastState == State.TERMINATED)
                break;
        }
    }
}
