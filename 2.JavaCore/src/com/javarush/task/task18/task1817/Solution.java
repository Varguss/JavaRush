package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("d:/file1.txt");
        int spaces = 0;
        int all = 0;

        while(stream.available() > 0) {
            int data = (byte) stream.read();
            if(data == 32)
                spaces++;

            all++;
        }

        System.out.printf("%.2f", (double) spaces/all*100);
        stream.close();
    }
}
