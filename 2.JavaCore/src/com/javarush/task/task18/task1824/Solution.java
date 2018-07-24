package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileReader> list = new ArrayList<>();
        String fileName = "";
        while(true) {
            try {
                fileName = reader.readLine();
                list.add(new FileReader(fileName));
            } catch (IOException e) {
                System.out.println(fileName);
                for(FileReader r : list)
                    try {
                        r.close();
                    } catch (IOException b) {
                    e.printStackTrace();
                    }
                break;
            }
        }
    }

}
