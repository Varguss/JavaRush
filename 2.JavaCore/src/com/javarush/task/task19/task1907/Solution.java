package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        int count = 0;

        while(fileReader.ready()) {
            String line = fileReader.readLine();
            String parts[] = line.split("\\W");

            for(String s : parts)
                if(s.equals("world"))
                    count++;
        }

        System.out.println(count);
        fileReader.close();
    }
}
