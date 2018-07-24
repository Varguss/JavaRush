package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.join();
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            int seconds = countSeconds;
            while(countSeconds>=0) {
                if(countSeconds!=0)
                {
                    System.out.printf("%d ", countSeconds);
                    countSeconds--;
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException a)
                    {

                    }
                } else if (seconds>3) {
                    System.out.print("Прервано!");
                    interrupt();
                    break;
                } else
                    {
                    System.out.println("Марш!");
                    interrupt();
                    break;
                }
            }
        }
    }
}
