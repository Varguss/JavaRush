package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String name = "default";
        int id;

        while(!name.equals("")) {
            try {
                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();
                map.put(name, id);
            } catch (NumberFormatException e) {
                break;
            }
        }

        for(HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
