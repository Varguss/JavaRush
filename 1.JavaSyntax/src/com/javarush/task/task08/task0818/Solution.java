package com.javarush.task.task08.task0818;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5, 9};
        reverse(data);
        System.out.println(Arrays.toString(data));
    }

    private static void reverse(int[] array) {
        for(int i = 0, k = array.length - 1; i < k; i++, k--) {
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
}