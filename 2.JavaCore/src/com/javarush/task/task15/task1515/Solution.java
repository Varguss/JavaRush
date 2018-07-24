package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    static {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            A = Integer.parseInt(r.readLine());
            B = Integer.parseInt(r.readLine());
            r.close();

        } catch (IOException a)
        {

        }

    }
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}