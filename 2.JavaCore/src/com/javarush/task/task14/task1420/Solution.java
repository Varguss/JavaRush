package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(r.readLine());
        int second = Integer.parseInt(r.readLine());

        if(first<0||second<0)
            throw new IllegalArgumentException("Нужны только положительные числа.");

        int max = first > second ? first : second;
        int min = first < second ? first : second;
        int NOD = 1;

        for(int minTemp = min; true; minTemp = min, min = max%minTemp, max = minTemp)
            if(min == 0) {
                NOD = max; break;
            }
        System.out.println(NOD);
    }
}