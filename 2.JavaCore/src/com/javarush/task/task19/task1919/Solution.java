package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while(reader.ready())
            lines.add(reader.readLine());

        Collections.sort(lines);

        Map<String, Double> list = new TreeMap<>();

        for(String line : lines) {
            String split[] = line.split(" ");
            list.put(split[0], list.get(split[0]) == null ? Double.parseDouble(split[1]) : list.get(split[0]) + Double.parseDouble(split[1]));
        }

        for(Map.Entry<String, Double> entry : list.entrySet())
            System.out.println(String.format("%s %s", entry.getKey(), entry.getValue()));

        reader.close();
    }


}
