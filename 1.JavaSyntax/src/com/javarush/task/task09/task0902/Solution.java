package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement a = elements[2];
        return a.getMethodName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement a = elements[2];
        return a.getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement a = elements[2];
        return a.getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement a = elements[2];
        return a.getMethodName();
    }

    public static String method5() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement a = elements[2];
        return a.getMethodName();
    }
}
