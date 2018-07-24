package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader console_reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(console_reader.readLine()));

        while(reader.ready()) {
            String line = reader.readLine();

            int i = 0;

            for(String s : words)
                if(line.contains(s))
                    i++;

            if(i == 2)
                System.out.println(line);
        }

        console_reader.close();
        reader.close();
    }
}
