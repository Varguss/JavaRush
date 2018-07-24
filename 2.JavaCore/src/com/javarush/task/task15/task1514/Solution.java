package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1d, "Hello");
        labels.put(2d, "My");
        labels.put(3d, "Name");
        labels.put(4d, "John");
        labels.put(5d, "Cena");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
