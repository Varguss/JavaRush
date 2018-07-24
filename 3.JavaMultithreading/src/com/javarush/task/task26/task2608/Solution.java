package com.javarush.task.task26.task2608;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    final int var1;
    final Integer var2;
    final int var3;
    final Integer var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (var2) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (var4) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
