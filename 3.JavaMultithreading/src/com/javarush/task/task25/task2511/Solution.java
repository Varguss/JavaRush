package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }

        class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public void uncaughtException(Thread e, Throwable t) {
                StringBuilder builder = new StringBuilder();

                for(int i = 0; i < e.getName().length(); i++)
                    builder.append('*');

                System.out.println(t.getMessage().replace(e.getName(), builder.toString()));
            }
        }

        this.original = original;
        this.handler = new UncaughtExceptionHandler();    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {

    }
}