package com.myownterritory.tests1.ThreadTest;

/**
 * Created by user on 06.07.2017.
 */
public class Clock implements Runnable {
    private int frequency;
    private boolean isCancel = false;
    public void run() {
        while(!isCancel) {
            try
            {
                System.out.println("Tik");
                Thread.sleep(frequency * 1000);
                System.out.println("Tak");
                Thread.sleep(frequency * 1000);
            }
            catch (InterruptedException a)
            {
                System.out.println(a.getMessage());
                System.out.println(a);
            }
        }
    }

    public void adjustClock(int frequency) {
        this.frequency = frequency;
    }
    public void cancel() {
        this.isCancel = true;
    }

    public Clock() {
        this.frequency = 1;
    }
}
