package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for(int i = 0; i < array.length-1; i++)
            for(int i2 = 1; i2 < array.length; i2++)
            {
                if (array[i2-1] < array[i2]) {
                    int trans = array[i2];
                    array[i2] = array[i2-1];
                    array[i2-1] = trans;
                }
            }
    }
}
