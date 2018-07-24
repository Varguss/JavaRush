package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;
/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(r.readLine());
        HashMap<Integer, Object> map = new HashMap<Integer, Object>();
        while(stream.available() > 0)
        {
            int data = stream.read();
            map.put(data, null);
        }

        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++)
            System.out.printf("%d ", list.get(i));

        stream.close();
        r.close();
    }
}
