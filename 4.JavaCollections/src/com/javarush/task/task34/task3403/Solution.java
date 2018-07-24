package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        if (n <= 1)
            return;

        if (n % 2 == 0) {
            System.out.print(2 + " ");
            recursion(n/2);
        } else if (n % 3 == 0) {
            System.out.print(3 + " ");
            recursion(n/3);
        } else if (n % 5 == 0) {
            System.out.print(5 + " ");
            recursion(n/5);
        } else System.out.print(n);
    }
}
