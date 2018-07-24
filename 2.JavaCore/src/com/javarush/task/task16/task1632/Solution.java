package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        for(Thread a : threads)
            a.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while(true) {

            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            while(!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while(!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            if(isAlive())
                interrupt();
        }
    }

    static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summ = 0;

            String s = "";
            while(!s.equals("N"))
            try {
                s = reader.readLine();

                summ += Integer.parseInt(s);
            } catch (NumberFormatException | IOException e) {
                //System.out.println(s + " skipped.");
            }

            System.out.println(summ);
        }
    }
}