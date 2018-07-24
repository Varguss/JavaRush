package com.myownterritory.tests1.ThreadTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 06.07.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread thread = new Thread(clock, "clock");
        thread.start();
        Thread.sleep(5000);
        clock.adjustClock(5);
        Thread.sleep(20000);
        clock.cancel();
    }
}
