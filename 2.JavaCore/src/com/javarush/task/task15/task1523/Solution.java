package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    protected Solution(String name) {
        System.out.println(name);
    }

    /**
     *
     */
    Solution() {
        System.out.println("Hi");
    }

    private Solution(String hello, String bye) {
        System.out.println(hello + bye);
    }

    public Solution(int a) {
        System.out.println(a);
    }

    public static void main(String[] args) {

    }
}

