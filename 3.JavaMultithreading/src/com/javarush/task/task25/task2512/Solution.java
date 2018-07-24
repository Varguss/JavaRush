package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printRecursiveStackTrace(e);
    }

    private static void printRecursiveStackTrace(Throwable e) {
        if(e.getCause() != null)
            printRecursiveStackTrace(e.getCause());

        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        Thread.currentThread().setUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
