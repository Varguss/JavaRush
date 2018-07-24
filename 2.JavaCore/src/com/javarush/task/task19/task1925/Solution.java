package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);

        List<String> words = new ArrayList<>();

        StringBuilder content = new StringBuilder();

        int data = reader.read();
        while(data != -1) {
            content.append((char) data);
            data = reader.read();
        }

        for(String s : content.toString().split(" "))
            if(s.length() > 6)
                words.add(s);

        StringBuilder builder = new StringBuilder();

        for(String s : words)
            builder.append(s).append(',');

        writer.write(builder.toString().substring(0, builder.toString().length() - 1));

        reader.close();
        writer.close();
    }
}
