package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        for(int i = 1; i <= 5; i += 2)
        {
            list.add(i, "именно");
        }
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
