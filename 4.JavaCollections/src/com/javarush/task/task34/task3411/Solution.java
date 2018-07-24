package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    // Рекурсивно решаем задачу «перенести башню из n−1 диска на 2-й штырь». Затем переносим самый большой диск на 3-й штырь, и рекурсивно решаем задачу «перенеси башню из n−1 диска на 3-й штырь».
    public static void moveRing(char a, char b, char c, int count) {
        if (count > 0) {
            moveRing(a, c, b, count-1);
            System.out.println("from " + a + " to " + b);
            moveRing(c, b, a, count-1);
        }
    }
}