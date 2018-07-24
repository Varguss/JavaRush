package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for(Integer a : array)
            if (min > a)
                min = a;
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(r.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < numbersCount; i++)
            list.add(Integer.parseInt(r.readLine()));
        return list;
    }
}
