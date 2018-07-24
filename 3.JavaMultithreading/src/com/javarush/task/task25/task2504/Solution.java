package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread t : threads) {
            switch(t.getState()) {
                case TERMINATED: {
                    System.out.println(t.getPriority());
                } break;
                case NEW: {
                    t.start();
                } break;
                case RUNNABLE: {
                    t.isInterrupted();
                } break;
                case TIMED_WAITING: {

                }
                case BLOCKED: {

                }
                case WAITING: {
                    t.interrupt();
                } break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
