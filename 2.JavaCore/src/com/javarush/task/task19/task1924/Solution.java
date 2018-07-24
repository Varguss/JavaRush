package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String hello = "\n";
        String file = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while(fileReader.ready()) {
            String line[] = fileReader.readLine().split(" ");

                for (int i = 0; i < line.length; i++) {
                    try {
                        if (map.containsKey(Integer.parseInt(line[i]))) {
                            line[i] = map.get(Integer.parseInt(line[i]));
                        }
                    } catch (NumberFormatException e) {
                        //System.out.println("Неправильно отформатировано: " + line[i]);
                    }
                }

            for(String s : line)
                System.out.print(s + " ");
            System.out.println();
        }

        reader.close();
        fileReader.close();
    }
}
