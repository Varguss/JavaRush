package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
            while(reader.ready())
                Solution.lines.add(reader.readLine());
        }
        catch (IOException a) {
            a.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(String s : lines)
            System.out.println(s);
    }
}
