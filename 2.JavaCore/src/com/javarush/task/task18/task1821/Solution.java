package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(int i = 0; i < 256; i++)
            map.put((char) i, 0);

        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                int read = reader.read();
                map.put((char) read, map.get((char) read) + 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
